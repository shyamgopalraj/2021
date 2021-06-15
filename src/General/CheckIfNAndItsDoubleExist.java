package General;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
