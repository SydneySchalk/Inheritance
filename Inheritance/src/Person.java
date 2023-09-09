import java.util.Calendar;

public class Person {
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;



    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }



    public String getIDNum() {
        return IDNum;
    }
    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return Integer.toString(currentYear - YOB);
    }

    public String getAge(int year) {
        return Integer.toString(year - YOB);
    }

    public String toCSVDataRecord() {
        return IDNum + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }
    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB='" + YOB + '\'' +
                '}';
    }

    public static class Worker extends Person {
        private double hourlyPayRate;

        public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
            super(IDNum, firstName, lastName, title, YOB);
            this.hourlyPayRate = hourlyPayRate;
        }

        public double calculateWeeklyPay(double hoursWorked) {
            double regularPay;
            double overtimePay;

            if (hoursWorked <= 40) {
                regularPay = hoursWorked * hourlyPayRate;
                overtimePay = 0.0;
            } else {
                regularPay = 40 * hourlyPayRate;
                overtimePay = (hoursWorked - 40) * (hourlyPayRate * 1.5);
            }

            return regularPay + overtimePay;
        }

        public String displayWeeklyPay(double hoursWorked) {
            double regularPay;
            double overtimePay;

            if (hoursWorked <= 40) {
                regularPay = hoursWorked * hourlyPayRate;
                overtimePay = 0.0;
            } else {
                regularPay = 40 * hourlyPayRate;
                overtimePay = (hoursWorked - 40) * (hourlyPayRate * 1.5);
            }

            double totalPay = regularPay + overtimePay;

            return "Regular Hours (40): $" + regularPay + " | Overtime Hours (" + (hoursWorked - 40) + "): $" + overtimePay + " | Total Pay: $" + totalPay;
        }
        public String getFullName() {
            return super.fullName();
        }
        public static class SalaryWorker extends Worker {
            private double annualSalary;

            public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {
                super(IDNum, firstName, lastName, title, YOB, hourlyPayRate);
                this.annualSalary = annualSalary;
            }

            @Override
            public double calculateWeeklyPay(double hoursWorked) {
                return annualSalary / 52.0;
            }

            @Override
            public String displayWeeklyPay(double hoursWorked) {
                return "Weekly Pay: $" + calculateWeeklyPay(hoursWorked) + " (Yearly Salary: $" + annualSalary + ")";
            }
            public String getFullName() {
                return super.fullName();
            }
        }

    }


}