package General;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    
    int n;
    int k;
    List<List<Integer>> result;
    
    public List<List<Integer>> combine(int n, int k) {
        this.result = new LinkedList<>();
        this.n = n;
        this.k = k;
        solution(1,new LinkedList<>());
        return result;
    }

    private void solution(int first, LinkedList<Integer> combinations) {
        if(combinations.size() == k) {
            result.add(new LinkedList<>(combinations));
        }
        
        for(int index = first;index <= n;index++) {
            combinations.add(index);
            solution(index+1, combinations);
            combinations.removeLast();
          
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        List<List<Integer>> result = obj.combine(4, 2);
        System.out.println(result);
        for(List<Integer> combination:result) {
            System.out.println(combination);
        }
    }

}
