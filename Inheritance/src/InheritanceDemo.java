import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {

        ArrayList<Person.Worker> workers = new ArrayList<>();

        workers.add(new Person.Worker("1", "John", "Doe", "Mr.", 1990, 20.0));
        workers.add(new Person.Worker("2", "Alice", "Smith", "Ms.", 1985, 18.0));
        workers.add(new Person.Worker("3", "Bob", "Johnson", "Mr.", 1995, 22.0));

        ArrayList<Person.Worker.SalaryWorker> salaryWorkers = new ArrayList<>();

        salaryWorkers.add(new Person.Worker.SalaryWorker("4", "Jane", "Brown", "Ms.", 1982, 0.0, 75000.0));
        salaryWorkers.add(new Person.Worker.SalaryWorker("5", "Emily", "Davis", "Ms.", 1978, 0.0, 90000.0));
        salaryWorkers.add(new Person.Worker.SalaryWorker("6", "Michael", "Wilson", "Mr.", 1989, 0.0, 80000.0));


        for (int week = 1; week <= 3; week++) {
            System.out.println("Week " + week + " Payroll:");

            System.out.printf("%-20s %-10s\n", "Worker", "Weekly Pay");
            System.out.println("--------------------------------------");

            for (Person.Worker worker : workers) {
                double weeklyPay = worker.calculateWeeklyPay(week == 2 ? 50 : 40);
                String formattedPay = String.format("%.2f", weeklyPay);
                System.out.printf("%-20s $%-10s\n", worker.getFullName(), formattedPay);
            }

            for (Person.Worker salaryWorker : salaryWorkers) {
                double weeklyPay = salaryWorker.calculateWeeklyPay(0);
                String formattedPay = String.format("%.2f", weeklyPay);
                System.out.printf("%-20s $%-10s\n", salaryWorker.getFullName(), formattedPay);
            }

            System.out.println();
        }
    }
}
