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
		
		Map<Team, Integer> ranking = new HashMap<>();
		ValueComparator bvc = new ValueComparator(ranking);
		TreeMap <Team, Integer> sorted_map = new TreeMap <Team,Integer>(bvc);
		ArrayList<FootballMatch> playedMatches = getPlayedMatches();
		for (int i = 0; i < getNumberTeams(); i++) 
			ranking.put(getTeam(i), 0);
		for (int i = 0; i<playedMatches.size(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = playedMatches.get(i).getHomeScore();
			guestScore = playedMatches.get(i).getGuestScore();
			homeTeam = playedMatches.get(i).getHomeTeam();
			guestTeam = playedMatches.get(i).getGuestTeam();
			if (homeScore > guestScore) {
				int score = ranking.get(homeTeam);
				ranking.put(homeTeam, score+3); 
			} else if (homeScore == guestScore){
				homeScore = ranking.get(homeTeam);
				ranking.put(homeTeam,homeScore + 1); 
				guestScore = ranking.get(guestTeam);
				ranking.put(guestTeam,guestScore + 1); 
			} else if (guestScore > homeScore){
				guestScore = ranking.get(guestTeam);
				ranking.put(guestTeam,guestScore+3);
			}	
		}

		ranking.forEach((key, value) -> System.out.println(key.getName() + " : " + value));// lambda expression 
		sorted_map.putAll(ranking);
		System.out.println("Dopo l'ordinamento:");
		sorted_map.forEach((key, value) -> System.out.println(key.getName() + " : " + value));// lambda expression 
		/*controls if there are equal scores*/
		
	}
	
	private class ValueComparator implements Comparator <Team>{
		Map<Team,Integer> base;
		
		public ValueComparator (Map<Team,Integer> base){
			this.base = base;
		}
		public int compare(Team a, Team b) {
			
			int comp = ( base.get(a) - base.get(b));
		        if (comp != 0)
		        	return -1;
		        else
		        	return 1;   
		 }

	}
}

