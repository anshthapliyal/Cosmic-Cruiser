package com.ansht.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.ansht.gaming.sprites.Enemy;
import com.ansht.gaming.sprites.Player;

public class Board extends JPanel {
	Timer timer;
	BufferedImage backgroundImage;
	Player player;
	Enemy enemies[] = new Enemy[3]; 
	public Board() {
		setSize(1535, 820);
		loadBackgroundImage();
		player = new Player();
		loadEnemies();
		gameLoop();
		bindEvents();
		setFocusable(true);
	}
	private void gameOver(Graphics pen) {
		if(player.outOfScreen()) {
			pen.setFont(new Font("times", Font.BOLD, 30));
			pen.setColor(Color.RED);
			pen.drawString("Game Win! Thanks For Playing.",1535/2, 820/2);
			timer.stop();
		}
		for(Enemy enemy : enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("times", Font.BOLD, 30));
				pen.setColor(Color.RED);
				pen.drawString("Game Over",1535/2, 820/2);
				timer.stop();
				
			}
		}
	}
	private boolean isCollide(Enemy enemy) {
		int xDistance = Math.abs(player.x - enemy.x);
		int yDistance = Math.abs(player.y - enemy.y);
		int maxH = Math.max(player.h ,  enemy.w);
		int maxW = Math.max(player.w, enemy.w);
		return xDistance <= maxW-250 && yDistance <= maxH-150;
	}
	private void bindEvents() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.speed = 10;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.speed = -10;
				}
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.speed = 0;
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void loadEnemies() {
		int x = 400;
		int gap = 400;
		int speed = 5;
		for(int i = 0; i<enemies.length; i++) {
			enemies[i] = new Enemy(x, speed);
			x = x+gap;
			speed = speed + 5;
		}
	}
	private void gameLoop() {
		timer = new Timer(50, (e)->repaint());
		timer.start();
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage = ImageIO.read(Board.class.getResource("game-bg.jpg"));
		} catch (IOException e) {
			System.out.println("Backgroung Image Not Found....");
			System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void printEnemies(Graphics pen) {
		for (Enemy enemy : enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen); //clean up
		//all printing/painting logic will be here
		pen.drawImage(backgroundImage,0,0,1535,820, null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		gameOver(pen);
	}
}
