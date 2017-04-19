package entities;

import java.awt.Color;

import entities.Account;

public class Player {

	private String name;
	private int position;
	private int number;
	private Color colour;
	private Account account;
	
//	Antallet af felter (skal opdateres)
	private int maxfields;
	
	public Player(){
		this.account = new Account();
		position = 0;
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
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int number){
		this.number = number;
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
