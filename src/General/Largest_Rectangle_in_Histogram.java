package General;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxArea = 0;
        int arrayLength = heights.length;
        for (int i = 0; i < arrayLength; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int breadth = heights[stack.pop()];
                int length = i - stack.peek() - 1;
                int area = breadth * length;
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int breadth = heights[stack.pop()];
            int length = arrayLength - stack.peek() - 1;
            int area = breadth * length;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        Largest_Rectangle_in_Histogram obj = new Largest_Rectangle_in_Histogram();
        int result = obj.largestRectangleArea(heights);
        System.out.println(result);
    }
}
