package prjPOOG;

import java.sql.Date;

public class Match {
	private Date dateMatch;
	private Team homeTeam, guestTeam;
	private int homeScore, guestScore;
	
	public Match (){
		dateMatch = new Date (00-00-0000);
		homeTeam = guestTeam = null;
		homeScore = guestScore = 0;
	}
	
	// controllare che homeTeam e guestTeam abbiano lo stesso sport
	public Match (Date dateMatch, Team homeTeam, Team guestTeam, int homeScore, int guestScore){
		setDateMatch(dateMatch);
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
		setHomeScore (homeScore);
		setGuestScore(guestScore);
	}
	
	public void setDateMatch(Date dateMatch){
		if (dateMatch != null)
			this.dateMatch = dateMatch;
	}
	public Date getDateMatch(){
		return dateMatch;
	}
	public Team getHomeTeam(){
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam){
		if (homeTeam!=null)
			this.homeTeam = homeTeam;
	}
	public Team getGuestTeam(){
		return guestTeam;
	}
	public void setGuestTeam(Team guestTeam){
		if (guestTeam!=null)
			this.guestTeam = guestTeam;
	}
	public int getHomeScore(){
		return homeScore;
	}
	public void setHomeScore(int homeScore){
		if (homeScore>=0)
			this.homeScore = homeScore;	
	}
	public int getGuestScore(){
		return guestScore;
	}
	public void setGuestScore(int guestScore){
		if (guestScore>=0)
			this.guestScore = guestScore;	
	}
	
}
