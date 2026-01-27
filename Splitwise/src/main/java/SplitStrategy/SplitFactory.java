package SplitStrategy;

import Entities.ExpenseSplitType;

public class SplitFactory {
    public static ExpenseSplit  getSplitObject(ExpenseSplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualSplit();
            case UNEQUAL:
                return new UnequalSplit();
            case PERCENTAGE:
                return new PercentageSplit();
            default:
                return null;
        }
    }
}
