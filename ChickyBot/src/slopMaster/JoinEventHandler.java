package slopMaster;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinEventHandler extends ListenerAdapter {
	
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		EmbedBuilder joinedUser = new EmbedBuilder();
		joinedUser.setTitle("✉️ new clope");
		JDA cl = event.getJDA();
		Guild g = event.getGuild();
		boolean isFemServer = g.getName().equals("Femboy Sorority");
		boolean isZeenServer = g.getName().equals("zeenith's zoo");
		if(isFemServer) {
			TextChannel channel = g.getTextChannelById("931616914227208203");
			joinedUser.setDescription(event.getMember().getAsMention());
			channel.sendMessage(joinedUser.build()).queue();
			
		} else if(isZeenServer) {
			TextChannel channel = g.getTextChannelById("939768536295952507");
			joinedUser.setDescription(event.getMember().getAsMention());
			channel.sendMessage(joinedUser.build()).queue();
		}
		
	}
}
