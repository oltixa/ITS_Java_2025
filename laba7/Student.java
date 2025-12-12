package laba7;

public class Student {
    private String name;
    private String surname;
    private String id;
    private int grade;

    public Student(String name, String surname, String id, int grade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + grade + ")";
    }
}
