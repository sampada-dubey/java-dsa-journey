import java.util.ArrayList;
import java.util.List;
import java.util.stream.Gatherer.Integrator;

public class SubsetsAndPermutations
{
    // 1. Generate all subsets (power set)
    static void generateSubsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> result)
    {
        if(index == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Include the element
        curr.add(nums[index]);
        generateSubsets(nums, index + 1, curr, result);

        // Exclude the element (backtrack)
        curr.remove(curr.size() - 1);
        generateSubsets(nums, index + 1, curr, result);
    }

    // 2. Generate all permutations
    static void generatePermutations(int[] nums, List<Integer> curr, boolean[] used, List<List<Integer>> result)
    {
        if(curr.size() == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(used[i]) continue;

            used[i] = true;
            curr.add(nums[i]);

            generatePermutations(nums, curr, used, result);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args)
    {
        int nums[] = {1, 2, 3};

        // Subsets
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), subsets);
        System.out.println("All Subsets:");
        for (List<Integer> subset : subsets)
        {
            System.out.println(subset);
        }

        // Permutations
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], permutations);
        System.out.println("All Permutations:");
        for (List<Integer> perm : permutations)
        {
            System.out.println(perm);
        }
    }
}
