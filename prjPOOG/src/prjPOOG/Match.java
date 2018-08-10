package prjPOOG;

import java.sql.Date;

public class Match {
	boolean played;
	//private Date dateMatch;
	private Team homeTeam, guestTeam;
	private int homeScore, guestScore;
	
	public Match (){
		//dateMatch = new Date (00-00-0000);
		homeTeam = guestTeam = null;
		homeScore = guestScore = 0;
		played = false;
	}
	
	// controllare che homeTeam e guestTeam abbiano lo stesso sport
	public Match (Date dateMatch, Team homeTeam, Team guestTeam, int homeScore, int guestScore){
		//setDateMatch(dateMatch);
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
		setHomeScore (homeScore);
		setGuestScore(guestScore);
		played = true;
	}
	/*
	public void setDateMatch(Date dateMatch){
		if (dateMatch != null)
			this.dateMatch = dateMatch;
	}
	public Date getDateMatch(){
		return dateMatch;
	}*/
	public Team getHomeTeam(){
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam){
		if (homeTeam!=null){
			this.homeTeam = homeTeam;
		}
	}
	public Team getGuestTeam(){
		return guestTeam;
	}
	public void setGuestTeam(Team guestTeam){
		if (guestTeam!=null){
			this.guestTeam = guestTeam;
		}
	}
	public int getHomeScore(){
		return homeScore;
	}
	public void setHomeScore(int homeScore){
		if (homeScore>=0) {
			this.homeScore = homeScore;	
		}
	}
	public int getGuestScore(){
		return guestScore;
	}
	public void setGuestScore(int guestScore){
		if (guestScore>=0) {
			this.guestScore = guestScore;
		}
	}
	
	public boolean isPlayed() {
		return played;
	}
	
	public void setPlayed(boolean p) {
		played = p;
	}
	/*
	public Team getWhoWon (){// occhio, la partita deve essere stata giocata!
			if (homeScore > guestScore) {
				System.out.println("ha vinto " + getHomeTeam().getName());
				return homeTeam;
			}
			else {
				System.out.println("oppure ha vinto " + getHomeTeam().getName());
				return guestTeam;
			}

	} */
	@Override
	public String toString() {
		return homeTeam.getName() + " " + homeScore + " - " + guestScore + " " + guestTeam.getName();
	}
	
}
