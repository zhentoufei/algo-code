import java.util.List;

public class bestTimeToBuyAndSellStockIII {


    public static int maxProfitFun(int[] prices) {
        int maxProfit = 0;

        if (null == prices || prices.length == 0) {
            return maxProfit;
        }
        maxProfit = dfsProfit(prices, 0, 0, 0);

        return maxProfit;
    }
    // 这个方法超时了
    public static int dfsProfit(int[] prices, int index, int status, int buyTime) {
        // statues 1: 代表购买
        // buyTime 带包当前购买次数
        if (index == prices.length || buyTime == 2) {
            return 0;
        }

        int keepIncome;
        int buyIncome = 0;
        int saleIncome = 0;

        keepIncome = dfsProfit(prices, index + 1, status, buyTime);

        if (status == 1) {
            saleIncome = dfsProfit(prices, index + 1, 0, buyTime + 1) + prices[index];
        } else {
            buyIncome = dfsProfit(prices, index + 1, 1, buyTime) - prices[index];
        }

        return Math.max(keepIncome, Math.max(buyIncome, saleIncome));

    }


    public static void main(String[] args) {
        System.out.println(maxProfitFun(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
