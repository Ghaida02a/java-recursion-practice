public class DigitSummer {

    public static void main(String[] args) {
        int number = 12345;
        int tempNumber = number;

        System.out.println("Calculating the sum of digits for " + number + " with a loop...");
        int sum = sumDigitsRecursive(number);
//        // --- START OF BLOCK TO REPLACE ---
//        while (tempNumber > 0) {
//            int lastDigit = tempNumber % 10; // Get the last digit
//            sum += lastDigit;
//            tempNumber = tempNumber / 10; // Remove the last digit
//        }
//        // --- END OF BLOCK TO REPLACE ---

        System.out.println("The sum of the digits is: " + sum);
    }
    public static int sumDigitsRecursive(int number){
        if(number == 0){
            return 0;
        }
        return (number % 10) + sumDigitsRecursive(number / 10);
    }
}