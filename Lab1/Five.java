
public class Five {

    public static void main(String[] args) {
        //a
        String text = "I Love my Home Country";
        System.out.println("Console length : " + text.length());
        //b
        String text2 = "I Love my little country";
        if (text2.toLowerCase().contains("my little country")) {
            System.out.println("my little country");
        }
        int pos = text2.indexOf("my little country");
        if (pos != -1) {
            System.out.println(text2.substring(pos, pos + 17));
        }
        //c
        String text3 = "Hi Students!";
        String[] arr = {"a", "e", "i", "o", "u"};
        int[] postion = {0, 0, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (text3.contains(arr[i])) {
                postion[i] = text3.indexOf(arr[i]);
            }
        }
        for (int i = 0; i < postion.length; i++) {
            if (postion[i] != 0 || postion[i] != 0) {
                System.out.println(arr[i] + " is at index : " + postion[i]);
            }
        }
        //d
        String text1 = "Hi Students!";
        String text4 = "Students";
        String text5 = "Hi Students!";
        System.out.println("Text1 is equal to Text2 : " + (text1.equals(text4)));
        System.out.println("Text1 is equal to Text3 : " + (text1.equals(text5)));
        String text6 = "Teacher";
        System.out.println("Text1 contains Text2: " + (text1.contains(text4)));
        System.out.println("Text1 contains Text3: " + (text1.contains(text6)));
    }
}
