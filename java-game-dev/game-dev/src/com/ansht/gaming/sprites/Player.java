package com.ansht.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite {
	public Player() {
		w= 150;
		h = 100;
		x = 150;
		y = 600;
		image = new ImageIcon(Player.class.getResource("player.gif"));
	}
	public void move() {
		x = x+speed;
	}
	public boolean outOfScreen() {
		return x>1535;
	}
}