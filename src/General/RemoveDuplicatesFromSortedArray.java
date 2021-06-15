package General;

public class RemoveDuplicatesFromSortedArray {
    
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for(int next = 1;next < nums.length;next++) {
            if(nums[cur] != nums[next]) {
                if(next - cur > 1) {
                    cur = cur+1;
                    nums[cur] = nums[next];
                }
                else {
                    cur++;
                }
            }
        }
        return cur;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
