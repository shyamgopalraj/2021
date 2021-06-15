package Microsoft;

public class Maximal_Network_Rank {
    
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] cnts = new int[n];
        for (int[] r : roads) {
            cnts[r[0]]++;
            cnts[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;  // cache if i and j directly connected
        }
        int res = 0;
        for (int i = 0; i < n; i++) 
            for (int j = i + 1; j < n; j++) 
                res = Math.max(res, cnts[i] + cnts[j] - (connected[i][j] ? 1 : 0));  // loop all pairs
        return res;
    }

    public static void main(String[] args) {
        Maximal_Network_Rank obj = new Maximal_Network_Rank();
        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
        int result = obj.maximalNetworkRank(4, roads);
        System.out.println(result);
    }

}
