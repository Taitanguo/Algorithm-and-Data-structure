import java.util.*;
class reversestring{
    public static void main(String args[]){
    String original, reverse = "";
    Scanner in = new Scanner(System.in);

    System.out.println("please enter the string");
    original = in.nextLine();

    for(int i = original.length() - 1; i >= 0; i--){
    reverse = reverse + original.charAt(i);
    }

    System.out.println("the reverse string is: \n" + reverse);

    }
}