package prjPOOG;

import java.util.ArrayList;

public class RugbyLeague extends League<RugbyMatch>{

	public RugbyLeague(){
		super(RugbyMatch.class);
	}
	
	public RugbyLeague(String name){
		super(RugbyMatch.class, name);
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
			RugbyMatch match = getMatch(i);
			if ( match.getHomeTry() >= 4)/*bonus score*/
				setScore(homeTeam,1);
			if (match.getGuestTry() >= 4)/*bonus score*/
				setScore(guestTeam,1);
			if (homeScore > guestScore) {
				setScore(homeTeam,4);
				if ((homeScore-guestScore) <= 7)
					setScore(guestTeam,1);
			} else if ( guestScore > homeScore){
				setScore(guestTeam,4);
				if ((guestScore-homeScore) <= 7)
					setScore(homeTeam,1);
			} else if (homeScore == guestScore) {
				setScore(homeTeam,2);
				setScore(guestTeam,2);
			}
			
		}
	}
}
