package lab10;
import java.util.ArrayList;
import java.util.Objects;

class Faculty{
    private String name;
    private ArrayList<Student> students;
    
    public Faculty(String name){
        this.name = name;
        students = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
    public int getNumberOfStudents(){
        return students.size();
    }
    
    public void addStudent(Student student){
        if (student == null){
            throw new NullPointerException("Null value cannot be added");
        } 
        if (students.contains(student)){
            throw new IllegalArgumentException("This student is already in list");
        }
        students.add(student);
    }
    
    public void addStudent(String firstName, String lastName, String gradeBookId, double averageMark){
        Student student = new Student(firstName, lastName, gradeBookId, averageMark);
        addStudent(student);   
    }
    
    public void removeStudent(Student student){
        if (students.isEmpty()){
            throw new NullPointerException("List of students of faculty: " + name + " is empty");
        }
        if (student == null){
            throw new NullPointerException("Null value cannot be removed");
        }
        students.remove(student);
        students.trimToSize();
    }
    
    @Override
    public String toString() {
        return "Name of the faculty: " + name + ". Number of students: " + getNumberOfStudents();
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Faculty other = (Faculty) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

}