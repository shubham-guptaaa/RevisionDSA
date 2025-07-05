import java.util.*;
class MedianArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i<n; i++) arr1[i] = sc.nextInt(); 
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i<m; i++) arr2[i] = sc.nextInt();
        int[] result = new int[n+m];
        int i = 0;
        int j = 0;
        int idx= 0;
        while(i<n){
            result[idx++] = arr1[i];
            i++;
        } 
        while(j<m){
            result[idx++] = arr2[j];
            j++;
        }
        Arrays.sort(result);
        int mid = result.length / 2;
        if(result.length % 2 == 0){
            float median = (result[mid] + result[mid - 1]) / 2.0f;
            System.out.println(median);
        }
        else{
            float median = result[mid];
            System.out.println(median);
        }
        sc.close();
    }
}
