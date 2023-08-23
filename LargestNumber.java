class LargestNumber
{
    public static void main(String args[])
    {
        int arr[] = {1,9,8,6,4};
        int largestNumber = 0;
        for(int i : arr)
        {
            if(arr[i] >= arr[i+1])
            {
                largestNumber = arr[i];
            }
            else
            {
                largestNumber = arr[i+1];
            }

        }
        System.out.println("Largest Number in the array is " + largestNumber);

    }
}