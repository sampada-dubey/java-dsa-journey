import java.util.Scanner;
import java.util.Arrays;
public class BasicProblems
{
    // 1. Print array
    static void printArray(int[] arr)
    {
        System.out.println("Array Elements: " + Arrays.toString(arr));
    }   

    // 2. Find max element
    static int findmax(int[] arr)
    {
        int max = arr[0];
        for(int val : arr)
        {
            if(val > max) max = val;
        }
        return max;
    }

    // 3. Find min element
    static int findMin(int[] arr)
    {
        int min = arr[0];
        for(int val : arr)
        {
            if(val < min) min = val;
        }
        return min;
    }

    // 4. Reverse array in-place
    static void reverseArray(int[] arr)
    {
        int left = 0, right = arr.length - 1;
        while(left < right)
        {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // 5. Linear Search
    static int linearSearch(int[] arr, int target)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == target) return i;
        }
        return -1; // not foumd
    }

    // 6. Binary Search (sorted array only)
    static int binarySearch(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // not found
    }

    // Main method
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input size and elements
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        printArray(arr);

        System.out.println("Max: " + findmax(arr));
        System.out.println("Max: " + findMin(arr));

        reverseArray(arr);
        System.out.println("Reversed Array: ");
        printArray(arr);

        // Linear Search
        System.out.print("Enter value for linear search: ");
        int target1  = sc.nextInt();
        int idx1 = linearSearch(arr, target1);
        System.out.println("Found index at :" + idx1);

        // Binary Search (sorted array only)
        Arrays.sort(arr);
        System.out.println("Sorted Array: ");
        printArray(arr);
        System.out.print("Enter the value for binary search: ");
        int target2 = sc.nextInt();
        int idx2 = binarySearch(arr, target2);
        System.out.println("Found at index: " + idx2);
    }
}
