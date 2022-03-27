package slopMaster;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SlopTimer extends Thread {
	File f = new File("bottimer.txt");
	public void run() {
		try {
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("Current Date: " + java.time.LocalDate.now() + " Current Time: " + java.time.LocalTime.now().toString().substring(0, 8));
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			System.out.println("Exception in thread " + Thread.currentThread().getId());
		}
	}
}
