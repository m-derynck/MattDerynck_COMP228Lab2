package Ex_3;

public class MethodOverloading {

    public static void main(String[] args) {
        showMessage('B');
        showMessage(new char[]{'H','E','L','L','O',' ','W','O','R','L','D'});
        showMessage("Hello World!");
    }

    //Char input type
    public static void showMessage(char message){
        System.out.println("Executing the char overloaded method.");
        System.out.println(message);
    }
    //Char array input type
    public static void showMessage(char[] message){
        System.out.println("Executing the char[] overloaded method.");
        System.out.println(message);
    }
    //String input type
    public static void showMessage(String message){
        System.out.println("Executing the string overloaded method.");
        System.out.println(message);
    }

}
