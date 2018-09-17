import java.util.*;

public class Main {
    private static int BarometerCount = 0;

    private static int Knapsack_Solver(List<Item> items, int weight){
        BarometerCount = 0;
        int bestValue = 0;
        for (List<Item> subset : subsets(items)) {
            int subWeight = getWeight(subset);
            BarometerCount += 1;
            if (subWeight <= weight) {
                int value = getValue(subset);
                if (value > bestValue) {
                    bestValue = value;
                }
            }
        }
        return bestValue;
    }

    public static void main(String[] args){
        if(args.length < 2){return;}

        int numItems = Integer.valueOf(args[1]);
        int Weight = Integer.valueOf(args[0]);

        List<Item> items = generateItems(numItems, Weight);

        printItems(items);

        int solution = Knapsack_Solver(items, Weight);

        System.out.println("Input Weight: " + Weight + " Input Items: "
                + numItems + " Maximum value of items: " + solution + " Barometer Count: " + BarometerCount);
    }

    /**
     * Helper methods
     * */

    private static List<Item> generateItems(int numItems, int Weight){
        List<Item> items = new ArrayList<>();

        for(int i = 0; i < numItems; i ++){
            int weight = (int) (Math.random() * Weight);
            int value = (int) (Math.random() * 100);
            Item item = new Item(weight, value);
            items.add(item);
        }

        return items;
    }

    private static void printItems(List<Item> items){
        for(Item item : items){
            System.out.println(item.toString());
        }
    }

    /**
     * Recursively find every single subset of the initial set of items
     * */
    private static List<List<Item>> subsets(List<Item> items) {
        List<List<Item>> subsets = new LinkedList<>();
        if (items.isEmpty()) {
            subsets.add(new LinkedList<>());
            return subsets;
        }

        Item first = items.get(0);
        List<List<Item>> subsubsets = subsets(items.subList(1, items.size()));
        for (List<Item> subset : subsubsets) {
            subsets.add(subset);
            List<Item> augmented = new LinkedList<>(subset);
            augmented.add(0, first);
            subsets.add(augmented);
        }
        return subsets;
    }

    private static int getWeight(List<Item> items){
        int weight = 0;
        for(Item i : items){
            weight += i.getWeight();
        }
        return weight;
    }

    private static int getValue(List<Item> items){
        int value = 0;
        for(Item i : items){
            value += i.getValue();
        }
        return value;
    }

}
