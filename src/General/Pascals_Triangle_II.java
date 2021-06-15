package General;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_II {

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>(rowIndex);
        result.add(1);

        for (int index = 0; index < rowIndex; index++) {
            for (int j = index; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}
