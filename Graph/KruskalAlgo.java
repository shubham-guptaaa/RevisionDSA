import java.util.*;

public class KruskalAlgo {
    static class Pair implements Comparable<Pair> {
        int u;
        int v;
        int wt;

        Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair other) {
            return this.wt - other.wt; // Sort by weight
        }
    }

    static class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
                return node;
            int temp = findParent(parent.get(node));
            parent.set(node, temp);
            return parent.get(node);
        }

        public void union(int u, int v) {
            int up = findParent(u);
            int uv = findParent(v);
            if (up == uv)
                return;
            if (rank.get(up) < rank.get(uv))
                parent.set(up, uv);
            else if (rank.get(up) > rank.get(uv))
                parent.set(uv, up);
            else {
                parent.set(uv, up);
                int rankU = rank.get(up);
                rank.set(up, rankU + 1);
            }
        }
    }

    public static int Kruskal(int V, int[][] edges) {
        List<Pair> p = new ArrayList<>();
        for (int[] edge : edges) {
            p.add(new Pair(edge[0], edge[1], edge[2]));
        }
        Collections.sort(p);
        DisjointSet ds = new DisjointSet(V);
        int weight = 0;
        int count = 0;
        for (Pair e : p) {
            if (ds.findParent(e.u) != ds.findParent(e.v)) {
                weight += e.wt;
                ds.union(e.u, e.v);
                count++;
                if (count > V)
                    break;
            }
        }
        return weight;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                { 0, 1, 10 },
                { 0, 2, 6 },
                { 0, 3, 5 },
                { 1, 3, 15 },
                { 2, 3, 4 }
        };

        System.out.println("MST Weight: " + Kruskal(V, edges));
    }
}
