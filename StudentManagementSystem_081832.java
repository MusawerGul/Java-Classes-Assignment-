class Student1 {
    String name;
    int rollNumber;
    int[] marks;

    public Student1(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public double calculateAverageMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public void displayDetails() {
        System.out.println("Student's Name: " + name);
        System.out.println("Student's Roll Number: " + rollNumber);
        System.out.print("Student's Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println("Average Marks: " + String.format("%.2f", calculateAverageMarks()));
    }

    public boolean isPassed(double passingPercentage) {
        return calculateAverageMarks() >= passingPercentage;
    }

    public static double calculateClassAverage(Student1[] students) {
        double totalAverage = 0;
        for (Student1 student : students) {
            totalAverage += student.calculateAverageMarks();
        }
        return totalAverage / students.length;
    }

    public static void main(String[] args) {
        Student1[] students = {
                new Student1("Najaf", 01, new int[] { 80, 50, 78 }),
                new Student1("Babar", 67, new int[] { 30, 15, 60 }),
                new Student1("Mushawer", 17, new int[] { 99, 95, 99 })
        };

        double passingPercentage = 60.0;

        for (Student1 student : students) {
            student.displayDetails();
            System.out.println(student.isPassed(passingPercentage) ? "Passed" : "Failed");
            System.out.println();
        }

        System.out.println("Class Average: " + String.format("%.2f", Student1.calculateClassAverage(students)));
    }
}