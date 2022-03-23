package slopMaster;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message.MentionType;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.Presence;



public class Commands extends ListenerAdapter {
	public String message = "";
	public String prefix = "s$";
	public int joeCount = 0;
	public int maximumJoe = 100;
	public File f = new File("log.txt");
	public int randCounter = ThreadLocalRandom.current().nextInt(50, 250);
	public int sloppy = 0;
	public int yed = 0;
	public String[] pathArray = {"C:/Users/mmmmm/Desktop/chicken/1.png", 
			"C:/Users/mmmmm/Desktop/chicken/2.png",
			"C:/Users/mmmmm/Desktop/chicken/3.png",
			"C:/Users/mmmmm/Desktop/chicken/4.png",
			"C:/Users/mmmmm/Desktop/chicken/5.png",
			"C:/Users/mmmmm/Desktop/chicken/6.png",
			"C:/Users/mmmmm/Desktop/chicken/7.png",
			"C:/Users/mmmmm/Desktop/chicken/8.png",
			"C:/Users/mmmmm/Desktop/chicken/9.png",
			"C:/Users/mmmmm/Desktop/chicken/10.png",
			"C:/Users/mmmmm/Desktop/chicken/11.png",
			"C:/Users/mmmmm/Desktop/chicken/12.png",
			"C:/Users/mmmmm/Desktop/chicken/13.png",
			"C:/Users/mmmmm/Desktop/chicken/14.png",
			"C:/Users/mmmmm/Desktop/chicken/15.png"};
	
