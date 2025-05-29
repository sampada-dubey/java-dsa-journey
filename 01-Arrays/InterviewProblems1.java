import java.util.Arrays;
public class InterviewProblems1
{
    // 1. Move all zeroes to end (maintain relative order)
    static void moveZeroesToEnd(int[] arr)
    {
        int idx = 0; // pointing to the position to place non-zero value

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != 0)
            {
                // swap non-zero with idx
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                idx++;
            }
        }
    }

    // 2. Rotate array to right by k steps (reversal algorithm)
    static void rotateArray(int[] arr, int k)
    {
        int n = arr.length;
        k = k % n; // handle k > n

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    // helper function
    static void reverse(int[] arr, int left, int right)
    {
        while(left < right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // 3. Check if array is sorted (non-decreasing)
    static boolean isSorted(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    // 4. Find second largest element
    static int secondLargest(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for(int val : arr)
        {
            if(val > max)
            {
                second = max;
                max = val;
            }
            else if(val > second && val != max)
            {
                second = val;
            }
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    // 5. Remove duplicates from sorted array, return new lwngth
    static int removeDuplicates(int[] arr)
    {
        if(arr.length == 0) return 0;

        int i = 0; // slow pointer
        for(int j = 1; j < arr.length; j++)
        {
            if(arr[j] != arr[i])
            {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1; // new length
    }

     public static void main(String[] args) {
        // Sample input
        int[] arr1 = {0, 1, 0, 3, 12};
        moveZeroesToEnd(arr1);
        System.out.println("Move Zeroes: " + Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5};
        rotateArray(arr2, 2);
        System.out.println("Rotate by 2: " + Arrays.toString(arr2));

        int[] arr3 = {1, 2, 2, 3, 4};
        System.out.println("Is Sorted? " + isSorted(arr3));

        int[] arr4 = {5, 1, 9, 2, 9};
        System.out.println("Second Largest: " + secondLargest(arr4));

        int[] arr5 = {1, 1, 2, 3, 3, 4};
        int newLen = removeDuplicates(arr5);
        System.out.println("After Removing Duplicates: " + Arrays.toString(Arrays.copyOf(arr5, newLen)));
    }
}
