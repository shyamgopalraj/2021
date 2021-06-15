package Microsoft;

import java.util.Arrays;
import java.util.Comparator;

public class Meeting_Rooms_II {

    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] array1, int[] array2) {
                return array1[1] - array2[0];
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] array1, int[] array2) {
                if (array1[0] == array2[0]) {
                    return array1[1] - array2[1];
                }
                return array1[0] - array2[0];
            }
        });



        int minMeetingRoom = 1;
        int[] cur = intervals[0];
        for (int index = 1; index < intervals.length; index++) {
            int[] next = intervals[index];
            if (cur[1] > next[0]) {
                minMeetingRoom++;
            }
            cur = next;

        }
        return minMeetingRoom;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] intervals = { { 9, 10 }, { 4, 9 }, { 4, 17 } };
        Meeting_Rooms_II obj = new Meeting_Rooms_II();
        int result = obj.minMeetingRooms(intervals);
        System.out.println(result);
    }

}
