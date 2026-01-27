package Adaptee;

public class PoundsWeighingMachineChild implements PoundsWeighingMachine{

    double weight;

    public PoundsWeighingMachineChild(double weight){
        this.weight = weight;
    }

    @Override
    public double getWeightInPounds() {
        return weight;
    }
}
