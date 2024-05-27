import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Item{
        int value, weight;
        double valuePerUnitWeight;
        Item(int value, int weight){
            this.value = value;
            this.weight = weight;

            valuePerUnitWeight = (double) value/weight;
        }
    }

    static class ValueByWeightComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {

            if (o1.valuePerUnitWeight>o2.valuePerUnitWeight){
                return -1;
            }
            else if (o1.valuePerUnitWeight < o2.valuePerUnitWeight) {
                return 1;
            }
            return 0;
        }
    }
    public static int solve(int[] A, int[] B, int C) {
        Item[] items = new Item[A.length];
        for (int i = 0; i < A.length; i++) {
            items[i] = new Item(A[i], B[i]);
        }
        Arrays.sort(items, new ValueByWeightComparator());
        double ans = 0;
        for (Item item : items) {
            int value = item.value, weight = item.weight;
            double valuePerUnitWeight = item.valuePerUnitWeight;
            if (C >= weight) {
                ans += value;
                C -= weight;
            } else {
                ans = ans + valuePerUnitWeight * C;
                break;
            }
        }
        ans = ans * 1000;
        return (int) ans/10;
    }
    public static void main(String[] args) {
        int[] A = {3};
        int[] B = {20};
        int C = 17;
        System.out.println(solve(A,B,C));
    }
}
