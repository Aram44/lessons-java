package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final FractionalKnapsackItem item1 = new FractionalKnapsackItem(4, 20);
        final FractionalKnapsackItem item2 = new FractionalKnapsackItem(3, 18);
        final FractionalKnapsackItem item3 = new FractionalKnapsackItem(2, 14);

        final FractionalKnapsackItem[] items = {item1, item2, item3};

        Arrays.sort(items, Comparator.comparingDouble(FractionalKnapsackItem::valuePerUnit).reversed());
        System.out.println(Arrays.toString(items));

        final int backpackWeight = 7;

        int currentWeight = 0;
        double currentValue = 0;
        int currentItem = 0;

        while (currentItem < items.length && backpackWeight != currentWeight) {
            if (currentWeight + items[currentItem].getWeight() < backpackWeight) {
                currentValue += items[currentItem].getValue();
                currentWeight += items[currentItem].getWeight();
            }else {
                currentValue += ((backpackWeight - currentWeight) / (double) items[currentItem].getWeight()) * items[currentItem].getValue();
                currentWeight = backpackWeight;
            }
            currentItem++;
        }

        System.out.println(currentValue);
    }
}


