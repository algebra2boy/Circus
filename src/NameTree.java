public class NameTree extends Tree{
    //Default constructor
    public NameTree()
    {
        super();
    }
    //Constructor if passed a root
    public NameTree(TreeNode root)
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
            System.out.println(root.employee.getFullName());
            printSideways(root.left, level + 1);
        }
    }

    // post: add an employee to NameTree
    public void add(CircusEmployee e)
    {
        setRoot(add(getRoot(),e));
    }
    // Binary Search Property
    private TreeNode add(TreeNode root, CircusEmployee e)
    {
        if(root == null)

            root = new TreeNode(e);
        else if (e.getFullName().compareTo(root.employee.getFullName()) <= 0) //adding to left of root
            root.left = add(root.left, e);
        else //adding to right of root
            root.right = add(root.right, e);

        return root;
    }
    @Override
    // pre: given the whole information of an employee
    // post: delete the employee from the circus
    public void remove(CircusEmployee e) {

    }
    private void remove(CircusEmployee root, CircusEmployee e)
    {

    }

}
