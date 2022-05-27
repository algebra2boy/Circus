public class CircusEmployee implements Comparable<CircusEmployee>{
    private String firstName, lastName, middleInitial, idNum, category, title;

    public CircusEmployee(String firstName, String lastName, String middleInitial, String idNum, String category, String title){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.idNum = idNum;
        this.category = category;
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName()
    {
        return lastName + ", " + firstName + " " + middleInitial;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", idNum='" + idNum + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + "";
    }


    @Override
    public int compareTo(CircusEmployee o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}
