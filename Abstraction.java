interface Animal
{
    public void animalSound();
    public void sleep();
}

class Cat implements Animal{
    public void animalSound()
    {
        System.out.print("Meowwwww");
    }
    public void sleep()
    {
        System.out.print("Zzzzzz");
    }
}

class Abstraction 
{
    public static void main(String args[])
    {
        Cat cat = new Cat();
        cat.animalSound();
        cat.sleep();
    }
}