/* 
 * Oscar Esparza
 * Created : 17 September 2018
 * Updated : 23 September 2018
 * GameWorld.java 
 * Homework 1 CSC 133 
 */

package com.mycompany.a1;

import java.util.Random;
import java.util.Vector;

public class GameWorld {
	Random rand = new Random();
	public Vector<GameObject> gameObjects = new Vector<GameObject>();
	private Asteroid asteroid;
	private NonePlayerShip nps;
	private MissleLauncher launcher;
	private PSMissleLauncher psLauncher;
	private SpaceStation station;
	private PlayerShip ps;
	private Missile missile;
	
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 768;
	public static final int MAXMISSILES = 10;
	private int lives = 3;
	private int score = 0;
	private int time = 0;
	
	private boolean dead() {
		if (lives == 0)
			return true;
		return false;
	}
	
	public GameWorld() {}
	
	public void init() {}

	public void addAsteroid() {
		asteroid = new Asteroid();
		asteroid.setSize(rand.nextInt(24) + 6); 	// 6 - 30
		asteroid.setSpeed(rand.nextInt(10));		// 0 - 10
		asteroid.setDirection(rand.nextInt(359));	// 0 - 359
		asteroid.setColor(255, 0, 0);				// red
		asteroid.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		gameObjects.add(asteroid);
		System.out.println("Asteroid has been created");
	}

	public void addNonePlayerShip() {
		int direction = rand.nextInt(359);			// 0 - 359
		nps = new NonePlayerShip();
		nps.setSize((rand.nextInt(1) + 1) * 10); 	// 10 or 20
		nps.setMissleCount(MAXMISSILES);			// 10
		nps.setSpeed(rand.nextInt(10));				// 0 - 10
		nps.setDirection(direction);				// 0 - 359
		nps.setColor(255, 255, 0);					// yellow
		nps.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		
		launcher = nps.getLauncher();
		launcher.setSpeed(rand.nextInt(10));	// 0 - 10
		launcher.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		launcher.setDirection(direction);		// 0 - 359
		launcher.setColor(255, 255, 100);		// lighter yellow
		nps.setMissleLaucher(launcher);
		gameObjects.add(nps);
		System.out.println("NPS has been created");
	}

	public void addSpaceStation() {
		station = new SpaceStation();
		station.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		station.setColor(0, 255, 0);			// green
		station.setID();
		station.setBlinkRate(rand.nextInt(4));	// 0 - 4
		gameObjects.add(station);
		System.out.println("SpaceStation has been created");
	}

