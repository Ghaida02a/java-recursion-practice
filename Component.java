import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Component {
    private String id;
    private boolean enabled = true;
    private List<Component> children = new ArrayList<>();

    public Component(String id) {
        this.id = id;
    }

    public void add(Component component) {
        children.add(component);
    }



    public List<Component> getChildren() {
        return children;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        System.out.println("Component " + id + " set to " + (enabled ? "enabled" : "disabled"));
    }
}

class ComponentManager {
//    public static void main(String[] args) {
//        // Create components
//        Component root = new Component("Root");
//        Component child1 = new Component("Child1");
//        Component child2 = new Component("Child2");
//        Component grandChild1 = new Component("GrandChild1");
//        Component grandChild2 = new Component("GrandChild2");
//
//        // Build tree structure
//        root.add(child1);
//        root.add(child2);
//        child1.add(grandChild1);
//        child2.add(grandChild2);
//
//        // Create manager and disable all
//        ComponentManager manager = new ComponentManager();
//        System.out.println("Disabling all components...");
//        manager.disableAll(root);
//    }
    public void disableAll(Component root) {
//        Queue<Component> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            Component current = queue.poll();
//            current.setEnabled(false);
//            for (Component child : current.getChildren()) {
//                queue.offer(child);
//            }
//        }
        root.setEnabled(false);
        for (Component child : root.getChildren()){
            disableAll(child);
        }
    }
}