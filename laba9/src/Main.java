package laba9.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // 🔹 ФІОТ
        List<Student> fiotStudents = new ArrayList<>(List.of(
                new Student("Іван", "Іванов", "001", 96),
                new Student("Петро", "Петров", "002", 88),
                new Student("Оксана", "Мельник", "003", 91),
                new Student("Дмитро", "Бондар", "004", 85),
                new Student("Аліна", "Кравець", "005", 97),
                new Student("Сергій", "Ткаченко", "006", 78)
        ));

        // 🔹 ІПСА
        List<Student> ipsaStudents = new ArrayList<>(List.of(
                new Student("Олена", "Сидорова", "007", 99),
                new Student("Марія", "Коваленко", "008", 92),
                new Student("Андрій", "Шевченко", "009", 97),
                new Student("Назар", "Гриценко", "010", 89),
                new Student("Юлія", "Лисенко", "011", 95),
                new Student("Владислав", "Романенко", "012", 83),
                new Student("Ірина", "Дяченко", "013", 100)
        ));

        // 🔹 ФЕЛ
        List<Student> felStudents = new ArrayList<>(List.of(
                new Student("Максим", "Олійник", "014", 90),
                new Student("Катерина", "Павленко", "015", 93),
                new Student("Богдан", "Савченко", "016", 87),
                new Student("Тетяна", "Мороз", "017", 98),
                new Student("Роман", "Яценко", "018", 76)
        ));

        // 🔹 Факультети
        Faculty f1 = new Faculty("ФІОТ", fiotStudents);
        Faculty f2 = new Faculty("ІПСА", ipsaStudents);
        Faculty f3 = new Faculty("ФЕЛ", felStudents);

        // 🔹 Інститут
        Institute institute = new Institute("КПІ",
                new ArrayList<>(List.of(f1, f2, f3)));

        // ✅ 0) ВИВІД ВСІХ ФАКУЛЬТЕТІВ
        System.out.println("Факультети та кількість студентів:");

        institute.getFaculties().forEach(f ->
                System.out.println(f.getName() + " - " + f.getStudents().size())
        );

        System.out.println();

        // ✅ 1) Кількість студентів
        long totalStudents = institute.getFaculties().stream()
                .flatMap(f -> f.getStudents().stream())
                .count();

        System.out.println("Кількість студентів: " + totalStudents);

        // ✅ 2) Найбільший факультет
        Optional<Faculty> maxFaculty = institute.getFaculties().stream()
                .max(Comparator.comparingInt(f -> f.getStudents().size()));

        maxFaculty.ifPresent(f ->
                System.out.println("Найбільший факультет: " + f.getName())
        );

        // ✅ 3) Студенти 95–100
        List<Student> topStudents = institute.getFaculties().stream()
                .flatMap(f -> f.getStudents().stream())
                .filter(s -> s.getAverageGrade() >= 95 && s.getAverageGrade() <= 100)
                .collect(Collectors.toList());

        System.out.println("\nТоп студенти (95-100):");
        topStudents.forEach(System.out::println);
    }
}