/*
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * */
public class maxProfitII {

    public static int maxProfitFunII(int[] prices) {
        int maxProfit = 0;
        if (null == prices || prices.length == 0 || prices.length == 1) {
            return maxProfit;
        }

        int i = 0;
        while (i < prices.length - 1) {
            int valleyIndex;
            int peakIndex;

            // 这里需要注意prices[i] >= prices[i + 1] 相等的条件
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valleyIndex = i;

            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            peakIndex = i;
            maxProfit += (prices[peakIndex] - prices[valleyIndex]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitFunII(new int[]{3,3}));
    }
}
