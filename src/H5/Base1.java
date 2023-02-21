package H5;

public class Base1 {
    public static void printJava() {
        String str1 = "Хорошо идут дела";
        String str2 = "Изучаю Java я!";
        String str3 = " ";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1 + str3 + str2);
        System.out.println(str2 + str3 + str1);
    }

    public static void printJava(String java1, String java2) {
        System.out.println(java1);
        System.out.println(java2 + "!");
        System.out.print(java1 + ", ");
        System.out.println(java2 + "!");
        System.out.print(java2 + ", ");
        System.out.println(java1 + "!");
    }

    public static String plusJava(String message) {
        return "Java - " + message + " язык программирования";
    }

    public static void main(String[] args) {
        printJava();
        printJava("Чтобы Java понимать", "Надо функции писать");
        printJava("Буду, буду программистом", "Код пишу я чисто, чисто");

        String str = plusJava("самый популярный");
        System.out.println(str);
        str = plusJava("объектно-ориентированный");
        System.out.println(str);
        System.out.println(plusJava("очень интересный"));
    }
}
