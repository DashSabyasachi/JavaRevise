# Core Java Interview Q&A

---

## 1. Core Java Fundamentals

**Q1. What are the main features of Java (platform independence, etc.)?**
Java compiles to bytecode (`.class` files) that runs on the JVM, not directly on hardware — this gives platform independence ("write once, run anywhere"). Other core features: automatic memory management (garbage collection), strong static typing, built-in multithreading support, and robust exception handling.

**Q2. Difference between JDK, JRE, and JVM?**
- **JVM** (Java Virtual Machine): executes bytecode, provides memory management and platform independence.
- **JRE** (Java Runtime Environment): JVM + core libraries needed to *run* Java applications.
- **JDK** (Java Development Kit): JRE + development tools (compiler `javac`, debugger, etc.) needed to *build* Java applications.

**Q3. Difference between `==` and `.equals()`?**
`==` compares references (memory addresses) for objects, and values for primitives. `.equals()` compares logical/content equality, and its behavior depends on whether the class has overridden it (default `Object.equals()` also just compares references unless overridden, as in `String` or `Integer`).

**Q4. Why is Java platform-independent but JVM is not?**
Java source code compiles to a universal bytecode format. The JVM itself is platform-*dependent* — a different JVM binary exists per OS/architecture — and its job is to translate that same bytecode into native instructions for that specific platform.

**Q5. Difference between stack and heap memory?**
- **Stack**: stores method call frames, local variables, and object references. Memory is allocated/deallocated automatically (LIFO) as methods are called/return. Fast, thread-specific.
- **Heap**: stores actual objects and arrays. Shared across threads, managed by the garbage collector, generally slower to access than stack.

**Q6. What is the difference between pass-by-value and pass-by-reference? Which does Java use?**
Java is strictly **pass-by-value**. For objects, the *value of the reference* (i.e., the address) is passed — so you can mutate the object's internal state through that reference, but reassigning the parameter inside the method doesn't affect the caller's original reference.

**Q7. Difference between primitive types and wrapper classes? What is autoboxing/unboxing?**
Primitives (`int`, `char`, `boolean`, etc.) store raw values directly and live on the stack. Wrapper classes (`Integer`, `Character`, `Boolean`) wrap these values as objects, enabling their use in collections (which require objects) and providing utility methods. **Autoboxing** is the automatic conversion of primitive → wrapper (`int` → `Integer`); **unboxing** is the reverse.

**Q8. What is the difference between `final`, `finally`, and `finalize()`?**
- `final`: keyword to make a variable constant, a method non-overridable, or a class non-inheritable.
- `finally`: a block that always executes after try/catch, used for cleanup.
- `finalize()`: a method called by the GC before reclaiming an object (deprecated since Java 9 — unreliable and discouraged; use try-with-resources instead).

**Q9. What is the difference between static and instance members?**
Static members belong to the class itself — one copy shared across all instances, accessible without creating an object. Instance members belong to each individual object, with a separate copy per instance.

**Q10. Why is the `main` method `public static void main(String[] args)`?**
- `public`: JVM must access it from outside the class.
- `static`: JVM calls it without instantiating the class.
- `void`: it doesn't return a value to the JVM.
- `String[] args`: allows command-line arguments to be passed in.

---

## 2. OOPs

