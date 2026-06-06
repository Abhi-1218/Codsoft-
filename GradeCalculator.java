import java.util.Scanner;

public class GradeCalculator {

    // Method to assign grade based on average percentage
    public static String getGrade(double average) {
        if (average >= 90) {
            return "A+ (Outstanding)";
        } else if (average >= 80) {
            return "A  (Excellent)";
        } else if (average >= 70) {
            return "B  (Very Good)";
        } else if (average >= 60) {
            return "C  (Good)";
        } else if (average >= 50) {
            return "D  (Average)";
        } else if (average >= 40) {
            return "E  (Pass)";
        } else {
            return "F  (Fail)";
        }
    }

    // Method to get remarks
    public static String getRemarks(double average) {
        if (average >= 90) {
            return "Keep up the brilliant work!";
        } else if (average >= 80) {
            return "Great performance!";
        } else if (average >= 70) {
            return "Good job, keep improving!";
        } else if (average >= 60) {
            return "You are doing well.";
        } else if (average >= 50) {
            return "You passed, but try to score higher!";
        } else if (average >= 40) {
            return "Barely passed. Work harder!";
        } else {
            return "You failed. Please study more and try again.";
        }
    }

    // Method to print a separator line
    public static void printLine(char ch, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printLine('=', 50);
        System.out.println("       STUDENT GRADE CALCULATOR");
        printLine('=', 50);

        // Step 1: Get student name
        System.out.print("\nEnter Student Name: ");
        String studentName = scanner.nextLine();

        // Step 2: Get number of subjects
        int numSubjects = 0;
        while (numSubjects <= 0) {
            System.out.print("Enter Number of Subjects: ");
            if (scanner.hasNextInt()) {
                numSubjects = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (numSubjects <= 0) {
                    System.out.println("  [!] Number of subjects must be greater than 0. Try again.");
                }
            } else {
                System.out.println("  [!] Invalid input. Please enter a valid number.");
                scanner.nextLine(); // flush invalid input
            }
        }

        // Step 3: Input subject names and marks
        String[] subjectNames = new String[numSubjects];
        double[] marks = new double[numSubjects];

        System.out.println();
        printLine('-', 50);
        System.out.println("  Enter Marks for Each Subject (out of 100)");
        printLine('-', 50);

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("  Subject " + (i + 1) + " Name : ");
            subjectNames[i] = scanner.nextLine();

            boolean validMark = false;
            while (!validMark) {
                System.out.print("  Marks Obtained : ");
                if (scanner.hasNextDouble()) {
                    marks[i] = scanner.nextDouble();
                    scanner.nextLine();
                    if (marks[i] < 0 || marks[i] > 100) {
                        System.out.println("  [!] Marks must be between 0 and 100. Try again.");
                    } else {
                        validMark = true;
                    }
                } else {
                    System.out.println("  [!] Invalid input. Please enter a numeric value.");
                    scanner.nextLine();
                }
            }
            System.out.println();
        }

        // Step 4: Calculate total marks and average
        double totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            totalMarks += marks[i];
        }

        double totalMaxMarks = numSubjects * 100;
        double averagePercentage = (totalMarks / totalMaxMarks) * 100;

        // Step 5: Get grade and remarks
        String grade = getGrade(averagePercentage);
        String remarks = getRemarks(averagePercentage);

        // Step 6: Display Results
        System.out.println();
        printLine('=', 50);
        System.out.println("              RESULT CARD");
        printLine('=', 50);
        System.out.printf("  Student Name     : %s%n", studentName);
        System.out.printf("  Total Subjects   : %d%n", numSubjects);
        printLine('-', 50);
        System.out.printf("  %-20s %10s %10s%n", "Subject", "Max Marks", "Obtained");
        printLine('-', 50);

        for (int i = 0; i < numSubjects; i++) {
            System.out.printf("  %-20s %10.0f %10.2f%n", subjectNames[i], 100.0, marks[i]);
        }

        printLine('-', 50);
        System.out.printf("  %-20s %10.0f %10.2f%n", "TOTAL", totalMaxMarks, totalMarks);
        printLine('=', 50);
        System.out.printf("  Average Percentage : %.2f%%%n", averagePercentage);
        System.out.printf("  Grade              : %s%n", grade);
        System.out.printf("  Remarks            : %s%n", remarks);
        printLine('=', 50);

        // Grade scale reference
        System.out.println("\n  GRADE SCALE REFERENCE:");
        printLine('-', 50);
        System.out.println("  90% - 100%  =>  A+ (Outstanding)");
        System.out.println("  80% -  89%  =>  A  (Excellent)");
        System.out.println("  70% -  79%  =>  B  (Very Good)");
        System.out.println("  60% -  69%  =>  C  (Good)");
        System.out.println("  50% -  59%  =>  D  (Average)");
        System.out.println("  40% -  49%  =>  E  (Pass)");
        System.out.println("   0% -  39%  =>  F  (Fail)");
        printLine('=', 50);
        System.out.println("  Thank you for using Student Grade Calculator!");
        printLine('=', 50);

        scanner.close();
    }
}
