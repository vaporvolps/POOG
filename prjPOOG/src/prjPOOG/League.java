package prjPOOG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public abstract class League<T extends Match> {
	private String name;
	private ArrayList <Team> teams;
	private Map <Team,Integer> ranking;
	private ArrayList<T> matches;
	
	public League (){
		name = null;
		teams = new ArrayList ();
		ranking = new HashMap <Team,Integer> ();
		matches = new ArrayList<T>();

	}
	
	public League(String name){
		setName(name);
	}
	
	public abstract void calcScore();
	
	public void addMatch(T m){
		matches.add(m);
	}
	public void setName(String name){
		if (name!= null)
			this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addTeam(Team t){
		if ( t != null ){
			teams.add(t);
			ranking.put(t,0);
		}
	}
	
	public void setScore(Team t, Integer score){
		System.out.println("Sto aggiungengo alla squadra " +t.getName() + " " + score + " punti." );
		System.out.println("L'attuale punteggio è : " + ranking.get(t) + " punti");
		ranking.put(t, ranking.get(t)+score);
		System.out.println("La squadra " +t.getName() + " ha " + ranking.get(t) + " punti." );
	}
	
	public int getHomeScore(int index){
		return matches.get(index).getHomeScore();
	}
	
	public int getGuestScore(int index){
		return matches.get(index).getGuestScore();
	}
	
	public Team getHomeTeam(int index){
		return matches.get(index).getHomeTeam();
	}
	
	public Team getGuestTeam(int index){
		return matches.get(index).getGuestTeam();
	}	
	
	public T getMatch (int index){
		return matches.get(index);
	}
	public int getSizeMatches(){
		return matches.size();
	}


}
