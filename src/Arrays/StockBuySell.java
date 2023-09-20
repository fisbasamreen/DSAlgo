package src.Arrays;

public class StockBuySell {
    static int maxProfit(int[] price) {
        int min = price[0], max=0, cost =0;
        for(int i=0;i<price.length;i++) {
            if(min > price[i]){
                min = price[i];
            }
            cost = price[i]-min;

            if(max<cost){
                max = cost;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310,
                40, 535, 695 };
        int n = price.length;

        System.out.print(maxProfit(price));
    }
}
