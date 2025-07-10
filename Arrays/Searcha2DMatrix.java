public class Searcha2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        // TC:- O(log(m*n));
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = n*m-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target) end = mid-1;
            else start = mid+1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{6,7,8},{9,11,24}};
        int target = 28;
        System.out.println(searchMatrix(matrix, target));
    }
}
