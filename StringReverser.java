public class StringReverser {

    public static void main(String[] args) {
        String original = "Hello World";

        System.out.println("Reversing string using recursion...");
        String reversed = reverseStringRecursive(original);

        // --- START OF BLOCK TO REPLACE ---
//        for (int i = original.length() - 1; i >= 0; i--) {
//            reversed += original.charAt(i);
//        }
//        // --- END OF BLOCK TO REPLACE ---

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

    public static String reverseStringRecursive(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }
}