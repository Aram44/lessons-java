package algorithms;

public class RecursiveSum {

    public static void main(String[] args) {
        System.out.println(sumOf(new int[]{1, 2, 4, 6, 5}, 0, 0));
    }

    private static int sumOf(int[] nums, int index, int sum) {
        if (index == nums.length) {
            return sum;
        } else {
            return sumOf(nums, index + 1, sum + nums[index]);
        }
    }
}
