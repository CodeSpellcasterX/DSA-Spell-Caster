class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> availableRecipes = new HashSet<>(Arrays.asList(supplies));
        HashSet<String> cannotBeMade = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        Map<String, List<String>> recipeMap = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            recipeMap.put(recipes[i], ingredients.get(i));
        }

        for (String recipe : recipes) {
            if (isPossibleToMake(recipe, availableRecipes, cannotBeMade, recipeMap, new HashSet<>())) {
                answer.add(recipe);
                availableRecipes.add(recipe);
            } else {
                cannotBeMade.add(recipe);
            }
        }
        return answer;
    }

    private boolean isPossibleToMake(String recipe, HashSet<String> availableRecipes, HashSet<String> cannotBeMade, Map<String, List<String>> recipeMap, HashSet<String> visited) {
        if (availableRecipes.contains(recipe)) return true;
        if (cannotBeMade.contains(recipe) || !recipeMap.containsKey(recipe)) return false;
        if (visited.contains(recipe)) return false; // Cycle detected

        visited.add(recipe);
        for (String ingredient : recipeMap.get(recipe)) {
            if (!availableRecipes.contains(ingredient)) {
                if (!isPossibleToMake(ingredient, availableRecipes, cannotBeMade, recipeMap, visited)) {
                    cannotBeMade.add(recipe);
                    return false;
                }
            }
        }
        visited.remove(recipe);
        availableRecipes.add(recipe);
        return true;
    }
}