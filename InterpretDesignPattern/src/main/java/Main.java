//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.setVariable("a", 12);
        context.setVariable("b", 5);
        context.setVariable("c", 3);
        context.setVariable("d", 9);
        System.out.println("Context: " + context);

        AbstractExpression multiply = new MultiplicationNonTerminalExpression(new NumberTerminalExpression("a"), new NumberTerminalExpression("c"));
        System.out.println(multiply.interpret(context));

        AbstractExpression binary = new BinaryTerminalExpression(new NumberTerminalExpression("a"), new NumberTerminalExpression("c"), '+');
        System.out.println(binary.interpret(context));
    }
}