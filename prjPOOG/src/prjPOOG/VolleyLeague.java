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
		Map<Team, ArrayList<Integer>> ranking = new HashMap<>();
		ValueComparator bvc = new ValueComparator(ranking);
		TreeMap <Team, ArrayList<Integer>> sorted_map = new TreeMap <>(bvc);
		ArrayList<VolleyMatch> playedMatches = getPlayedMatches();
		// first element will be score, second one will be won matches,third one will be won sets, 
		// fourth one will be lost sets, fifth one will be the sum of done sets' score, sixth one will be the sum of suffered sets' score
		for (int i = 0; i < getNumberTeams(); i++) 
			ranking.put(getTeam(i), new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0))); 
		for (int i = 0 ; i < playedMatches.size(); i++){
			int homeScore,guestScore;
			Team homeTeam, guestTeam;
			homeScore = playedMatches.get(i).getHomeScore();
			guestScore = playedMatches.get(i).getGuestScore();
			homeTeam = playedMatches.get(i).getHomeTeam();
			guestTeam = playedMatches.get(i).getGuestTeam();
			/*stores info about score sets (last two elements of ranking)*/
			for (int k = 0; k < 5; k++){
				int homeSetScore = playedMatches.get(i).getSetHome(k);
				int homeStoredScore = ranking.get(homeTeam).get(4);
				ranking.get(homeTeam).set(4, homeStoredScore + homeSetScore); 
				int guestSetScore = playedMatches.get(i).getSetGuest(k);
				int guestStoredScore = ranking.get(guestTeam).get(4);
				ranking.get(guestTeam).set(4, guestStoredScore + guestSetScore); 
				int homeSufferedSetScore = ranking.get(homeTeam).get(5);
				ranking.get(homeTeam).set(5, guestSetScore+homeSufferedSetScore);
				int guestSufferedSetScore = ranking.get(guestTeam).get(5);
				ranking.get(guestTeam).set(5, homeSetScore + guestSufferedSetScore);
				
			}
			/*stores info about sets (second and third elements of ranking*/
			int wonHomeSets = ranking.get(homeTeam).get(2);
			ranking.get(homeTeam).set(2, wonHomeSets + homeScore); 
			int wonGuestSets = ranking.get(guestTeam).get(2);
			ranking.get(guestTeam).set(2, wonGuestSets + guestScore);
			int lostHomeSets = ranking.get(homeTeam).get(3);
			ranking.get(homeTeam).set(3, lostHomeSets + guestScore); 
			int lostGuestSets = ranking.get(guestTeam).get(3);
			ranking.get(guestTeam).set(3, lostGuestSets + homeScore); 
			/*calculates ranking score based on volley matches results (element 0 of ranking) and info about matches (element 1 of ranking)*/
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
		//ranking.forEach((key, value) -> System.out.println(key.getName() + " : " + value));// lambda expression 
		sorted_map.putAll(ranking);
		sorted_map.forEach((key, value) -> System.out.println(key.getName() + " : " + value));// lambda expression 
		
	}
	private class ValueComparator implements Comparator <Team>{
		Map<Team,ArrayList<Integer>> base;
		
		public ValueComparator (Map<Team,ArrayList<Integer>> base){
			this.base = base;
		}
		
		public int compare(Team a, Team b) {
			int score = base.get(a).get(0) - base.get(b).get(0);
			 if (score != 0)
		        	return -1;
		        else{
		        	int won = base.get(a).get(1) - base.get(b).get(1);
		        	if (won != 0)
		        		return -1;
		        	else /*{
		        		int setsRatio = base.get(a).get(2)/base.get(a).get(3) - base.get(b).get(2)/base.get(b).get(3);//da provare, e va controllata la divisione per 0
		        		if (setsRatio != 0)
		        			return -1;
		        		else {
		        			int scoreRatio = base.get(a).get(4)/base.get(a).get(5) - base.get(b).get(4)/base.get(b).get(5); // da provare e va controllata da divisione per 0
		        			if (scoreRatio != 0)
		        				return -1;
		        			else*/
		        				return 1;
		        		}
		
		        	}
		        		
		        //}
			
		 }

	//}
}

