class AVLNode {
    int data;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }
}

class RedBlackNode {
    int data;
    RedBlackNode left;
    RedBlackNode right;
    RedBlackNode parent;
    int color; // 0 for black, 1 for red

    public RedBlackNode(int data) {
        this.data = data;
        this.color = 1; // New nodes are initially red
    }
}

public class AVLToRedBlackConverter {
    public static RedBlackNode convertToRedBlack(AVLNode avlNode) {
        if (avlNode == null) {
            return null;
        }

        RedBlackNode root = new RedBlackNode(avlNode.data);
        root.color = 0; // Set the root to black to satisfy Red-Black tree properties

        if (avlNode.left != null) {
            root.left = convertToRedBlack(avlNode.left);
        }

        if (avlNode.right != null) {
            root.right = convertToRedBlack(avlNode.right);
        }

        return root;
    }

    public static void main(String[] args) {
        AVLNode avlTreeRoot = new AVLNode(10);
        avlTreeRoot.left = new AVLNode(5);
        avlTreeRoot.right = new AVLNode(20);
        avlTreeRoot.left.left = new AVLNode(2);
        avlTreeRoot.left.right = new AVLNode(15);

        RedBlackNode redBlackTreeRoot = convertToRedBlack(avlTreeRoot);

        // The transformed Red-Black tree might look like this (simplified):
        // Red-Black Tree:
        //       10 (Black)
        //      /  \
        //     5 (Red)  20 (Red)
        //    /             \
        //  2 (Black)      15 (Black)
    }
}
