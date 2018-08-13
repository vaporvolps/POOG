package prjPOOG;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class Main {
	public static void main (String [] args) throws InstantiationException, IllegalAccessException{
		/*
		ArrayList<League<? extends Match>> leagues = new ArrayList<>();
		VolleyLeague v = new VolleyLeague();
		//FootballLeague v = new FootballLeague();
		leagues.add(v);
		v.addTeam(new Team("Albatros"));
		v.addTeam(new Team("Flamingos"));
		v.addTeam(new Team("BarbaraCulos"));
		v.addTeam(new Team("Dioboseeculos"));
		v.generateSchedule();
		//ArrayList<FootballMatch> round = v.getPlayedMatches();
		//round.get(0).setGuestScore(4);
		ArrayList<VolleyMatch> round = v.getPlayedMatches();
		round.get(0).setGuestScore(3);
		round.get(0).setHomeScore(0);
		v.calcScore();*/
		try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
			} 
			catch (UnsupportedLookAndFeelException e) {
				System.out.println("Look & Feel non supportato");
			}
			catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			catch (InstantiationException e) {
				System.out.println("L'oggetto non puo' essere istanziato");
			}
			catch (IllegalAccessException e) {
				System.out.println("e"); //a cosa serve questa eccezione?Che stampa è una e?
			}
			
			MainWindow mainW = new MainWindow("Gestione Tornei") ;
			mainW.setVisible(true);

		}

}

