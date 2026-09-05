package basic_Prog;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Core Java - Scenario-Based Coding & Debugging Questions
 * ----------------------------------------------------------
 * Each question is its own method (q1 ... q30).
 * Work through them one at a time:
 *   1. Go to the method for the question you're solving.
 *   2. Fix the code inside it (some are commented out because they
 *      won't compile / will throw as originally written).
 *   3. Uncomment its call in main() (they're already listed) and run.
 *   4. Comment it back out or leave it running - up to you.
 *
 * To run just one question at a time, comment out the others in main().
 */
public class CoreJavaScenarios {

    public static void main(String[] args) {
        System.out.println("===== Q1: String Comparison =====");
        q1();

        System.out.println("\n===== Q2: String Immutability =====");
        q2();

        System.out.println("\n===== Q3: NullPointerException =====");
        q3();

        System.out.println("\n===== Q4: Remove Duplicates =====");
        q4();

        System.out.println("\n===== Q5: HashMap Key Issue =====");
        q5();

        System.out.println("\n===== Q6: ConcurrentModificationException =====");
        q6();

        System.out.println("\n===== Q7: ArrayIndexOutOfBoundsException =====");
        q7();

        System.out.println("\n===== Q8: Integer Comparison =====");
        q8();

        System.out.println("\n===== Q9: Finally Block =====");
        System.out.println(q9());

        System.out.println("\n===== Q10: Integer Division =====");
        q10();

        System.out.println("\n===== Q11: Static Variable =====");
        q11();

        System.out.println("\n===== Q12: Constructor Issue =====");
        q12();

        // Q13 (Method Overloading) is a compile-time design question - see q13() notes.
        System.out.println("\n===== Q13: Method Overloading =====");
        q13();

        System.out.println("\n===== Q14: Method Overriding =====");
        q14();

        System.out.println("\n===== Q15: Exception Handling =====");
        q15();

        System.out.println("\n===== Q16: Try-With-Resources =====");
        q16();

        System.out.println("\n===== Q17: Stream Filtering =====");
        q17();

        System.out.println("\n===== Q18: Stream Map =====");
        q18();

        System.out.println("\n===== Q19: Find First Element =====");
        q19();

        System.out.println("\n===== Q20: Null Values in Stream =====");
        q20();

        System.out.println("\n===== Q21: Sorting =====");
        q21();

        System.out.println("\n===== Q22: Duplicate Elements =====");
        q22();

        System.out.println("\n===== Q23: HashSet Behavior =====");
        q23();

        System.out.println("\n===== Q24: TreeSet Sorting =====");
        q24();

        System.out.println("\n===== Q25: Thread Race Condition =====");
        q25Wrapper();

        System.out.println("\n===== Q26: Thread Sleep / Join =====");
        q26();

        System.out.println("\n===== Q27: Immutable Object =====");
        q27();

        System.out.println("\n===== Q28: equals() and HashSet =====");
        q28();

        System.out.println("\n===== Q29: Comparator Issue =====");
        q29();

        System.out.println("\n===== Q30: Optional Usage =====");
        q30();
    
    }
    // ---------------------------------------------------------------
    // Q1: String Comparison
    // Prints "Different", should print "Same". Fix without removing
    // the `new String(...)` construction if you want to test == vs equals.
    // ---------------------------------------------------------------
    static void q1() {
        String s1 = new String("Java");
        String s2 = new String("Java");
        // TODO: fix the comparison below (hint: == compares references)
        if (s1.equals(s2))
            System.out.println("Same");
        else
            System.out.println("Different");
    }
    
    // ---------------------------------------------------------------
    // Q2: String Immutability
    // Expected output: "Java Programming"
    // ---------------------------------------------------------------
    static void q2() {
        String name = "Java";
        name += " Programming";
        // TODO: fix so that "Java Programming" is printed
        System.out.println(name);
    }

    // ---------------------------------------------------------------
    // Q3: NullPointerException
    // Should safely print "Other"
    // ---------------------------------------------------------------
    static void q3() {
        String name = null;
        // TODO: fix so this doesn't throw NPE
        if (name.equals("Java")) {
            System.out.println("Java");
        } else {
            System.out.println("Other");
        }
    }

    // ---------------------------------------------------------------
    // Q4: Remove Duplicates
    // Arrays.asList(...) returns a fixed-size list -> remove() throws.
    // Output should contain only unique numbers.
    // ---------------------------------------------------------------
    static void q4() {
        List<Integer> numbers =
                Arrays.asList(10, 20, 10, 30, 20, 40);
        // TODO: fix - this throws UnsupportedOperationException as written
        for (Integer n : numbers) {
            if (numbers.indexOf(n) != numbers.lastIndexOf(n))
                numbers.remove(n);
        }
        System.out.println(numbers);
    }

    // ---------------------------------------------------------------
    // Q5: HashMap Key Issue
    // ---------------------------------------------------------------
    static void q5() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 10);
        map.put(new String("Java"), 20);
        System.out.println(map.size());
        System.out.println(map.get("Java"));
        // TODO: explain the output, then note what you'd need (a different
        // key type / no equals+hashCode override) to store both separately
    }

    // ---------------------------------------------------------------
    // Q6: ConcurrentModificationException
    // Fix without an index-based loop.
    // ---------------------------------------------------------------
    static void q6() {
        List<String> names =
                new ArrayList<>(Arrays.asList("A", "B", "C"));
        // TODO: fix - throws ConcurrentModificationException as written
        for (String name : names) {
            if (name.equals("B"))
                names.remove(name);
        }
        System.out.println(names);
    }

    // ---------------------------------------------------------------
    // Q7: ArrayIndexOutOfBoundsException
    // ---------------------------------------------------------------
    static void q7() {
        int[] numbers = {10, 20, 30, 40, 50};
        // TODO: fix the loop bound
        for (int i = 0; i <= numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    // ---------------------------------------------------------------
    // Q8: Integer Comparison
    // Developer expects both println's to print true.
    // ---------------------------------------------------------------
    static void q8() {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        // TODO: fix the comparisons below (hint: Integer cache range is -128..127)
        System.out.println(a == b);
        System.out.println(c == d);
    }

    // ---------------------------------------------------------------
    // Q9: Finally Block
    // As written this returns 20. Modify so the method returns 10.
    // ---------------------------------------------------------------
    static int q9() {
        // TODO: modify so this returns 10, not 20
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    // ---------------------------------------------------------------
    // Q10: Integer Division
    // Expected output: 2.5
    // ---------------------------------------------------------------
    static void q10() {
        int total = 5;
        int count = 2;
        // TODO: fix so average prints 2.5
        double average = total / count;
        System.out.println(average);
    }

    // ---------------------------------------------------------------
    // Q11: Static Variable
    // Both employees currently show the same company - fix the design.
    // ---------------------------------------------------------------
    static class EmployeeQ11 {
        int id;
        static String company; // TODO: this is the bug - should it be static?
        EmployeeQ11(int id, String company) {
            this.id = id;
            this.company = company;
        }
    }

    static void q11() {
        EmployeeQ11 e1 = new EmployeeQ11(1, "Infosys");
        EmployeeQ11 e2 = new EmployeeQ11(2, "TCS");
        System.out.println(e1.id + " - " + e1.company);
        System.out.println(e2.id + " - " + e2.company);
    }

    // ---------------------------------------------------------------
    // Q12: Constructor Issue
    // new Employee(200) should set id to 200, not 0.
    // ---------------------------------------------------------------
    static class EmployeeQ12 {
        private int id;
        EmployeeQ12() {
            id = 100;
        }
        EmployeeQ12(int id) {
            // TODO: fix - this assigns the parameter to itself (shadowing)
            id = id;
        }
        int getId() { return id; }
    }

    static void q12() {
        EmployeeQ12 e = new EmployeeQ12(200);
        System.out.println(e.getId());
    }

    // ---------------------------------------------------------------
    // Q13: Method Overloading
    // Original class does NOT compile (overloads can't differ by return
    // type alone). Fix by changing the signature (params), not just
    // the return type.
    // ---------------------------------------------------------------
    static class CalculatorQ13 {
        int add(int a, int b) {
            return a + b;
        }
        // TODO: this won't compile alongside the method above - fix the signature
        // double add(int a, int b) {
        //     return a + b;
        // }
        double add(double a, double b) {
            return a + b;
        }
    }

    static void q13() {
        CalculatorQ13 calc = new CalculatorQ13();
        System.out.println(calc.add(2, 3));
        System.out.println(calc.add(2.5, 3.5));
    }

    // ---------------------------------------------------------------
    // Q14: Method Overriding
    // ---------------------------------------------------------------
    static class ParentQ14 {
        void show() {
            System.out.println("Parent");
        }
    }
    static class ChildQ14 extends ParentQ14 {
        void show() {
            System.out.println("Child");
        }
    }

    static void q14() {
        ParentQ14 p = new ChildQ14();
        p.show(); // TODO: explain why this prints "Child" (runtime polymorphism)
    }

    // ---------------------------------------------------------------
    // Q15: Exception Handling
    // Does not compile - ArithmeticException is unreachable after
    // the general Exception catch. Fix the catch block order.
    // ---------------------------------------------------------------
    static void q15() {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        // TODO: original had catch(Exception) before catch(ArithmeticException) - fix the order
    }

    // ---------------------------------------------------------------
    // Q16: Try-With-Resources
    // Resource should close automatically even on exception.
    // ---------------------------------------------------------------
    static void q16() {
        // TODO: convert to try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------------
    // Q17: Stream Filtering
    // Print only even numbers greater than 20.
    // ---------------------------------------------------------------
    static void q17() {
        List<Integer> numbers =
                Arrays.asList(10, 15, 20, 25, 30);
        // TODO: add the "greater than 20" condition
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------------
    // Q18: Stream Map
    // Expected: JAVA - 4, SPRING - 6, AWS - 3
    // ---------------------------------------------------------------
    static void q18() {
        List<String> names =
                Arrays.asList("java", "spring", "aws");
        // TODO: modify the stream to also print each name's length
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------------
    // Q19: Find First Element
    // Print only 15, not Optional[15].
    // ---------------------------------------------------------------
    static void q19() {
        List<Integer> numbers =
                Arrays.asList(5, 10, 15, 20);
        Optional<Integer> result =
                numbers.stream()
                        .filter(n -> n > 12)
                        .findFirst();
        // TODO: unwrap the Optional before printing
        System.out.println(result);
    }

    // ---------------------------------------------------------------
    // Q20: Null Values in Stream
    // ---------------------------------------------------------------
    static void q20() {
        List<String> names =
                Arrays.asList("Java", null, "Spring", null);
        // TODO: fix so null values are ignored (throws NPE as written)
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------------
    // Q21: Sorting
    // Print numbers in descending order.
    // ---------------------------------------------------------------
    static void q21() {
        List<Integer> numbers =
                Arrays.asList(50, 10, 40, 20, 30);
        // TODO: sort descending instead of ascending
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------------
    // Q22: Duplicate Elements
    // Complete the filter to print only duplicates: 10 and 20
    // ---------------------------------------------------------------
    static void q22() {
        List<Integer> numbers =
                Arrays.asList(10, 20, 10, 30, 20, 40);
        // TODO: replace the filter condition below (currently prints nothing)
        numbers.stream()
                .filter(n -> false /* ??? */)
                .distinct()
                .forEach(System.out::println);
    }

    // ---------------------------------------------------------------
    // Q23: HashSet Behavior
    // Developer expects size 3.
    // ---------------------------------------------------------------
    static void q23() {
        Set<String> names = new HashSet<>();
        names.add("Java");
        names.add("Java");
        names.add("Spring");
        System.out.println(names.size());
        // TODO: explain why size is 2, and note which collection allows duplicates
    }

    // ---------------------------------------------------------------
    // Q24: TreeSet Sorting
    // ---------------------------------------------------------------
    static void q24() {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        numbers.add(10);
        System.out.println(numbers);
        // TODO: explain why the duplicate 10 disappears and output is sorted
    }

    // ---------------------------------------------------------------
    // Q25: Thread Race Condition
    // Fix so 1000 increments per thread x N threads gives the correct total.
    // ---------------------------------------------------------------
    static class CounterQ25 {
        int count = 0;
        // TODO: fix - not thread-safe as written (add synchronized, or use AtomicInteger)
        void increment() {
            count++;
        }
    }

    static void q25() throws InterruptedException {
        CounterQ25 counter = new CounterQ25();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count: " + counter.count);
    }

    // wrapper to swallow the checked InterruptedException in main()
    static void q25Wrapper() {
        try {
            q25();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ---------------------------------------------------------------
    // Q26: Thread Sleep / Join
    // "Completed" should print only after the thread finishes.
    // ---------------------------------------------------------------
    static void q26() {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 5; i++)
                System.out.println(i);
        });
        t.start();
        // TODO: fix so "Completed" prints only after the thread finishes
        System.out.println("Completed");
    }

    // ---------------------------------------------------------------
    // Q27: Immutable Object
    // Make Employee immutable.
    // ---------------------------------------------------------------
    static final class EmployeeQ27 { // TODO: class should be final for true immutability
        private final String name; // TODO: field should be final
        EmployeeQ27(String name) {
            this.name = name;
        }
        // TODO: remove the setter below - immutable objects can't be modified after construction
        // public void setName(String name) {
        //     this.name = name;
        // }
        public String getName() {
            return name;
        }
    }

    static void q27() {
        EmployeeQ27 e = new EmployeeQ27("Sabya");
        System.out.println(e.getName());
    }

    // ---------------------------------------------------------------
    // Q28: equals() and HashSet
    // Expected size 1, currently prints 2.
    // ---------------------------------------------------------------
    static class EmployeeQ28 {
        int id;
        EmployeeQ28(int id) {
            this.id = id;
        }
        // TODO: override equals() and hashCode() based on id
    }

    static void q28() {
        Set<EmployeeQ28> employees = new HashSet<>();
        employees.add(new EmployeeQ28(101));
        employees.add(new EmployeeQ28(101));
        System.out.println(employees.size());
    }

    // ---------------------------------------------------------------
    // Q29: Comparator Issue
    // Fix to correctly sort by salary, including ties.
    // ---------------------------------------------------------------
    static class EmployeeQ29 {
        String name;
        double salary;
        EmployeeQ29(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        double getSalary() { return salary; }
        public String toString() { return name + ":" + salary; }
    }

    static List<EmployeeQ29> getEmployeesQ29() {
        return new ArrayList<>(Arrays.asList(
                new EmployeeQ29("A", 50000),
                new EmployeeQ29("B", 40000),
                new EmployeeQ29("C", 40000),
                new EmployeeQ29("D", 60000)
        ));
    }

    static void q29() {
        List<EmployeeQ29> employees = getEmployeesQ29();
        // TODO: fix this comparator (buggy for equal salaries / brittle in general)
        employees.sort((e1, e2) ->
                e1.getSalary() > e2.getSalary() ? 1 : -1);
        System.out.println(employees);
    }

    // ---------------------------------------------------------------
    // Q30: Optional Usage
    // Should print "Unknown" instead of throwing NoSuchElementException.
    // ---------------------------------------------------------------
    static String getName() {
        return null; // simulates a lookup that found nothing
    }

    static void q30() {
        Optional<String> name = Optional.ofNullable(getName());
        // TODO: fix so this prints "Unknown" instead of throwing
        System.out.println(name.get());
    }
}