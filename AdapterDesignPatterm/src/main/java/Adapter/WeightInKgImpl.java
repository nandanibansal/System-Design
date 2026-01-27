package Adapter;

import Adaptee.PoundsWeighingMachine;

public class WeightInKgImpl implements WeightInKg{
    PoundsWeighingMachine poundsWeighingMachine;

    public WeightInKgImpl(PoundsWeighingMachine poundsWeighingMachine){
        this.poundsWeighingMachine = poundsWeighingMachine;
    }

    @Override
    public double getWeightInKg() {
        return poundsWeighingMachine.getWeightInPounds()*0.45;
    }
}
