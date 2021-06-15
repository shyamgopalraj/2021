package Microsoft;


public class Reverse_Words_in_a_String {

    public String reverseWords(String s) {
        if (s.isEmpty())
            return null;
        String[] sArray = s.trim().split("\\s+");
        int start = 0;
        int end = sArray.length - 1;
        while (start < end) {
            String temp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for (String string : sArray) {
            sb.append(string + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Shyam    gopal";
        Reverse_Words_in_a_String obj = new Reverse_Words_in_a_String();
        System.out.println(obj.reverseWords(s));
    }

}
