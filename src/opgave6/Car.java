package opgave6;



public class Car {
    private String make;
    private String model;
    private boolean electric;
    private double price;

    public Car(String mærke, String model, boolean elektrisk, double prisPrDag) {
        this.make = mærke;
        this.model = model;
        this.electric = elektrisk;
        this.price = prisPrDag;
    }

    @Override
    public String toString() {
        return make + " " + model + ", pris pr dag: " + price + "kr.";
    }
}


