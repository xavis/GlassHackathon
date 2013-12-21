package glass.eyelead;

import android.graphics.Bitmap;

public class Coords {

	double lat, lon;
	String [] info;
	Bitmap foto;
	
	public Coords(double la, double lo, String[] s){
		
		lat = la;
		lo = lon;
		info = s;
		
		
	}
	
	//Sets
	public void setLat(double input){
		lat = input;
	}
	public void setLon(double input){
		lon = input;
	}
	public void setinfo(String[] input){
		info = input;
	}
	
	//Gets
	public double getLat(){
		return lat;
	}
	public double getLon(){
		return lon;
	}
	public String[] getinfo(){
		return info;
	}
	public Bitmap getFoto(){
		return foto;
	}
	
}
