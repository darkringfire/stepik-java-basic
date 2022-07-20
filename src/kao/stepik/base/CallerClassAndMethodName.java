package kao.stepik.base;

public class CallerClassAndMethodName {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        level2();
    }

    private static void level2() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = (new RuntimeException()).getStackTrace();
        if (stackTrace.length > 2) {
            return stackTrace[2].getClassName() + "#" + stackTrace[2].getMethodName();
        }
        return null;
    }

}
