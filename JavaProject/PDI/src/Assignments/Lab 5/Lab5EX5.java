/*Compare the execution of a factorial function
implemented procedurally and using recursion. Let
define input to this function as 3, 6, 10 and 50.
What are the result output? */
public class Lab5EX5 {
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorialRecursive(n - 1);
        }
    }

    public static void main(String[] args) {
        int[] inputs = { 3, 6, 10, 50 };

        System.out.println("Factorial using Iterative Method:");
        for (int input : inputs) {
            long startTime = System.nanoTime();
            System.out.println("Factorial of " + input + " is: " + factorialIterative(input));
            long endTime = System.nanoTime();
            System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        }

        System.out.println("\nFactorial using Recursive Method:");
        for (int input : inputs) {
            long startTime = System.nanoTime();
            System.out.println("Factorial of " + input + " is: " + factorialRecursive(input));
            long endTime = System.nanoTime();
            System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        }
    }
}
