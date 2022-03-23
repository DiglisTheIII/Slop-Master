package slopMaster;

import net.dv8tion.jda.api.events.guild.member.GenericGuildMemberEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.Permission;

public class BanLeague extends ListenerAdapter{
	
	public void onGenericGuildMemberUpdate(GenericGuildMemberEvent event) {
		String presence = "RichPresence(League of Legends / " + event.getMember().getId() + ")";
		for(int i = 0; i < event.getMember().getActivities().size() - 1; i++) {
			if(event.getMember().getActivities().get(i).asRichPresence().toString().equals(presence) && !event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getGuild().ban(event.getMember(), 1).queue();
			}
			else if(!event.getMember().getActivities().get(i).asRichPresence().toString().equals(presence) || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				System.out.println("TEST");
			}
		}
	}
}
	
