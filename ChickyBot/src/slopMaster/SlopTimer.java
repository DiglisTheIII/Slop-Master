package slopMaster;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
public class SlopTimer extends Thread {
	File f = new File("bottimer.txt");
	public void run() {
		RuntimeMXBean uptime = ManagementFactory.getRuntimeMXBean();
		System.out.println(uptime.getUptime() / 1000 + " second(s)");
	}
}
