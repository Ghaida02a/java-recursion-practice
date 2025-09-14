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

        int sum = 0;
        for (Container nestedContainer : container.getContainers()) {
            sum += calculateTotalValue(nestedContainer); // recursion here
        }
        return sum;
    }
}