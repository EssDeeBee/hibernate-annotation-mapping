package domain;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

public class Domain {

	public static void main(String... args) throws SQLException {

		/*Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Address address = new Address();
		address.setCountry("DC");
		address.setCity("Gotham City");
		address.setStreet("Arkham street 1");
		address.setPostCode("12345");

		Project project = new Project();
		project.setTitle("5678");

		Employee employee = new Employee();
		employee.setFirstName("James");
		employee.setLastName("Gordon");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1939, Calendar.MAY, 1);

		employee.setBirthday(new Date(calendar.getTime().getTime()));
		employee.setAddress(address);

		Set<Employee> employees = new HashSet<>();
		employees.add(employee);
		project.setEmployees(employees);

		Set<Project> projects = new HashSet<>();
		projects.add(project);
		employee.setProjects(projects);

		session.save(address);
		session.save(project);
		session.save(employee);

		session.getTransaction().commit();
		HibernateUtil.shutdown();*/
		
		AddressService addressService = new AddressService();
		EmployeeService employeeService = new EmployeeService();
		ProjectService projectService = new ProjectService();
		
		Address address = new Address();
		address.setCountry("DC");
		address.setCity("Gotham City");
		address.setStreet("Arkham street 1");
		address.setPostCode("12345");

		Project project = new Project();
		project.setTitle("Gotham PD");

		Employee employee = new Employee();
		employee.setFirstName("James");
		employee.setLastName("Gordon");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1939, Calendar.MAY, 1);

		employee.setBirthday(new Date(calendar.getTime().getTime()));
		employee.setAddress(address);

		Set<Employee> employees = new HashSet<>();
		employees.add(employee);
		project.setEmployees(employees);

		Set<Project> projects = new HashSet<>();
		projects.add(project);
		employee.setProjects(projects);

		/*addressService.add(address);
		employeeService.add(employee);
		projectService.add(project);*/
		
		Address a = addressService.getById(1L);
		System.out.println(a);
		
		HibernateUtil.shutdown();

	}

}
