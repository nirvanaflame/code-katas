package codewars.two.june;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeFunWithAggregateOperationsTest {
  private Student[] students;

  @BeforeEach
  void setUp() {

    //Generate a basic array of students:
    Student galina = new Student("Galina", 95, "Philology", Student.Gender.FEMALE);
    Student anton = new Student("Anton", 90, "CS", Student.Gender.MALE);
    Student jack = new Student("Jack", 82, "Philology", Student.Gender.MALE);
    Student mike = new Student("Mike", 60, "Philology", Student.Gender.MALE);
    Student jane = new Student("Jane", 65, "CS", Student.Gender.FEMALE);

    students = new Student[]{galina, anton, jack, mike, jane};
  }

  @Test
  void basicTestGetAverageGradeByDepartment() {
    Map<String, Double> actual = getAverageGradeByDepartment(Arrays.stream(students));
    Map<String, Double> expected = new HashMap<>();
    expected.put("CS", 77.5);
    expected.put("Philology", 79.0);

    assertEquals(expected, actual);
  }

  @Test
  void basicTestGetNumberOfStudentsByDepartment() {
    Map<String, Long> actual = getNumberOfStudentsByDepartment(Arrays.stream(students));
    Map<String, Long> expected = new HashMap<>();
    expected.put("CS", 2l);
    expected.put("Philology", 3l);

    assertEquals(expected, actual);
  }

  @Test
  void basicTestGetStudentNamesByDepartment() {

    Map<String, List<String>> actual = getStudentNamesByDepartment(Arrays.stream(students));
    List<String> list1 = new ArrayList<>(Arrays.asList("Galina", "Jack", "Mike"));
    List<String> list2 = new ArrayList<>(Arrays.asList("Anton", "Jane"));
    Map<String, List<String>> expected = new HashMap<>();
    expected.put("Philology", list1);
    expected.put("CS", list2);

    assertEquals(expected, actual);
  }

  @Test
  void basicTestGetTheNumberOfStudentsByGenderForEachDepartment() throws Exception {

    Map<String, Map<Student.Gender, Long>> actual = getTheNumberOfStudentsByGenderForEachDepartment(Arrays.stream(students));
    Map<String, Map<Student.Gender, Long>> expected = new HashMap<>();
    Map<Student.Gender, Long> map1 = new HashMap<>();
    Map<Student.Gender, Long> map2 = new HashMap<>();
    map1.put(Student.Gender.MALE, 1L);
    map1.put(Student.Gender.FEMALE, 1L);
    map2.put(Student.Gender.MALE, 2L);
    map2.put(Student.Gender.FEMALE, 1L);
    expected.put("CS", map1);
    expected.put("Philology", map2);

    assertEquals(expected, actual);
  }

  Map<String, Map<Student.Gender, Long>> getTheNumberOfStudentsByGenderForEachDepartment(Stream<Student> students) {
    return students.collect(Collectors.groupingBy(Student::getDepartment, Collectors.groupingBy(Student::getGender, Collectors.counting())));
  }

  Map<String, List<String>> getStudentNamesByDepartment(Stream<Student> students) {
    return students.collect(Collectors.groupingBy(Student::getDepartment, Collectors.mapping(Student::getName, Collectors.toList())));
  }

  Map<String, Long> getNumberOfStudentsByDepartment(Stream<Student> students) {
    return students.collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
  }

  Map<String, Double> getAverageGradeByDepartment(Stream<Student> stream) {
    return stream.collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getGrade)));
  }
}

class Student {
  public static final double PASSING_GRADE = 70.0;
  private String name;
  private double grade;
  private String department;
  private Gender gender;

  public Student(String name, double grade, String department, Gender gender) {
    this.name = name;
    this.grade = grade;
    this.department = department;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getGrade() {
    return grade;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public enum Gender {
    MALE, FEMALE
  }
}
