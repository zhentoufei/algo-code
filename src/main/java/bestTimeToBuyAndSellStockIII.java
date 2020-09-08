import java.util.List;

public class bestTimeToBuyAndSellStockIII {

    public static int maxProfitFun(int[] prices){
        int maxProfit = 0;

        if(null == prices || prices.length == 0 || prices.length == 1){
            return maxProfit;
        }

        int length = prices.length;


        int valleyIndex;
        int peakIndex;
        int smallProfit = 0;
        int bigProfit = 0;
        int i = 0;
        while (i < length - 1){

            while (i < length -1 && prices[i] >= prices[i + 1]){
                i ++;
            }
            valleyIndex = i;

            while (i < length - 1 && prices[i] < prices[i + 1]){
                i ++;
            }
            peakIndex = i;

            int tempProfit = prices[peakIndex] - prices[valleyIndex];
            if(tempProfit > bigProfit){
                smallProfit = bigProfit;
                bigProfit = tempProfit;
            }else if(tempProfit > smallProfit && tempProfit < bigProfit){
                smallProfit = tempProfit;
            }
        }
        maxProfit = smallProfit + bigProfit;

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitFun(new int[]{3,3,5,0,0,3,1,4}));
    }
}
