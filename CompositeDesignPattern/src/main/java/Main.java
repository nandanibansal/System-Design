import java.lang.Number;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("======= Composite Design Pattern ======");
        ArithmeticExpression two = new NumberVal(2);
        ArithmeticExpression one = new NumberVal(1);
        ArithmeticExpression seven = new NumberVal(7);

        ArithmeticExpression addExpression = new Expression(one, seven, OperationType.Add);
        ArithmeticExpression parentExpression = new Expression(two, addExpression, OperationType.Multiply);

        System.out.println(parentExpression.evaluate());
    }
}