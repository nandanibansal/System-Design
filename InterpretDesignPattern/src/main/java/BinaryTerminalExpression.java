public class BinaryTerminalExpression implements AbstractExpression{
    AbstractExpression leftExpression, rightExpression;
    char operator;

    public BinaryTerminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression, char operator){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int interpret(Context context) {
        return switch (operator){
            case '*'-> leftExpression.interpret(context) * rightExpression.interpret(context);
            case '+' -> leftExpression.interpret(context) + rightExpression.interpret(context);
            default -> 0;
        };
    }
}
