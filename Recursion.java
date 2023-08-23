public class Recursion {
    static int table(int a)
    {
        while(a<100)
        {
            a = a * a;
            table(a);
            System.out.println(a);
        }
        return a;
    }

    public static void main(String args[])
    {
        table(2);
    }
    
}
