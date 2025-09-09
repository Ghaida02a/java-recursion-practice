public class PowerCalculator {

    public static void main(String[] args) {
        int base = 3;
        int exponent = 4;
        //long result = 1;

        System.out.println("Calculating " + base + "^" + exponent + " using a loop...");

        long result = powerRecursive(base, exponent);
        System.out.println("Result: " + result);
//        // --- START OF BLOCK TO REPLACE ---
//        for (int i = 0; i < exponent; i++) {
//            result *= base;
//        }
//        // --- END OF BLOCK TO REPLACE ---

        System.out.println("Result: " + result); // Expected: 81
    }
    public static long powerRecursive(int base, int exp){
        if(exp == 0){
            return 1;
        }
        return base * powerRecursive(base, exp - 1);
    }
}