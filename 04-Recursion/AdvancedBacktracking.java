import java.util.ArrayList;
import java.util.List;

public class AdvancedBacktracking
{
    // 1. Combination Sum (no duplicates, use same element multiple times)
    static void combinationSumHelper(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> result)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0 || index == candidates.length) return;
        
        // Include current data
        curr.add(candidates[index]);
        combinationSumHelper(candidates, target - candidates[index], index, curr, result);

        // Backtrack and exclude
        curr.remove(curr.size() - 1);
        combinationSumHelper(candidates, target, index + 1, curr, result);
    }

    // 2. Palindrome Partitioning
    static void palindromePartitioningHelper(String s, int start, List<String> curr, List<List<String>> result)
    {
        if(start == s.length())
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int end = start + 1; end <= s.length(); end++)
        {
            String prefix = s.substring(start, end);
            if(isPalindrome(prefix))
            {
                curr.add(prefix);
                palindromePartitioningHelper(s, end, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s)
    {
        int l = 0, r = s.length() - 1;
        while (l < r)
        {
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        // Combination Sum
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combResult = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), combResult);
        System.out.println("Combination Sum Results:");
        for (List<Integer> comb : combResult)
        {
            System.out.println(comb);
        }

        // Palindrome Partitioning
        String s = "aab";
        List<List<String>> partResult = new ArrayList<>();
        palindromePartitioningHelper(s, 0, new ArrayList<>(), partResult);
         System.out.println("Palindrome Partitions:");
        for (List<String> part : partResult)
        {
            System.out.println(part);
        }
    }
}
