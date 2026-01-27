import Adaptee.PoundsWeighingMachine;
import Adaptee.PoundsWeighingMachineChild;
import Adapter.WeightInKg;
import Adapter.WeightInKgImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WeighingMachine {
    public static void main(String[] args) {
        PoundsWeighingMachine poundsWeighingMachine = new PoundsWeighingMachineChild(40);

        WeightInKg weightInKg = new WeightInKgImpl(poundsWeighingMachine);
        System.out.println(weightInKg.getWeightInKg());
    }
}