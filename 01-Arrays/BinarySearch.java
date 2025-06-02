import java.util.*;;
public class BinarySearch
{
    // 1. Standard Binary Search
    static int binarySearch(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }   

    // 2. Find first occurence of target (lower bound)
    static int firstOccurrence(int[] arr, int target)
    {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target)
            {
                result = mid;
                right = mid - 1;
            }
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    // 3. Square root of a number
    static int sqrt(int x)
    {
        if(x == 0 || x == 1) return x;
        int left = 1, right = x, ans = 0;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(mid <= x / mid)
            {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        // 1. Test Binary Search
        int[] arr1 = {1, 3, 5, 7, 9, 11};
        int target = 5;
        System.out.println("Index of " + target + ": " + binarySearch(arr1, target));

        // 2️. Test first occurrence
        int[] arr2 = {1, 2, 2, 2, 3, 4};
        target = 2;
        System.out.println("First occurrence of " + target + ": " + firstOccurrenc(arr2, target));

        // 3️. Test square root
        int x = 10;
        System.out.println("Square root of " + x + ": " + sqrt(x));
    }
}
