import java.util.*;

public class DuplicateStringsFinder {
    public static void main(String[] args) {
        // Sample ArrayList
        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "pay_PvDEukwMre4exW","pay_PsqZNJ8iZDH0Qq","pay_PzZ9ZoQiMHU2hw","pay_PreWvKZZVXHyX3","pay_PkvpsBgRj89QWr","pay_PqSKdBFjCiVHOj","pay_Pu2CMbUXvZ9xVK","pay_PwnR8DDQCn3YlM","pay_PrevpcjM91CwXz","pay_Pu2CMbUXvZ9xVK","pay_Ps31gEp6PohUYw","pay_PpHJ8ZZ4WkmjoY","pay_PzZ9ZoQiMHU2hw","pay_PzZ9ZoQiMHU2hw","pay_Pu2CMbUXvZ9xVK","pay_PoLp5WeuWGLYoM","pay_Pu2CMbUXvZ9xVK","pay_Pu2CMbUXvZ9xVK","pay_PvzoZWs1SGybDm","pay_PixhEqgLSo7WVr","pay_PzxfMiAS1FlzXK","pay_Pu2CMbUXvZ9xVK","pay_Pu2CMbUXvZ9xVK","pay_PsRZPQYLC7EmIt","pay_Pvbmygqj2pywYn","pay_Ps31gEp6PohUYw","pay_Pu2CMbUXvZ9xVK","pay_PoUem8T0HtPUr3","pay_PixAyvB1rKDXqD","pay_PixAyvB1rKDXqD","pay_Ps31gEp6PohUYw","pay_PoUem8T0HtPUr3","pay_PreWvKZZVXHyX3","pay_PzZ9ZoQiMHU2hw","pay_PzZ9ZoQiMHU2hw","pay_PoUem8T0HtPUr3","pay_PixAyvB1rKDXqD"   ))
                ;

        // Set to track seen items
        Set<String> seen = new HashSet<>();
        // Set to store duplicates
        Set<String> duplicates = new HashSet<>();

        for (String name : names) {
            if (!seen.add(name)) { // add() returns false if element already exists
                duplicates.add(name);
            }
        }

        // Output duplicates
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicate strings: " + duplicates);
        }

        System.out.println();

        System.out.println("uninque: "+ seen);
    }
}
