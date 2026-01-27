package Entities;

public enum TransactionType {
    CHECK_BALANCE,
    CASH_WITHDRAWAL;

    public static void showAllTransactionTypes(){

        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
