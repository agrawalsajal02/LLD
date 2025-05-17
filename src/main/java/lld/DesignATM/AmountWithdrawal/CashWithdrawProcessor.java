package lld.DesignATM.AmountWithdrawal;

import LowLevelDesign.DesignATM.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawalProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawalProcessor) {

        this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;

    }

    public void withdraw(ATM atm, int remainingAmount) {

        if (nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}


//        | Aspect                     | Decorator                   | Chain of Responsibility    |
//        | -------------------------- | --------------------------- | -------------------------- |
//        | **Goal**                   | Add behavior dynamically    | Pass request until handled |
//        | **Flow**                   | Always calls wrapped object | May stop at any handler    |
//        | **Client aware of chain?** | Yes                         | No                         |
//        | **Behavior extension**     | Yes                         | No, just passing logic     |
//