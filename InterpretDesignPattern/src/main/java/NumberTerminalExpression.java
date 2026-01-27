public class NumberTerminalExpression implements AbstractExpression{

    String stringVal;

    public NumberTerminalExpression(String stringVal){
        this.stringVal = stringVal;
    }

    @Override
    public int interpret(Context context) {
        return context.getVariable(stringVal);
    }
}
