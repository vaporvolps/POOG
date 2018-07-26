package prjPOOG;

import java.awt.Image;

public class Team {
	private String name, city, sport; //finisci di iniziallizzare anche sport
	private Image logo;
	
	public Team(){
		name = null;
		city = null;
		logo = null;
	}
	
	public Team(String name, String city, Image logo){
		setName(name);
		setCity(city);
		setLogo(logo);
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
