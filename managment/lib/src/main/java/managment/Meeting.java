package managment;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event{
	
	private String id; 
	
	public List<Employee> attendees = new ArrayList<>();
	
	public Meeting(String id) {
		this.id = id;
	}
	
	public void addPeople(Employee emp) {
		
		this.attendees.add(emp);

	}
	
	public String getid() {
		return this.id;
	}

}
