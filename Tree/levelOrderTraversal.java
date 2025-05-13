import java.util.*;
class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class levelOrderTraversal {
    public static Node buildTree(ArrayList<Integer> arr){
        if(arr.size()==0 || arr.get(0)==null) return null;
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<arr.size() && !q.isEmpty()){
            Node curr = q.poll();
            if(curr != null){
                if(i<arr.size() && arr.get(i)!=null){
                    curr.left = new Node(arr.get(i));
                    q.add(curr.left);
                }
                i++;
                if(i<arr.size() && arr.get(i)!=null){
                    curr.right = new Node(arr.get(i));
                    q.add(curr.right);
                }
                i++;
            }
        }
        return root;
    }
    public static ArrayList<ArrayList<Integer>> levelOrder(Node root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i = 0; i<size; i++){
                Node curr = q.poll();
                ds.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            result.add(ds);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        String str = sc.nextLine();
        String[] part = str.trim().split(",");
        ArrayList<Integer> arr = new ArrayList<>();
        for(String s : part){
            s = s.trim();
            if(s.equals("null")){
                arr.add(null);
            }
            else{
                arr.add(Integer.parseInt(s));
            }
        }
        Node root = buildTree(arr);

        ArrayList<ArrayList<Integer>> result = levelOrder(root);
        System.out.println(result);
        sc.close();
    }
}
