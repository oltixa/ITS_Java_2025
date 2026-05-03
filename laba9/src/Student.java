package laba9.src;
public class Student {
    private String firstName;
    private String lastName;
    private String recordBookNumber;
    private double averageGrade;

    public Student(String firstName, String lastName, String recordBookNumber, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.recordBookNumber = recordBookNumber;
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + averageGrade + ")";
    }
}
