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
		// char c = '7'; // c holds the character 7 (55)
		// int i = c - '0'; // i holds the number 7 (55 - 48) 
		// println(i);
	}

	public void setup() 

	{	colorMode(HSB);
		loadScore();
		printScores();
	}

	public void draw()
	{
		background(255);
		drawLines();
		drawNotes();
		float border = (float)width * 0.1f;
		for(int i = 0; i < note.size(); i++){
			float y = map(i, 0, note.size(), border * 2, width - (border * 2));
			float y1 = map(i, 1, note.size(), height - border, border * 3);
			if(mouseX > (y - 5) && mouseX > (y + 5) ){
				fill(255,255,255);
				text(note.get(i).getNote(), y, border * 2);
				fill(255,255,255);
				if(note.get(i).getType() == "Crotchet"){
					circle(y, y1, 20);
					line(y + 10, y1, y + 10, y1 - 50);
				}
				else{
					circle(y, y1, 20);
					line(y + 10, y1, y + 10, y1 - 50);
					line(y + 10, y1 - 50, y + 20, y1 - 40);
				}
				fill(0);
			}else{
				fill(0);
				text(note.get(i).getNote(), y, border * 2);
				fill(0);
				if(note.get(i).getType() == "Crotchet"){
					circle(y, y1, 20);
					line(y + 10, y1, y + 10, y1 - 50);
				}
				else{
					circle(y, y1, 20);
					line(y + 10, y1, y + 10, y1 - 50);
					line(y + 10, y1 - 50, y + 20, y1 - 40);
				}
			}
		}
	}

	void drawNotes()
	{	
		float border = (float)width * 0.1f;
		for(int i = 0; i < note.size(); i++){
			float y = map(i, 0, note.size(), border * 2, width - (border * 2));
			float y1 = map(i, 1, note.size(), height - border, border * 3);
			fill(0);
			text(note.get(i).getNote(), y, border * 2);
			fill(0);
			if(note.get(i).getType() == "Crotchet"){
				circle(y, y1, 20);
				line(y + 10, y1, y + 10, y1 - 50);
			}
			else{
				circle(y, y1, 20);
				line(y + 10, y1, y + 10, y1 - 50);
				line(y + 10, y1 - 50, y + 20, y1 - 40);
			}
		}
	}


	public void drawLines(){
		background(255);
		float border = (float)width * 0.1f;
		for(int i = 1; i <= 5; i++){
			float y = map(i, 1, 5, border * 3, height - border);
			stroke(0);
			fill(0);
			line(border * 2, y, width - (border * 2), y);
		}
	}

	public void loadScore(){

		for(int i = 0; i < score.length() - 1; i++){
			char c = score.charAt(i + 1);
			int j = c - '0';
			if(j == 2){
				note.add(new Note(score.charAt(i), 2, "Crotchet"));
				++i;
			}else{
				note.add(new Note(score.charAt(i), 1, "Quaver"));
			}
		}
	}
	public void printScores(){
		for(Note n : note){
			println(n.toString());
		}
	}
}
