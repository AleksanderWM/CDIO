/**
 * @author Simon
 * Gruppe 
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
	
	public Player(String name,int ID, Color colour){
		this.account = new Account();
		position = 0;
		this.name = name;
		this.colour = colour;
		this.ID = ID;
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
	
//	Mangler krydsning af start bonus
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
