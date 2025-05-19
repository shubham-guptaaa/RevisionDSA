package Graph;
import java.util.*;
public class dfsTraversal {
    public static void buildGraph(ArrayList<ArrayList<Integer>> adj, Scanner sc){
        System.out.println("Enter the number of vertex/Node: ");
        int ver = sc.nextInt();
        for(int i =0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter the number of edge connected to the vertex/node: ");
        int edge = sc.nextInt();

        for(int i =0; i<edge; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();

            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans ,boolean[] visi){
        visi[node] = true;
        ans.add(node);
        for(int i : adj.get(node)){
            if(visi[i]==false){
                dfs(i, adj, ans, visi);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        buildGraph(adj, sc);
        ArrayList<Integer> ans = new ArrayList<>(); 
        boolean[] visi = new boolean[adj.size()];
        dfs(adj.size()-1, adj, ans, visi);
        System.out.println(ans);
        sc.close();
    }
}
