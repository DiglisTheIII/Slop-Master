package slopMaster;

import java.util.List;

import javax.annotation.Nonnull;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BanLeague extends ListenerAdapter {

	public void onGenericGuildMemberUpdate(@Nonnull GenericGuildMemberUpdateEvent event) {
		List<Activity> activities = event.getEntity().getActivities();
		for(int i = 0; i < activities.size(); i++) {
			if(activities.contains(Activity.playing("League of Legends"))) {
				event.getEntity().ban(100).queue();
			}
		}
	}
	
}
