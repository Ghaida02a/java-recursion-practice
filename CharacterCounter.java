public class CharacterCounter {

    public static void main(String[] args) {
        String sentence = "recursion is replacing the repetition of loops";
        char target = 'r';

        System.out.println("Counting occurrences of '" + target + "' with a loop...");
        int count = countCharRecursive(sentence, target, 0);

        // --- START OF BLOCK TO REPLACE ---
//        for (int i = 0; i < sentence.length(); i++) {
//            if (sentence.charAt(i) == target) {
//                count++;
//            }
//        }
//        // --- END OF BLOCK TO REPLACE ---

        System.out.println("The character '" + target + "' appears " + count + " times.");
    }
    public static int countCharRecursive(String text, char target, int index){
        if(index == text.length()){
            return 0;
        }

        //check if current character matches target
        if(text.charAt(index) == target){
            return 1 + countCharRecursive(text, target, index + 1);
        }
        else {
            return 0 + countCharRecursive(text, target, index + 1);
        }
    }
}