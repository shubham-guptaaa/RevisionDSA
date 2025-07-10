import java.util.*;
public class setMatrixZeroes {
    public static void setZeroes(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int row = pair[0];
            int col = pair[1];

            //set row to 0
            for(int i = 0; i<n; i++){
                matrix[row][i] = 0;
            }
            for(int j = 0; j<m; j++){
                matrix[j][col] = 0;
            }
        }
    }
    public static void print(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        print(matrix);
    }
    
}
