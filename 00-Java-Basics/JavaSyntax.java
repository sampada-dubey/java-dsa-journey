// JavaSyntax.java
// Basic Java syntax examples and practice
import java.util.Scanner;;

public class JavaSyntax 
{

    // Function to add two numbers
    public static int add(int x, int y)
    {
        return x + y;
    }
    public static void main(String[] args) 
    {
        // Print Hello World
        System.out.println("Hello, World!");

        // Variables
        int a = 10;
        double b = 20.5;
        char c = 'A';
        boolean isTrue = true;
        String name = "Sampada";

        // Output variables
        System.out.println("Integer: " + a);
        System.out.println("Double: " + b);
        System.out.println("Char: " + c);
        System.out.println("Boolean: " + isTrue);
        System.out.println("String: " + name);

        // Conditional Statement
        if (a > 5) 
        {
            System.out.println("a is greater than 5");
        } else 
        {
            System.out.println("a is 5 or less");
        }

        // Loops
        System.out.println("For loop:");
        for (int i = 0; i < 5; i++)
        {
            System.out.println("i = " + i);
        }

        System.out.println("While loop:");
        int count = 0;
        while (count < 5) 
        {
            System.out.println("count = " + count);
            count++;
        }

        // Functions
        int sum = add(5, 10);
        System.out.println("Sum: " + sum);

        //Switch Statement
        int day = 3;
        switch (day) 
        {
            case 1:
            System.out.println("Monday");
            break;
            case 2:
            System.out.println("Tuesday");
            break;
            default:
            System.out.println("Other Day");
        }

        //User Input using Scanner
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("You entered: " + num);
        sc.close();

        //Array declaration and traversal
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("Element at index " + i + ": " + arr[i]);
        }

        //Enhanced For Loop (for-each)
        for(int value : arr)
        {
            System.out.println("Value:" + value);
        }

        //String Methods
        String str = "Sampada";
        System.out.println("Length: " + str.length());
        System.out.println("First char: " + str.charAt(0));
        System.out.println("Substring: " + str.substring(0, 3));
    }
}