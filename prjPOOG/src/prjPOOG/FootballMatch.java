package prjPOOG;

import java.sql.Date;
import java.util.ArrayList;

public class FootballMatch extends Match {
	private int homeYellowCards,homeRedCards, guestYellowCards, guestRedCards;
	
	public FootballMatch(){
		super();
		homeYellowCards = homeRedCards = guestYellowCards = guestRedCards = 0;
	}
	public FootballMatch(int homeYellowCards, int homeRedCards, int guestYellowCards, int guestRedCards){
		setHomeYellowCards(homeYellowCards);
		setGuestYellowCards(guestYellowCards);
		setHomeRedCards(homeRedCards);
		setGuestRedCards(guestRedCards);
	}
	public FootballMatch( Team homeTeam, Team guestTeam, int homeScore, int guestScore, int homeYellowCards, int guestYellowCards, int homeRedCards, int guestRedCards){
		super( homeTeam, guestTeam, homeScore, guestScore);
		setHomeYellowCards(homeYellowCards);
		setGuestYellowCards(guestYellowCards);
		setHomeRedCards(homeRedCards);
		setGuestRedCards(guestRedCards);
	}
	
	public void setHomeYellowCards(int homeYellowCards) {
		if (homeYellowCards >= 0)
			this.homeYellowCards = homeYellowCards;
	}
	public void setGuestYellowCards(int guestYellowCards) {
		if (guestYellowCards >= 0)
			this.guestYellowCards = guestYellowCards;
	}
	
	public void setHomeRedCards(int homeRedCards) {
		if (homeRedCards >= 0)
			this.homeRedCards = homeRedCards;
	}
	
	public void setGuestRedCards(int guestRedCards) {
		if (guestRedCards >= 0)
			this.guestRedCards = guestRedCards;
	}
	
	public int getHomeYellowCards() {
		return homeYellowCards;
	}
	
	public int getHomeRedCards() {
		return homeRedCards;
	}
	
	public int getGuestYellowCards() {
		return guestYellowCards;
	}
	
	public int getGuestRedCards() {
		return guestRedCards;
	}

}
