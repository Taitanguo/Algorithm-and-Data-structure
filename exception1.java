// throw an exception
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String S = in.next();
        try
            {
            int x = Integer.parseInt(S);
            System.out.println(x);
        }
        catch(NumberFormatException e){
            System.out.println("Bad String");
        }
    }
}