**Q11. What are the four pillars of OOP?**
Encapsulation (bundling data + methods, restricting direct access via access modifiers), Abstraction (hiding implementation details, exposing only what's necessary), Inheritance (acquiring properties/behavior of a parent class), and Polymorphism (one interface, many forms — via overloading/overriding).

**Q12. Difference between method overloading and overriding?**
- **Overloading**: same method name, different parameter list, within the same class. Resolved at **compile time**.
- **Overriding**: subclass provides a specific implementation of a method already defined in its superclass, same signature. Resolved at **runtime** (dynamic dispatch).

**Q13. Can you overload a static method? Can you override one?**
Static methods can be overloaded. They **cannot truly be overridden** — if a subclass defines a static method with the same signature, it's "method hiding," not overriding, and is resolved based on the reference type at compile time, not the object's runtime type.

**Q14. Difference between abstract class and interface?**
- **Abstract class**: can have both abstract and concrete methods, constructors, instance variables, and any access modifier. A class can extend only one abstract class.
- **Interface**: traditionally only abstract methods; since Java 8, can also have `default` and `static` methods. All variables are implicitly `public static final`. A class can implement multiple interfaces.
Use an abstract class when sharing common state/behavior among closely related classes; use an interface to define a contract that unrelated classes can implement.

**Q15. Why doesn't Java support multiple inheritance with classes?**
To avoid the **diamond problem** — ambiguity when two parent classes have a method with the same signature and the compiler can't determine which one to inherit. Java sidesteps this by allowing multiple *interface* implementation instead, where Java 8's default methods require the implementing class to explicitly resolve any conflict.

**Q16. What is the difference between composition and inheritance? "Favor composition over inheritance" — why?**
Inheritance models an "is-a" relationship and creates tight coupling to the parent class's implementation. Composition models a "has-a" relationship — a class holds a reference to another class to reuse its functionality. Composition is generally preferred because it's more flexible (behavior can be swapped at runtime) and doesn't break encapsulation the way deep inheritance chains can.

**Q17. What is polymorphism and how is it achieved in Java?**
The ability of an object to take multiple forms. Achieved via **compile-time polymorphism** (method overloading) and **runtime polymorphism** (method overriding, using a superclass/interface reference pointing to a subclass object, resolved via dynamic method dispatch).

**Q18. What is the `super` keyword used for?**
To refer to the immediate parent class — accessing its constructor (`super()`), methods, or fields that may be hidden/overridden by the subclass.

**Q19. Can a constructor be private? Why would you do that?**
Yes — commonly used in the **Singleton pattern** to prevent external instantiation, forcing object creation through a controlled static method instead.

**Q20. What is object cloning, and what's the difference between shallow and deep copy?**
Cloning creates a copy of an object via `clone()` (from the `Cloneable` interface). A **shallow copy** copies primitive fields directly but copies object references as-is (so both objects share the same nested objects). A **deep copy** recursively copies referenced objects too, so the two are fully independent.

---

## 3. Collections

**Q21. What is the Collections Framework, and what are its core interfaces?**
A unified architecture for storing and manipulating groups of objects. Core interfaces: `Collection` (root), with `List` (ordered, allows duplicates), `Set` (no duplicates), `Queue` (FIFO-style processing); and separately `Map` (key-value pairs, not a true `Collection` subtype).

**Q22. Difference between `ArrayList` and `LinkedList`?**
`ArrayList` is backed by a dynamic array — fast random access (O(1) `get`), but slow insertion/deletion in the middle (O(n), needs shifting). `LinkedList` is a doubly-linked list — fast insertion/deletion (O(1) once positioned) but slow random access (O(n) traversal).

**Q23. How does `HashMap` work internally?**
It stores entries in an array of buckets. A key's `hashCode()` is used (with internal hash spreading) to determine the bucket index. On collision (two keys landing in the same bucket), entries are stored as a linked list within that bucket — or, since Java 8, converted to a balanced red-black tree if a bucket grows beyond a threshold (default 8 entries), improving worst-case lookup from O(n) to O(log n).

**Q24. Difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?**
- `HashMap`: no ordering guarantee, O(1) average operations.
- `LinkedHashMap`: maintains insertion order (or access order if configured), slight overhead over `HashMap`.
- `TreeMap`: maintains keys in sorted order (natural or via `Comparator`), backed by a red-black tree, O(log n) operations.

**Q25. Difference between `HashMap` and `Hashtable` / `ConcurrentHashMap`?**
`Hashtable` is a legacy, synchronized (thread-safe) class that locks the entire map for every operation — slow under contention and doesn't allow `null` keys/values. `HashMap` is unsynchronized and allows one `null` key. `ConcurrentHashMap` is thread-safe but achieves much better concurrency by locking only segments/buckets rather than the whole map.

**Q26. What is `ConcurrentModificationException`, and how do you avoid it?**
Thrown when a collection is structurally modified (add/remove) while being iterated with a standard iterator, other than through the iterator's own `remove()` method. Avoid it by using `Iterator.remove()`, a `CopyOnWriteArrayList`/`ConcurrentHashMap` for concurrent scenarios, or collecting changes and applying them after iteration.

**Q27. Difference between `Comparable` and `Comparator`?**
`Comparable` (via `compareTo()`) defines a class's single natural ordering, implemented within the class itself. `Comparator` (via `compare()`) defines external, custom ordering logic — you can create multiple comparators for the same class without modifying it.

**Q28. How does `HashSet` ensure elements are unique?**
Internally, `HashSet` is backed by a `HashMap` — each added element becomes a key, mapped to a constant dummy value. Since map keys must be unique (checked via `hashCode()` and `equals()`), duplicate elements are naturally rejected.

**Q29. What is the contract between `equals()` and `hashCode()`? Why does it matter for collections?**
If two objects are equal via `equals()`, they **must** return the same `hashCode()`. If this contract is broken, hash-based collections (`HashMap`, `HashSet`) will behave incorrectly — e.g., a `HashSet` could store "duplicate" entries or fail to find an object that's logically present, because it looks in the wrong bucket.

**Q30. Difference between fail-fast and fail-safe iterators?**
**Fail-fast** iterators (e.g., `ArrayList`, `HashMap`) throw `ConcurrentModificationException` if the collection is modified during iteration — they detect this via an internal modification counter. **Fail-safe** iterators (e.g., `CopyOnWriteArrayList`, `ConcurrentHashMap`) operate on a cloned/snapshot copy of the collection, so they don't throw exceptions, but may not reflect the latest updates.

---

## 4. Exception Handling

**Q31. Difference between checked and unchecked exceptions?**
**Checked exceptions** (e.g., `IOException`, `SQLException`) are checked at compile time — the method must either handle them or declare them via `throws`. **Unchecked exceptions** (e.g., `NullPointerException`, `ArithmeticException`, subclasses of `RuntimeException`) aren't checked at compile time and typically indicate programming errors.

**Q32. Difference between `throw` and `throws`?**
`throw` is used to actually raise/trigger an exception instance at a specific point in code. `throws` is used in a method signature to declare that the method might propagate a certain exception, so callers know to handle it.

**Q33. Difference between `Error` and `Exception`?**
Both are subclasses of `Throwable`. `Error` represents serious problems generally outside the application's control (e.g., `OutOfMemoryError`, `StackOverflowError`) that apps typically shouldn't try to catch. `Exception` represents conditions an application might reasonably want to catch and handle.

**Q34. What is the order of execution for try-catch-finally? Does `finally` always run?**
`try` runs first; if an exception occurs, control jumps to a matching `catch`; `finally` runs after either, **almost always** — even if there's a `return` in the try/catch block. The only exceptions are if `System.exit()` is called, or the JVM crashes/is killed.

**Q35. What happens if you return a value in both `try` and `finally`?**
The value returned in `finally` **overrides** the one from `try` — this is why returning from `finally` is considered bad practice, as it can silently mask exceptions or intended return values.

**Q36. What is exception chaining, and why use it?**
Wrapping a lower-level (caught) exception inside a new, higher-level exception via its constructor (`new ServiceException("failed", originalException)`), preserving the original cause. This lets you translate exceptions to a more meaningful abstraction level for the caller, without losing the original stack trace for debugging.

**Q37. Can you catch multiple exceptions in a single catch block?**
Yes, using the multi-catch syntax introduced in Java 7: `catch (IOException | SQLException e) { ... }` — useful when the handling logic is identical, though the exceptions must not be related by subclassing.

**Q38. Why would you create a custom exception?**
To represent domain-specific error conditions clearly (e.g., `InsufficientFundsException`), making error handling more expressive and allowing callers to catch specific business errors distinctly from generic exceptions.

---

## 5. Java 8+ / Streams

**Q39. What is a lambda expression, and what problem does it solve?**
A concise way to represent an anonymous function — `(params) -> expression/body`. It solves the verbosity of anonymous inner classes when implementing functional interfaces, e.g., replacing a 5-line anonymous `Runnable` with `() -> System.out.println("run")`.

**Q40. What is a functional interface?**
An interface with exactly **one abstract method** (it may have default/static methods too), enabling it to be implemented via a lambda expression. Marked (optionally but conventionally) with `@FunctionalInterface`. Examples: `Runnable`, `Comparator<T>`, and the `java.util.function` package (`Function<T,R>`, `Predicate<T>`, `Supplier<T>`, `Consumer<T>`).

**Q41. What is the Stream API, and how is it different from a Collection?**
`Stream` is an abstraction for processing sequences of data in a declarative, functional style (filter, map, reduce, etc.). Unlike a `Collection`, a stream doesn't store data — it's computed on-demand from a source, can only be traversed/consumed **once**, and supports lazy evaluation plus easy parallelization (`.parallelStream()`).

**Q42. Difference between intermediate and terminal operations in Streams?**
**Intermediate operations** (`filter`, `map`, `sorted`) are lazy — they return a new stream and aren't executed until a terminal operation is invoked. **Terminal operations** (`collect`, `forEach`, `reduce`, `count`) trigger the actual processing and produce a result or side effect, after which the stream is consumed and can't be reused.

**Q43. Difference between `map()` and `flatMap()`?**
`map()` transforms each element into another value, producing a stream of the same "shape" (one-to-one). `flatMap()` is used when each element maps to *multiple* elements (e.g., a `Stream<List<Integer>>`) — it flattens the nested structure into a single, flat stream.

**Q44. What is `Optional`, and what problem does it solve?**
A container object that may or may not hold a non-null value, used as a return type to explicitly signal "this might be absent" rather than returning `null` — forcing callers to handle the absence case (e.g., via `isPresent()`, `orElse()`, `map()`) instead of risking an unchecked `NullPointerException`.

**Q45. What are default and static methods in interfaces, and why were they added in Java 8?**
`default` methods provide a method body directly in an interface, allowing implementations to be added to interfaces **without breaking existing classes** that implement them (crucial for evolving the Collections API to add Stream support). `static` methods belong to the interface itself, used for utility/helper logic (e.g., `Comparator.comparing()`).

**Q46. What is method reference, and how does it relate to lambdas?**
Shorthand syntax for a lambda that just calls an existing method, e.g., `String::toUpperCase` instead of `s -> s.toUpperCase()`. Four kinds: static method (`ClassName::staticMethod`), instance method on a particular object (`obj::instanceMethod`), instance method on an arbitrary object of a type (`ClassName::instanceMethod`), and constructor reference (`ClassName::new`).

**Q47. What is the difference between `Collectors.toList()` and `Collectors.toSet()` in Stream terminal operations?**
Both are terminal collector operations used with `.collect()`. `toList()` gathers stream elements into a `List` (preserving order, allowing duplicates); `toSet()` gathers them into a `Set` (no defined order guarantee, duplicates removed).

---

## 6. JVM / Memory

**Q48. What are the main memory areas managed by the JVM?**
- **Heap**: stores all objects/arrays; shared across threads; divided into Young Generation (Eden + Survivor spaces) and Old Generation for GC purposes.
- **Stack**: per-thread, stores method frames and local variables.
- **Method Area / Metaspace**: stores class metadata, static variables, constant pool (Metaspace replaced PermGen from Java 8 onward).
- **PC Register**: per-thread, tracks the address of the currently executing instruction.
- **Native Method Stack**: supports native (non-Java) method calls.

**Q49. What is garbage collection, and how does it decide what to collect?**
Automatic reclamation of heap memory occupied by objects no longer reachable from any live reference (GC roots — e.g., active thread stacks, static references). Java uses a generational approach: most objects die young, so the **Young Generation** is collected frequently and quickly (Minor GC); objects that survive multiple collections get promoted to the **Old Generation**, collected less often but more expensively (Major/Full GC).

**Q50. What causes a `StackOverflowError` vs an `OutOfMemoryError`?**
`StackOverflowError` occurs when the call stack exceeds its limit — typically from deep or infinite recursion. `OutOfMemoryError` occurs when the heap (or Metaspace) can't allocate more memory because it's full and the GC can't free enough space — e.g., from memory leaks or genuinely holding too much live data.

**Q51. What is the difference between Young Generation and Old Generation in the heap?**
**Young Generation** holds newly created, short-lived objects (split into Eden and two Survivor spaces); collected frequently via fast Minor GC. **Old Generation** holds long-lived objects that survived several Young Gen collections; collected less frequently but with a more expensive Major/Full GC since it scans a larger memory region.

**Q52. What is class loading, and what are the three built-in class loaders?**
The JVM process of loading `.class` files into memory, done lazily (on first use) via a **parent delegation model**: 
1. **Bootstrap ClassLoader** — loads core JDK classes (`java.lang.*`, etc.).
2. **Extension/Platform ClassLoader** — loads classes from extension directories.
3. **Application ClassLoader** — loads classes from the application's classpath.
Each delegates to its parent first, only loading the class itself if the parent can't find it — this prevents core classes from being overridden accidentally.

**Q53. What is the difference between JIT compilation and interpretation in the JVM?**
The JVM initially **interprets** bytecode line-by-line, which is slower. The **JIT (Just-In-Time) compiler** identifies "hot" code paths (frequently executed methods/loops) and compiles them directly into native machine code at runtime, caching the result — dramatically speeding up subsequent executions of that code.

**Q54. What is a memory leak in Java, given it has automatic garbage collection?**
A memory leak happens when objects are no longer needed by the application logic but are still **reachable** via some lingering reference (e.g., objects stuck in a static collection, unclosed resources, listeners never deregistered) — so the GC can't reclaim them, even though GC itself is working correctly.

**Q55. What are strong, weak, soft, and phantom references?**
- **Strong reference**: default; object is never GC'd while reachable.
- **Soft reference**: GC'd only when the JVM is low on memory (useful for memory-sensitive caches).
- **Weak reference**: GC'd as soon as no strong references exist, regardless of memory pressure (used in `WeakHashMap`).
- **Phantom reference**: object is already finalized; used for pre-cleanup actions/tracking, retrieved via a `ReferenceQueue` rather than `get()`.

---

*Tip: work through these in order — Fundamentals and OOPs first, since Collections, Exceptions, and Streams all lean heavily on those concepts (e.g., understanding `equals()`/`hashCode()` before HashMap internals, or understanding interfaces before functional interfaces).*
