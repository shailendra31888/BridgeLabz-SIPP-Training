
interface MealPlan {

    String getDescription();
}

class VegetarianMeal implements MealPlan {

    private String mainDish;

    public VegetarianMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getDescription() {
        return "Vegetarian: " + mainDish;
    }
}

class VeganMeal implements MealPlan {

    private String mainDish;

    public VeganMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getDescription() {
        return "Vegan: " + mainDish;
    }
}

class KetoMeal implements MealPlan {

    private String mainDish;

    public KetoMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getDescription() {
        return "Keto: " + mainDish;
    }
}

class HighProteinMeal implements MealPlan {

    private String mainDish;

    public HighProteinMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getDescription() {
        return "High-Protein: " + mainDish;
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {

    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void display() {
        System.out.println(mealPlan.getDescription());
    }
}

// Utility with generic method to validate and generate meal plan
class MealPlanGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        // Example validation: only allow non-null main dish
        if (mealPlan.getDescription().contains("null")) {
            throw new IllegalArgumentException("Invalid meal plan: missing main dish.");
        }
        System.out.println("Meal plan generated: " + mealPlan.getDescription());
        return new Meal<>(mealPlan);
    }
}

public class PersonalizedMealPlanGenerator {

    public static void main(String[] args) {
        // Generate different meal plans
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal("Paneer Curry"));
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal("Tofu Stir Fry"));
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal("Grilled Chicken"));
        Meal<HighProteinMeal> hpMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal("Egg White Omelette"));

        System.out.println("\nPersonalized Meal Plans:");
        vegMeal.display();
        veganMeal.display();
        ketoMeal.display();
        hpMeal.display();

        // Uncomment to see validation in action:
        // Meal<VeganMeal> invalid = MealPlanGenerator.generateMealPlan(new VeganMeal(null));
    }
}
