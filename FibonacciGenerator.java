public class FibonacciGenerator {

    public static void main(String[] args) {
        System.out.println("Generating the first 10 Fibonacci numbers iteratively...");

         for (int i = 0; i < 10; i++) {
             System.out.print(fibonacciRecursive(i) + " ");
         }
//        // --- START OF BLOCK TO REPLACE ---
//        // This entire block calculates and prints the sequence.
//        // Your goal is to call a recursive function inside a simple loop instead.
//        int n1 = 0, n2 = 1;
//        System.out.print(n1 + " " + n2);
//
//        for (int i = 2; i < countElements; i++) {
//            int n3 = n1 + n2;
//            System.out.print(" " + n3);
//            n1 = n2;
//            n2 = n3;
//        }
//        // --- END OF BLOCK TO REPLACE ---
//        System.out.println();
    }
    public static int fibonacciRecursive(int n) {
        if(n <= 1){
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}