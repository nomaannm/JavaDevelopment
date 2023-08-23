abstract class Abstract{
    public String name = "john";
    public int age  = 24;
    public abstract void study();
}

class Student extends Abstract{
    public int graduationYear = 2018;
    public void study()
    {
        System.out.println("Studying !");
    }

}

class Third
{
    public static void main(String args[])
    {
        Student s1 = new Student();
        System.out.println("Name : " + s1.name);
        System.out.println("Age : " + s1.age);
        System.out.println("Graduation year :" + s1.graduationYear);
        s1.study();
    }
}
