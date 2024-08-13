public class AVLTree{

    // Node Variable
    private Node root;

    // Node Class 
    private class Node {

        Node left, right;
        Stock stock;
        int height;

        /**
         * Constructor for Node.
         * @param stock Stock data for the node.
         */
        private Node(Stock stock){
            this.height = 1;
            this.stock = stock;
        }

        /**
         * Get the height of the node.
         * @return Height of the node.
         */
        private int GetHeight(){
            return height;
        }

        /**
         * Set the height of the node.
         * @param NewHeight New height to set.
         */
        private void SetHeight(int NewHeight){
            this.height = NewHeight;
        }
    }

    /**
     * Get the height of a given node.
     * @param node Node whose height is to be retrieved.
     * @return Height of the node.
     */
    int GetHeight(Node node){
        if(node == null)
            return 0;
        return node.GetHeight();
    }

    /**
     * Insert a stock into the AVL tree.
     * @param stock Stock to be inserted.
     */
    public void insert(Stock stock){
        root = insert(root, stock);
    }

    /**
     * Insert a stock into the subtree rooted with node and returns the new root.
     * @param node Current root node.
     * @param stock Stock to be inserted.
     * @return New root node after insertion.
     */
    private Node insert(Node node, Stock stock){
        // Normal BST insertion
        if(node == null)
            return new Node(stock);
        
        if(stock.Compare(node.stock) < 0)
            node.left = insert(node.left, stock);
        else if(stock.Compare(node.stock) > 0)
            node.right = insert(node.right, stock);
        else
            return node; // No key Duplication

        // Update height of Ancestor Node
        node.SetHeight(1 + Math.max(GetHeight(node.left), GetHeight(node.right)));

        // Check if node is unbalanced
        int balance = GetBalance(node);

        // In case of unbalanced
        // Check balance value and based on that do rotate operations
        // Left Left condition
        if(balance > 1 && stock.Compare(node.left.stock) < 0)
            return RightRotation(node);
        // Right Right condition
        if(balance < -1 && stock.Compare(node.right.stock) > 0)
            return LeftRotation(node);
        // Left Right condition
        if(balance > 1 && stock.Compare(node.left.stock) > 0){
            node.left = LeftRotation(node.left);
            return RightRotation(node);
        }
        // Right Left condition
        if(balance < -1 && stock.Compare(node.right.stock) < 0){
            node.right = RightRotation(node.right);
            return LeftRotation(node);
        }

        // Return the node pointer 
        return node;
    }

    /**
     * Get the balance factor of the node.
     * @param node Node whose balance factor is to be calculated.
     * @return Balance factor of the node.
     */
    private int GetBalance(Node node) {
        // Calculate balance of node
        if (node == null)
            return 0;
        else
            return (GetHeight(node.left) - GetHeight(node.right));
    }

    /**
     * Perform right rotation of the subtree rooted with y.
     * @param y Root of the subtree to rotate.
     * @return New root after rotation.
     */
    private Node RightRotation(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
        
        // Do rotation
        x.right = y;
        y.left = T2;

        // Update Heights of Nodes
        y.SetHeight(1 + Math.max(GetHeight(y.left), GetHeight(y.right)));
        x.SetHeight(1 + Math.max(GetHeight(x.left), GetHeight(x.right)));

        // New root 
        return x;
    }

    /**
     * Perform left rotation of the subtree rooted with x.
     * @param x Root of the subtree to rotate.
     * @return New root after rotation.
     */
    private Node LeftRotation(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
        
        // Do rotation
        y.left = x;
        x.right = T2;

        // Update Heights of Nodes
        x.SetHeight(1 + Math.max(GetHeight(x.left), GetHeight(x.right)));
        y.SetHeight(1 + Math.max(GetHeight(y.left), GetHeight(y.right)));

        // New root 
        return y;
    }

    /**
     * Delete a stock from the AVL tree.
     * @param symbol Symbol of the stock to be deleted.
     */
    public void delete(String symbol){
        root = delete(root, symbol);

        if(root != null){
            System.out.println("REMOVE: " + symbol);
        }
    }

    /**
     * Delete a stock from the subtree rooted with node and returns the new root.
     * @param node Current root node.
     * @param symbol Symbol of the stock to be deleted.
     * @return New root node after deletion.
     */
    private Node delete(Node node, String symbol){
        // Perform BST Delete
        if(node == null)
            return node;

        // Node that will be deleted lies in, Left subtree since (subroot) node's symbol greater
        if(symbol.compareTo(node.stock.GetSymbol()) < 0)
            node.left = delete(node.left, symbol);
        else if(symbol.compareTo(node.stock.GetSymbol()) > 0)
            node.right = delete(node.right, symbol); // Node that will be deleted lies in, Right subtree since (subroot) node's symbol smaller
        else{
            // If Node found (Node's symbol same as symbol) 
            // Node with child one or none
            if( node.left == null || node.right == null){
                Node temp = null;
                if(temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                // None child
                if(temp == null){
                    temp = node;
                    node = null;
                }
                else // One child
                    node = temp;
            }
            else{
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = GetMinValueNode(node.right);
                // Copy the inorder successor's data to this node
                node.stock = temp.stock;
                // Delete the inorder successor
                node.right = delete(node.right, temp.stock.GetSymbol());
            }
        }

        // If the tree had only one node then return
        if (node == null)
            return node;

        // Update height of the current node
        node.height = Math.max(GetHeight(node.left), GetHeight(node.right)) + 1;

        // Get the balance factor of this node to check whether this node became unbalanced
        int balance = GetBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && GetBalance(node.left) >= 0)
            return RightRotation(node);

        // Left Right Case
        if (balance > 1 && GetBalance(node.left) < 0) {
            node.left = LeftRotation(node.left);
            return RightRotation(node);
        }

        // Right Right Case
        if (balance < -1 && GetBalance(node.right) <= 0)
            return LeftRotation(node);

        // Right Left Case
        if (balance < -1 && GetBalance(node.right) > 0) {
            node.right = RightRotation(node.right);
            return LeftRotation(node);
        }

        return node;
    }

    /**
     * Get the node with the smallest value (in-order successor).
     * @param node Root node of the subtree.
     * @return Node with the smallest value.
     */
    private Node GetMinValueNode(Node node) {
        Node current = node;
        // Loop down till to find most left leaf
        while (current.left != null)
            current = current.left;
        return current;
    }

    /**
     * Search for a stock in the AVL tree.
     * @param symbol Symbol of the stock to search for.
     * @return The Stock if found, else null.
     */
    public Stock Search(String symbol){
        Node FoundNode = Search(root, symbol);
        return (FoundNode != null) ? FoundNode.stock : null;
    }

    /**
     * Search for a stock in the subtree rooted with node.
     * @param node Current root node.
     * @param symbol Symbol of the stock to search for.
     * @return The node if found, else null.
     */
    private Node Search(Node node, String symbol){
        if(node == null || node.stock.GetSymbol().equals(symbol))
            return node;
            
        if(symbol.compareTo(node.stock.GetSymbol()) < 0)
            return Search(node.left, symbol);
        else
            return Search(node.right, symbol);
    }

    /**
     * Perform in-order traversal of the AVL tree.
     */
    public void InOrderTraverse(){
        InOrderTraverse(root);
    }

    /**
     * Perform in-order traversal of the subtree rooted with node.
     * @param node Current root node.
     */
    public void InOrderTraverse(Node node){
        if(node != null){
            InOrderTraverse(node.left);
            System.out.println(node.stock);
            InOrderTraverse(node.right);
        }
    }

    /**
     * Perform pre-order traversal of the AVL tree.
     */
    public void PreOrderTraverse(){
        PreOrderTraverse(root);
    }

    /**
     * Perform pre-order traversal of the subtree rooted with node.
     * @param node Current root node.
     */
    public void PreOrderTraverse(Node node){
        if(node != null){
            System.out.println(node.stock);
            PreOrderTraverse(node.left);
            PreOrderTraverse(node.right);
        }
    }

    /**
     * Perform post-order traversal of the AVL tree.
     */
    public void PostOrderTraverse(){
        PostOrderTraverse(root);
    }

    /**
     * Perform post-order traversal of the subtree rooted with node.
     * @param node Current root node.
     */
    public void PostOrderTraverse(Node node){
        if(node != null){
            PostOrderTraverse(node.left);
            PostOrderTraverse(node.right);
            System.out.println(node.stock);
        }
    }
}
