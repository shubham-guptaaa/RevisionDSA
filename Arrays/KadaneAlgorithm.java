package Arrays;
import java.util.*;
public class KadaneAlgorithm {
    public static int maxSumSubArray(int[] arr){
        int n = arr.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
            max = Math.max(max, sum);
            if(sum<0){
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of element in array: ");
        int n = sc.nextInt();
        System.out.println("Enter the element in array: ");
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();
        System.out.println(maxSumSubArray(arr));
        sc.close();
    }
}
