package assignment3;

class Change {

    public static boolean change(int[] coins, int n) {
        return (recChange(coins, coins.length - 1, n));
    }

    public static boolean recChange(int[] coins, int i, int n) {

        boolean ans = false;
        if (n == 0)
            ans = true;
        while (i > 0 && coins[i] > n)
            i--;
        if (i < 0)
            ans = false;

        if (coins[i] <= n) {
            ans = recChange(coins, i, n - coins[i]);
        }
        return ans;
    }

    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse) {
        boolean ans = recChangeLimited(coins, coins.length - 1, n, numOfCoinsToUse);
        //Task 2.2
        return ans;
    }

    public static boolean recChangeLimited(int[] coins, int i, int n, int numOfCoinsToUse) {

        boolean ans = false;
        if (n == 0)
            ans = true;
        while (i > 0 && coins[i] > n)
            i--;
        if (i < 0)
            ans = false;

        if (coins[i] <= n & numOfCoinsToUse > 0) {
            ans = recChangeLimited(coins, i, n - coins[i], numOfCoinsToUse - 1);
        }
        return ans;
    }

    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        int[] arr = new int[numOfCoinsToUse];
        boolean ans = printRecChangeLimited(coins, coins.length - 1, n, numOfCoinsToUse, arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);
            System.out.print(",");

        }
        System.out.println(arr[arr.length - 1]);
    }

    public static boolean printRecChangeLimited(int[] coins, int i, int n, int numOfCoinsToUse, int[] arr) {

        boolean ans = false;
        if (n == 0)
            ans = true;
        while (i > 0 && coins[i] > n)
            i--;
        if (i < 0)
            ans = false;

        if (coins[i] <= n & numOfCoinsToUse > 0) {
            arr[arr.length - (numOfCoinsToUse)] = coins[i];
            ans = printRecChangeLimited(coins, i, n - coins[i], numOfCoinsToUse - 1, arr);
        }

        return ans;
    }

    public static boolean ChangeLimitedRev(int[] coins, int n, int numOfCoinsToUse) {
        boolean ans = recChangeLimitedRev(coins, 0, n, numOfCoinsToUse);
        //Task 2.2
        return ans;
    }

    public static boolean recChangeLimitedRev(int[] coins, int i, int n, int numOfCoinsToUse) {
        boolean ans = false;
        if (n == 0)
            ans = true;
        while ((i < coins.length - 1) && (n < coins[i])) {
            i++;
        }
        if (i >= coins.length)
            ans = false;

        if (coins[i] <= n & numOfCoinsToUse > 0) {
            for (int place = 0; place < coins.length - i & !ans; place++)
                ans = recChangeLimitedRev(coins, i + place, n - coins[i], numOfCoinsToUse - 1);
        }
        return ans;
    }

    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse) {
        int ans = 0;
        for (int i = 0; i < coins.length; i++)
            ans += recCountChangeLimited(coins, n - coins[i], numOfCoinsToUse - 1, i);
        return ans;
    }

    public static int recCountChangeLimited(int[] coins, int n, int numOfCoinsToUse, int i) {
        int ans = 0;
        if (n == 0)
            return 1;
        if (numOfCoinsToUse == 0 | n < 0)
            return 0;

        for (int j = i; j < coins.length; j++)
            ans += recCountChangeLimited(coins, n - coins[j], numOfCoinsToUse - 1, j);
        return ans;
    }

    public static void printChangeLimited(int[] ans) {

        for (int i = 0; i < ans.length - 1; i++) {
            System.out.print(ans[i]);
            System.out.print(",");

        }
        System.out.println(ans[ans.length - 1]);
    }

    public static void recprintAllChangeLimited(int[] coins, int n, int numOfCoinsToUse, int i, int[] ans) {
        if (n == 0) {
            printChangeLimited(ans);
            return;
        }
        if (numOfCoinsToUse == 0 | n < 0)

            return;
        for (int j = i; j < coins.length; j++) {
            ans[ans.length - numOfCoinsToUse] = coins[j];
            recprintAllChangeLimited(coins, n - coins[j], numOfCoinsToUse - 1, j, ans);
        }
    }

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse) {

        for (int i = 0; i < coins.length; i++) {
            int[] ans = new int[numOfCoinsToUse];
            ans[0] = coins[i];
            recprintAllChangeLimited(coins, n - coins[i], numOfCoinsToUse - 1, i, ans);
        }
    }

}
