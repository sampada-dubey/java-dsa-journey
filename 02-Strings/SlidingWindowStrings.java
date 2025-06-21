import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowStrings
{
    // 1. Minimum Window Substring
    static String minWindow(String s, String t)
    {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);

        int left = 0, right = 0, required = tMap.size(), formed = 0;
        Map<Character, Integer> window = new HashMap<>();

        int[] ans = {-1, 0, 0}; // length, start, end

        while(right < s.length())
        {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(tMap.containsKey(c) && window.get(c).intValue() == tMap.get(c).intValue())
            formed++;

            while(left <= right && formed == required)
            {
                if (ans[0] == -1 || right - left + 1 < ans[0])
                {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                char temp = s.charAt(left);
                window.put(temp, window.get(temp) - 1);
                if(tMap.containsKey(temp) && window.get(temp) < tMap.get(temp)) formed--;
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    // 2. Find All Anagrams in a String
    static List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(int i = 0; i < p.length(); i++)
        {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, sCount)) result.add(0);

        for(int i = p.length(); i < s.length(); i++)
        {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if(Arrays.equals(pCount, sCount)) result.add(i - p.length() + 1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        // Minimum Window Substring
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println(minWindow(s1, t1));

        // Find all anagrams
        String s2 = "cbaebabacd", p2 = "abc";
        System.out.println(findAnagrams(s2, p2));
    }
}
