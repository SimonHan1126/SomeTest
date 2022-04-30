package youTap;

/**
 * @author Simon-the-coder
 * @date 28/11/21 9:40 AM
 */
public class SecondHighestNumberInArray {

    public static void main(String[] args) {
        int arr[] =  { 100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89 };
        int largest = 0;
        int secondLargest = 0;

        System.out.println("The given array is:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] > secondLargest) {
                if (arr[i] > largest) {
                    // the largest becomes the second largest and get a new value
                    secondLargest = largest;
                    largest = arr[i];
                } else {
                    secondLargest = arr[i];
                }
            }
        }

        System.out.println("\nSecond largest number is: " + secondLargest);
        System.out.println("Largest Number is: " + largest);
    }
}
