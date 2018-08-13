package prjPOOG;

import java.sql.Date;

public class RugbyMatch extends Match {
	private int homeTry,guestTry,homeConversions,guestConversions,homeDrop,guestDrop;
	
	public RugbyMatch(){
		super();
		homeTry = guestTry = homeConversions = guestConversions = homeDrop = guestDrop = 0;
	}
	public RugbyMatch(int homeTry,int guestTry,int homeConversions,int guestConversions,int homeDrop,int guestDrop){
		setHomeTry(homeTry);
		setGuestTry(guestTry);
		setHomeConversions(homeConversions);
		setGuestConversions(guestConversions);
		setHomeDrop(homeDrop);
		setGuestDrop(guestDrop);
	}
	public RugbyMatch( Team homeTeam, Team guestTeam, int homeScore, int guestScore,int homeTry,int guestTry,int homeConversions,int guestConversions,int homeDrop,int guestDrop){
		super ( homeTeam, guestTeam, homeScore, guestScore);
		setHomeTry(homeTry);
		setGuestTry(guestTry);
		setHomeConversions(homeConversions);
		setGuestConversions(guestConversions);
		setHomeDrop(homeDrop);
		setGuestDrop(guestDrop);
	}
	public int getHomeTry() {
		return homeTry;
	}
	public void setHomeTry(int homeTry) {
		if (homeTry >= 0)
			this.homeTry = homeTry;
	}
	public int getGuestTry() {
		return guestTry;
	}
	public void setGuestTry(int guestTry) {
		if (guestTry >= 0)
			this.guestTry = guestTry;
	}
	public int getHomeConversions() {
		return homeConversions;
	}
	public void setHomeConversions(int homeConversions) {
		if (homeConversions >= 0)
			this.homeConversions = homeConversions;
	}
	public int getGuestConversions() {
		return guestConversions;
	}
	public void setGuestConversions(int guestConversions) {
		if (guestConversions >= 0)
			this.guestConversions = guestConversions;
	}
	public int getHomeDrop() {
		return homeDrop;
	}
	public void setHomeDrop(int homeDrop) {
		if (homeDrop >= 0)
			this.homeDrop = homeDrop;
	}
	public int getGuestDrop() {
		return guestDrop;
	}
	public void setGuestDrop(int guestDrop) {
		if (guestDrop >= 0)
			this.guestDrop = guestDrop;
	}
	
}
