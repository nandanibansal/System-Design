public class Expression implements ArithmeticExpression {
    ArithmeticExpression left, right;
    OperationType operationType;

    public Expression(ArithmeticExpression left, ArithmeticExpression right, OperationType operationType){
        this.left = left;
        this.right = right;
        this.operationType = operationType;
    }

    @Override
    public int evaluate() {
        int value = 0;
        switch (operationType) {
            case Add:
                value = left.evaluate() + right.evaluate();
                break;
            case Subtract:
                value = left.evaluate() - right.evaluate();
                break;
            case Multiply:
                value = left.evaluate() * right.evaluate();
                break;
            case Divide:
                value = left.evaluate() / right.evaluate();
                break;
        }
        return value;
    }
}
