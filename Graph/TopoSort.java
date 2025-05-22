package Graph;
import java.util.*;
class TopoSort{
    public static void dfs(int start, int[] visi, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visi[start] = 1;
        for(int node : adj.get(start)){
            if(visi[node]==0){
                dfs(node, visi, adj, st);
            }
        }
        st.push(start);
    }
    public static int[] toposort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visi = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<V; i++){
            if(visi[i]==0){
                dfs(i, visi, adj, st);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i] = st.peek();
            i++;
            st.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
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
            //directed graph
            adj.get(src).add(dest);
        }
        int[] result = toposort(ver, adj);
        for(int res :  result){
            System.out.print(res+" ");
        }
        System.out.println();
        sc.close();
    }
}