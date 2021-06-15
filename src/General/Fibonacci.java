package General;

import java.util.HashMap;

public class Fibonacci {

    public static int getFibonacci(int n) {
        if (n > 1) {
            int[] fibSeries = new int[n+1];
            fibSeries[0] = 0;
            fibSeries[1] = 1;
            computeFibOfN(fibSeries);
            return fibSeries[n];
        }
        return n;
    }

    private static void computeFibOfN(int[] fibSeries) {
        for (int index = 2; index < fibSeries.length; index++) {
            fibSeries[index] = fibSeries[index - 1] + fibSeries[index - 2];
        }
    }
    
    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    private static int fib(int N) {
      if (cache.containsKey(N)) {
        return cache.get(N);
      }
      int result;
      if (N < 2) {
        result = N;
      } else {
        result = fib(N-1) + fib(N-2);
      }
      // keep the result in cache.
      cache.put(N, result);
      return result;
    }

    public static void main(String[] args) {
        int result = fib(3);
        System.out.println(result);
    }

}
