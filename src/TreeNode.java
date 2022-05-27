public class TreeNode {
    public TreeNode left, right;
    public CircusEmployee employee;

    public TreeNode()
    {
       this(null,null,null);
    }
    public TreeNode(CircusEmployee employee)
    {
        this(null,null,employee);
    }
    public TreeNode(TreeNode left, TreeNode right, CircusEmployee employee) {
        this.left = left;
        this.right = right;
        this.employee = employee;
    }


}
