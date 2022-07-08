
public class RolesSpeech {

	public static void main(String[] args) {
		String[] roles = { "Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич" };
		String[] textLines = {
				"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
				"Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?",
				"Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
				"Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!",
				"Лука Лукич: Господи боже! еще и с секретным предписаньем!"

		};
		System.out.println(printTextPerRole(roles, textLines));
	}

	private static String printTextPerRole(String[] roles, String[] textLines) {
		String[] roleLines = new String[roles.length];
		return "";
	}
}
