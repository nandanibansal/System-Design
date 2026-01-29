package Transaction;

import java.util.List;

public class TransactionController {
    TransactionService txnService;

    public TransactionController() {
        this.txnService = new TransactionService();
    }

    public void makePayment(TransactionDO txnDO) {
        txnService.makePayment(txnDO);
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return txnService.getTransactionHistory(userID);
    }

}
