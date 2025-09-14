import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Item {
    private int value;

    public Item(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}



class Container {
    private Item item;
    private List<Container> containers;

    public Container(Item item) {
        this.item = item;
        this.containers = null;
    }

    public Container(List<Container> containers) {
        this.item = null;
        this.containers = containers;
    }

    public boolean isItem() {
        return item != null;
    }

    public Item getItem() {
        return item;
    }

    public List<Container> getContainers() {
        return containers;
    }
}

class ValueCalculator {
    public int calculateTotalValue(Container container) {
        if (container.isItem()) {
            return container.getItem().getValue();
        }

        int sumOfObjects = 0;
        for (Container subContainer : container.getContainers()) {
            sumOfObjects += calculateTotalValue(subContainer); // recursion here
        }
        return sumOfObjects;
    }
//    public static void main(String[] args) {
//        // Create individual items
//        Container c1 = new Container(new Item(10));
//        Container c2 = new Container(new Item(20));
//        Container c3 = new Container(new Item(30));
//
//        // Nest some containers
//        List<Container> nested1 = new ArrayList<>();
//        nested1.add(c1);
//        nested1.add(c2);
//        Container group1 = new Container(nested1);
//
//        List<Container> nested2 = new ArrayList<>();
//        nested2.add(group1);
//        nested2.add(c3);
//        Container topLevel = new Container(nested2);
//
//        // Calculate total value
//        ValueCalculator calculator = new ValueCalculator();
//        int total = calculator.calculateTotalValue(topLevel);
//
//        System.out.println("Total value of all items: " + total);
//    }
}