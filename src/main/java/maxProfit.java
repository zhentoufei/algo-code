/*
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * */
public class maxProfit {
    public static int maxProfitFun(int[] prices){
        if(null==prices || prices.length == 0 || prices.length == 1){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(price < minPrice){
                minPrice = price;
            }
            int tmpMaxProfit = price - minPrice;
            if(tmpMaxProfit > 0 && tmpMaxProfit > maxProfit){
                maxProfit = tmpMaxProfit;
            }

        }
        return maxProfit;

    }

    public static void main(String[] args) {
        System.out.println(maxProfitFun(new int[]{3,2,1}));
    }
}
