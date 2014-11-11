import java.io.PrintWriter;
import java.io.*;
import java.io.Writer;
public class GameLogging {
private PrintWriter printer;

public GameLogging()
{
	printer = null;
}

public void openFile(String fileName)
{
	try
	{
		printer = new PrintWriter(new FileWriter(fileName, true));
	}
	catch (IndexOutOfBoundsException e) {
    System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());                      
	} 
	catch (IOException e) {
    System.err.println("Caught IOException: " +  e.getMessage());                        
	}
	catch(Exception e){
		System.err.println("Caught Exception: " + e.getMessage());
	}
}

//Return the printwriter
public PrintWriter getPrinter()
{
	return printer;
}

//Writes to the gamelog
public void record(String input)
{
	printer.print(input);
}
	
//Saves the game log
public void saveFile()
{
	System.out.println("gameplay log was closed and save successfully ");
	printer.close();
}

public void eraseFile(String fileName)
{
	try
	{
		printer = new PrintWriter(new FileWriter(fileName));
	}
	catch (IndexOutOfBoundsException e) {
    System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());                      
	} 
	catch (IOException e) {
    System.err.println("Caught IOException: " +  e.getMessage());                        
	}
	catch(Exception e){
		System.err.println("Caught Exception: " + e.getMessage());
	}
}





}
