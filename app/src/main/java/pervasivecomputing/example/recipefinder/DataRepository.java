package pervasivecomputing.example.recipefinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {
    // Map<category, List<Recipe>>
    public static final Map<String, List<Recipe>> CATEGORY_MAP = new HashMap<>();

    static {
        // --- Salads ---
        List<Recipe> salads = new ArrayList<>();
        salads.add(new Recipe("Greek Salad",
                "INGREDIENTS:\n• 1 medium red onion, thinly sliced into half moons\n• 4 medium juicy tomatoes, sliced into bite-sized pieces or wedges\n• 1 English cucumber, partially peeled to make a striped pattern and sliced into half moons\n• 1 green bell pepper, cored and sliced into rings\n•1 handful pitted Kalamata olives\n•1 1/2 teaspoons dried oregano\n•Kosher salt\n•1-2 tablespoons red wine vinegar\n• 1 (7 ounce) block Greek feta cheese in brine, torn into slabs\n" +
                        "\nINSTRUCTIONS:\n1. Shock the onion (optional). If you’d like to mellow the onion’s raw taste, fill a small bowl with ice water. Add about 1 teaspoon of red wine vinegar to the water, then add the sliced onion. Set aside to soak for 10 minutes or so.\n2. Combine the veggies. Place the tomato, cucumber, bell pepper, and olives in a large serving dish. Remove the onions from the water and add to the dish with the rest of the vegetables.\n3. Season. Sprinkle the vegetables with 3/4 teaspoon of oregano and a pinch of kosher salt. Add the oil and vinegar (to your liking) then give everything a gentle toss.\n 4. Finish and serve. Top the salad with slabs of feta and sprinkle with the remaining 3/4 teaspoon of oregano and enjoy!\n",
                "https://www.themediterraneandish.com/traditional-greek-salad-recipe/",
                "https://www.youtube.com/watch?v=iFC7-urzfXw"));
        salads.add(new Recipe("Caesar Salad",
                "INGREDIENTS:\n• Chicken\n• Lettuce\n• Caesar dressing\n... Visit the Website to see the full recipe!\n",
                "https://natashaskitchen.com/caesar-salad-recipe/",
                "https://www.youtube.com/watch?v=FNUumn079DM"));
        salads.add(new Recipe("Chef's Salad",
                "INGREDIENTS:\n• Ham\n• Turkey\n• Cheese\n...Visit the Website to see the full recipe!\n",
                "https://akispetretzikis.com/en/recipe/3323/salata-toy-sef-akh",
                "https://www.youtube.com/watch?v=tlv7j29tYWo"));
        salads.add(new Recipe("Dakos Salad",
                "INGREDIENTS:\n• Barley rusks\n• Tomato\n• Feta\n...Visit the Website to see the full recipe!\n",
                "https://www.simplyrecipes.com/dakos-salad-recipe-5193718",
                "https://www.youtube.com/watch?v=X2ZIOO9CQoo"));
        CATEGORY_MAP.put("Salads", salads);

        // --- Soups ---
        List<Recipe> soups = new ArrayList<>();
        soups.add(new Recipe("Chicken Soup",
                "INGREDIENTS:\n• Chicken\n• Noodles\n...Visit the Website to see the full recipe!\n",
                "https://www.allrecipes.com/recipe/8814/homemade-chicken-soup/",
                "https://www.youtube.com/watch?v=DVVEbgn6Khk"));
        soups.add(new Recipe("Pumpkin Soup",
                "INGREDIENTS:\n• Pumpkin\n• Cream\n...Visit the Website to see the full recipe!\n",
                "https://www.recipetineats.com/classic-pumpkin-soup/",
                "https://www.youtube.com/watch?v=GA-fCgJykEw"));
        soups.add(new Recipe ("Tomato Soup",
                "INGREDIENTS:\n• Tomatoes\n• Garlic\n...Visit the Website to see the full recipe!\n",
                "https://natashaskitchen.com/tomato-soup-recipe/",
                "https://www.youtube.com/watch?v=MdUfrgVhUuw"));
        CATEGORY_MAP.put("Soups", soups);

        // --- Pasta ---
        List<Recipe> pasta = new ArrayList<>();
        pasta.add(new Recipe("Spaghetti Bolognese",
                "INGREDIENTS:\n• Pasta\n• Ground beef\n\nINSTRUCTIONS:\n...Visit the Website to see the full recipe!",
                "https://www.recipetineats.com/spaghetti-bolognese/",
                "https://www.youtube.com/watch?v=-gF8d-fitkU"));
        pasta.add(new Recipe("Carbonara",
                "INGREDIENTS:\n• Eggs\n• Bacon\n• Parmesan\n\nINSTRUCTIONS:\n...Visit the Website to see the full recipe!",
                "https://www.bbcgoodfood.com/recipes/ultimate-spaghetti-carbonara-recipe",
                "https://www.youtube.com/watch?v=D_2DBLAt57c"));
        pasta.add(new Recipe("Mac & Cheese",
                "INGREDIENTS:\n• Pasta\n• Cheese\n\nINSTRUCTIONS:\n...Visit the Website to see the full recipe!",
                "https://www.recipetineats.com/baked-mac-and-cheese/",
                "https://www.youtube.com/watch?v=J_tohEVZJtA"));
        CATEGORY_MAP.put("Pasta", pasta);

        // --- Pastries ---
        List<Recipe> pastries = new ArrayList<>();
        pastries.add(new Recipe("Croissant",
                "INGREDIENTS:\n• Flour\n• Butter\n\nINSTRUCTIONS:\n...Visit the Website to see the full recipe!",
                "https://sallysbakingaddiction.com/homemade-croissants/",
                "https://www.youtube.com/watch?v=djnNkLi_K6E"));
        pastries.add(new Recipe("Bougatsa",
                "INGREDIENTS:\n• Custard\n• Filo\n\nINSTRUCTIONS:\n...Visit the Website to see the full recipe!",
                "https://akispetretzikis.com/en/recipe/1237/grhgorh-mpoygatsa-glykia",
                "https://www.youtube.com/watch?v=6j5FOdWWzx8"));
        pastries.add(new Recipe("Apple Pie",
                "INGREDIENTS:\n• Apples\n• Cinnamon\n\nINSTRUCTIONS:\n...Visit the Website to see the full recipe!",
                "https://akispetretzikis.com/en/recipe/4682/mhlopita",
                "https://www.youtube.com/watch?v=lzL1VeF1sFE"));
        CATEGORY_MAP.put("Pastries", pastries);
    }

    public static List<String> getRecipeNamesForCategory(String category) {
        List<Recipe> list = CATEGORY_MAP.get(category);
        List<String> names = new ArrayList<>();
        if (list != null) {
            for (Recipe r : list) names.add(r.name);
        }
        return names;
    }

    public static Recipe getRecipeByName(String category, String recipeName) {
        List<Recipe> list = CATEGORY_MAP.get(category);
        if (list != null) {
            for (Recipe r : list) {
                if (r.name.equals(recipeName)) return r;
            }
        }
        return null;
    }

    public static class Recipe {
        public final String name;
        public final String details;
        public final String url;
        public final String videoUrl;

        public Recipe(String name, String details, String url, String videoUrl) {
            this.name = name;
            this.details = details;
            this.url = url;
            this.videoUrl = videoUrl;
        }
    }
}