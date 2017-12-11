package javaexample;

public class Apple {
    public Apple(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    int weight;


    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }

}
