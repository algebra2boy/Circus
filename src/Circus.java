import java.util.TreeMap;
import java.util.TreeSet;

public class Circus {
    private final NameTree nameTree;
    private final IdTree idTree;
    private final TreeMap<String, TreeSet<CircusEmployee>> map;

    public Circus()
    {
        nameTree = new NameTree();
        idTree = new IdTree();
        map = new TreeMap<>();
    }



    public void add(CircusEmployee e)
    {
        // add to the nameTree
        nameTree.add(e);

        // add to the idTree
        idTree.add(e);

        // add to the TreeMap
        // the category does not exists
        if(!map.containsKey(e.getCategory()))
           map.put(e.getCategory(), new TreeSet<>());
        TreeSet<CircusEmployee> set = map.get(e.getCategory()); // get the set
        set.add(e); // put the employee into the set
        map.put(e.getCategory(), set); // update the set
    }

    public TreeMap<String, TreeSet<CircusEmployee>> getMap() {
        return map;
    }


    // print all of the employee printAlphabetically
    // using the in-order traversal
    public void printAlphabetically()
    {
        printAlphabetically(nameTree.getRoot());
        System.out.println("\n\n\n\n");
    }

    private void printAlphabetically(TreeNode root)
    {
        if(root != null)
        {
           printAlphabetically(root.left);
           System.out.println(root.employee.getFullName());
           printAlphabetically(root.right);
        }
    }
    // print all of the employee with its IdNum
    // using the in-order traversal
    public void printIdNum()
    {
        printIdNum(idTree.getRoot());
        System.out.println("\n\n\n\n");
    }
    private void printIdNum(TreeNode root)
    {
        if(root != null)
        {
            printIdNum(root.left);
            System.out.println(root.employee.getIdNum());
            printIdNum(root.right);
        }
    }

    // pre: given the name and category of an employee
    // post: add the employee into the circus
    public void addEmployee(CircusEmployee e)
    {
        add(e);
    }

    // pre: given the name and category of an employee
    // post: delete the employee into the circus
    public void removeEmployee(String name, String category)
    {

    }


    // pre: given the name of a category
    // post: print a particular Category Alphabetically
    public void printCategoryAlphabetically(String category)
    {
        // if category exists in the map
        if(map.containsKey(category))
        {
            System.out.println(category +":");
            for (CircusEmployee e : map.get(category)) {
                System.out.println(e);
            }
            System.out.println();
        }
    }

    //print all categories and employees alphabetically
    public void printCategoriesAndEmployeesAlphabetically()
    {
        for(String category : map.keySet())
        {
            printCategoryAlphabetically(category);
            System.out.println("\n\n\n\n");
        }
    }

    //pre: given String category not already in map, add a new key value
    //post: adds a key value category with an empty TreeSet to map
    public void addCategory(String category)
    {
        map.put(category, new TreeSet<>());
    }
    //pre: given a String category, delete the category key and value from map
    //post: the key category and its value has been deleted from map
    public void deleteCategory(String category)
    {
        if(map.containsKey(category))
            map.remove(category);

        //// figuring the delete method
    }
}
