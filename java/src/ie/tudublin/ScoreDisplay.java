package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	// String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	ArrayList<Note> note = new ArrayList<Note>();
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{
		loadScore();
		printScores();
	}

	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{

	}

	public void loadScore(){

		for(int i = 0; i < score.length() - 1; i++){
			char c = score.charAt(i + 1); // c holds the character 7 (55)
			int j = c - '0'; // i holds the number 7 (55 - 48) 
			if(j == 2){
				note.add(new Note(score.charAt(i), 2));
				++i;
			}else{
				note.add(new Note(score.charAt(i), 1));
			}
		}
	}
	public void printScores(){
		for(Note n : note){
			if(n.getDuration() > 1){
				println(n.getNote() + "		" + n.getDuration() + "	 " + "Crotchet");
			}else{
				println(n.getNote() + "		" + n.getDuration() + "	 " + "Quaver");
			}
		}
	}
}
