package slopMaster;

import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UpdateNameEventClass extends ListenerAdapter {
	
	public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {
		/*
		try {
			if(event.getEntity().getId().equals("629024069332893711") && !event.getEntity().getEffectiveName().equals("dickhead")) {
				event.getEntity().modifyNickname("dickhead").queue();
			}
			if(event.getEntity().getId().equals("600705350223659024") && !event.getEntity().getEffectiveName().equals("kid lover"))  {
				event.getEntity().modifyNickname("kid lover").queue();
			}
		}catch(NullPointerException e) {
			System.out.println(e);
		}
		*/
	
	}
}
