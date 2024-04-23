package com.ansht.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {
	public Enemy(int x, int speed) {
		y = 50;
		this.x = x;
		this.speed = speed;
		w = 300;
		h = 200;
		image = new ImageIcon(Enemy.class.getResource("enemy.gif"));
	}
	public void move() {
		if(y>700) {
			y = 0;
		}
		y = y+ speed;
	}
}
