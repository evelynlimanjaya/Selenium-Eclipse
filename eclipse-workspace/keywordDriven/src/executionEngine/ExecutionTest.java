package executionEngine;
import java.io.IOException; 
import java.lang.reflect.InvocationTargetException; 
import keywordDriven.Action_keyword;

public class ExecutionTest {
	public static void main(String[] args) throws IOException, Exception, IllegalArgumentException, InvocationTargetException 
	{ 
 
	Action_keyword keyword = new Action_keyword(); 
	keyword.openBrowser(); 
	keyword.navigate(); 
	keyword.input(); 
	keyword.clickEnter(); 
	keyword.checkResult(); 
	keyword.closeBrowser();
	System.out.println("Test executed successfully"); 
	}
}
