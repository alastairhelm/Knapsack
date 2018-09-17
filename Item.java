public class Item {

    private int value;
    private int weight;

    public Item(int weight, int value){
        this.value = value;
        this.weight = weight;
    }

    public int getValue(){
        return value;
    }

    public int getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}