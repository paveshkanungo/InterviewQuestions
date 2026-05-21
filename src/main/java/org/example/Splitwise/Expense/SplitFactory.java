package org.example.Splitwise.Expense;

import org.example.Splitwise.Expense.Split.EqualExpenseSplit;
import org.example.Splitwise.Expense.Split.ExpenseSplit;
import org.example.Splitwise.Expense.Split.PercentageExpenseSplit;
import org.example.Splitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
