package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Implement_strStr {

    public static int solution(int[] A, int monkeyjump) {
        int monkeyPosStart = -1;
        int newMonkeyPos = -1;
        int steps = 0;
        for (int index = 0; index < A.length; index++) {

//            int startIndex = index;
            int maxJump = newMonkeyPos + monkeyjump;

            while (index <= maxJump && index < A.length) {
                
                int val = A[index];
                
                while(val != index+1) {
                    steps++;
                    val--;
                    continue;
                }
                if (A[index] >= 0) {
                    newMonkeyPos = index;
                }
                if(index+1 > maxJump) {
                    break;
                }
                index++;
            }

            if (newMonkeyPos != monkeyPosStart) {
                monkeyPosStart = newMonkeyPos;
                steps++;
            }
        }

        if (newMonkeyPos != A.length - 1) {
            return -1;
        }
        return steps;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = { 3,2,1 };
        int monkeyjump = 1;
        int result = solution(array, monkeyjump);
        System.out.println(result);
    }

}
