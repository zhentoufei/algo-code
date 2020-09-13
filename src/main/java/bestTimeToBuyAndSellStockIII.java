import java.util.HashMap;
import java.util.Map;

public class bestTimeToBuyAndSellStockIII {


    public static int maxProfitFun(int[] prices) {
        int maxProfit = 0;

        if (null == prices || prices.length == 0) {
            return maxProfit;
        }
        // maxProfit = dfsProfit(prices, 0, 0, 0);
        Map<String, Integer> map = new HashMap<String, Integer>();
        maxProfit = dfsProfitWithDict(prices, 0, 0, 0, map);
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

    public static Integer dfsProfitWithDict(int[] prices, int index, int status, int buyTime, Map<String, Integer> res){
        String key = String.valueOf(index) + "_" + String.valueOf(status) + "_" + String.valueOf(buyTime);
        if(res.containsKey(key)){
            return res.get(key);
        }
        if(index == prices.length || buyTime == 2){
            res.put(key, 0);
            return 0;
        }
        int keepIncome;
        int buyIncome = 0;
        int saleIncome = 0;

        keepIncome = dfsProfitWithDict(prices, index + 1, status, buyTime, res);
        if(status == 1){
            saleIncome = dfsProfitWithDict(prices, index + 1, 0, buyTime + 1, res) + prices[index];
        }else{
            buyIncome = dfsProfitWithDict(prices, index + 1, 1, buyTime, res) - prices[index];
        }
        res.put(key, Math.max(keepIncome, Math.max(buyIncome, saleIncome)));
        return res.get(key);

    }


    public static void main(String[] args) {
        System.out.println(maxProfitFun(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
