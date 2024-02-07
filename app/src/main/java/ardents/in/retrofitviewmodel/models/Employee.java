package ardents.in.retrofitviewmodel.models;

public class Employee {
	private String employeeName;
	private String employeeSalary;
	private String id;
	private String employeeAge;

	public Employee(String employeeName, String employeeSalary, String id, String employeeAge) {
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.id = id;
		this.employeeAge = employeeAge;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"employee_name = '" + employeeName + '\'' + 
			",employee_salary = '" + employeeSalary + '\'' + 
			",id = '" + id + '\'' + 
			",employee_age = '" + employeeAge + '\'' + 
			"}";
		}
}
