import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("a:");
    int a=s.nextInt();
    System.out.println("b:");
    int b=s.nextInt();
    System.out.printf("Sum of %d and %d is: %d \n",a,b,a+b); 
    System.out.println("Hello, World!"); 
    }
}