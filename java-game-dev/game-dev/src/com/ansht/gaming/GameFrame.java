package com.ansht.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() {  //Constructor
		Board board = new Board();
		this.setSize(1535, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Cosmic Cruiser");
		add(board);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame();
		

	}

}
