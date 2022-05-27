import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CircusClient
{
    public static void main(String[] args)
            throws FileNotFoundException
    {
        Circus c = new Circus();
        Scanner input = new Scanner(new File("CircusEmployees.txt"));
        while(input.hasNext())
        {
            String line = input.nextLine(); 	// read line
            Scanner input2 = new Scanner(line); // to read each piece
            while(input2.hasNext())
            {
                String firstName = input2.next(),
                        lastName = input2.next(),
                        midInitial = input2.next(),
                        idNum = input2.next(),
                        category = input2.next(),
                        title = input2.next();
                CircusEmployee employee =
                        new CircusEmployee(firstName, lastName, midInitial, idNum, category, title);
                c.add(employee);
                //System.out.println(employee);
            }
            //System.out.println();
        } // the end of while loop
        int selection;
        String message;

        ImageIcon image = new ImageIcon("circus_picture.jpg");
        Image scale = image.getImage().getScaledInstance(image.getIconWidth() /4 , image.getIconHeight() /4, Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(scale);
        message = "Mr.Marques's Final Project,\nDone by Yongye Tan and Jeffery Zeng\nAdvanced Java Programming in Spring 2021";
        JOptionPane.showMessageDialog(null, message, "Welcome to Circus", JOptionPane.INFORMATION_MESSAGE, scaleIcon);

        // at least executes once
        do {
            selection = Integer.parseInt(JOptionPane.
                    showInputDialog("Welcome to Circus:\n\n"
                            + "(1) printAlphabetically \n"
                            + "(2) printIdNum          \n"
                            + "(3) addEmployee         \n"
                            + "(4) removeEmployee      \n"
                            + "(5) printCategoryAlphabetically\n"
                            + "(6) printCategoriesAndEmployeesAlphabetically\n"
                            + "(7) addCategory\n"
                            + "(8) deleteCategory\n"
                            + "(9) quit the program\n"
                    ));
            switch (selection)
            {

                case 1:
                    message = "all the employee has been printed printAlphabetically";
                    c.printAlphabetically();
                    JOptionPane.showMessageDialog(null, message);
                    break;
                case 2:
                    message = "all the IDNum has been printed printAlphabetically";
                    c.printIdNum();
                    JOptionPane.showMessageDialog(null, message);
                    break;
                case 3:
                    message = "Adding an employee into the circus";
                    JOptionPane.showMessageDialog(null, message);
                    CircusEmployee newEmployee = inputEmployeeInformation();
                    c.addEmployee(newEmployee);
                    JOptionPane.showMessageDialog(null, newEmployee.getFullName() + " has been successfully added into the circus" );
                    break;
                case 4: //c.removeEmployee();
                case 5:
                    String category = createPanelForCategory(c);
                    message = "printing out all the employee from " + category;
                    c.printCategoryAlphabetically(category);
                    JOptionPane.showMessageDialog(null, message);
                    break;
                case 6:
                    message = "all the employees have been printed out alphabetically\nby its categories";
                    c.printCategoriesAndEmployeesAlphabetically();
                    JOptionPane.showMessageDialog(null, message);
                    break;
                case 7:

                case 8:

                case 9:
                    message = "Thank you for coming to Circus!";
                    JOptionPane.showMessageDialog(null, message);
                    System.exit(0);
                    break;
                default:
                    message = "No such command";
                    JOptionPane.showMessageDialog(null, message);
                    break;
            }
        }while("happy".equals("happy"));
    }//Main

    // post: create a panel that reads the input from the user
    public static CircusEmployee inputEmployeeInformation()
    {
        JTextField firstNameField   = new JTextField(10),
                lastNameField    = new JTextField(10),
                midInitialField  = new JTextField(10),
                idNumField       = new JTextField(10),
                categoryField    = new JTextField(10),
                titleField       = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(250, 250));
        myPanel.add(new JLabel("FirstName:"));
        myPanel.add(firstNameField);
        myPanel.add(new JLabel("LastName:"));
        myPanel.add(lastNameField);
        myPanel.add(new JLabel("MidInitial:"));
        myPanel.add(midInitialField);
        myPanel.add(new JLabel("IDNum:   "));
        myPanel.add(idNumField);
        myPanel.add(new JLabel("Category:"));
        myPanel.add(categoryField );
        myPanel.add(new JLabel("  Title:   "));
        myPanel.add(titleField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter The Information Of An Employee", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION)
            return new CircusEmployee(firstNameField.getText(),
                    lastNameField.getText(),
                    midInitialField.getText(),
                    idNumField.getText(),
                    categoryField.getText(),
                    titleField.getText());
        return null;

    } // the end of the method "inputEmployeeInformation"

    // post: creating a panel for inputting category
    // return a string of the category
    public static String createPanelForCategory(Circus c)
    {
        JTextField category = new JTextField(10);
        JPanel myPanel = new JPanel();
        //myPanel.setPreferredSize(new Dimension(250,250));

        String aListOfCategory = "";
        // get a set that contains all the keys from a map
        Set s = c.getMap().keySet();
        Iterator<String> itr = s.iterator();

        while(itr.hasNext()){
            aListOfCategory += itr.next() +"\n\n";
        }


        myPanel.add(new JLabel("Category:"));
        myPanel.add(category);
        myPanel.add(new JLabel(aListOfCategory));

        //OK_CANCEL_OPTION = 2
        //OK_OPTION = 0
        int result = JOptionPane.showConfirmDialog(null, myPanel,"Please input a category", JOptionPane.OK_CANCEL_OPTION);

        if(result == JOptionPane.OK_OPTION)
            return category.getText();
        return "";
    }

            /*Tree idTree = c.getIdTree();
        Tree nameTree = c.getNameTree();
        TreeMap<String, TreeSet<CircusEmployee>> map = c.getMap();

        nameTree.printSideways();
        System.out.println("\n\n\n\n");
        idTree.printSideways();
        System.out.println("\n\n\n\n");

        for(String category : map.keySet())
        {
            TreeSet<CircusEmployee> treeset = map.get(category);
            System.out.println(category + ":");
            Iterator<CircusEmployee> itr = treeset.iterator();

            while(itr.hasNext())
            {
                CircusEmployee e = itr.next();
                System.out.print(e + "\n");
            }
            System.out.print("\n\n\n\n");
        }*/
        /*CircusEmployee FunnyBOY = new CircusEmployee("Funny","Boy", "T","541-123-890", "Entertainer","Jumper");
        c.addEmployee(FunnyBOY);
        c.printAlphabetically();
        System.out.println("\n\n\n\n");
        c.printIdNum();
        System.out.println("\n\n\n\n");

        //c.printCategoryAlphabetically("Magician");
        c.printCategoriesAndEmployeesAlphabetically();*/
} // the end of this class
