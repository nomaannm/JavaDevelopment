class OuterInner
{
    int x = 10;

    class Inner {

        int y = 11;
    }

    public static void main(String args[])
    {
        OuterInner outerInner = new OuterInner();
        OuterInner.Inner inner = outerInner.new Inner();
        System.out.println(outerInner.x + inner.y); 
    }
}