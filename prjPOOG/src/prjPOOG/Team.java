package prjPOOG;

import java.awt.Image;

public class Team {
	private String name, city, sport; //finisci di inizializzare anche sport
	private Image logo;
	private int nPlayedMatches; //this will be useful in order to sort teams' ranking
	private int score;
	
	public Team(){
		name = null;
		city = null;
		logo = null;
		//nPlayedMatches = 0;
		//score = 0;
	}
	
	public Team(String name) {
		setName(name);
	}
	
	public Team(String name, String city, Image logo,int nPlayedMatches,int score ){
		setName(name);
		setCity(city);
		setLogo(logo);
		//setnPlayedMatches(nPlayedMatches);
		//setScore(score);
	}
	
	public int getnPlayedMatches() {
		return nPlayedMatches;
	}

	public void setnPlayedMatches(int nPlayedMatches) {
		if (nPlayedMatches >= 0)
			this.nPlayedMatches = nPlayedMatches;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score>=0)
			this.score = score;
	}

	public String getName(){
		return name;
	}
	
	public void setName (String name){
		if (name != null)
			this.name = name;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity (String city){
		if (city != null)
			this.city = city;
	}
	
	public Image getLogo(){
		return logo;
	}
	
	public void setLogo (Image logo){
		if (logo != null)
			this.logo = logo;
	}
}
