package DP;
import java.util.*;

class CoinChange {
    public static int helper(ArrayList<Integer> coins, int n, int amount) {
        if(amount == 0) return 0;
        if(n <= 0 || amount < 0) return Integer.MAX_VALUE-1;
        
        int include = Integer.MAX_VALUE-1;
        if(amount >= coins.get(n-1)) {
            include = 1 + helper(coins, n, amount - coins.get(n-1));
        }
        int exclude = helper(coins, n-1, amount);
        return Math.min(include, exclude);
    }

    public static int knapsake(ArrayList<Integer> coins, int amount) {
        int n = coins.size();
        int result = helper(coins, n, amount);
        return (result == Integer.MAX_VALUE-1) ? -1 : result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> coins = new ArrayList<>();
    
        while (true) {
            int coin = sc.nextInt();
            if (coin == -1) break;
            coins.add(coin);
        }
        int amount = sc.nextInt();
        System.out.println(knapsake(coins, amount));
        sc.close();
    }
}