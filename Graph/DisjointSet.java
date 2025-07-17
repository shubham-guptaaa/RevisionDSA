import java.util.*;

class DisjointSet{
    static List<Integer> rank = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0; i<=n; i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findPar(int node){
        if(node==parent.get(node)) return node;
        int temp = findPar(parent.get(node));
        parent.set(node,temp);
        return parent.get(node);
    }
    public void union(int u, int v){
        int up = findPar(u);
        int uv = findPar(v);
        if(up==uv) return;
        if(rank.get(up)<rank.get(uv)) parent.set(up,uv);
        else if(rank.get(up)>rank.get(uv)) parent.set(uv,up);
        else{
            parent.set(up,uv);
            int rankU = rank.get(up);
            rank.set(up,rankU+1);
        }
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.union(1,2);
        ds.union(2,3);
        ds.union(4,5);
        ds.union(6,7);
        ds.union(5,6);

        if(ds.findPar(3)==ds.findPar(7)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        ds.union(3, 7);
        if(ds.findPar(3)==ds.findPar(7)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }


    }
}