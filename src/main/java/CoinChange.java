public class CoinChange {
    public static int coinChange(int[] coins, int target){
        if(target == 0 || coins.length == 0){
            return 0;
        }

        if(target < 0){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            if(res == -1) continue;
            res = Math.min(res, dp(coins, target - coin) + 1);
        }
        return res;
    }

    public static int dp(int[] coins, int target){
        if(target <= 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            if(res == 0) continue;
            res = Math.min(res, dp(coins, target -coin) + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] coins = new int[]{2,3};
        int target = 2;
        System.out.println(coinChange(coins, target));
    }
}
