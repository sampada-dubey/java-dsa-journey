public class TwoPointer
{
    // 1. Valid Palindrome 2 (delete at most one character)
    static boolean validPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            if(s.charAt(left) != s.charAt(right))
            {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPalindrome(String s, int left, int right)
    {
        while (left < right)
        {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // 2. Reverse only letters
    static String reverseOnlyLetters(String s)
    {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            if(!Character.isLetter(arr[left]))
            {
                left++;
            }
            else if(!Character.isLetter(arr[right]))
            {
                right--;
            }
            else
            {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args)
    {
        // Valid Paliindrome 2
        String s1 = "abca";
        System.out.println(validPalindrome(s1));

        // Reverse only letters
        String s2 = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s2));
    }
}
