public class IdTree extends Tree {
    //Default constructor
    public IdTree()
    {
        super();
    }
    //Constructor if passed a root
    public IdTree(TreeNode root)
    {
        super(root);
    }

    public void printSideways() {
        printSideways(super.getRoot(), 0);
    }
    private void printSideways(TreeNode root, int level)
    {
        if(root != null){
            printSideways(root.right, level + 1);
            for(int i = 0; i < level; i++){
                System.out.print("     ");
            }
            System.out.println(root.employee.getIdNum());
            printSideways(root.left, level + 1);
        }
    }

    @Override
    //Adding to IdTree
    public void add(CircusEmployee e)
    {
        setRoot(add(getRoot(),e));
    }

    //Binary Search Property
    // Add the employee into the tree
    private TreeNode add(TreeNode root, CircusEmployee e)
    {
        if (root == null)
            root = new TreeNode(e);
        else if (e.getIdNum().compareTo(root.employee.getIdNum()) <= 0) //adding to left of root
            root.left = add(root.left, e);
        else //adding to right of root
            root.right = add(root.right, e);

        return root;
    }

    @Override
    public void remove(CircusEmployee e) {

    }

}
