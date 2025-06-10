public class StringProblems
{
    // 1. Reverse a String
    static String reverseString(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    // 2.  Check for Palindrome
    static boolean isPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;
        while (left < right)
        {
            if (s.charAt(left) != s.charAt(right)) 
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 3. Reverse Words in a String
    static String reverseWords(String s)
    {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
        {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
    // 1. Test Reverse
    String s1 = "hello";
    System.out.println("Reverse: " + reverseString(s1));

    // 2. Test Palindrome
    String s2 = "madam";
    System.out.println("Is Palindrome: " + isPalindrome(s2));

    // 3. Test Reverse Words
    String s3 = "  the sky is blue  ";
    System.out.println("Reverse Words: " + reverseWords(s3));
}
}
