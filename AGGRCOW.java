import java.util.*;

public class AGGRCOW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        for(int i = 0; i < numTests; i++) {
            int numStalls = scanner.nextInt();
            int numCows = scanner.nextInt();
            int[] stalls = new int[numStalls];

            for(int j = 0; j < numStalls; j++) {
                stalls[j] = scanner.nextInt();
            }
            Arrays.sort(stalls);

            System.out.println(binarySearch(stalls, numCows));
        }

        scanner.close();
    }

    public static int binarySearch(int[] stalls, int numCows) {
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(isValid(stalls, numCows, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static boolean isValid(int[] stalls, int numCows, int distance) {
        int cowsPlaced = 1;
        int lastPlaced = stalls[0];

        for(int i = 1; i < stalls.length; i++) {
            if(stalls[i] - lastPlaced >= distance) {
                cowsPlaced++;
                lastPlaced = stalls[i];
            }
        }

        return cowsPlaced >= numCows;
    }
}