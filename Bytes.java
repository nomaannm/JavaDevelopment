class Bytes
{
    static int myMethod(int a , int b)
    {
        int c = a * b;
        return c;
    }
    static String myMethod(String name)
    {
        return name.toUpperCase();
    }

    public static void main(String args[])
    {
        System.out.println(myMethod(2,3));
        System.out.println(myMethod("Nomaan"));
    }
}