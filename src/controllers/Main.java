package controllers;

public class Main {

	static mGUI gui = new mGUI();
	static GameBoard board = new GameBoard();
	
	public static void main(String[] args) {
			board.CreateBoard();
			gui.getButton("test","test");
	}

}
