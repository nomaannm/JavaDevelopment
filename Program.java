import java.util.Scanner;

class Program
{
  public static void main(String args[])
  {
    Scanner obj = new Scanner(System.in);
    int a,b,c ;
    System.out.println("Enter first number");
    a = obj.nextInt();
    System.out.println("Enter second number");
    b = obj.nextInt();
    c = a + b ;
    System.out.println("Answer is " + c);
  }
}
