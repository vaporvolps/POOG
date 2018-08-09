package prjPOOG;

import java.util.ArrayList;

public class Main {
	public static void main (String [] args) throws InstantiationException, IllegalAccessException{
		ArrayList<League<? extends Match>> leagues = new ArrayList<>();
		FootballLeague v = new FootballLeague();
		//VolleyLeague v = new VolleyLeague();
		//RugbyLeague v = new RugbyLeague();
		//leagues.add(l);
		//leagues.add(v);
		leagues.add(v);
		//FootballMatch m = new FootballMatch();
		//VolleyMatch m2 = new VolleyMatch();
		/*ArrayList <RugbyMatch> m3 = new ArrayList<RugbyMatch>();
		for (int i = 0 ; i < v.getNumberTeams(); i++){
			RugbyMatch m = new RugbyMatch();
			m.setHomeTeam();
		}*/
		//RugbyMatch m3 = new RugbyMatch();

		//m3.setHomeTeam(f);
		//m3.setGuestTeam(t);
		//m3.setHomeScore(3);
		//m3.setGuestScore(3);
		//m3.setHomeTry(4);
		//m2.setSetHome(0,5);
		//m2.setSetHome(1,6);
		//m2.printSetHome();
		v.addTeam(new Team("Albatros"));
		v.addTeam(new Team("Flamingos"));
		v.addTeam(new Team("BarbaraCulos"));
		v.addTeam(new Team("Dioboseeculos"));
		v.generateSchedule();
		//v.getPlayedMatches();
		//v.addMatch(m3);
		//v.generateSchedule();
		v.calcScore();
		//v.addTeamToRanking();

	}
}
