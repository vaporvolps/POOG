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
		HashMap<Team, ArrayList<Integer>> ranking = new HashMap<>();
		ArrayList<VolleyMatch> playedMatches = getPlayedMatches();
		for (int i = 0; i < getNumberTeams(); i++) 
			ranking.put(getTeam(i), new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0))); // first element will be score, second one will be won matches,third one will be won sets, fourth one will be lost sets, fifth one will be the sum of done sets' score
		for (int i = 0 ; i < playedMatches.size(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = playedMatches.get(i).getHomeScore();
			guestScore = playedMatches.get(i).getGuestScore();
			homeTeam = playedMatches.get(i).getHomeTeam();
			guestTeam = playedMatches.get(i).getGuestTeam();
			for (int k = 0; i < 5; i++){
				int homeSetScore = playedMatches.get(i).getSetHome(k);
				int homeStoredScore = ranking.get(homeTeam).get(4);
				ranking.get(homeTeam).set(4, homeStoredScore + homeSetScore); 
				int guestSetScore = playedMatches.get(i).getSetGuest(k);
				int guestStoredScore = ranking.get(guestTeam).get(4);
				ranking.get(guestTeam).set(4, guestStoredScore + guestSetScore); 
			}
			int wonHomeSets = ranking.get(homeTeam).get(2);
			ranking.get(homeTeam).set(2, wonHomeSets + homeScore); 
			int wonGuestSets = ranking.get(guestTeam).get(2);
			ranking.get(guestTeam).set(2, wonGuestSets + guestScore);
			int lostHomeSets = ranking.get(homeTeam).get(3);
			ranking.get(homeTeam).set(3, lostHomeSets + guestScore); 
			int lostGuestSets = ranking.get(guestTeam).get(3);
			ranking.get(guestTeam).set(3, lostGuestSets + homeScore); 
			if (homeScore > guestScore) {
				int wonMatches = ranking.get(homeTeam).get(1);
				ranking.get(homeTeam).set(1, wonMatches+1);
				if ((guestScore==0) || (guestScore==1)) {
					int score = ranking.get(homeTeam).get(0);
					ranking.get(homeTeam).set(0,score + 3); 
				}
				else if (guestScore == 2){
					homeScore = ranking.get(homeTeam).get(0);
					ranking.get(homeTeam).set(0,homeScore + 2); 
					guestScore = ranking.get(guestTeam).get(0);
					ranking.get(guestTeam).set(0,guestScore + 1); 
				}
			} else if ( guestScore > homeScore){
				int wonMatches = ranking.get(guestTeam).get(1);
				ranking.get(guestTeam).set(1, wonMatches+1);
				if((homeScore==0)||(homeScore==1)) {
					guestScore = ranking.get(guestTeam).get(0);
					ranking.get(guestTeam).set(0,guestScore + 3);
				}
				else if(homeScore==2){
					homeScore = ranking.get(homeTeam).get(0);
					ranking.get(homeTeam).set(0,homeScore + 1); 
					guestScore = ranking.get(guestTeam).get(0);
					ranking.get(guestTeam).set(0,guestScore + 2); 
				}
			}	
		}
		System.out.println("Team - Score - Won - Won Sets - Lost - Lost Sets - Sum(score)");
		ranking.forEach((key, value) -> System.out.println(key.getName() + " : " + value));// lambda expression 
	}
}

