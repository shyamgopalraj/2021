package Amazon;

public class Container_With_Most_Water {

    public int maxArea(int[] height) {

        int length = height.length;
        int result = 0;

        if (length == 1) {
            return result;
        }

        int leftMaxIndex = 0;
        int rightMaxIndex = length - 1;

        while (leftMaxIndex < rightMaxIndex) {

            int minMax = Math.min(height[leftMaxIndex], height[rightMaxIndex]);
            result = Math.max(result, (minMax * (rightMaxIndex - leftMaxIndex)));

            if (minMax == height[leftMaxIndex]) {
                leftMaxIndex++;
            } else {
                rightMaxIndex--;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Container_With_Most_Water obj = new Container_With_Most_Water();
        int result = obj.maxArea(height);
        System.out.println(result);
    }

}
