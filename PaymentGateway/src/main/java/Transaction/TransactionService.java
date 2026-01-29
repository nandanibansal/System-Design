package Transaction;

import Instrument.*;

import java.util.*;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userID) {
        return userVsTransactionsList.get(userID);
    }

    public void makePayment(TransactionDO txnDO) {
        // validate details

        // load sender instrument details which need to be passed to processors
        InstrumentDO senderInstrumentDO = instrumentController.getInstrumentByID(txnDO.getSenderId(), txnDO.getDebitInstrumentId());

        // load receiver instrument details which need to be passed to processors
        InstrumentDO receiverInstrumentDO = instrumentController.getInstrumentByID(txnDO.getReceiverId(), txnDO.getCreditInstrumentId());

        processor.processPayment(senderInstrumentDO, receiverInstrumentDO);

        //based on processor response, we will set the status. for now har coding it to SUCCESS
        Transaction txn = new Transaction();
        txn.setAmount(txnDO.getAmount());
        txn.setTxnID(txnDO.getTxnID());
        txn.setSenderId(txnDO.getSenderId());
        txn.setReceiverId(txnDO.getReceiverId());
        txn.setDebitInstrumentId(txnDO.getDebitInstrumentId());
        txn.setCreditInstrumentId(txnDO.getCreditInstrumentId());
        txn.setStatus(TransactionStatus.SUCCESS);

        //history
        List<Transaction> senderTxnsList = userVsTransactionsList.computeIfAbsent(txn.getSenderId(), k -> new ArrayList<>());
        senderTxnsList.add(txn);
        List<Transaction> receiverTxnLists = userVsTransactionsList.computeIfAbsent(txn.getReceiverId(), k -> new ArrayList<>());
        receiverTxnLists.add(txn);

        txnDO.setTxnID(txn.getTxnID());
        txnDO.setStatus(txn.getStatus());
    }
}