	public void addPlayerShip() {
		// checks to see if there is a ship already
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				System.out.println("PlayerShip already exsists!");
				return;
			}		
		}
		
		ps = new PlayerShip();
		ps.setMissleCount(MAXMISSILES);
		ps.setSpeed(0);
		ps.setDirection(0);							// points north
		ps.setColor(0, 0, 0);						// black
		ps.setLocation((WIDTH / 2), (HEIGHT / 2));	// center of map

		
		launcher = ps.getLauncher();
		launcher.setSpeed(0);	// 0 - 10
		launcher.setLocation((WIDTH / 2), (HEIGHT / 2));
		launcher.setDirection(rand.nextInt(359));	// 0 - 359
		launcher.setColor(50, 50, 50);		// grey
		ps.setMissleLaucher(launcher);
		gameObjects.add(ps);
		System.out.println("Player Ship has been created");
	}
	
	public void increaseSpeed() {
		// checks to see if there is a ship already
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				ps.increaseSpeed();
				psLauncher.increaseSpeed(); // since ps and its launcher must have matching speed
				return;
			}		
		}
		System.out.println("No PS exists so we can increment the speed!");
	}

	public void decreaseSpeed() {
		// checks to see if there is a ship already
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				ps.decreaseSpeed();
				psLauncher.decreaseSpeed(); // since ps and its launcher must have matching speed
				return;
			}		
		}
		System.out.println("No PS exists so we can increment the speed!");
	}
	
	public void turnLeft() {
		if(ps != null) { ps.turnLeft();}
		else {System.out.println("There is no ship");}
	}
	
	public void turnRight() {
		if(ps != null) { ps.turnRight();}
		else {System.out.println("There is no ship");}
	}

	public void turnMissleLauncher() {
		if(psLauncher != null) { psLauncher.turnLeft();}
		else {System.out.println("There is no ship or Missile Launcher");}
	}

	public void fireMissile() {
		if((ps != null) && (ps.getMissleCount() > 0)) { 
			missile = new Missile();
			launcher = ps.getLauncher();
			missile.setDirection(launcher.getDirection()); // since a ps launcher could have diff direction than ps
			missile.setSpeed(ps.getSpeed() + 1);
			missile.setLocation(ps.getXCoordinate(), ps.getYCoordinate()); //missile location is same as ps
			missile.setColor(50,50,50); // same as launcher (gray)
			missile.setFuel(10);	
			gameObjects.add(missile);
			ps.useMissile(1);
			System.out.println("You have fired a missile");
			System.out.println("Missile Count : " + ps.getMissleCount());
		}
		else if(ps == null) {System.out.println("There is no ship");}
		else System.out.println("You have no more missiles!");
	}

	public void launchMissile() {
		if((nps != null) && (nps.getMissleCount() > 0)) { 
			missile = new Missile();
			launcher = ps.getLauncher();
			missile.setDirection(launcher.getDirection());
			missile.setSpeed(nps.getSpeed() + 1);
			missile.setLocation(nps.getXCoordinate(), nps.getYCoordinate()); //missile location is same as ps missile launcher
			missile.setColor(50,50,50); // same as launcher (gray)
			missile.setFuel(10);	
			gameObjects.add(missile);
			nps.useMissile(1);
			System.out.println("You have fired a missile");
			System.out.println("Missile Count : " + nps.getMissleCount());
		}
		else if(nps == null) {System.out.println("There is no ship");}
		else System.out.println("You have no more missiles!");
	}

	public void jump() {
		if(ps != null) ps.setLocation((WIDTH / 2), (HEIGHT / 2));
		else System.out.println("There is no ship");
		}	// center of map

	public void reload() {
		if (ps != null) {
			if (ps.getMissleCount() == 10) System.out.println("You are already at max capacity");
			else ps.setMissleCount(MAXMISSILES);
		}
		else System.out.println("There is no ship");
	}
	// need to come back
	public void killAsteroid() {
		gameObjects.remove(asteroid);
		gameObjects.remove(missile);
		score++;
	}
	// need to come back
	public void killNPS() {
		gameObjects.remove(nps);
		gameObjects.remove(missile);
		score = score + 2;
	}
	
	public void killPS() {
		gameObjects.remove(ps);
		gameObjects.remove(missile);
		lives--;
		System.out.println("NPS has hit you, you have lost a life");
		if(dead()) System.exit(0);
	}

	public void crashAsteroid() {
		if((asteroid == null) || (ps == null)) {
			System.out.println("You need a ps and a asteroid!");
			return;
		}
		gameObjects.remove(asteroid);
		gameObjects.remove(ps);
		lives--;
		System.out.println("You have crashed into an asteroid, you have lost a life");
		if(dead()) System.exit(0);
	}
	
	public void crashNPS() {
		if((nps == null) || (ps == null)) {
			System.out.println("You need a ps and a nps!");
			return;
		}
		gameObjects.remove(nps);
		gameObjects.remove(ps);
		lives--;
		System.out.println("You have crashed into an nps, you have lost a life");
		if(dead()) System.exit(0);
	}
// needs work only removes 1 sometimes	
	public void asteroidCollision() {
		// have to do this because doing .remove(a) twice only removes 1
		GameObject a1 = null;
		GameObject a2 = null;
		
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Asteroid) {
				if(a1 == null) a1 = gameObjects.get(i);
				else {
					a2 = gameObjects.get(i);
					break;
				}
			}
		}
		
		if(a1 == null || a2 == null) {
			System.out.println("You need at least 2 asteroids for them to collide.");
			return;
		}
		
		System.out.println("Two asteroids have collided with each other.");
		gameObjects.remove(a1);
		gameObjects.remove(a2);
		
	}
	
	public void npsAsteroidCollision()
	{
		gameObjects.remove(asteroid);
		gameObjects.remove(nps);
	}
	
	public void tick() { //game clock has ticked
		time++;
		
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.elementAt(i) instanceof IMovable) {
				IMovable mObj = (IMovable)gameObjects.elementAt(i);
				mObj.move();
			}
		}
		
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.elementAt(i) instanceof Missile) {
				Missile mObj = (Missile)gameObjects.elementAt(i);
				if(mObj.useFuel()) {	//if out of fuel
					System.out.println("Missile has run out of fuel");
					gameObjects.remove(i);	// removes the missile
				}
			}
		}
		// blinks
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.elementAt(i) instanceof SpaceStation) {
				SpaceStation mObj = (SpaceStation)gameObjects.elementAt(i);
				if((mObj.getBlinkRate() % time) == 0) System.out.print("BLINK");
			}
		}
	}
	
	public void print() {
		System.out.println("Current score : [" + score + "] " +
				           "Current time :[" + time + "]");
		if(ps != null) System.out.println("Current missiles available : [" + ps.getMissleCount() + "]");
	}
	public void map() {
		for(Object obj : gameObjects) {
			// Print each object
			System.out.println(obj);
		}
	}
}
