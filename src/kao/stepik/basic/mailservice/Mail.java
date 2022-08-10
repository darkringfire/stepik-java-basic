package kao.stepik.basic.mailservice;

import java.util.Objects;
import java.util.logging.*;

public class Mail {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
    }
    /**
     * Интерфейс: сущность, которую можно отправить по почте.
     * У такой сущности можно получить от кого и кому направляется письмо.
     */
    public interface Sendable {
        String getFrom();

        String getTo();
    }

    /**
     * Абстрактный класс, который позволяет абстрагировать логику хранения
     * источника и получателя письма в соответствующих полях класса.
     */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            return from.equals(that.from) && to.equals(that.to);
        }

    }

    /**
     * Письмо, с текстом, который можно получить с помощью метода `getMessage`
     */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return Objects.equals(message, that.message);
        }

    }

    /**
     * Посылка, содержимое которой можно получить с помощью метода `getContent`
     */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }

    }

    /**
     * Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
     */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /**
     * Интерфейс, задающий класс, который может каким-либо образом обработать почтовый объект.
     */
    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    /**
     * Класс, в котором скрыта логика настоящей почты
     */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    /**
     * Класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать почтовый объект
     * непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
     * в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
     * У UntrustworthyMailWorker должен быть конструктор от массива MailService
     * (результат вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
     * и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService
     */
    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] midHands;
        private final RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] midHands) {
            this.midHands = midHands;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService hands : midHands) {
                mail = hands.processMail(mail);
            }
            mail = realMailService.processMail(mail);
            return mail;
        }

        public MailService getRealMailService() {
            return realMailService;
        }
    }

    /**
     * Шпион, логгирующий о всей почтовой переписке, которая проходит через его руки. Объект конструируется
     * от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами
     * класса MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках
     * на значения полей почты):
     * <il>
     * <li>Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
     * уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"</li>
     * <li>Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}</li>
     * </il>
     */
    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage mailMessage = (MailMessage) mail;
                if (mailMessage.getFrom().equals(AUSTIN_POWERS) || mailMessage.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING,
                            "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mailMessage.getFrom(), mailMessage.getTo(), mailMessage.getMessage()}
                    );
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mailMessage.getFrom(), mailMessage.getTo()});
                }
            }
            return mail;
        }
    }

    /**
     * Вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе
     * переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен
     * присутствовать метод getStolenValue, возвращающий суммарную стоимость всех посылок, которые он своровал.
     * Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только
     * с нулевой ценностью и содержимым посылки "stones instead of {content}"
     */
    public static class Thief implements MailService {
        private final int minPrice;
        private int stolen = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage ) {
                MailPackage mailPackage = (MailPackage) mail;
                Package content = mailPackage.getContent();
                if (content.getPrice() >= minPrice) {
                    stolen += content.getPrice();
                    mail = new MailPackage(
                            mail.getFrom(),
                            mail.getTo(),
                            new Package("stones instead of " + content.getContent(), 0)
                    );
                }
            }
            return mail;
        }

        public int getStolenValue() {
            return stolen;
        }
    }

    public static class IllegalPackageException extends RuntimeException {}
    public static class StolenPackageException extends RuntimeException {}

    /**
     * Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
     * если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
     * ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую
     * из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения
     * вы должны объявить самостоятельно в виде непроверяемых исключений.
     */
    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage ) {
                MailPackage mailPackage = (MailPackage) mail;
                Package packageContent = mailPackage.getContent();
                if (packageContent.getContent().equals(WEAPONS) || packageContent.getContent().equals(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if (packageContent.getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

}
