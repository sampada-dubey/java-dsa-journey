public class RecursionBasics
{
    // 1. Print numbers from N to 1 (tail recursion)
    static void printNto1(int n)
    {
        if(n == 0) return;
        System.out.print(n + " ");
        printNto1(n - 1);
    }

    // 2. Print numbers from 1 to N (head recursion)
    static void print1toN(int n)
    {
        if(n == 0) return;
        print1toN(n - 1);
        System.out.print(n + " ");
    }

    // 3. Factorial of N
    static int factorial(int n)
    {
        if(n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // 4. Sum of first N numbers
    static int sumOfN(int n)
    {
        if(n == 0) return 0;
        return n + sumOfN(n - 1);
    }

    public static void main(String[] args)
    {
        int n = 5;

        System.out.print("Print N to 1: ");
        printNto1(n);
        System.out.println();

        System.out.print("Print 1 to N: ");
        print1toN(n);
        System.out.println();

        System.out.println("Factorial of " + n + ": " + factorial(n));
        System.out.println("Sum of first " + n + " numbers: " + sumOfN(n));
    }
}
