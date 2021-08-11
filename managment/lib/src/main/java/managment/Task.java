package managment;

public class Task extends Event {	
	
	private Head head = null;
	private Employee emp = null;
	
	private String info;
	
	public Task(Head head, Employee emp, String task) {
	
		this.head = head;
		this.emp = emp;
		this.info = task;
	}
	
	public String getInfo() {
		return this.info;
	}
	
	public Head getHead() {
		return this.head;
	}
	
	public Employee getEmployee() {
		return this.emp;
	}
	

}
