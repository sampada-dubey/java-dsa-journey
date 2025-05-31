import java.util.*;
public class PrefixSum
{
        // 1. Prefix sum of an array
        static int[] getPrefixSum(int[] arr)
        {
            int n = arr.length;
            int[] prefix = new int[n];
            prefix[0] = arr[0];
            for(int i = 1; i < n; i++)
            {
                prefix[i] = prefix[i - 1] + arr[i];
            }
            return prefix;
        }

        // 2. Subarray sum equal to k (using hashmap)
        static int subarraySum(int[] arr, int k)
        {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // to handle sum from index 0
            int count = 0, sum = 0;

            for(int i = 0; i < arr.length; i++)
            {
                sum += arr[i];
                if(map.containsKey(sum - k))
                {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }

        public static void main(String[] args)
        {

        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Prefix sum array: " + Arrays.toString(getPrefixSum(arr1)));

        int[] arr2 = {1, 1, 1};
        int k = 2;
        System.out.println("Number of subarrays with sum " + k + ": " + subarraySum(arr2, k));
        }
}
