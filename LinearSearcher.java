import java.util.Arrays;
import java.util.List;

public class LinearSearcher {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Grape", "Mango");
        String targetFruit = "Grape";

        System.out.println("Searching for '" + targetFruit + "' with a loop...");
        boolean found = searchRecursive(fruits, targetFruit, 0);

//        // --- START OF BLOCK TO REPLACE ---
//        for (int i = 0; i < fruits.size(); i++) {
//            if (fruits.get(i).equals(targetFruit)) {
//                found = true;
//                break; // Exit the loop once found
//            }
//        }
//        // --- END OF BLOCK TO REPLACE ---

        if (found) {
            System.out.println("Success! Found the fruit.");
        } else {
            System.out.println("Failure! Fruit not in the list.");
        }
    }
    public static boolean searchRecursive(List<String> items, String target, int index){
        if(index >= items.size()){
            return false;
        }
        if(items.get(index).equals(target)){
            return true;
        }
        return searchRecursive(items, target, index + 1);
    }
}