import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Integer> variables = new HashMap<>();

    public void setVariable(String var, int val)
    {
        variables.put(var, val);
    }

    public int getVariable(String val)
    {
        return variables.get(val);
    }

    @Override
    public String toString() {
        return variables.toString();
    }

}
