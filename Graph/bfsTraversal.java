package Graph;
import java.util.*;

class bfsTraversal {
    public static void buildGraph(ArrayList<ArrayList<Integer>> adj, Scanner sc) {
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        
        // Initialize adjacency list
        for (int i = 0; i <= vertices; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        
        System.out.println("Enter " + edges + " edges (format: source destination):");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            
            // Add edges for undirected graph
            adj.get(source).add(dest);
            adj.get(dest).add(source);
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int start, int v) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visi = new boolean[v + 1];
        ArrayList<Integer> b = new ArrayList<>();
        
        q.add(start);
        visi[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            b.add(curr);
            for (int i : adj.get(curr)) {
                if (!visi[i]) {
                    visi[i] = true;
                    q.add(i);
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        buildGraph(adj, sc);
        
        System.out.print("Enter starting vertex for BFS: ");
        int start = sc.nextInt();
        
        ArrayList<Integer> b = bfs(adj, start, adj.size() - 1);
        System.out.println("BFS traversal: " + b);
        
        sc.close();
    }
}
