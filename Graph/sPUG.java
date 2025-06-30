import java.util.*;
class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class sPUG {
    public static int[] shortestPath(int V, int E, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<E; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int wei = curr.weight;
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int dist = it.weight;
                if(result[adjNode]>dist+wei){
                    result[adjNode] = dist+wei;
                    pq.add(new Pair(adjNode, dist+wei));
                }
            }
        }
        for(int i = 0; i<V; i++){
            if(result[i] == Integer.MAX_VALUE)
            result[i] = -1;
        }
        return result;
    }
    public static void main(String[] args) {
        // Input: V = 4, E = 2, edges = [[0,1,2], [0,2,1]]
        int V = 4;
        int E = 2;
        int[][] edges = {{0,1,2},{0,2,1}};
        int[] result = shortestPath(V, E, edges);
        for(int num : result){
            System.out.print(num+" ");
        }

    }
}
