import java.util.*;

public class IsGraphBipartiteBFS {
    public static boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] visi, int currColor){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visi[start] = currColor;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neg : adj.get(node)){
                if(visi[neg]==visi[node]) return false;
                if(visi[neg]==-1){
                    visi[neg] = 1-visi[node];
                    q.add(neg);
                }
            }
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
            if(visi[i]!=-1 && bfs(i, adj, visi, 0)==false){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] edges = {{1},{0,3},{3},{1,2}};
        System.out.println(isBipartite(edges));
    }
}
