package java8;

public class Transaction {

    private final Trader trader;
    private final int value;
    private final int year;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", value=" + value +
                ", year=" + year +
                '}';
    }

}
