import java.util.*; 
public class bfsIsCycle {
    public static boolean bfs(int start, List<List<Integer>> adj, boolean[] visi){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,-1});
        visi[start] = true;
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0];
            int parent = pair[1];
            for(int neg : adj.get(node)){
                if(neg==parent) continue;
                if(visi[neg]) return true;
                else{
                    q.add(new int[]{neg,node});
                    visi[neg] = true;
                }
            }
        }
        return false;
    }
    public static boolean isCycle(int V, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visi = new boolean[V];
        for(int i  =0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i =0; i<V; i++){
            if(!visi[i] && bfs(i, adj, visi)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
        int V = 4;
        // int[][] egdes = {{0,1},{0,2},{1,2},{2,3}};

        // V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
        int[][] egdes = {{0,1},{1,2},{2,3}};
        System.out.println(isCycle(V, egdes));
    }
}
