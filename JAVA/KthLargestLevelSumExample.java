import java.util.*;

/**
 * This program defines a binary tree and implements a method to find the 
 * kth largest sum of all levels in the tree. 
 * 
 * The BinaryTreeNode class represents the structure of a node in the 
 * binary tree, and the LevelSumFinder class contains the logic to calculate 
 * the kth largest level sum using breadth-first traversal.
 * 
 * The main method demonstrates the functionality by creating a sample 
 * binary tree and calling the kthLargestLevelSum method.
 */

class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class LevelSumFinder {
    public int kthLargestLevelSum(BinaryTreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        List<Long> levelSums = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            levelSums.add(levelSum);
        }

        if (k > levelSums.size()) {
            return -1;
        }
        Collections.sort(levelSums, Collections.reverseOrder());
        return (int)(long)levelSums.get(k - 1);
    }
}

public class KthLargestLevelSumExample {
    public static void main(String[] args) {
        // Create a sample binary tree
        // Example Tree:
        //         1
        //        / \
        //       2   3
        //      / \   \
        //     4   5   6

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        int k = 2; 
        LevelSumFinder finder = new LevelSumFinder();
        int result = finder.kthLargestLevelSum(root, k);

        System.out.println("The " + k + "th largest level sum is: " + result);
    }
}
