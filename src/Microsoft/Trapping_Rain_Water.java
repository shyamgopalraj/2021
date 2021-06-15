package Microsoft;

public class Trapping_Rain_Water {
    public int trap(int[] height) {

        int trapperWaterVol = 0;
        int length = height.length;
        if (length <= 2)
            return 0;

        int left = 0;
        int right = length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {

            int minMax = Math.min(leftMax, rightMax);
            if (minMax == leftMax) {
                left++;
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    trapperWaterVol += leftMax - height[left];
                }

            } else {
                right--;
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    trapperWaterVol += rightMax - height[right];
                }
            }
        }

        return trapperWaterVol;

    }
    
    public static void main(String[] args) {
        Trapping_Rain_Water obj = new Trapping_Rain_Water();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedRainWaterVol = obj.trap(height);
        System.out.println(trappedRainWaterVol);
    }
}
