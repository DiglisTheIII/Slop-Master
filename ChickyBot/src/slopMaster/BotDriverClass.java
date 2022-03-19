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
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class BotDriverClass {
	
	public static void main(String[] args) throws LoginException, IOException {
		String token = Files.readAllLines(Paths.get("C:/Users/mmmmm/Desktop/botgifs/token.txt")).get(0);
		JoeFileCount file = new JoeFileCount();
		//Caches members, messages, and builds the bot for use
		JDA jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES)
				.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE)
				.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS)
				.enableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.ONLINE_STATUS)
				.setMemberCachePolicy(MemberCachePolicy.ALL)
				.addEventListeners(new Commands(), new UpdateNameEventClass(), new BanLeague())
				.setActivity(Activity.playing("slopping innocent people (i hate them)"))
				.setStatus(OnlineStatus.ONLINE)
				.build();
		//jda.addEventListeners(new Commands());
		System.out.println(file.readFile(file.joe));
		
		
	}

} 

