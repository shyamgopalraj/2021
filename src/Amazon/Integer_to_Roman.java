package Amazon;

public class Integer_to_Roman {

    public String intToRoman(int num) {

        StringBuilder stringBuilder = new StringBuilder();

        String[] romanSymbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        for (int index = 0; index < value.length && num > 0; index++) {
            if (value[index] <= num ) {
                num -= value[index];
                stringBuilder.append(romanSymbol[index]);
                while (value[index] <= num ) {
                    stringBuilder.append(romanSymbol[index]);
                    num -= value[index];
                }
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Integer_to_Roman obj = new Integer_to_Roman();
        String result = obj.intToRoman(58);
        System.out.println(result);
    }

}
