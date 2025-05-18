package Graph;
import java.util.*;
class dfsIsCycle{
    public static boolean dfs(int start, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visi){
        visi[start] = true;
        for(int neg : adj.get(start)){
            if(neg==parent) continue;
            if(visi[neg]) return true;
            else{
                if(dfs(neg, start, adj, visi))
                return true;
            }
        }
        return false;
    }
    public static boolean icCycle(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visi = new boolean[V];
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i = 0; i<V; i++){
            if(!visi[i] && dfs(i, -1, adj, visi)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        System.out.println(icCycle(V, edges));
    }
}