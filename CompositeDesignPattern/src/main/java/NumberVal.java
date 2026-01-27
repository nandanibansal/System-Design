public class NumberVal implements ArithmeticExpression{
    int value;

    public NumberVal(int value){
        this.value = value;
    }

    public int evaluate(){
        return value;
    }
}
