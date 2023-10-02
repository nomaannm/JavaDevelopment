import java.io.*;
class Files{

    public static void main(String[] args)
    {
        Customer[] customers = getCustomers();
        PrintWriter custOuput = createFile("Customers.txt"); 
        for(Customer person : customers)
        {
            createCustomers(person , custOuput);
        }
        custOuput.close();

        getFileInfo();



    }

    private static class Customer{
        String firstName ;
        String lastName ;
        int age ;

        public Customer(String fName , String lName , int age)
        {
            this.firstName = fName ;
            this.lastName = lName ;
            this.age = age ;
        }
    }
    private static Customer[] getCustomers()
    {
        Customer[] customers = new Customer[5];

        customers[0] = new Customer("Talha","Marghoob",22);
        customers[1] = new Customer("Md.","Atif",20);
        customers[2] = new Customer("Aadil","Anwar",23);
        customers[3] = new Customer("Abdul","Musawwir",24);
        customers[4] = new Customer("Haasin","Qureshi",19);
        return customers;
    }

    private static PrintWriter createFile(String fileName)
    {

        try{
            File listOfNames = new File(fileName);
            PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfNames)));
            return infoToWrite;

        }

        catch(IOException e){System.out.println("An IO error occurred"); System.exit(0);}
        return null ;
    }
    private static void createCustomers(Customer customer , PrintWriter custOuput)
    {
        String custInfo = customer.firstName + " " + customer.lastName ;
        custInfo += Integer.toString(customer.age);
        custOuput.println(custInfo);

    }
    private static void getFileInfo()
    {
        System.out.println("Info Written to File\n");
        File listOfNames = new File("Customers.txt");
        try{
            //This will read as many characters from the file as possible before it prints them
            BufferedReader bufferedReader = new BufferedReader(new FileReader(listOfNames));
            String custInfo = bufferedReader.readLine();

            while(custInfo != null)
            {
                System.out.println(custInfo);
                custInfo = bufferedReader.readLine();
            }
        
        }
        catch(FileNotFoundException f)
        {
            System.out.println("Couldn't find file");
            System.exit(0);

        }
        catch(IOException e)
        {
            System.out.println("An IO exception occurred");
            System.exit(0);
        }


    }
}
