public class Objects{

    int a ;
    public Objects()
    {
        a = 0;
    }

    public Objects(int x , int y)
    {
        a = x;

    }
    static void myStaticMethod()
    {
        System.out.println("Static Method");

    }

    public void myPublicMethod()
    {
        System.out.println("Public Method");

    }

    public static void main(String args[])
    {
        Objects obj = new Objects();
        Objects obj1 = new Objects(1,3);
        System.out.println(obj.a);
        System.out.println(obj1.a);
    }
}