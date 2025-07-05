import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

class PrimsAlgo{
    static class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public static int spanningTree(int V, int E, List<List<int[]>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        int[] visi = new int[V];
        int sum = 0;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;
            if(visi[node]==1) continue;
            visi[node] = 1;
            sum +=wt;
            for(int i = 0; i<adj.get(node).size(); i++){
                int adjNode = adj.get(node).get(i)[0];
                int w = adj.get(node).get(i)[1];
                if(visi[adjNode]==0){
                    pq.add(new Pair(adjNode, w));
                }
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        // Input:
        // 3 3
        // 0 1 5
        // 1 2 3
        // 0 2 1
        int V = 3;
        int E = 3;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new java.util.ArrayList<>());
        }
        // Edge: 0 1 5
        adj.get(0).add(new int[]{1, 5});
        adj.get(1).add(new int[]{0, 5});
        // Edge: 1 2 3
        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});
        // Edge: 0 2 1
        adj.get(0).add(new int[]{2, 1});
        adj.get(2).add(new int[]{0, 1});
        System.out.println(spanningTree(V, E, adj));
    }
}