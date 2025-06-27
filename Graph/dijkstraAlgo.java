import java.util.*;
class Pair{
    int distance;
    int node;
    Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}
class dijkstraAlgo {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++) adj.add(new ArrayList<>());
        // Build adjacency list from edge list
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] result = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[src] = 0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int dist = curr.distance;
            int node = curr.node;
            for(Pair neg: adj.get(node)){
                int adjNode = neg.node;
                int weight = neg.distance;
                if(dist+weight<result[adjNode]){
                    result[adjNode] = dist+weight;
                    pq.add(new Pair(result[adjNode],adjNode));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
            {0, 1, 2},
            {0, 2, 4},
            {1, 2, 1},
            {1, 3, 7},
            {2, 4, 3},
            {3, 4, 1}
        };
        int src = 0;
        dijkstraAlgo obj = new dijkstraAlgo();
        int[] result = obj.dijkstra(V, edges, src);
        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < result.length; i++) {
            System.out.println("To node " + i + " = " + result[i]);
        }
    }
}