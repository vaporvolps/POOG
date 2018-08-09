package prjPOOG;

import java.util.*;

public class VolleyLeague extends League<VolleyMatch> {

	public VolleyLeague(){
		super(VolleyMatch.class);
	}
	
	public VolleyLeague(String name){
		super(VolleyMatch.class, name);
	}
	
	public void calcScore(){
		for (int i = 0 ; i < getNMatches(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = getHomeScore(i);
			guestScore = getGuestScore(i);
			homeTeam = getHomeTeam(i);
			guestTeam = getGuestTeam(i);
			//homeTeam.setnPlayedMatches(homeTeam.getnPlayedMatches()+1);
			//guestTeam.setnPlayedMatches(guestTeam.getnPlayedMatches()+1);
			if (homeScore > guestScore) {
				if ((guestScore==0) || (guestScore==1))
					setScore(homeTeam,3); 
				else if (guestScore == 2){
					setScore(homeTeam,2);
					setScore(guestTeam,1);
				}
			} else if ( guestScore > homeScore){
				if((homeScore==0)||(homeScore==1))
					setScore(guestTeam,3);
				else if(homeScore==2){
					setScore(guestTeam,2);
					setScore(homeTeam,1);
				}
			}	
		}
	}
}

