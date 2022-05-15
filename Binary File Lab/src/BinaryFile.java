import java.io.*;
import java.io.IOException;
public class BinaryFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			generateRandomNum();
			readBinaryFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void generateRandomNum() throws IOException{
		int [] array= new int[500];
		
		for (int i=0; i<array.length; i++) {
			array[i]= (int)((Math.random()*(9999-1000))+1000);
		}
		
		String binary ="BinaryFile.dat";
		String ascii= "data.txt";
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream(binary));
		PrintWriter pw = new PrintWriter(ascii);
		
		for (int i=0; i<array.length; i++) {
			pw.println(array[i]);
			out.writeInt(array[i]);
		}
		pw.close();
		out.close();
	}
	
	public static void readBinaryFile() throws IOException{
		String binary="BinaryFile.dat";
		DataInputStream in=null;
		try {
			in = new DataInputStream(new FileInputStream(binary));
			while(true) {
				System.out.println(in.readInt());	
			}
		}catch(IOException e) {
			e.printStackTrace();;
		}
		in.close();	
	}

}
