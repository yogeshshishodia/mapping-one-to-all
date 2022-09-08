package jdbaonetomany;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import jdbaahibernateutility.HibernateUtility;

public class OneToManyDemo {

	public static void main(String[] args) {
		Session session= HibernateUtility.getSessionFactory().openSession();
		Department department = new Department();
		department.setDeptName("MARKETING");
		department.setLocation("NEW DELHI");
		
		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setEmpName("Kriti Sanon");
		employee.setHireDate(new Date());
		
		
		Employee employee1 = new Employee();
		employee1.setDepartment(department);
		employee1.setEmpName("Nursat Bharocha");
		employee1.setHireDate(new Date());
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(employee1);
		empSet.add(employee);
		department.setEmployees(empSet);
		
		session.beginTransaction();
		session.persist(employee);
		session.persist(employee1);
		session.getTransaction().commit();
	}

}