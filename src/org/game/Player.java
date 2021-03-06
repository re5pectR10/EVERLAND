package org.game;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.game.Figure.Color;

@SuppressWarnings("serial")
public class Player extends JPanel {

	private boolean isHuman = false;
	private ArrayList<Figure> figures = new ArrayList<Figure>();
	private Figure.Color playerColor;
	
	public Player(Figure.Color color) {
		this.playerColor = color;
		initFigures();
	}
	
	public Player(boolean isHuman, Figure.Color color) {
		this.playerColor = color;
		this.setHuman(isHuman);
		initFigures();
	}
	
	public void paint(Graphics g) {
		for (Figure f : figures) {
			f.paint(g);
		}
	}
	
	private void initFigures() {
		int defaultPosition = 0;
		int startingPosition = 0;
		int additionalFieldSartPosition;
		if (playerColor == Figure.Color.RED) {
			defaultPosition = 68;
			startingPosition = 30;
			additionalFieldSartPosition = 52;
		} else if (playerColor == Figure.Color.GREEN) {
			defaultPosition = 56;
			startingPosition = 0;
			additionalFieldSartPosition = 40;
		} else if (playerColor == Figure.Color.BLUE) {
			defaultPosition = 64;
			startingPosition = 20;
			additionalFieldSartPosition = 48;
		} else {
			defaultPosition = 60;
			startingPosition = 10;
			additionalFieldSartPosition = 44;
		}
		
		for (int i = defaultPosition; i < defaultPosition + 4; i++) {
			
			this.figures.add(new Figure(i, playerColor, startingPosition, additionalFieldSartPosition));
		}
	}
	
	public void removeFigure(Figure f) {
		this.figures.remove(f);
	}
	
	public ArrayList<Figure> getFigures() {
		return this.figures;
	}
	
	public boolean isHuman() {
		return isHuman;
	}
		
	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}
	
	public Color getPlayerColor() {
		return this.playerColor;
	}
}
