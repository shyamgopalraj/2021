package Microsoft;

public class Reverse_String {
    
    public void reverseString(char[] s) {
        int start =0;
        int end = s.length-1;
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Reverse_String obj = new Reverse_String();
        obj.reverseString(s);
        System.out.println(s);
    }

}
