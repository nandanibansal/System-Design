public class MultiplicationNonTerminalExpression implements AbstractExpression{
    AbstractExpression leftExpression, rightExpression;

    public MultiplicationNonTerminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) * rightExpression.interpret(context);
    }
}
