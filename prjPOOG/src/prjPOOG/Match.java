package prjPOOG;

public class Match {
	/*valuta se salvare la giornata*/
	boolean played;
	private Team homeTeam, guestTeam;
	private int homeScore, guestScore;
	
	public Match (){
		homeTeam = guestTeam = null;
		homeScore = guestScore = 0;
		played = false;
	}
	
	// controllare che homeTeam e guestTeam abbiano lo stesso sport
	public Match (Team homeTeam, Team guestTeam, int homeScore, int guestScore){
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
		setHomeScore (homeScore);
		setGuestScore(guestScore);
		played = true;
	}

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
	
	public boolean isPlayed() {
		return played;
	}
	
	public void setPlayed(boolean p) {
		played = p;
	}
	
	public String toString() {
		return homeTeam.getName() + " " + homeScore + " - " + guestScore + " " + guestTeam.getName();
	}
	
}
