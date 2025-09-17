import java.util.ArrayList;
import java.util.List;

class Ingredient {
    private String name;
    private List<Ingredient> subIngredients = new ArrayList<>();

    // Constructor for a complex ingredient
    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSubIngredient(Ingredient ingredient) {
        this.subIngredients.add(ingredient);
    }

    public List<Ingredient> getSubIngredients() {
        return subIngredients;
    }
}

public class RecipeAnalyzer {
    public boolean isIngredientRequired(Ingredient currentIngredient, String basicIngredientName) {
        if (basicIngredientName.isEmpty()) {//basicIngredientName has zero characters.
            return false;
        }

        if (currentIngredient.getName().equalsIgnoreCase(basicIngredientName)) { //if the current does not match the the required, ask its children
            return true;
        }

        for (Ingredient sub : currentIngredient.getSubIngredients()) {//loop over its children
            if (isIngredientRequired(sub, basicIngredientName)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Basic ingredients
        Ingredient flour = new Ingredient("Flour");
        Ingredient sugar = new Ingredient("Sugar");
        Ingredient eggs = new Ingredient("Eggs");
        Ingredient butter = new Ingredient("Butter");
        Ingredient vanilla = new Ingredient("Vanilla Extract");

        // Complex ingredients
        Ingredient batter = new Ingredient("Cake Batter");
        batter.addSubIngredient(flour);
        batter.addSubIngredient(sugar);
        batter.addSubIngredient(eggs);

        Ingredient frosting = new Ingredient("Frosting");
        frosting.addSubIngredient(butter);
        frosting.addSubIngredient(sugar);
        frosting.addSubIngredient(vanilla);

        // Final Recipe Item
        Ingredient cake = new Ingredient("Cake");
        cake.addSubIngredient(batter);
        cake.addSubIngredient(frosting);

        RecipeAnalyzer analyzer = new RecipeAnalyzer();

        // Test cases
        boolean needsFlour = analyzer.isIngredientRequired(cake, "Flour");
        System.out.println("Is Flour required for the Cake? " + needsFlour); // Expected: true

        boolean needsVanilla = analyzer.isIngredientRequired(cake, "Vanilla Extract");
        System.out.println("Is Vanilla Extract required for the Cake? " + needsVanilla); // Expected: true

        boolean needsSalt = analyzer.isIngredientRequired(cake, "Salt");
        System.out.println("Is Salt required for the Cake? " + needsSalt); // Expected: false
    }
}