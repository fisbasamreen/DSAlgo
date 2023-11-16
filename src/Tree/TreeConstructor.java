package src.Tree;

/*
TreeConstructor(strArr) take the array of strings stored in strArr, which will contain pairs of integers in the following format: (i1,i2),
where i1 represents a child node in a tree and the second integer i2 signifies that it is the parent of i1.
For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"]
 */

/* Notes:
You can use a HashMap to represent the tree structure, where the keys are parent nodes, and the values are lists of child nodes.
Make sure only one root node exists(no parents)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeConstructor {
    public static String buildTree(String[] strArr) {
        Map<Integer, List<Integer>> tree = new HashMap<>();

        // Parse the input strings to build the tree
        for (String pairStr : strArr) {
            String[] pair = pairStr.substring(1, pairStr.length() - 1).split(",");
            int child = Integer.parseInt(pair[0]);
            int parent = Integer.parseInt(pair[1]);

            // Check if the parent already has this child
            if (tree.containsKey(parent) && tree.get(parent).contains(child)) {
                return "false"; // It's not a valid tree
            }

            // Check if the parent already has 2 children
            if (tree.containsKey(parent) && tree.get(parent).size() >= 2) {
                return "false"; // More than 2 children for a parent, not a valid binary tree
            }

            // Add the child to the parent's list
            tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        int rootCount = 0;

        // Count the number of root nodes
        for (int node : tree.keySet()) {
            if (!tree.values().stream().anyMatch(list -> list.contains(node))) {
                rootCount++;
                if (rootCount > 1) {
                    return "false"; // More than one root node
                }
            }
        }

        return rootCount == 1 ? "true" : "false";
    }

}
