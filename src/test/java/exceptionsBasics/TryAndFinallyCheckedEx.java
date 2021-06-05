package exceptionsBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.IIOException;

public class TryAndFinallyCheckedEx {

	public static void main(String[] args) throws FileNotFoundException {

		TryAndFinallyCheckedEx tna = new TryAndFinallyCheckedEx();
		tna.noCatch();

	}

	public void noCatch() throws FileNotFoundException  {
		
	String filePath = null;
	FileInputStream fis = null;
	
		try {
			  fis = new FileInputStream(filePath);
		}
			
		finally{
		
			System.out.println("I am in finally" );
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	

	}

}
