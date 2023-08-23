class Second
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