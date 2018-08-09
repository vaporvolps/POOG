package prjPOOG;

import java.util.*;

public class FootballLeague extends League<FootballMatch> {

	public FootballLeague(){
		super(FootballMatch.class);
	}
	
	public FootballLeague(String name){
		super(FootballMatch.class, name);
	}
	
	public void calcScore(){
		
		HashMap<Team, ArrayList<Integer>> ranking = new HashMap<>();
		ArrayList<FootballMatch> playedMatches = getPlayedMatches();
		for (int i = 0; i < getNumberTeams(); i++) 
			ranking.put(getTeam(i), new ArrayList<Integer>());
		for (int i = 0; i<playedMatches.size(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = playedMatches.get(i).getHomeScore();
			guestScore = playedMatches.get(i).getGuestScore();
			homeTeam = playedMatches.get(i).getHomeTeam();
			guestTeam = playedMatches.get(i).getGuestTeam();
			//homeTeam.setnPlayedMatches(homeTeam.getnPlayedMatches()+1);
			//guestTeam.setnPlayedMatches(guestTeam.getnPlayedMatches()+1);
			if (homeScore > guestScore) {
				int score = ranking.get(homeTeam).get(0);
				ranking.get(homeTeam).add(0,score + 3); 
			} else if (homeScore == guestScore){
				homeScore = ranking.get(homeTeam).get(0);
				ranking.get(homeTeam).add(0,homeScore + 1); 
				guestScore = ranking.get(guestTeam).get(0);
				ranking.get(guestTeam).add(0,guestScore + 1); 
			} else if (guestScore > homeScore){
				guestScore = ranking.get(guestTeam).get(0);
				ranking.get(guestTeam).add(0,guestScore + 3);
			}	
		}
		ranking.forEach((key, value) -> System.out.println(key.getName() + " : " + value));// lambda expression 
		
	}
}
