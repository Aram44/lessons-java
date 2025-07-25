package algorithms;

public class FindOptimalStop {
    public static void main(String[] args) {
        final int[] stations = {0, 200, 375, 550, 750, 950};
        System.out.println("Min stops is " + calculateMinStops(stations, 400));
    }

    private static int calculateMinStops(int[] stations, int capacity) {
        int res = 0;
        int currentStop = 0;
        while (currentStop < stations.length - 1) {
            int nextStop = currentStop;
            while (nextStop < stations.length - 1 && stations[nextStop + 1] - stations[currentStop] <= capacity) {
                nextStop++;
            }
            if (currentStop == nextStop) {
                return -1;
            }
            if (nextStop < stations.length - 1) {
                res++;
            }
            currentStop = nextStop;
        }
        return res;
    }
}
