package algorithms;

public class FractionalKnapsackItem {
    private int weight;
    private int value;

    public FractionalKnapsackItem(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnit() {
        return value / (double) weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return weight + "/" + value;
    }
}
