/**
 * @author Simon
 * Gruppe A
 * 02362 Projekt i software-udvikling 
 */

package entities;

import java.awt.Color;

import entities.Account;

public class Player {

	private String name;
	private int position;
	private int ID;
	private Color colour;
	private Account account;
	
	private int maxfields;
	
	public Player(int idnumber, String name, Color colour){
		this.account = new Account();
		position = 0;
		ID = idnumber;
		this.name = name;
		this.colour = colour;
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int newPosition){
		position = newPosition;
	}
	
	public void movePosition(int moves){
		position = this.position + moves;
		if(this.position > maxfields)
			position = this.position % maxfields;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int number){
		this.ID = number;
	}
	
	public Color getColour(){
		return colour;
	}
	
	public void setColour(Color colour){
		this.colour = colour;
	}
	
	public Account getAccount(){
		return account;
	}
	
}
