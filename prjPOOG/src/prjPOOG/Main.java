package prjPOOG;

import java.util.ArrayList;

public class Main {
	public static void main (String [] args){
		Team t = new Team();
		t.setName("Albatros");
		Team f = new Team();
		f.setName("Flamingos");
		ArrayList<League<? extends Match>> leagues = new ArrayList<>();
		//FootballLeague l = new FootballLeague();
		//VolleyLeague v = new VolleyLeague();
		RugbyLeague v = new RugbyLeague();
		//leagues.add(l);
		//leagues.add(v);
		leagues.add(v);
		//FootballMatch m = new FootballMatch();
		//VolleyMatch m2 = new VolleyMatch();
		RugbyMatch m3 = new RugbyMatch();
		m3.setHomeTeam(f);
		m3.setGuestTeam(t);
		m3.setHomeScore(3);
		m3.setGuestScore(3);
		m3.setHomeTry(4);
		//m2.setSetHome(0,5);
		//m2.setSetHome(1,6);
		//m2.printSetHome();
		v.addTeam(t);
		v.addTeam(f);
		v.addMatch(m3);
		v.calcScore();

	}
}
