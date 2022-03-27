package slopMaster;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException, IOException, InterruptedException {
		String token = Files.readAllLines(Paths.get("C:/Users/mmmmm/Desktop/botgifs/token.txt")).get(0);
		JoeFileCount file = new JoeFileCount();
		//Caches members, messages, and builds the bot for use
		JDA jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES)
				.disableCache(CacheFlag.EMOTE)
				.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES)
				.enableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.ONLINE_STATUS, CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE)
				.setMemberCachePolicy(MemberCachePolicy.ALL)
				.addEventListeners(new Commands(), new UpdateNameEventClass(), new BanLeague())
				.setActivity(Activity.playing("slopping innocent people (i hate them)"))
				.setStatus(OnlineStatus.ONLINE)
				.build();
		//jda.addEventListeners(new Commands());
		System.out.println(file.readFile(file.joe));
		File f = new File("C:/Users/mmmmm/Desktop/botgifs/uptime.txt");
		int seconds = 0;
		try {
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				if(java.time.LocalDate.now() == java.time.LocalDate.now()) {
					pw.println("Current Uptime For: "  + java.time.LocalTime.now());
					pw.close();
				} else {
					pw.println("Current Uptime Start At: "  + java.time.LocalDate.now());
					pw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			System.out.println("");
		}
		while(true) {
			long mil = System.currentTimeMillis();
			seconds++;
			//System.out.println(seconds);
			SlopTimer timer = new SlopTimer();
			timer.start();
			try {
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					pw.println("Current Uptime: "  + seconds);
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch(Exception e) {
				System.out.println("");
			}
			Thread.sleep(1000 - mil % 1000);
		}
	}

} 



