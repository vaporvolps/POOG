package prjPOOG;

public class RugbyLeague extends League<RugbyMatch>{

	public RugbyLeague(){
		super();
	}
	
	public RugbyLeague(String name){
		super(name);
	}
	
	public void calcScore(){ 
		for (int i = 0 ; i < getSizeMatches(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = getHomeScore(i);
			guestScore = getGuestScore(i);
			homeTeam = getHomeTeam(i);
			guestTeam = getGuestTeam(i);
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
