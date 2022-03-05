package slopMaster;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException, IOException {
		String token = Files.readAllLines(Paths.get("C:/Users/mmmmm/Desktop/botgifs/token.txt")).get(0);
		JoeFileCount file = new JoeFileCount();
		JDA jda = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
				.addEventListeners(new Commands())
				.setActivity(Activity.playing("slopping innocent people (i hate them)"))
				.setStatus(OnlineStatus.ONLINE)
				.build();
		//jda.addEventListeners(new Commands());
		System.out.println(file.readFile(file.joe));
		String arg = "my name is walter hartwell white";
		int i = arg.indexOf(' ');
	}

} 

