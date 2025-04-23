import java.util.*;

public class TreeTraversal {
    public List<String> traverse(String root, Map<String,List<String>> tree){
    
        List<String> result = new ArrayList<>();
        if (!tree.containsKey(root)) return result;

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<String> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                String node = queue.poll();
                level.add(node);

                List<String> children = tree.getOrDefault(node, new ArrayList<>());
                if (children.size() > 0 && children.get(0) != null) queue.offer(children.get(0)); // left
                if (children.size() > 1 && children.get(1) != null) queue.offer(children.get(1)); // right
            }

            if (!leftToRight) Collections.reverse(level);
            result.addAll(level);
            leftToRight = !leftToRight;
        }

        return result;
    }
    
    public static void main(String[] args) {
        String root = "A";
        Map<String, List<String>> tree = new HashMap<>();
        tree.put("A", Arrays.asList("B", "C"));
        tree.put("B", Arrays.asList("D", "E"));
        tree.put("C", Arrays.asList("F", "G"));
        tree.put("D", Arrays.asList());
        tree.put("E", Arrays.asList());
        tree.put("F", Arrays.asList());
        tree.put("G", Arrays.asList());
        TreeTraversal main = new TreeTraversal();
        System.out.println(main.traverse(root, tree));
    }
}



