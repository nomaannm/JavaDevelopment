import java.util.ArrayList;

class ARRAYLISTS
{
    public static void main(String args[])
    {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Thar");
        cars.add("Porsche");
        cars.add("Honda Civic");
        System.out.print(cars + " ");
        for(int i = 0 ; i < cars.size() ; i++)
        {
            System.out.println(cars.get(i));
        }
    }
}