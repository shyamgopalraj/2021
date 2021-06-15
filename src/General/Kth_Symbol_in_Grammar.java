package General;

public class Kth_Symbol_in_Grammar {

    public static int kthGrammar(int N, int K) {
        if(N == 1)
            return 0;
        int lastDigit = kthGrammar(N-1, (K+1)/2);
        if((lastDigit == 0 && K%2 == 0) || (lastDigit == 1 && K%2 != 0))
            return 1;
        return 0;
            
    }
    
    public static void main(String[] args) {
        int result = kthGrammar(4, 7);
        System.out.println(result);
    }
    

}
