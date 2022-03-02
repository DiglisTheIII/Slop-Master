package slopMaster;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException, IOException {
		Token token = new Token();
		JoeFileCount file = new JoeFileCount();
		JDABuilder jda = JDABuilder.createDefault(token.Token);
		jda.setActivity(Activity.playing("slopping innocent people (i hate them)"));
		jda.setStatus(OnlineStatus.ONLINE);
		jda.addEventListeners(new Commands());
		jda.build();
		System.out.println(file.readFile(file.joe));
		
	}

} 

