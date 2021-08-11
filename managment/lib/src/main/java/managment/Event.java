package managment;

import java.time.LocalDateTime;
import java.util.Calendar; 

public class Event {
	
	public Calendar start_time = Calendar.getInstance();	
	public Calendar end_time = Calendar.getInstance();	
	
	public Event() {
						
	}
	
	public void setStart(int year, int month, int day, int hour, int minute) {
		
		this.start_time.set(year, month, day, hour, minute);
		
	}
	
	public void setEnd(int year, int month, int day, int hour, int minute) {
		
		this.end_time.set(year, month, day, hour, minute);
		
	}
	
	public boolean isSame(Event eve) {
		return (this.start_time.equals(eve.start_time) && this.end_time.equals(eve.end_time));
	}
	
	public boolean overlap(Event eve) {
		
		if (this.start_time.before(eve.start_time) && this.end_time.before(eve.start_time)) {
			
			return false;	
			
		}
		
		else if (this.start_time.after(eve.end_time)) {
			return false;
		}
		
		
		return true;
		
	}
	
	
	

}
