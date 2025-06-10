import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hashing
{
    // 1️. Two Sum
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // 2️. Longest Substring Without Repeating Characters
    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // 1️. Test Two Sum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Indices of target sum: " + Arrays.toString(twoSum(nums, target)));

        // 2️. Test Longest Substring Without Repeating Characters
        String s = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s));
    }
}
