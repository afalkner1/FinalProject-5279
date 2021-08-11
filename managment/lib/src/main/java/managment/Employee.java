package managment;
import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class
import java.lang.Object.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Employee implements Worker{
	
	public int min = 5;
    public int max = 1000;
    	
	protected String id = "";
	
	protected String name = "";
	
	protected String dep = "";
	
	protected List<Task> tasks = new ArrayList<>();	
	
	public List<Event> leave_calendar = new ArrayList<>();	
	
	public HashMap<String, Meeting> meetings = new HashMap<String, Meeting>();
	
	public Employee() {
		this.id = this.generateId();
	}
	public Employee(String id) {
		this.id = id;
	}	
	public Employee(String name, String id) {
		this.id = id;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDep(String dep) {
		this.dep = dep;
	}
	
	public String getDep() {
		return this.dep;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}		
	
	public void requestLeave(boolean decision, Event eve) {
		
		if (decision){
			this.leave_calendar.add(eve);
	
		}
				
	}
		
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public List<Task> getTasks() {
		return this.tasks;
	}
	
	public void printTasks() {
		tasks.stream()
		  .forEach(t-> System.out.println(
		      t.getInfo()));
	}
	
	public String generateId() {
		
		return String.valueOf((int)Math.floor(Math.random()*(this.max-this.min+1)+this.min));
	}
	public boolean addMeeting(Meeting meet, String meet_id) {
//		make sure it doesn't overlap with other meetings 
		
		for(HashMap.Entry<String, Meeting> entry : this.meetings.entrySet()) {
			Meeting temp = this.meetings.get(entry.getKey());
			if (temp.overlap(meet)) {
				System.out.println("Cannot be added to meeting. Already busy.");
				return false;
			}
		}
		
		this.meetings.put(meet_id, meet);
		
		return true;
	}
	


}
