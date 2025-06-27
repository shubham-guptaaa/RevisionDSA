import java.util.*;
public class cycleInDirectedGraph {
    public static boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, int[] visi, int[] pathVisi){
        visi[start] = 1;
        pathVisi[start] = 1;
        for(int node : adj.get(start)){
            if(visi[node]==0){
                if(dfs(node, adj, visi, pathVisi)==true){
                    return true;
                }
                else if(pathVisi[node]==1){
                    return true;
                }
            }
        }
        pathVisi[start] = 0;
        return false;
    }
    public static boolean isCycle(int V, int[][] edges){
        int[] visi = new int[V];
        int[] pathVisi = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int s = edge[0];
            int d = edge[1];

            adj.get(s).add(d);
        }
        for(int i = 0; i<V; i++){
            if(visi[i]==0 && dfs(i, adj, visi, pathVisi)==true) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        // V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
        int[][] edges = {{3,0},{4,2},{1,2}};
        System.out.println(isCycle(V, edges));
        sc.close();
    }
}