	public String[] gifPathArray = {"C:/Users/mmmmm/Desktop/chicken/acorn.gif",
			"C:/Users/mmmmm/Desktop/chicken/dance.gif"};
	
	
	public JoeFileCount joeFile = new JoeFileCount();
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		//List<Role> allRoles = event.getGuild().getRoles();
		//allRoles = allRoles.subList(0, allRoles.size() - 1);
		String[] args = event.getMessage().getContentRaw().split(" ");
		String userStr = event.getAuthor().toString().substring(2).replaceAll("[0-9()]", "");
		final boolean isServer = event.getGuild().getName().equals("Femboy Sorority");
		if(args[0].equalsIgnoreCase(prefix + "helpme")) {
			event.getMessage().getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage("Command List:\n"
					+ "s$hi - Slop Master replies with Greetings \n"
					+ "s$die - Slop Master replies with Love you too {@userID}\n"
					+ "s$lean - Slop Master will send a video with an Asuka/Venom Lean Meme.\n"
					+ "computer show me hell - Will send a gif of a skeleton burning in hell, be sure to thank computer afterwards!\n"
					+ "s$activity - Listens to the senders screams as an activity.\n"
					+ "s$cock - Sends a gif with a chicken.\n"
					+ "s$chickengif - Sends a guy who is very excited to eat some chicken!\n"
					+ "s$multichicken - Sends between 1-5 random pictures of fried chicken.\n"
					+ "s$soy {@userID} - Pings the user with a soy bounce gif.\n"
					+ "s$goodnight - A personal favorite :)\n"
					+ "s$warn {@userID} - Sends a dm to the pinged user, warning them.\n"
					+ "s$tuesday - Sends Out of Touch - Hall & Oates music video link\n"
					+ "computer kill joe biden - Probably the most complex command, this one sends an image to your server, counts up by one, and checks if the number has reached a maximum.\n"
					+ "Along with a bunch of stupid file shit.\n"
					+ "s$reset - This increases the maximum by a random amount between 50-249.\n"
					+ "s$play - Sets Slop Master's activity to playing a custom game of the senders choosing.\n"
					+ "s$listen - Sets Slop Master's activity to listening to a custom song."
					+ "s$lonely - Sets Slop Master's status to Do Not Disturb")).queue();
		}
		
		if(args[0].equalsIgnoreCase(prefix + "silence")) {
			List<Member> mentionedMember = event.getMessage().getMentionedMembers();
			if(event.getMember().isOwner() || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getGuild().addRoleToMember(mentionedMember.get(0), event.getGuild().getRoleById("932112631546916884")).queue();
				event.getChannel().sendMessage(mentionedMember.get(0).getAsMention() + " has been silenced").queue();
			} else if(event.getMember().isOwner() || !event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getMessage().reply("you cant do that").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "hi")) {
			event.getMessage().reply("Greetings, " + event.getAuthor().getAsMention()).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "die")) {
			event.getMessage().reply("Love you too " + event.getAuthor().getAsMention() + "!").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "grease")) {
			User user = event.getAuthor();
			for(int i = 0; i < 5; i++) {	
				if(user.getId().equals("285179041777188875")) {
					event.getMessage().reply("Don't play yourself").queue();
					i = 5;
					break;
				}
				event.getMessage().delete().queue();
				event.getChannel().sendMessage("<@285179041777188875> fuck you").queue();	
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "suckmyballs")) {
			String[] userIDs = {"508100678758170644", "530269428185825290", "695688150466428989", "600705350223659024", "381437831878279168", "629024069332893711", "399304447575982082"};
			int randID = ThreadLocalRandom.current().nextInt(0, 7);
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Suck my balls <@" + userIDs[randID] + ">").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "lean")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/carnage.mp4")).queue();
		}
		
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("show") && args[2].equalsIgnoreCase("me") && args[3].equalsIgnoreCase("hell")) {
			File f = new File("C:/Users/mmmmm/Desktop/botgifs/skeleton-burning.gif");
			EmbedBuilder embed = new EmbedBuilder();
			
			embed.setTitle(" ");
			embed.setImage("attachment://hell.gif");
			event.getChannel().sendMessage(embed.build()).addFile(f, "hell.gif").queue();
			
		}
		if(args[0].equalsIgnoreCase(prefix + "activity")) {
			event.getMessage().reply("done").queue();
			event.getJDA().getPresence().setActivity(Activity.listening(event.getAuthor().getAsTag() + " screaming"));
		}
		if(args[0].equalsIgnoreCase(prefix + "activityclear")) {
			event.getMessage().reply("cleared").queue();
			event.getJDA().getPresence().setActivity(Activity.playing("Los Pollos Hermanos"));
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("ChickenBot activity has been reset.");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "cock")) {
			File f = new File("C:/Users/mmmmm/Desktop/chicken/cock.gif");
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Look at this cock!");
			embed.setImage("attachment://cock.gif");
			event.getChannel().sendMessage(embed.build()).addFile(f, "cock.gif").queue();
			
		}
		if(args[0].equalsIgnoreCase(prefix + "chicken")) {
			int rand = ThreadLocalRandom.current().nextInt(0, 15);
			File file = new File(pathArray[rand - 1]);
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("A chicken?!");
			embed.setImage("attachment://chicken.png");
			event.getChannel().sendMessage(embed.build()).addFile(file, "chicken.png").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "chickengif")) {
			int rand = ThreadLocalRandom.current().nextInt(0, 2);
			event.getChannel().sendFile(new File(gifPathArray[rand])).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "multichicken")) {
			int rand = ThreadLocalRandom.current().nextInt(0, 6);

			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("You asked for it...");
			embed.setImage("attachment://chicken.png");
			for(int i = 0; i < rand; i++) {
				int randFile = ThreadLocalRandom.current().nextInt(0, 16);
				File file = new File(pathArray[randFile - 1]);
				event.getChannel().sendMessage(embed.build()).addFile(file, "chicken.png").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "specialModCommand")) {
			if(event.getAuthor().getId().equals("695688150466428989")) {
				for(int i = 0; i < 5; i++) {
					event.getMessage().delete().queue();
					event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/casket-coffin.gif")).queue();
				}
			} else {
				event.getMessage().delete().queue();
				event.getChannel().sendMessage("How did you get here?");
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "fuckyougeo")) {
			for(int i = 0; i < 25; i++) {
				event.getChannel().sendMessage("Fuck you die <@256920677385371649>").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "soy")) {
			IMentionable mentionedUser =  event.getMessage().getMentions(MentionType.USER).get(0);
			String replace = mentionedUser.toString();
			long id = Long.parseLong(replace.replaceAll("[^0-9]", ""));
			event.getChannel().sendMessage("<@" + String.valueOf(id) + ">").queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/bounce.gif")).queue();
			event.getMessage().delete().queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "goodnight")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/sleep.mp4")).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "unsilence")) {
			Member member = event.getMessage().getMentionedMembers().get(0);
			User author = event.getMessage().getAuthor();
			boolean isAdmin = true;
			if(!event.getGuild().getMember(author).hasPermission(net.dv8tion.jda.api.Permission.ADMINISTRATOR)) {
				event.getChannel().sendMessage("You are not an administrator idiot!");
				isAdmin = false;
			} 
			if(isAdmin) {
				event.getGuild().removeRoleFromMember(member, event.getGuild().getRoleById("932112631546916884")).queue();
				event.getChannel().sendMessage(member.getAsMention() + " Has been unmuted :(").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "kys")) {
			event.getMessage().delete().queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/kys.png")).queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "warn")) {
			for(int i = 0; i < args.length; i++) {
				message += args[i] += " ";
			}
			
			User user = event.getMessage().getMentionedUsers().get(0);
			user.openPrivateChannel().queue(channel -> channel.sendMessage(message).queue());
			event.getMessage().delete().queue();
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println(event.getMessage().getMentionedMembers().toString() + " has been warned.");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("jango")) {
				i = args.length;
				final String emoteId = "felixsupremacy:944033771836022844";
				event.getMessage().addReaction(emoteId).queue();
			}
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("benadryl")) {
				i = args.length;
				final String emoteId = "BENADRYL:943635931456495696";
				event.getMessage().addReaction(emoteId).queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("tuesday")) {
				i = args.length;
				event.getChannel().sendMessage("Tuesday? Am I so out of touch? https://www.youtube.com/watch?v=D00M2KZH1J0").queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[0].equalsIgnoreCase("league") && args[1].equalsIgnoreCase("of") && args[2].equalsIgnoreCase("legends")) {
				i = args.length;
				event.getMessage().reply(new File("C:/Users/mmmmm/Desktop/botgifs/outofthegenepool.png")).queue();
			}
		}
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("kill") && args[2].equalsIgnoreCase("joe") && args[3].equalsIgnoreCase("biden")) {
			String counter = String.valueOf(joeCount);
			joeCount++;
			try {
				joeFile.writeFile(joeCount);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				counter = joeFile.readFile(joeFile.joe);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(joeCount <= 10 && joeCount > 1) {
				event.getChannel().sendTyping().delay(Duration.ofSeconds(5)).queue();
				event.getChannel().sendMessage("I have killed Joe Biden, here is the video.").queue();
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/biden.gif")).queue();
				event.getChannel().sendMessage("Joe Biden has been killed " + counter + " times.").queue();
			} else if (joeCount == 1) {
				event.getChannel().sendTyping().delay(Duration.ofSeconds(5)).queue();
				event.getChannel().sendMessage("I have killed Joe Biden, here is the video.").queue();
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/biden.gif")).queue();
				event.getChannel().sendMessage("Joe Biden has been killed " + counter + " time.").queue();
			}
			
			else if(joeCheck(joeCount) == maximumJoe) {
				event.getChannel().sendMessage("Oops, Joe Biden is now perma dead!").queue();
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("Joe Biden death count raised to " + joeCount);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "joekillcount")) {
			String counter = String.valueOf(joeCount);
			try {
				counter = joeFile.readFile(joeFile.joe);
			} catch (IOException e) {
				e.printStackTrace();
			}
			event.getChannel().sendMessage(counter).queue();
		}
		
		if(args[0].equalsIgnoreCase(prefix + "reset")) {
			
			int totalJoe = joeCount;
			if(joeCount == maximumJoe) {
				if(event.getMember().isOwner() || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
					event.getChannel().sendMessage("They respawned!!!!").queue();
					joeCount = 0;
				}
			} else if(joeCount < maximumJoe) {
				totalJoe += randCounter;
				event.getChannel().sendMessage("\u26A0 Here they come...").queue();
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("Total Joe Biden count increased to " + totalJoe);
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if(args[0].equalsIgnoreCase(prefix + "play")) {
			String activity = "";
			for(int i = 1; i < args.length; i++) {
				activity += args[i] += " ";
				event.getJDA().getPresence().setActivity(Activity.playing(activity));
			}
			event.getChannel().sendMessage("I am now playing " + activity).queue();	
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("ChickenBot activity changed to: playing " + event.getJDA().getPresence().getActivity().toString());
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(args[0].equalsIgnoreCase(prefix + "listen")) {
			String activity = "";
			for(int i = 1; i < args.length; i++) {
				activity += args[i] += " ";
				event.getJDA().getPresence().setActivity(Activity.listening(activity));
			}
			event.getChannel().sendMessage("I am now listening to " + activity).queue();	
			
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("ChickenBot activity changed to: listening to " + event.getJDA().getPresence().getActivity().toString());
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase("!rule34")) {
			event.getMessage().reply("Horny").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "nuke")) {
			if(event.getMember().isOwner() || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getMessage().delete().queue();
				event.getChannel().sendMessage("This channel will be cleared in 10 seconds").queue();
				event.getChannel().createCopy().queue();
	            event.getChannel().delete().queueAfter(10, TimeUnit.SECONDS);
	    
			} else if(!event.getMember().isOwner() || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getChannel().sendMessage("You are not an admin, get fucked").queue();
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println(event.getChannel().getName() + " has been cleared");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "killyourself")) {
			if(event.getAuthor().getId().equals("695688150466428989")) {
				event.getChannel().sendMessage("Ok :( goodbye").queue();
				event.getJDA().shutdown();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					pw.println("ChickenBot shut down for maintenance");
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				event.getChannel().sendMessage("You cannot initiate shutdown sequence: t88shutdownevent.");
			}
			
			
		}
		if(args[0].equalsIgnoreCase(prefix + "die")) {
			if(event.getAuthor().getId().equals("695688150466428989")) {
				event.getChannel().sendMessage("i will be back cunt").queue();
				event.getJDA().shutdown();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(f, true));
					pw.println("ChickenBot shutdown for miscellaneous reasons");
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				event.getChannel().sendMessage("You cannot initiate shutdown sequence: t99shutdownevent.");
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "lonely")) {
			event.getJDA().getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
			event.getChannel().sendMessage("Do not speak to me...").queue();
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("wales")) {
				i = args.length;
				event.getChannel().sendMessage("Llanfairpwllgwyngyllgogerychrywndrobwllllantysiliogogogoch").queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("trump")) {
				i = args.length;
				event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/trump.png")).queue();
			}
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("jp")) {
				i = args.length;
				event.getMessage().addReaction("trand:946483227231649823").queue();
			}
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("destiny")) { 
				i = args.length;
				event.getChannel().sendFile(new File("C:/Users/mmmmm/desktop/botgifs/out.gif")).queue();			
			} else if(args[i].equalsIgnoreCase("hate") && args[i + 1].equalsIgnoreCase("destiny")) {
				i = args.length;
				event.getChannel().sendFile(new File("C:/Users/mmmmm/desktop/botgifs/basedchad.gif")).queue();
			}
		}
		
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("show") && args[2].equalsIgnoreCase("me") && args[3].equalsIgnoreCase("shit")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/desktop/botgifs/shitgame.png")).queue();
		}
		
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("walt")) {
				event.getChannel().sendFile(new File("C:/Users/mmmmm/desktop/botgifs/walt.png")).queue();
			}
		}
		
		if(event.getChannel().isNSFW() && args[0].equalsIgnoreCase("horny") && !event.getAuthor().isBot()) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/desktop/botgifs/nfw.gif")).queue();
		} else if((!event.getChannel().isNSFW()) && args[0].equalsIgnoreCase("horny")) {
			event.getChannel().sendMessage("You cannot be horny here").queue();
		}
		
		if(args[0].equalsIgnoreCase("slop") && args[1].equalsIgnoreCase("me")) {
			sloppy++;
			if(sloppy == 1) {
				event.getMessage().reply("You have been slopped " + sloppy + " time.").queue();
			} else if(sloppy > 1) {
				event.getMessage().reply("You have been slopped " + sloppy + " times.").queue();
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println(event.getAuthor().getAsTag() + " has been slopped");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase("unslop") && args[1].equalsIgnoreCase("me")) {
			if(sloppy == 0) {
				event.getChannel().sendMessage("there is no slop to unslop!").queue();
			} else {
				event.getChannel().sendMessage("no more slop!").queue();
				sloppy = 0;
			}
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f, true));
				pw.println("slop reset");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "incarcerate")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/prison.jpg")).queue();
		}
		if(args[0].equalsIgnoreCase("slop")) {
			IMentionable mentionedUser =  event.getMessage().getMentions(MentionType.USER).get(0);
			String replace = mentionedUser.toString();
			long id = Long.parseLong(replace.replaceAll("[^0-9]", ""));
			event.getChannel().sendMessage("<@" + String.valueOf(id) + "> has been slopped.").queue();
		}
	
		for(int i = 0; i < args.length; i++) {
			boolean isAdmin = false;
			if(event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				isAdmin = true;
			}
			
			if(args[i].equalsIgnoreCase("genshin") && !isAdmin) {
				event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("932112631546916884")).queue();
				event.getMessage().reply("Muted lol").queue();
			}
			else if(args[i].equalsIgnoreCase("genshin") && isAdmin) {
				event.getMessage().reply("i cant mute you :(").queue();
			}
		}
		
		//Puts every role in the server, minus @everyone in the list
		List<Role> allRoles = event.getGuild().getRoles();
		allRoles = allRoles.subList(0, allRoles.size() - 1);
		if(args[0].equalsIgnoreCase(prefix + "role")) {
			try {
				//Debug stuff
				String role = "";
				boolean nullRole = false;
				for(int i = 0; i < allRoles.size(); i++) {
					System.out.println(allRoles.get(i));
				}
				if(args.length > 1) {
					for(int i = 1; i < args.length; i++) {
						//This takes the message, drops the command prefix, and just gets the role they want
						role += args[i] + " ";
						//patman was here
					}
					//System.out.println(role);
				} else if(args.length == 2) {
					//If it is just a one word role, this sents the role variable to that argument
					role = args[1];
				}
				for(int i = 8; i < allRoles.size(); i++) {
					//checks if role is equal to the raw string name of a sublist of allRoles
					if(role.contains(allRoles.get(i).toString().substring(2).replaceAll("[0-9()]", ""))  && (!args[1].equalsIgnoreCase("Sinful") && !args[2].equalsIgnoreCase("Fool"))) {
						//Gets rid of everything in the Role but the ID, which is a long value as string
						String rolee = allRoles.get(i).toString().replaceAll("[a-zA-Z():]", "").substring(1).trim();
						//System.out.println(rolee);
						event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById(rolee)).queue();
						event.getChannel().sendMessage("roled").queue();
						nullRole = true;
						try {
							PrintWriter pw = new PrintWriter(new FileWriter(f, true));
							pw.println(userStr + " was given role " + role);
							pw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} 
				}
				if(!nullRole  && (args[1].equalsIgnoreCase("Sinful") && args[2].equalsIgnoreCase("Fool"))) {
					event.getChannel().sendMessage("this shit aint fr!").queue();
				}
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "unrole")) {
			try {
				String role = "";
				boolean nullRole = false;
				for(int i = 0; i < allRoles.size(); i++) {
					System.out.println(allRoles.get(i));
				}
				if(args.length > 1) {
					for(int i = 1; i < args.length; i++) {
						role += args[i] + " ";
					}
				} else if(args.length == 2) {
					role = args[1];
				}
				for(int i = 8; i < allRoles.size(); i++) {
					if(role.contains(allRoles.get(i).toString().substring(2).replaceAll("[0-9()]", "")) && (!args[1].equalsIgnoreCase("Sinful") && !args[2].equalsIgnoreCase("Fool"))) {
						String rolee = allRoles.get(i).toString().replaceAll("[a-zA-Z():]", "").substring(1).trim();
						//System.out.println(rolee);
						event.getGuild().removeRoleFromMember(event.getMember(), event.getGuild().getRoleById(rolee)).queue();
						event.getChannel().sendMessage("role taken away. bye bye").queue();
						nullRole = true;
						try {
							PrintWriter pw = new PrintWriter(new FileWriter(f, true));
							pw.println(userStr + " was removed from role:  " + role);
							pw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} 
				}
				if(!nullRole && (args[1].equalsIgnoreCase("Sinful") && args[2].equalsIgnoreCase("Fool"))) {
					event.getChannel().sendMessage("this shit aint fr!").queue();
				}
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "rolelist")) {
			String[] rolesArr = new String[allRoles.size()];
			String everyRole = "";
			for(int i = 0; i < allRoles.size(); i++) {
				rolesArr[i] = allRoles.get(i).toString().substring(2).replaceAll("[0-9()]", "");
				everyRole += rolesArr[i] += "\n";
			}
			final String privateRollList = everyRole;
			event.getMessage().reply("snent").queue();
			event.getMessage().getAuthor().openPrivateChannel().flatMap(channel -> channel.sendMessage(privateRollList)).queue();
		}
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("show") && args[2].equalsIgnoreCase("me") && args[3].equalsIgnoreCase("heaven")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/heaven.png")).queue();
		}
		int count = event.getGuild().getMemberCount();
		if(args[0].equalsIgnoreCase(prefix + "usercount")) {
			event.getChannel().sendMessage("There are " + count + " people in the server").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "banme")) {
			int troll = count - 1;
			event.getMessage().delete().queue();
			event.getMessage().reply(event.getAuthor().getAsMention() + " has been banned *(" + troll + ")*").queue();
		}
		if(args[0].equalsIgnoreCase(prefix + "gotohell")) {
			List<Member> mentions = event.getMessage().getMentionedMembers();
			if(event.getMember().isOwner() || event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getGuild().ban(mentions.get(0), Integer.parseInt(args[2])).queue();
				event.getChannel().sendMessage(mentions.get(0).getAsMention() + " has been banned").queue();
			} else if(!event.getMember().isOwner() || !event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
				event.getMessage().reply("You cannot do that").queue();
			}
		}
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("am") && args[2].equalsIgnoreCase("i") && args[3].equalsIgnoreCase("cool")) {
			if(event.getMember().isOwner() || event.getMember().hasPermission(Permission.ADMINISTRATOR) && !event.getAuthor().getId().equals("530269428185825290")) {
				event.getMessage().reply("Yes").queue();
			} else if(!event.getMember().isOwner() || !event.getMember().hasPermission(Permission.ADMINISTRATOR) || event.getAuthor().getId().equals("530269428185825290")) {
				final String emoteID = "quaint:949743841337024532";
				event.getMessage().reply("No").queue();
				event.getMessage().addReaction(emoteID).queue();
			}
		}
		if(args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("do") && args[2].equalsIgnoreCase("i") && args[3].equalsIgnoreCase("suck") && args[4].equalsIgnoreCase("dick")) {
			if(event.getAuthor().getId().equals("530269428185825290")) {
				event.getChannel().sendMessage("YES!").queue();
			} else {
				event.getChannel().sendMessage("NO!").queue();
			}
		}
		for(int i = 0; i < args.length; i++) {
			if(args[i].equalsIgnoreCase("sand") && !event.getAuthor().isBot()) {
				event.getChannel().sendMessage("i eated all the sand").queue();
			}
		}
		List<Member> membercount = event.getGuild().getMembers();
		String[] memberList = new String[membercount.size()];
		for(int i = 0; i < membercount.size(); i++) {
			int par = membercount.get(i).toString().indexOf("(");
			memberList[i] = membercount.get(i).toString().substring(3, par);
		}
		if(args[0].equalsIgnoreCase(prefix + "memberlist") && (event.getMember().hasPermission(Permission.ADMINISTRATOR) || event.getMember().isOwner())) {
			String memberListForChannel = "";
			for(int i = 0; i < memberList.length; i++) {
				memberListForChannel += memberList[i] += "\n";
			}
			event.getChannel().sendMessage(memberListForChannel).queue();
		}
		
		if(args[0].equalsIgnoreCase("fuckyou")) {
			event.getGuild().moveVoiceMember(event.getGuild().getMemberById("256920677385371649"), event.getGuild().getVoiceChannelById("932093403322273793")).queue();
		}
		
		if(args[0].equalsIgnoreCase("trolenames") && event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
			Member self = event.getMember();
			Random randNum = new Random();
		    Set<Integer>set = new LinkedHashSet<Integer>();
		    while (set.size() < event.getGuild().getMemberCount()) {
		       set.add(randNum.nextInt(event.getGuild().getMemberCount()) + 1);
		    }
		    ArrayList<Integer> arr = new ArrayList<Integer>();
		    for(Iterator<Integer> it = set.iterator(); it.hasNext();) {
		    	arr.add(it.next());
		    }
		    int i = 0;
			for(Member member : event.getGuild().getMembers()) {
				if(self.canInteract(member) && i < arr.size()) {
					event.getGuild().modifyNickname(member, "conrad").queue();
					i++;
				}
			}
		}
		if(args[0].equalsIgnoreCase("geo") && event.getGuild().getName().equals("Femboy Sorority")) {
			event.getMessage().delete();
			event.getChannel().sendMessage("<@256920677385371649> doo doo shitter is a bad game!").queue();
		}
		if(args[0].equalsIgnoreCase("Say") && args[1].equalsIgnoreCase("the") && args[2].equalsIgnoreCase("line,") && args[3].equalsIgnoreCase("bulbjak!")) {
			if(event.getGuild().getName().equals("Femboy Sorority")) {
				event.getMessage().reply("Learn to LIGHTEN up! <:bulbjak:954624531375460393>").queue();
			}
		}
		
		if(args[0].equalsIgnoreCase("among") && args[1].equalsIgnoreCase("us")) {
			event.getChannel().sendMessage("sus").queue();
		}
		
		if(isServer && args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("activate") && args[2].equalsIgnoreCase("iguana")) {
			event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/325351648849428480/901152594729259008/Iguana.mp4").queue();
		}
		if(isServer && args[0].equalsIgnoreCase("computer") && args[1].equalsIgnoreCase("deactivate") && args[2].equalsIgnoreCase("iguana")) {
			event.getChannel().sendMessage("https://cdn.discordapp.com/attachments/325351648849428480/901152499686330428/Iguana.mp4").queue();
		}

		if(args[0].equalsIgnoreCase("fnaf")) {
			event.getChannel().sendMessage("Connection terminated. I'm sorry to interupt you Elizabeth, if you still even remember that name, but I'm afraid you've been misinformed. You're not here to recieve a gift, nor have you been called here by the individual you assume, although you have indeed been called. You have all been called here, into a labyrinth of sounds and smells, misdirection and misfortune. A labirynth with no exit, a maze with no prize. You don't even realize that you are trapped. Your lust for blood has driven you in endless circles, chasing the cries of children in some unseen chamber always seeming so near, yet somehow out of reach. But you will never find them, none of you will. This is where your story ends.\r\n"
					+ "\r\n"
					+ "And to you, my brave volunteer, who somehow found this job listing not intended for you, although there was a way out planned for you, I have a feeling that's not what you want. I have a feeling that you are right where you want to be. I am remaining as well. I am nearby. This place will not be remembered and the memory of everything that started this can finally begin to fade away, as the agony of every tragedy should. And to you monsters trapped in the corridors, be still, and give up your spirits. They don't belong to you. For most of you, I believe there is peace and perhaps more waiting for you after the smoke clears. Although for one of you, the darkest pit of hell has opened to swallow you whole, so don't keep the devil waiting old friend.\r\n"
					+ "\r\n").queue();
			event.getChannel().sendMessage("My daughter, if you can hear me, I knew you would return as well. It's in your nature to protect the innocent. I'm sorry that on that day, the day you were shut out and left to die, no one was there to lift you up into their arms, the way you lifted others into yours. And then, what became of you? I should have known you wouldn't be contempt to just disappear, not my daughter. I couldn't save you then, so let me save you now.\r\n"
					+ "\r\n"
					+ "It's time to rest. For you, and those you have carried in your arms. This ends, for all of us. End communication.").queue();
		}
		if(isServer) {
			if(args[0].equalsIgnoreCase("jangosong")) {
				event.getChannel().sendMessage("When I wake up, well I know I'm gonna be,\r\n"
						+ "I'm gonna be the man who wakes up next to you\r\n"
						+ "When I go out, yeah I know I'm gonna be\r\n"
						+ "I'm gonna be the man who goes along with you\r\n"
						+ "When I get drunk, well I know I'm gonna be\r\n"
						+ "I'm gonna be the man who gets drunk next to you\r\n"
						+ "And when I haver, hey I know I'm gonna be\r\n"
						+ "I'm gonna be the man who's havering to you\r\n"
						+ "And I would roll 500 miles\r\n"
						+ "And I would roll 500 more\r\n"
						+ "Just to be the man who rolls a thousand miles\r\n"
						+ "To fall down at your door\r\n"
						+ "When I'm working, yes I know I'm gonna be\r\n"
						+ "I'm gonna be the man who's working hard for you\r\n"
						+ "And when the money, comes in for the work I do\r\n"
						+ "I'll pass almost every penny on to you\r\n"
						+ "When I come home(When I come home), well I know I'm gonna be\r\n"
						+ "I'm gonna be the man who comes back home to you\r\n"
						+ "And when I grow old, well I know I'm gonna be\r\n"
						+ "I'm gonna be the man who's growing old with you\r\n"
						+ "But I would roll 500 miles\r\n"
						+ "And I would roll 500 more\r\n"
						+ "Just to be the man who roles a thousand miles\r\n"
						+ "To fall down at your door\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da Da Da Dun Diddle Un Diddle Un Diddle Uh Da Da\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da Da Da Dun Diddle Un Diddle Un Diddle Uh Da Da\r\n"
						+ "When I'm lonely, well I know I'm gonna be\r\n"
						+ "I'm gonna be the man who's lonely without you\r\n"
						+ "And when I'm dreaming, well I know I'm gonna dream\r\n"
						+ "I'm gonna Dream about the time when I'm with you\r\n"
						+ "When I go out(When I go out), well I know I'm gonna be\r\n"
						+ "I'm gonna be the man who goes along with you\r\n"
						+ "And when I come home(When I come home), yes I know I'm gonna be\r\n"
						+ "I'm gonna be the man who comes back home with you\r\n"
						+ "I'm gonna be the man who's coming home with you\r\n"
						+ "And I would roll 500 miles\r\n").queue();
				event.getChannel().sendMessage("And I would roll 500 more\r\n"
						+ "Just to be the man who rolled a thousand miles\r\n"
						+ "To fall down at your door\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da Da Da Dun Diddle Un Diddle Un Diddle Uh Da Da\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da Da Da Dun Diddle Un Diddle Un Diddle Uh Da Da\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da Da Da Dun Diddle Un Diddle Un Diddle Uh Da Da\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da da da (da da da)\r\n"
						+ "Da Da Da Dun Diddle Un Diddle Un Diddle Uh Da Da\r\n"
						+ "And I would walk 500 miles\r\n"
						+ "And I would roll 500 more\r\n"
						+ "Just to be the man who rolled a thousand miles\r\n"
						+ "To fall down at your door\r\n"
						+ "Eh\r\n"
						+ "Don't like it\r\n"
						+ "I love the Welsh").queue();
			}
		}
		if(args[0].equalsIgnoreCase(prefix + "oosted?")) {
			if(event.getGuild().getBoostCount() == 0) {
				event.getChannel().sendMessage("not oosted <:cubic:941574305748242493>").queue();
			} else if(event.getGuild().getBoostCount() > 0) {
				event.getChannel().sendMessage("oosted (" + event.getGuild().getBoostCount() + ") times! <:aaaaaaaaaaahhhh:932080598066024448>").queue();
			}
		}

		int len = args.length;
		if(len == 1 && args[0].equalsIgnoreCase(prefix + "coinflip")) {
			event.getChannel().sendMessage("tails").queue();
			len = -1;
		} else if(args.length > 1) {
			int ascii = 0;
			if(args[0].equalsIgnoreCase(prefix + "coinflip")) {
				try {
					String arg = args[1];
					if ((Integer) Integer.parseInt(args[1]) instanceof Integer) {
						try {
							if(Integer.parseInt(args[1]) < Integer.MAX_VALUE) {
								event.getChannel().sendMessage("Heads: 0 \nTails: " + Integer.parseInt(args[1])).queue();
							}
						}catch(Exception e) {
							event.getChannel().sendMessage("Heads: 0 \nTails: " + args[1]).queue();
						}
						
					} 
				}catch(NumberFormatException e) {
					String arg = args[1];
					int iterator = arg.length();
					if(args[1] instanceof String) {
						for(int i = 0; i < iterator - 1; i++) {
							ascii += (int) arg.charAt(i);
						}
						event.getChannel().sendMessage("Heads: 0 \nTails: " + ascii).queue();
					} 
				}
			}
			if(args[0].equalsIgnoreCase(prefix + "realcoinflip")) {
				String memberGuess = args[1];
				int flip = ThreadLocalRandom.current().nextInt(0, 2);
				String head = "";
				String tail = "";
				boolean win = false;
				if(flip == 0) {
					head = "heads";
				} else if(flip == 1) {
					tail = "tails";
				}
				if(memberGuess.equals(head) || memberGuess.equals(tail)) {
					win = true;
				} else if(!memberGuess.equals(head) || !memberGuess.equals(tail)) {
					win = false;
				}
				if(win) {
					event.getChannel().sendMessage("Result is: " + head + "" + tail + " you win").queue();
				} else {
					event.getChannel().sendMessage("Result is: " + head + "" + tail + " you lose").queue();
				}
			}
		} 
		if(args[0].equalsIgnoreCase("disgusting")) {
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/anthony.png")).queue();
		}
	}
	
	public int joeCheck(int joeCount) {
		if(joeCount >= 10) {
			try {
				joeFile.writeFile(joeCount + randCounter);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return joeCount;
	}
	public void killJoeBiden(GuildMessageReceivedEvent event) {
		String counter = String.valueOf(joeCount);
		joeCount++;
		try {
			joeFile.writeFile(joeCount);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			counter = joeFile.readFile(joeFile.joe);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(joeCount <= 10 && joeCount > 1) {
			event.getChannel().sendTyping().delay(Duration.ofSeconds(5)).queue();
			event.getChannel().sendMessage("I have killed Joe Biden, here is the video.").queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/biden.gif")).queue();
			event.getChannel().sendMessage("Joe Biden has been killed " + counter + " times.").queue();
		} else if (joeCount == 1) {
			event.getChannel().sendTyping().delay(Duration.ofSeconds(5)).queue();
			event.getChannel().sendMessage("I have killed Joe Biden, here is the video.").queue();
			event.getChannel().sendFile(new File("C:/Users/mmmmm/Desktop/botgifs/biden.gif")).queue();
			event.getChannel().sendMessage("Joe Biden has been killed " + counter + " time.").queue();
		}
		
		else if(joeCheck(joeCount) == maximumJoe) {
			event.getChannel().sendMessage("Oops, Joe Biden is now perma dead!").queue();
		}
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f, true));
			pw.println("Joe Biden death count raised to " + joeCount);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

