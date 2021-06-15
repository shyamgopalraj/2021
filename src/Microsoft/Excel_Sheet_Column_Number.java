package Microsoft;

public class Excel_Sheet_Column_Number {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int index = 0; index < columnTitle.length(); index++) {
            result = result * 26;
            result = result + (columnTitle.charAt(index) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
