package Graph;
import java.util.*;
public class IsGraphBipartite {
    public static boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int[] visi, int currColor){
        visi[start] = currColor;
        for(int neg : adj.get(start)){
            if(neg==currColor) return false;
            if(visi[neg]!=-1 && dfs(neg, adj, visi, 1-currColor)==false) return false;
        }
        return true;
    }
    public static boolean isBipartite(int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = edges.length;
        int[] visi = new int[V];
        Arrays.fill(visi, -1);
        for(int i  =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
       for(int i = 0; i < edges.length; i++){
            for(int j : edges[i]){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
         for(int i = 0; i<V; i++){
            if(visi[i]!=-1 && dfs(i, adj, visi, 0)==false){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // 1. int[][] edges = {{1,2,3},{0,2},{0,1,3},{0,2}};
        // 2. [[1,3],[0,2],[1,3],[0,2]]
        // 3. [[1],[0,3],[3],[1,2]]
        int[][] edges = {{1},{0,3},{3},{1,2}};
        System.out.println(isBipartite(edges));
        
    }
}
