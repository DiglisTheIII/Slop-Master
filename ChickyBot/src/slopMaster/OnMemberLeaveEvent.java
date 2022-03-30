package slopMaster;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class OnMemberLeaveEvent extends ListenerAdapter {
	
	
	@Override
	public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
		String leave = event.getMember().getAsMention();
		EmbedBuilder bld = new EmbedBuilder();
		bld.setTitle("Idiot!");
		bld.setDescription(leave);
		bld.setImage("https://cdn.discordapp.com/attachments/948538571999035392/958459101111787550/Screenshot_374.png");
		Guild g = event.getGuild();
		boolean isMyServer = g.getName().equals("Femboy Sorority");
		boolean isZeenServer = g.getName().equals("zeenith's zoo");
		if(isMyServer) {
			TextChannel tc = g.getTextChannelById("931616914227208203");
			tc.sendMessage(bld.build()).queue();
			
		} else if(isZeenServer) {
			TextChannel tc = g.getTextChannelById("939768536295952507");
			tc.sendMessage(bld.build()).queue();
		}
		
	}
	
}
