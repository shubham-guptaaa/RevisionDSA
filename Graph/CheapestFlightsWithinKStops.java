import java.util.*;

public class CheapestFlightsWithinKStops {

    static class Pair{
        int src;
        int cost;
        int step;
        Pair(int src, int cost, int step){
            this.src= src;
            this.cost = cost;
            this.step = step;
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i<n; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new Pair(v, wt, 0));
        }
        int[][] result = new int[n][n];
        for(int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);
        result[src][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.src;
            int cost = curr.cost;
            int step = curr.step;
            if(node==dst) return cost;
            if(step>k) continue; 
            for(Pair neg : adj.get(node)){
                int adjNode = neg.src;
                int newCost = cost+neg.cost;
                if(newCost<result[adjNode][step+1]){
                    result[adjNode][step+1] = newCost;
                    pq.add(new Pair(adjNode, newCost, step+1));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
        // Output: 700
        int[][] arr = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = arr.length;
        int src = 0;
        int dest = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, arr, src, dest, k));
    }
}
