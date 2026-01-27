package SplitStrategy;

import Entities.Split;

import java.util.List;

public class UnequalSplit implements ExpenseSplit{
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double total =0;

        for(Split split: splitList){
            total += split.getAmountOwe();
        }

        if(total!=totalAmount) throw new RuntimeException("Not unequally divided");
    }
}
