package leetcodeNZ.tags.topInterviewQuestions;

public class TIQ_121_Best_Time_to_Buy_and_Sell_Stock {
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = prices.length - 1; i >= 0 ; i--) {
//            for (int j = i - 1; j >= 0; j--) {
//                int profit = prices[i] - prices[j];
//                if (profit > maxProfit) maxProfit = profit;
//            }
//        }
//        return maxProfit;
//    }

//    public int maxProfit(int[] prices) {
//        if (prices.length == 1) return 0;
//        int minIndex = 0;
//        int maxIndex = 1;
//        int min = prices[minIndex];
//        int max = prices[maxIndex];
//        System.out.println("prices.length: " + prices.length);
//        for (int i = 0; i < prices.length;) {
//            System.out.println("minIndex " + minIndex + " maxIndex " + maxIndex);
//            int minIndexValue = minIndex >= prices.length ? min : prices[minIndex];
//            int maxIndexValue = maxIndex >= prices.length ? max : prices[maxIndex];
//            if (minIndexValue < min) {
//                min = minIndexValue;
//            }
//            if (maxIndexValue > max) {
//                max = maxIndexValue;
//            }
//            System.out.println("minIndexValue " + minIndexValue + " maxIndexValue " + maxIndexValue + " min " + min + " max " + max);
//            minIndex++;
//            maxIndex++;
//            if (minIndex >= maxIndex) {
//                minIndex = maxIndex - 1;
//            }
//            i++;
//        }
//        if (min < max) return max - min;
//        else return 0;
//    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int currentProfit;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            currentProfit = prices[i] - min;
            if (currentProfit > profit) profit = currentProfit;
        }
        return profit;
    }


    public static void main(String[] args) {
//        int array[] = {7,1,5,3,6,4};
//        int array[] = {7,6,4,3,1};
//        int array[] = {2,1,2,0,1};
        int array[] = {1,2,4};
        TIQ_121_Best_Time_to_Buy_and_Sell_Stock object = new TIQ_121_Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(object.maxProfit(array));
    }
}
