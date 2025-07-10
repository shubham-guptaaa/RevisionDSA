import java.util.*;
public class sortestPathInUGraph {
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src){
        int V = adj.size();
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;
            for(int neg : adj.get(node)){
                if(result[neg]>weight+1){
                    result[neg] = weight+1;
                    pq.add(new Pair(neg, weight+1));
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // adj[][]= [[3], [3], [], [0, 1]], src=3
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter edges (u v) as space-separated pairs (0-based index):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();
        int[] result = shortestPath(adj, src);
        System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(result));
        
        sc.close();
    }
}
