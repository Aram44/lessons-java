package algorithms;

public class DivideAndConcur {

    public static void main(String[] args) {
        var size = divideAndCheck(1680, 640);
        System.out.println(size);
        System.out.println("count : " + (1680 / size * 640 / size));
    }

    private static int divideAndCheck(int weight, int height) {
        System.out.println("weight : " + weight + " height : " + height);
        if (weight % height == 0) {
            return height;
        } else if (weight > height) {
            var newHeight = weight - ((weight / height) * height);
            return divideAndCheck(height, newHeight);
        } else {
            var newWeight = height - ((height / weight) * weight);
            return divideAndCheck(newWeight, weight);
        }
    }
}
