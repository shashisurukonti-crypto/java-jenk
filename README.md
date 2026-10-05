# StudentJava

A standalone Java application specifically designed for a **Jenkins CI/CD practical and viva demonstration**.

This project demonstrates core software engineering and DevOps principles:
- **Java Programming**: Object-oriented implementation of a Student Management system using standard collections (`ArrayList`).
- **Maven Build Tool**: Clean compilation, dependency management, and packaging.
- **JUnit 5 Testing**: Automated unit tests with standard assertions verifying application logic.
- **Jenkins CI Pipeline**: Fully automated multi-stage Declarative Pipeline (`Compile` → `Test` → `Package`) on Windows.

---

## Project Structure

```text
StudentJava/
│
├── pom.xml
├── Jenkinsfile
├── README.md
├── JENKINS_GUIDE.md
├── .gitignore
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               └── student/
    │                   ├── Student.java
    │                   └── StudentManager.java
    │
    └── test/
        └── java/
            └── com/
                └── example/
                    └── student/
                        ├── StudentTest.java
                        └── StudentManagerTest.java
```

---

## Features & Implementation

### 1. [Student.java](file:///d:/notes/SE/jenkins/java-proj/src/main/java/com/example/student/Student.java)
- **Attributes**: `id` (int), `name` (String), `department` (String)
- **Constructor**: Parameterized constructor initializing all attributes.
- **Getters & Setters**: Encapsulated field access.
- **`getDetails()`**: Formats student details into the exact string `id - name - department` (e.g., `101 - Sathvik - CSE`).

### 2. [StudentManager.java](file:///d:/notes/SE/jenkins/java-proj/src/main/java/com/example/student/StudentManager.java)
- Uses an `ArrayList<Student>` to manage student records.
- **Operations**:
  1. `addStudent(Student student)`: Adds a student to the list.
  2. `findStudentById(int id)`: Searches and returns the matching student, or `null` if not found.
  3. `getAllStudents()`: Returns a list copy of all students.
  4. `removeStudentById(int id)`: Removes a student by ID and returns boolean status (`true`/`false`).
  5. `getStudentCount()`: Returns total student count.

### 3. [StudentTest.java](file:///d:/notes/SE/jenkins/java-proj/src/test/java/com/example/student/StudentTest.java) & [StudentManagerTest.java](file:///d:/notes/SE/jenkins/java-proj/src/test/java/com/example/student/StudentManagerTest.java)
- JUnit 5 test suite with assertions: `assertEquals()`, `assertTrue()`, `assertFalse()`, `assertNull()`, and `assertNotNull()`.
- Covers student creation, field updates, details formatting, add, find (existing and non-existent), remove, list retrieval, and count tracking.

---

## Local Setup & Testing Guide

### Step 1: Install Prerequisites
1. **Java 17 (or JDK 17+)**: Ensure JDK is installed and configured in your system environment variable `JAVA_HOME`.
2. **Apache Maven**: Ensure Apache Maven is installed and its `bin` folder is added to your system `PATH`.

### Step 2: Verify Installation
Open PowerShell or Command Prompt on Windows and verify:

```cmd
java -version
mvn -version
```

Both commands should display valid version information without errors.

### Step 3: Navigate to Project Directory
Navigate into the root of this project:

```cmd
cd d:\notes\SE\jenkins\java-proj
```

### Step 4: Compile the Application
Compile the Java source files into bytecode (`.class` files in `target/classes`):

```cmd
mvn clean compile
```

Expected output ends with:
```text
[INFO] BUILD SUCCESS
```

### Step 5: Run Unit Tests
Run the JUnit 5 automated test suite:

```cmd
mvn test
```

Expected output:
```text
[INFO] Running com.example.student.StudentManagerTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.example.student.StudentTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] BUILD SUCCESS
```

To run clean and test in a single command:
```cmd
mvn clean test
```

### Step 6: Package the Application
Bundle compiled classes into an executable JAR artifact:

```cmd
mvn package
```

To package skipping unit test execution (as done in the pipeline Package stage):
```cmd
mvn package -DskipTests
```

### Step 7: Generated Artifact Location
The compiled and packaged JAR file is located at:
```text
target/StudentJava-1.0-SNAPSHOT.jar
```

---

## Git Commands to Push to GitHub

To push this repository to GitHub so that Jenkins can pull it via SCM:

```bash
git init
git add .
git commit -m "Initial Java project"
git branch -M main
git remote add origin <GITHUB_URL>
git push -u origin main
```

*(Replace `<GITHUB_URL>` with your actual GitHub repository URL, e.g. `https://github.com/your-username/StudentJava.git`)*

---

## Jenkins Configuration & Viva Guide

For complete Jenkins setup instructions, stage explanations, viva questions with answers, and troubleshooting steps, refer to [JENKINS_GUIDE.md](file:///d:/notes/SE/jenkins/java-proj/JENKINS_GUIDE.md).
