package managment;

import java.util.*;

public class Head extends Employee {
	
	public List<Event> emp_leave_calendar = new ArrayList<>();	
	public HashMap<String, Employee> dep_employees = new HashMap<String, Employee>();
	

	public Head(String name, String id) {
		this.id = id;
		this.name = name;
	}
	
	
	public void createTask(Task task, Employee emp) {
		
		emp.addTask(task);
		this.addTask(task);
		
	}
	
	public void setDep(String dep) {
		this.id = dep;
	}
	
	public void addEmployee(Employee emp) {
		dep_employees.put(emp.getId(), emp);
	}
	
	public boolean leaveRequested(Employee emp, Event eve) {
		
		if (this.emp_leave_calendar.size() == 0) {
			
			System.out.println("Leave Accepted");
			this.emp_leave_calendar.add(eve);
			return true;
		}
		
		else {
			for (Event temp: this.emp_leave_calendar) {
				
				if (temp.isSame(eve)) {
					
				
					System.out.println("Cannot accept leave: Overlap");
					return false;
				}
				
				else if (temp.overlap(eve)) {
					
					System.out.println("Cannot accept leave: Overlap");
					return false;
				}
				
				else {
					
					
					System.out.println("Leave Accepted");
					
					this.emp_leave_calendar.add(eve);
					return true;
					
				}							
				
			}
		
		}
		return false;
		
	}
	
	public void removeEmployee(String emp_id) {
		this.dep_employees.remove(emp_id);
	}
	
	public void printEmployees() {
		this.dep_employees.entrySet().stream().forEach(e ->
	    System.out.println(e.getKey() + "=" + e.getValue()));
	}
	
	
}
