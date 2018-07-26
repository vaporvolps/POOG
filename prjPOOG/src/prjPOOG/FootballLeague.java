package prjPOOG;

import java.util.*;

public class FootballLeague extends League<FootballMatch> {
	
	public FootballLeague(){
		super();
	}
	public FootballLeague(String name){
		super(name);
	}
	
	public void calcScore(){
		for (int i = 0; i<getSizeMatches(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = getHomeScore(i);
			guestScore = getGuestScore(i);
			homeTeam = getHomeTeam(i);
			guestTeam = getGuestTeam(i);
			if (homeScore > guestScore) {
				setScore(homeTeam,3); 
			} else if (homeScore == guestScore){
				setScore(homeTeam, 1);
				setScore(guestTeam,1);
			} else if (guestScore > homeScore){
				setScore(guestTeam,3); 
			}	
		}
		
	}
}
