package General;

public class Coin_Change {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return amount;
        int length = amount + 1;
        int[] array = new int[length];
        array[0] = 0;
        for (int index = 1; index < length; index++) {
            array[index] = Integer.MAX_VALUE;
        }

        for (int index = 1; index < length; index++) {
            for (int coin : coins) {
                if (coin <= index) {
                    int diff = index - coin;
                    if (array[diff] != Integer.MAX_VALUE) {
                        array[index] = Math.min(array[index], array[diff] + 1);
                    }
                }
            }
        }

        if (array[length - 1] == Integer.MAX_VALUE)
            return -1;
        return array[length - 1];
    }

    public static void main(String[] args) {
        Coin_Change obj = new Coin_Change();
        int[] coins = { 2 };
        int amount = 3;
        int minimumCoins = obj.coinChange(coins, amount);
        System.out.println(minimumCoins);
    }

}
