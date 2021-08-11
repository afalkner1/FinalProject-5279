package managment;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( { DatabaseTest.class, TestEmployee.class, HeadTest.class, 
	eventTest.class, MeetingTest.class, TestTask.class} )
public class Autograder{

    

}
