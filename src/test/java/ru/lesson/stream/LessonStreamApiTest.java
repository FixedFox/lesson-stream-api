package ru.lesson.stream;

import org.junit.Test;
import ru.lesson.stream.dto.Employee;
import ru.lesson.stream.dto.PositionType;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LessonStreamApiTest {

    private final LessonStreamApi lessonStreamApi = new LessonStreamApi();

    @Test
    public void testTask1() {
        Employee employee1 = new Employee(1, "Ivan", 40);
        Employee employee2 = new Employee(2, "Olga", 50);
        Employee employee3 = new Employee(3, "John", 60);
        Employee employee4 = new Employee(4, "Tom", 85);
        List<Employee> employees = Arrays.asList(
                employee1, employee2, employee2, employee3, employee3, employee4, employee4
        );

        List<Employee> result = lessonStreamApi.task1(employees);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertThat(result, contains(employee3, employee4));
    }

    @Test
    public void testTask2() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ivan", 40),
                new Employee(2, "Olga", 50),
                new Employee(3, "John", 60),
                new Employee(4, "Tom", 85),
                new Employee(5, "Bob", 45));

        List<String> result = lessonStreamApi.task2(employees);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertThat(result, contains("Ivan=40", "Bob=45"));
    }

    @Test
    public void testTask3() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ivan", 40),
                new Employee(2, "Olga", 50),
                new Employee(3, "John", 60));

        double result = lessonStreamApi.task3(employees);
        assertEquals(50.0, result, 0.0);
    }

    @Test
    public void testTask4() {
        Employee employee1 = new Employee(1, "Ivan", 40);
        Employee employee2 = new Employee(2, "Olga", 50);
        Employee employee3 = new Employee(3, "John", 60);
        Employee employee4 = new Employee(4, "Tom", 99);
        Employee employee5 = new Employee(5, "Ben", 69);

        List<Employee> employeeDepartment1 = Arrays.asList(employee1, employee2, employee3);
        List<Employee> employeeDepartment2 = Arrays.asList(employee3, employee4, employee5);

        List<Employee> result = lessonStreamApi.task4(Arrays.asList(employeeDepartment1, employeeDepartment2));
        assertNotNull(result);
        assertEquals(5, result.size());
        assertEquals(employee4, result.get(0));
        assertThat(result, contains(employee4, employee5, employee3, employee2, employee1));
    }

    @Test
    public void testTask5() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            employees.add(new Employee(i, "Name" + i,i + 10));
        }

        List<Employee> result = lessonStreamApi.task5(employees,3, 1);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertThat(result, contains(
                new Employee(1, "Name1",11),
                new Employee(2, "Name2",12),
                new Employee(3, "Name3",13)));

        List<Employee> result2 = lessonStreamApi.task5(employees,3, 2);
        assertNotNull(result2);
        assertEquals(3, result2.size());
        assertThat(result2, contains(
                new Employee(4, "Name4",14),
                new Employee(5, "Name5",15),
                new Employee(6, "Name6",16)));
    }

    @Test
    public void testTask6() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ivan", 40),
                new Employee(2, "Olga", 50),
                new Employee(3, "John", 60));

        String result = lessonStreamApi.task6(employees);
        assertNotNull(result);
        assertEquals(result, "[Ivan, Olga, John]");
    }

    @Test
    public void testTask7() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Ivan", 40),
                new Employee(2, "Olga", 50),
                new Employee(3, "John", 60),
                new Employee(4, "John", 61));

        boolean result = lessonStreamApi.task7(employees);
        assertTrue(result);
    }

    @Test
    public void testTask8() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Name1", PositionType.DEVELOPER, 60),
                new Employee(2, "Name2", PositionType.DEVELOPER, 100),
                new Employee(4, "Name4", PositionType.TESTER, 50),
                new Employee(5, "Name5", PositionType.TESTER, 100),
                new Employee(7, "Name7", PositionType.ANALYST, 40),
                new Employee(8, "Name8", PositionType.ANALYST, 100));

        Map<PositionType, Double> result = lessonStreamApi.task8(employees);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(80.0, result.get(PositionType.DEVELOPER), 0.0);
        assertEquals(75.0, result.get(PositionType.TESTER), 0.0);
        assertEquals(70.0, result.get(PositionType.ANALYST), 0.0);
    }

    @Test
    public void testTask9() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Name1", PositionType.DEVELOPER, 40),
                new Employee(7, "Name7", PositionType.ANALYST, 45),
                new Employee(5, "Name5", PositionType.TESTER, 60),
                new Employee(8, "Name8", PositionType.ANALYST, 65),
                new Employee(2, "Name2", PositionType.DEVELOPER, 70));

        Map<Boolean, Long> result = lessonStreamApi.task9(employees);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(3, result.get(Boolean.TRUE).longValue());
        assertEquals(2, result.get(Boolean.FALSE).longValue());
    }

    @Test
    public void testTask10() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Name1", PositionType.DEVELOPER, 40),
                new Employee(2, "Name2", PositionType.DEVELOPER, 70),
                new Employee(5, "Name5", PositionType.TESTER, 60),
                new Employee(7, "Name7", PositionType.ANALYST, 45),
                new Employee(8, "Name8", PositionType.ANALYST, 65));

        Map<Boolean, String> result = lessonStreamApi.task10(employees);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Name1, Name7", result.get(Boolean.FALSE));
        assertEquals("Name2, Name5, Name8", result.get(Boolean.TRUE));
    }

}
