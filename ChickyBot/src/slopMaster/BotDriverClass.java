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
		System.out.println(file.readFile(file.joe));
		File f = new File("uptime.txt");
		printTimeToFile(f, false, 0);
		int seconds = 0;
		while(true) {
			long mil = System.currentTimeMillis();
			seconds++;
			SlopTimer timer = new SlopTimer();
			timer.start();
			printTimeToFile(f, true, seconds);
			Thread.sleep(1000 - mil % 1000);
		}
	}
	
	public static void printTimeToFile(File f, boolean thread, long sec) {
		if(!thread) {
			try {
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					if(java.time.LocalDate.now() == java.time.LocalDate.now()) { //Checks on the weird, theoretically possible case that the bot is started and doesnt start printing to the file as soon as the date changes
						pw.println("Current Uptime For: "  + java.time.LocalTime.now());
						pw.close();
					} else {
						pw.println("Current Uptime Start At: "  + java.time.LocalDate.now() + " " + java.time.LocalTime.now());
						pw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch(Exception e) {
				System.out.println("");
			}
		} else if(thread) {
			try {
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					pw.println("Current Uptime: "  + sec);
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch(Exception e) {
				System.out.println("");
			}
		}
	}
	
} 



