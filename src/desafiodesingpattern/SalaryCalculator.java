package desafiodesingpattern;

import java.util.Scanner;

// Classe Employee para representar os detalhes do funcionário:


public class SalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        int hoursWorked = scanner.nextInt();
        double hourlyRate = scanner.nextDouble();
        
        // TODO: Utilize o Factory Method para criar um objeto Employee:
       Employee employee = EmployeeFactory.createEmployee(hoursWorked, hourlyRate);
        
        double salary = employee.calculateSalary();
        scanner.close();
        
        System.out.printf("Salario total: %.1f%n", salary);
    }
}
    
    class Employee {
        private int hoursWorked;
        private double hourlyRate;

        public Employee(int hoursWorked, double hourlyRate) {
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        public double calculateSalary() {
            return this.hoursWorked * this.hourlyRate;
        }
    }
        
        class EmployeeFactory {
            

            public static Employee createEmployee(int hoursWorked, double hourlyRate){
                return new Employee(hoursWorked, hourlyRate);
            }
          }
    


    // TODO: Implemente a classe Factory para criar objetos Employee:
        // TODO: Implemente o método createEmployee:
            // TODO: Implemente do método para criar e retornar um objeto Employee:
         
            
         

