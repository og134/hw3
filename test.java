package assignment3;

public class test {
        private static void printSolution(int[] sol, int n) { // a function that giving a solution array and a sum print only
    int sum = 0;									  //the valid integers in the requested format
    for(int i = 0; i<sol.length & sum<n && sol[i] != 0;i++) {
        sum += sol[i];
        if(i < sol.length-1 & sum <n) {
            System.out.print(sol[i] +",");
        }
        else
            System.out.println(sol[i]);
    }


}
        private static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse, int sum,int lowerLimit){
            int ans = 0;
            if(sum == n) return 1;
            if(numOfCoinsToUse <= 0 | sum > n) return 0;
            for(int i = lowerLimit; i<coins.length;i++) { // after finding a solution i don't need to use the lower values anymore
                int coin = coins[i];
                ans+=countChangeLimited(coins,n,numOfCoinsToUse-1,sum+coin,i);
            }
            return ans;
        }
        public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
            int ans = 0;
            for(int i = 0; i<coins.length;i++) {
                int coin = coins[i];
                ans +=countChangeLimited(coins,n,numOfCoinsToUse-1,coin, i);
            }
            return ans;
        }

        public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse,int sum ,int lowerLimit ,int[] sol){
            if(sum == n) printSolution(sol,n);
            if(numOfCoinsToUse <= 0 | sum > n) return;
            for(int i = lowerLimit; i<coins.length;i++) {
                int coin = coins[i];
                sol[sol.length-numOfCoinsToUse] =  coin;
                printAllChangeLimited(coins,n,numOfCoinsToUse-1,sum+coin,i,sol);
            }
        }

        public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
            for(int i = 0; i<coins.length;i++) {
                int coin = coins[i];
                int[] sol = new int[numOfCoinsToUse]; // reset the solution array for each new starting coin
                sol[0] =  coin;
                printAllChangeLimited(coins,n,numOfCoinsToUse-1,coin, i,sol);
            }
        }
}
