package slopMaster;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException, IOException {
		String token = Files.readAllLines(Paths.get("C:/Users/mmmmm/Desktop/botgifs/token.txt")).get(0);
		JoeFileCount file = new JoeFileCount();
		JDABuilder jda = JDABuilder.createDefault(token);
		jda.setActivity(Activity.playing("slopping innocent people (i hate them)"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.build();
		System.out.println(file.readFile(file.joe));
		
	}

} 

