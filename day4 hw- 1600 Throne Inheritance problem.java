import java.util.*;

class ThroneInheritance {
    private final String king;
    // Maps each parent to their list of children in order of birth
    private final Map<String, List<String>> familyTree;
    // Tracks dead family members
    private final Set<String> deadMembers;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deadMembers = new HashSet<>();
        // Initialize the king's entry in the family tree
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Add the child to the parent's list of children
        this.familyTree.get(parentName).add(childName);
        // Initialize the child's own entry in the tree
        this.familyTree.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        // Mark the person as dead
        this.deadMembers.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Perform pre-order DFS starting from the king
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // Add to the order only if the person is alive
        if (!deadMembers.contains(current)) {
            order.add(current);
        }
        
        // Traverse children in birth order
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
