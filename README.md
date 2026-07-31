# SE2012 2026 S2 L02 — Student Management System

A simple console-based Student Management System written in Java, submitted in two parts. Part 2 is a refactor of Part 1 into proper packages with a separate service layer.

## Repository Structure

```
.
├── part_1/
│   └── StudentManagement/
│       ├── Main.java        # Entry point, menu, and student array (default package)
│       ├── Student.java     # Student model
│       ├── Course.java      # Course model
│       └── docs/            # Generated Javadoc (open docs/index.html)
│
└── part_2/
    └── StudentManagement/
        ├── mainapp/
        │   └── Main.java              # Entry point and user menu
        ├── models/
        │   ├── Student.java           # Student model
        │   └── Course.java            # Course model
        ├── services/
        │   └── EnrollmentManager.java # Handles enrollment, searching, and sorting logic
        └── docs/                      # Generated Javadoc (open docs/index.html)
```

### Part 1 — `part_1/StudentManagement`
All classes (`Main`, `Student`, `Course`) live together in the default package. `Main` owns the student data array and handles both the menu and the business logic directly.

### Part 2 — `part_2/StudentManagement`
The same functionality refactored into three packages:
- `mainapp` — the `Main` class, responsible only for the menu/UI loop
- `models` — the `Student` and `Course` data classes
- `services` — `EnrollmentManager`, which owns the student data and handles enrollment, searching, and sorting

## How to Compile and Run

### Part 1

```bash
cd part_1/StudentManagement
javac *.java
java Main
```

### Part 2

```bash
cd part_2/StudentManagement
javac mainapp/*.java models/*.java services/*.java
java mainapp.Main
```

> Requires a JDK (Java 8+) on your `PATH`. Check with `java -version` and `javac -version`.

## Documentation

Each part includes pre-generated Javadoc HTML. To view it, open the corresponding `index.html` file in a web browser:

- Part 1: `part_1/StudentManagement/docs/index.html`
- Part 2: `part_2/StudentManagement/docs/index.html`

To regenerate the docs yourself instead of using the pre-built ones:

```bash
# Part 1
cd part_1/StudentManagement
javadoc -d docs *.java

# Part 2
cd part_2/StudentManagement
javadoc -d docs models/*.java services/*.java mainapp/*.java
```