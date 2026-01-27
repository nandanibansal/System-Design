package SplitStrategy;

import Entities.Split;

import java.util.List;

public class EqualSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double amountShouldBePresent = totalAmount/ splitList.size();

        for(Split split: splitList){
            if(split.getAmountOwe()!=amountShouldBePresent){
                throw new RuntimeException("Not equally splited");
            }
        }
    }
}
