package prjPOOG;

import java.util.ArrayList;
import java.util.Collections;

public abstract class League<T extends Match> /*implements Comparator <Team>*/{
	/* questa è la classe tipo dei Match specifici,verrà usata per la creazione delle giornate del torneo, e va per forza inizializzata nel costruttore. Sarebbe stato più comodo fare new T, ma java non lo permette. */
	private Class<T> cl; 
	private String name;
	private ArrayList <Team> teams;
	//private ArrayList <Team> ranking;// questo sarà da togliere
	//private ArrayList <ArrayList<Integer>> rank;// questo sarà da togliere
	private Schedule<T> schedule;//questa è la classe della mia classifica
	public League (Class<T> clazz){
		name = "";
		teams = new ArrayList <Team> ();
		//ranking = new ArrayList <Team> ();
		//rank = new ArrayList <ArrayList<Integer>> ();
		schedule = new Schedule<>();
		cl = clazz;
	}
	
	public League(Class<T> clazz, String name){
		this(clazz);
		setName(name);
	}
	
	public abstract void calcScore();
	
	public void setName(String name){
		if (name!= null)
			this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Team getTeam(int index) {
		return teams.get(index);
	}
	
	public void addTeam(Team t){
		if ( t != null ){
			teams.add(t);
			//ranking.put(t,0);
		}
	}
	
	public ArrayList <T> getPlayedMatches (){
		return schedule.getPlayedMatches();
	}
	
	public ArrayList<T> getRound(int round) throws IndexOutOfBoundsException {
		return schedule.getRound(round);
	}
	
	public int getNumberTeams(){
		return teams.size();
	}
	
	/*
	private class OrderComparator implements Comparator <Team>{
	laz
		public int compare(Team t1, Team t2){ 
		int val = t1.getScore() - t2.getScore();
		System.out.println("Val è : " + val);
		if (val != 0)
			return val;
		else
			return t1.getnPlayedMatches()-t2.getnPlayedMatches();/*inventati qualcosa per un eventuale spareggio
	}
	
	/* Algorithm took inspiration from this gist: https://gist.github.com/Makistos/7192934 and follows round-robin rules: https://en.wikipedia.org/wiki/Round-robin_tournament */
	public void generateSchedule() {
		schedule = new Schedule<>();//per evitare che, nel caso debba rifare una classifica perchè si aggiunge o toglie una squadra, rischi di avere dei problemi con lo schedule del costruttore
		ArrayList<Team> t = new ArrayList<>();
		t.addAll(teams); // copio i team in t
		//Round robin's schedule has n / 4 * (n - 1) rounds
		int halfSportsDays = t.size() / 4 * (t.size() - 1); //mi basta calcolare il girone di andata, quello di ritorno sarà solo a squadre invertite
		for (int i = 0; i < halfSportsDays; i++) {
			schedule.addFirstRound(generateRound(t, true));
			schedule.addSecondRound(generateRound(t, false));
			t.add(1, t.get(t.size() - 1));//prendo l'ultimo elemento e lo metto al posto del secondo elemento, facendo slittare gli altri
			t.remove(t.size() - 1);//tolgo l'ultimo elemento 
		}
		/*stampa le giornate e i nomi delle squadre/*
		/*for (int i = 0; i < schedule.numberOfSportsDays(); i++) {
			ArrayList<T> day = schedule.getRound(i);
			System.out.println("Giornata " + (i+1));
			for (int x = 0; x < day.size(); x++) {
				System.out.println(day.get(x).getHomeTeam().getName() + " - " + day.get(x).getGuestTeam().getName());
			}
		}*/
	}
	/* if firstRound is true, we're generating a first rounds's schedule; otherwise, we're generating a second one */
	private ArrayList<T> generateRound(ArrayList<Team> t, boolean firstRound) { 
		ArrayList<T> day = new ArrayList<>();
		int size = t.size();
		int halfSize = size / 2;
		for (int i = 0; i < halfSize; i++) {
			try {
				T match = cl.newInstance(); // questa cosa mi permette di sopperire all'impossibilità del new T : è come creare un nuovo *sport*Match
				match.setPlayed(true);/*************andrà cambiato********/
				match.setHomeScore(3);/**************+anche questo ************/
				if (firstRound){
					match.setHomeTeam(t.get(i));
					match.setGuestTeam(t.get(size - 1 - i));
				} else {
					match.setGuestTeam(t.get(i));
					match.setHomeTeam(t.get(size - 1 - i));
				}
				day.add(match);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return day; // torna l'array con le partite della giornata 
	} 
	
	private class Schedule<T extends Match> {
		private ArrayList<ArrayList<T>> firstRound;
		private ArrayList<ArrayList<T>> secondRound;
		
		public Schedule() {
			firstRound = new ArrayList<ArrayList<T>>();
			secondRound = new ArrayList<ArrayList<T>>();
		}
		
		public void addFirstRound(ArrayList<T> round) {
			firstRound.add(round);
		}
		
		public void addSecondRound(ArrayList<T> round) {
			secondRound.add(round);
		}
		
		public ArrayList<T> getFirstRound(int round) throws IndexOutOfBoundsException {
			return firstRound.get(round);
		}
		
		public ArrayList<T> getSecondRound(int round) throws IndexOutOfBoundsException {
			return secondRound.get(round);
		}
		
		public ArrayList<T> getRound(int round) throws IndexOutOfBoundsException {
			if (round < firstRound.size()) {
				return firstRound.get(round);
			} else {
				return secondRound.get(round - firstRound.size());
			}
		}
		
		// TODO: Optimize
		public ArrayList<T> getPlayedMatches (){
			ArrayList <T> matches = new ArrayList<>();
			for (int i = 0; i < numberOfSportsDays()/2; i++){
				ArrayList <T> m = getFirstRound(i);
				for (int j = 0; j < m.size(); j++){
					if (m.get(j).played)
						matches.addAll(m);
				}		
			}
			for (int i = 0; i < numberOfSportsDays()/2; i++){
				ArrayList <T> m = getSecondRound(i);
				for (int j = 0; j < m.size(); j++){
					if (m.get(j).played)
						matches.addAll(m);
				}
			}
			/*System.out.println("Le partite giocate sono : ");
			for (int i = 0; i < matches.size(); i++)
				System.out.println(matches.get(i).getHomeTeam().getName() + " - " + matches.get(i).getGuestTeam().getName() );*/
			return matches;
		}
		
		public int numberOfSportsDays() {
			return firstRound.size() + secondRound.size();
		}
	}
}
