package laba7;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> s1 = new ArrayList<>();
        s1.add(new Student("Ivan", "Petrenko", "AB123", 96));
        s1.add(new Student("Olena", "Ivanenko", "AB124", 88));

        List<Student> s2 = new ArrayList<>();
        s2.add(new Student("Maksym", "Shevchenko", "AB200", 99));
        s2.add(new Student("Sofia", "Koval", "AB201", 75));
        s2.add(new Student("Andrii", "Lysenko", "AB202", 97));

        Faculty f1 = new Faculty("Комп'ютерні науки", s1);
        Faculty f2 = new Faculty("Фізика", s2);

        List<Faculty> faculties = Arrays.asList(f1, f2);
        Institute inst = new Institute("Технічний інститут", faculties);

        System.out.println("Загальна кількість студентів: " + countAllStudents(inst));
        System.out.println("Найбільший факультет: " + findBiggestFaculty(inst).getName());
        System.out.println("Студенти з балом 95-100: " + findBestStudents(inst));
    }

    // ------------------ МЕТОДИ ---------------------

    public static int countAllStudents(Institute inst) {
        int count = 0;
        for (Faculty f : inst.getFaculties()) {
            count += f.getStudents().size();
        }
        return count;
    }

    public static Faculty findBiggestFaculty(Institute inst) {
        return inst.getFaculties()
                .stream()
                .max(Comparator.comparingInt(f -> f.getStudents().size()))
                .orElse(null);
    }

    public static List<Student> findBestStudents(Institute inst) {
        List<Student> best = new ArrayList<>();
        for (Faculty f : inst.getFaculties()) {
            for (Student s : f.getStudents()) {
                if (s.getGrade() >= 95) best.add(s);
            }
        }
        return best;
    }
}
