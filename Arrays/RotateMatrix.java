class RotateMatrix{
    public static int[][] rotate(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        //Transpose of Matrix
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i<=j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                }
            }
        }
        // Reverse Matrix 
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        return matrix;
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
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] ans = rotate(matrix);
        print(ans);
    }
}