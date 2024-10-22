/*Write a Java program to create a class called "Employee" with a name, job title, and salary attributes, and methods to calculate and update salary.
"Çalışan" adında bir sınıf oluşturan, bir isim, iş ünvanı ve maaş niteliklerini ve maaşı hesaplama ve güncelleme yöntemlerini içeren bir Java programı yazın.*/

package LAB.LAB2;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Ömer Halis Demir", "Full Stack Developer", 50000);
        Employee employee2 = new Employee("Nisa Demir", "Psychologist", 45000);

        System.out.println("\nEmployee Details:");   // Çalışan detayları bölümü için bir başlık yazdır
        employee1.printEmployeeDetails();  // employee1 nesnesinin detaylarını yazdır
        employee2.printEmployeeDetails();  // employee2 nesnesinin detaylarını yazdır
        employee1.raiseSalary(8);  // employee1'in maaşını %8 oranında artır
        employee2.raiseSalary(12); // employee2'nin maaşını %12 oranında artır

        System.out.println("\nAfter raising salary:");   // Maaşların artırıldığını belirten bir başlık yazdır

        System.out.println("\n8% for 'Ömer Halis Demir':"); // employee1'in maaş artışı ile ilgili başlık yazdır
        employee1.printEmployeeDetails(); // Güncellenmiş employee1 detaylarını yazdır

        System.out.println("\n12% for 'Nisa Demir':");  // employee2'nin maaş artışı ile ilgili başlık yazdır
        employee2.printEmployeeDetails();  // Güncellenmiş employee2 detaylarını yazdır
    }
}
/*
Employee Details:
Name: Ömer Halis Demir
Job Title: Full Stack Developer
Salary: 50000.0
Name: Nisa Demir
Job Title: Psychologist
Salary: 45000.0

After raising salary:

8% for 'Ömer Halis Demir':
Name: Ömer Halis Demir
Job Title: Full Stack Developer
Salary: 54000.0

12% for 'Nisa Demir':
Name: Nisa Demir
Job Title: Psychologist
Salary: 50400.0

+---------------------------------+
|           Employee              |
+---------------------------------+
| - name: String                  |
| - jobTitle: String              |
| - salary: double                |
+---------------------------------+
| + Employee(name: String, jobTitle: String, salary: double) |
| + getName(): String             |
| + setName(name: String): void    |
| + getJobTitle(): String         |
| + setJobTitle(jobTitle: String): void |
| + getSalary(): double           |
| + setSalary(salary: double): void|
| + raiseSalary(percentage: double): void|
| + printEmployeeDetails(): void  |
+---------------------------------+

 */