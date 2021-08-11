package managment;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class Database{
	

	public List<Task> tasks = new ArrayList<>();
	public HashMap<String, Meeting> meetings = new HashMap<String, Meeting>();
	
	public HashMap<String, Employee> all_employees = new HashMap<String, Employee>();
	public HashMap<String, Employee> employees = new HashMap<String, Employee>();
	public HashMap<String, Head> heads = new HashMap<String, Head>();
		
	
	public void addEmployee(String name, String id) {	
		Employee emp = new Employee(name,id);
		employees.put(emp.getId(), emp);
		all_employees.put(id, emp);	
	}
	
	public Head addHead(String name, String dep) {	
		Head head = new Head(name,dep);
		for(HashMap.Entry<String, Employee> entry : employees.entrySet()) {
			Employee emp = employees.get(entry.getKey());
			if (emp.getDep() == dep) {
				head.addEmployee(emp);
			}			
		}
		
		heads.put(dep, head);
		all_employees.put(dep, head);
		
		return head;
	}
	
	public Task createTask(String head_id,String emp_id,String info) {
		
		Employee emp  = employees.get(emp_id);
		Head head = heads.get(head_id);
		Task task = new Task(head,emp,info);
		heads.get(head_id).createTask(task, employees.get(emp_id));
		
		tasks.add(task);
		
		return task;
		
	}
	
	public void requestLeave( String emp_id, Event holiday) {
		
		String head_id = employees.get(emp_id).getDep();		
		boolean decision = heads.get(head_id).leaveRequested(employees.get(emp_id), holiday);
		employees.get(emp_id).requestLeave(decision, holiday);

	}
	
	public void setDep(String emp_id, String head_id) {
		employees.get(emp_id).setDep(head_id);
		if (heads.containsKey(head_id)) {
			heads.get(head_id).addEmployee(employees.get(emp_id));
		}	
	}
	
	public void removeEmployee(String emp_id) {
		String head_id = employees.get(emp_id).getDep();
		heads.get(head_id).removeEmployee(emp_id);
		employees.remove(emp_id);
		all_employees.remove(emp_id);
	}
	
	public void removeHead(String head_id) {
		heads.remove(head_id);
		all_employees.remove(head_id);
	}
	
	public void promoteEmployee(String emp_id, String dep) {
		String head_id = employees.get(emp_id).getDep();
		String name = employees.get(emp_id).getName();
		heads.get(head_id).removeEmployee(emp_id);
		employees.remove(emp_id);
		all_employees.remove(emp_id);
		Head head = this.addHead(name, dep);
		all_employees.put(dep, head);

	}
	
	public void printHeads() {
		heads.entrySet().stream().forEach(e ->
	    System.out.println(e.getKey() + "=" + e.getValue()));
	}
	
	public void printEmployees() {
		employees.entrySet().stream().forEach(e ->
	    System.out.println(e.getKey() + "=" + e.getValue()));
	}

	public void createMeeting(String meeting_id) {
		Meeting meeting = new Meeting(meeting_id);
		this.meetings.put(meeting_id, meeting);

	}
	
	public void addPeopletoMeeting(String emp_id, String meeting_id) {
			
		boolean attend = all_employees.get(emp_id).addMeeting(meetings.get(meeting_id), meeting_id);
		
		if (attend) {
			meetings.get(meeting_id).addPeople(all_employees.get(emp_id));
			
		}
	}
	
	public void setMeetingStartTime(String meeting_id, int year, int month, int day, int hour, int min ) {
		meetings.get(meeting_id).setStart(year, month, day, hour, min);
		
	}
	
	public void setMeetingEndTime(String meeting_id, int year, int month, int day, int hour, int min ) {
		meetings.get(meeting_id).setEnd(year, month, day, hour, min);
		
	}

}
