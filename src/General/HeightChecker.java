package General;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] sortedHeights = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            sortedHeights[i] = heights[i];
        }

        Arrays.sort(heights);

        int indexChanged = 0;

        for (int i = 0; i < heights.length; i++) {
            if (sortedHeights[i] != heights[i])
                indexChanged++;
        }

        return indexChanged;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
