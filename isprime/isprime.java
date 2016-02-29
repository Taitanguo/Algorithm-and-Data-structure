import java.util.Scanner;
class isprime{

public static void main(String[] args){
    System.out.println("please enter the prime\n");
    Scanner prime = new Scanner(System.in);
    int n = prime.nextInt();
    if(n%2 ==0){ //if this number is multiple of 2
        System.out.println("false");
        System.exit(0);
    }//if this number is odd
    for(int i = 3; i * i <= n; i = i + 2){
        if(n%i == 0){
        System.out.println("This number is: " + "false");
        System.exit(0);
        }
    }
     System.out.println("this number is: " + "ture");

}

}