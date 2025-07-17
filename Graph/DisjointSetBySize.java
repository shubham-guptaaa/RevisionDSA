import java.util.*;

public class DisjointSetBySize {
    static List<Integer> size = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();
    DisjointSetBySize(int n){
        for(int i = 0; i<=n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node)) return node;
        int temp = findParent(parent.get(node));
        parent.set(node,temp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v){
        int up = findParent(u);
        int uv = findParent(v);
        if(up==uv) return;
        if(size.get(up)<size.get(uv)){
            parent.set(up,uv);
            size.set(uv,size.get(uv)+size.get(up));
        }
        else{
            parent.set(uv,up);
            size.set(up,size.get(up)+size.get(uv));
        }
    }
    public static void main(String[] args) {
        DisjointSetBySize ds = new DisjointSetBySize(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        if(ds.findParent(3)==ds.findParent(7)) System.out.println("yes");
        else System.out.println("no");
        ds.unionBySize(3, 7);
        if(ds.findParent(3)==ds.findParent(7)) System.out.println("yes");
        else System.out.println("no");
    }
}
