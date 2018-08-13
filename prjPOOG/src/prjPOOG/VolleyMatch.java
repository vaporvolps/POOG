package prjPOOG;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class VolleyMatch extends Match {
	private ArrayList<Integer> homeSet,guestSet;
	
	
	public VolleyMatch(){
		initializeHomeSetArray();
		initializeGuestSetArray();
	}
	public VolleyMatch (ArrayList<Integer> homeSet, ArrayList<Integer> guestSet ){
		setAllHomeSet(homeSet);
		setAllGuestSet(guestSet);
	}
	public VolleyMatch (Team homeTeam, Team guestTeam, int homeScore, int guestScore, ArrayList<Integer> homeSet, ArrayList<Integer> guestSet){
		super(homeTeam,guestTeam,homeScore,guestScore);
		setAllHomeSet(homeSet);
		setAllGuestSet(guestSet);
	}
	
	public void initializeHomeSetArray(){
		//A match can also ends 3-0; last 2 elements will be zeroes.
		homeSet = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	}
	
	public void initializeGuestSetArray(){
		//A match can also ends 3-0; last 2 elements will be zeroes.
		guestSet = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	}
	public void setAllHomeSet(ArrayList<Integer> homeSet){
		for (int i=0; i<homeSet.size(); i++){
			if ((homeSet.get(i)>=0) && (homeSet.size() == 5))
				this.homeSet.set(i, homeSet.get(i));
		}	
	}
	
	public void setAllGuestSet(ArrayList<Integer> guestSet){
		for (int i=0; i<homeSet.size(); i++){
			if ((guestSet.get(i)>=0) && (guestSet.size() == 5))
				this.guestSet.set(i, guestSet.get(i));
		}		
	}
	
	public int getSetHome(int index) {
		if (index>=0 && index <=5)
			return (int)homeSet.get(index);
		else
			return -1;
	}
	
	public int getSetGuest(int index) {
		if (index>=0 && index <=5)
			return (int)guestSet.get(index);
		else 
			return -1;
	}
	
	public void printSetHome(){
		for(int i : homeSet){
			System.out.println(i);
		}
	}
	
	public void setSetHome(int index, int score){
		
		if (index >= 0 && index <=5)
			homeSet.set(index, (Integer)score);
	}
	
	public void setSetGuest(int index, int score){
		if (index >= 0 && index <=5 )
			guestSet.set(index, (Integer)score);
	}

	
}
