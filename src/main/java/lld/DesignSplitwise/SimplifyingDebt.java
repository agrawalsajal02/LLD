package lld.DesignSplitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplifyingDebt {

    public int minTransfers(int [][] transactions) {

        Map<Integer, Integer> memberVsBalanceMap = new HashMap<>();
        // Compute the overall balance (incoming - outgoing) for each member
        for(int[] txn : transactions) {

            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];
            memberVsBalanceMap.put(from, memberVsBalanceMap.getOrDefault(from, 0) - amount);
            memberVsBalanceMap.put(to, memberVsBalanceMap.getOrDefault(to, 0) + amount);
        }

        // Put into the balance list
        List<Integer> balances = new ArrayList<>();
        for(int amount : memberVsBalanceMap.values()) {

            if(amount != 0) {
                balances.add(amount);
            }
        }

        return dfs(balances, 0);
    }

    private int dfs(List<Integer> balances, int currentIndex) {
        // Skip settled balances
        while (currentIndex < balances.size() && balances.get(currentIndex) == 0) {
            currentIndex++;
        }

        // Base case: if we have checked all balances
        if (currentIndex == balances.size()) {
            return 0;
        }

        int minTransactions = Integer.MAX_VALUE;

        for (int i = currentIndex + 1; i < balances.size(); i++) {
            if (balances.get(i) * balances.get(currentIndex) < 0) { // Only try to settle with opposite signs
                // Settle balance between balances[currentIndex] and balances[i]
                balances.set(i, balances.get(i) + balances.get(currentIndex));

                // Recursively calculate the minimum transactions for the next state
                minTransactions = Math.min(minTransactions, 1 + dfs(balances, currentIndex + 1));

                // Backtrack to try other options
                balances.set(i, balances.get(i) - balances.get(currentIndex));
            }
        }

        return minTransactions;
    }

}
