package managment;

import java.util.Scanner; 

public class present {
	
	private String printMenue() {
		
		Scanner myObj = new Scanner(System.in);
		System.out.println();
		System.out.println("Choose Option: ");
		System.out.println("1. Add Employee ");
		System.out.println("2. Add Head ");
		System.out.println("3. Add Task ");
		System.out.println("4. Remove Employee ");
		System.out.println("5. Remove Head ");
		System.out.println("6. Print Tasks for Employee or Head ");
		System.out.println("7. Print Employees ");
		System.out.println("8. Print Head Employees ");
		System.out.println("9. Close Application ");
		
		
		String option = myObj.nextLine();
		
				
		
		return option;
	}
	
	public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		
		present pres = new present();
		
		Database data = Database.getInstance();
		
		while(true) {
		
			String option = pres.printMenue();
			
			
			if (option.equals("1")) {
				
				System.out.print("Type Name: ");
				
				
				String name = myObj.nextLine();
				
				System.out.print("Type Employee id: ");
				
				
				String id = myObj.nextLine();
				
				System.out.print("Type Employee department: ");
				
				
				String dep = myObj.nextLine();								
				
				data.addEmployee(name, id);
				
				data.setDep(id, dep);
				
			}
			
			if (option.equals("2")) {
				
				System.out.print("Type Name: ");
				
				
				String name = myObj.nextLine();
				
				System.out.print("Type Department: ");
				
				
				String id = myObj.nextLine();
				
				
				data.addHead(name, id);
				
			}
			else if (option.equals("3")) {
//				add task
				System.out.print("Type Employee id: ");
				
				
				String emp_id = myObj.nextLine();
				
				System.out.print("Type department: ");
				
				
				String dep = myObj.nextLine();
				
				System.out.print("Type Task information: ");
				
				
				String info = myObj.nextLine();								
				
				data.createTask(dep, emp_id, info);
				
			}
			
			else if (option.equals("4")) {
//				remove emp
				System.out.print("Type Employee id: ");
				
				
				String emp_id = myObj.nextLine();
				
				data.removeEmployee(emp_id);
			}
			
			else if (option.equals("5")) {
				
//				remove head
				
				System.out.print("Type Department of Head: ");				
				
				String head_id = myObj.nextLine();
				
				data.removeHead(head_id);
				
				
			}
			else if (option.equals("6")) {
				
				System.out.print("For Employee tasks type Employee ID, and for Head tasks type department: ");
								
				String emp_id = myObj.nextLine();
				
				data.all_employees.get(emp_id).printTasks();
				
				
			}
			else if (option.equals("7")) {
				data.printEmployees();
			}
			
			else if (option.equals("8")) {
				data.printHeads();
			}
			
			else if (option.equals("9")) {
				
				break;
			}
			
		}

    }

}


