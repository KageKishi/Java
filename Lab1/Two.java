
public class Two {

    public static void main(String[] args) {
        System.out.printf("%-12s %30s\n", "\\n", "Line break");
        System.out.printf("%-12s %30s\n", "\\t", "Tabulation");
        System.out.printf("%-12s %30s\n", "\\'", "Single quote");
        System.out.printf("%-12s %30s\n", "\"", "Double quote");
        System.out.printf("%-12s %30s\n", "\\", "Backslash");
        System.out.printf("%-12s %30s\n", "\\\\", "Double Backslash");
        System.out.printf("%-12s %30s\n", "//", "Line Comment");
        System.out.printf("%-12s %30s\n", "/*...*/", "Block Comment");
        System.out.printf("%-12s %30s\n", "\"\"\"", "Text Block");
        System.out.printf("%-12s %30s\n", "/** */", "Documentation Comment");
    }
}
