/* 
 * Oscar Esparza
 * Created : 17 September 2018
 * Updated : 3 October 2018
 * Game.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.commands.AccelerateCommand;
import com.mycompany.a3.commands.AddAsteroidCommand;
import com.mycompany.a3.commands.AddNPSCommand;
import com.mycompany.a3.commands.AddPSCommand;
import com.mycompany.a3.commands.AddSSCommand;
import com.mycompany.a3.commands.DecelerateCommand;
import com.mycompany.a3.commands.FireMissileCommand;
import com.mycompany.a3.commands.JumpCommand;
import com.mycompany.a3.commands.LaunchMissileCommand;
import com.mycompany.a3.commands.MapCommand;
import com.mycompany.a3.commands.PauseCommand;
import com.mycompany.a3.commands.RefuelCommand;
import com.mycompany.a3.commands.ReloadCommand;
import com.mycompany.a3.commands.TurnLeftCommand;
import com.mycompany.a3.commands.TurnMissileLauncherLeftCommand;
import com.mycompany.a3.commands.TurnMissileLauncherRightCommand;
import com.mycompany.a3.commands.TurnRightCommand;
import com.mycompany.a3.views.MapView;
import com.mycompany.a3.views.PointsView;

public class Game extends Form implements Runnable{
	private GameWorld gw;	// observable
	private MapView mv;		// observer of GameWord
	private PointsView pv;	// "                  "
	
	private int topGap = 4;
	private int bottomGap = 4;
	private int leftGap = 1;
	private int rightGap = 1;
	
	// buttons are private static so we can modify them in GameWorld
	private static Button pause = new Button("Pause");
	private static Button addAsteroid = new Button("Add Asteroid");
	private static Button addNPS = new Button("Add NPS");
	private static Button addSS = new Button("Add Space Station");
	private static Button addPS = new Button("Add Player Ship");
	private static Button accelerate = new Button("Accelerate");
	private static Button decelerate = new Button("Decelerate");
	private static Button turnLeft = new Button("Turn Left");
	private static Button turnRight = new Button("Turn Right");
	private static Button turnMSL = new Button("Turn Missile Launcher Left");
	private static Button turnMSR = new Button("Turn Missile Launcher Right");		
	private static Button fireMissile = new Button("Fire Missile");
	private static Button LaunchMissile = new Button("Launch Missile");
	private static Button Jump = new Button("Jump");
	private static Button Reload = new Button("Reload");
	private static Button map = new Button("Map");
	private static Button refuel = new Button("Refuel");
	
	public Game() {		
		UITimer timer = new UITimer(this);
		timer.schedule(20, true, this);
		
		gw = new GameWorld();		// create "Observable"
		mv = new MapView(gw);			// create an "Observer" for the map
		pv = new PointsView();	// create an "Observer" for the points
		gw.addObserver(mv);			// register the map observer
		gw.addObserver(pv);			// register the points observer
		
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		Command overFlowItm1 = new Command("Not Implemented");
		myToolbar.addCommandToOverflowMenu(overFlowItm1);			//Adds 3 vertical dots menu at top right
		myToolbar.getAllStyles().setFgColor(ColorUtil.WHITE); 
		myToolbar.getAllStyles().setBgColor(ColorUtil.BLACK);
		
		Command sideMenuSound = new Command("Sound") {
			public void actionPerformed(ActionEvent e) {
				gw.toggleSound();
			}
		};
		
		myToolbar.addCommandToSideMenu(sideMenuSound);
		Command sideMenuNew = new Command("New Game");
		myToolbar.addCommandToSideMenu(sideMenuNew);
		Command sideMenuSave = new Command("Save Game");
		myToolbar.addCommandToSideMenu(sideMenuSave);
		Command sideMenuUndo = new Command("Undo");
		myToolbar.addCommandToSideMenu(sideMenuUndo);
		Command sideMenuAbout = new Command("About") {
			public void actionPerformed(ActionEvent e) {Dialog.show("About", "Creator: Oscar Esparza\n\nCourse: CSC133", "OK", null);}
		};
		myToolbar.addCommandToSideMenu(sideMenuAbout);
		
		Command sideMenuQuit = new Command("Quit") {
			public void actionPerformed(ActionEvent e) {
				 new ClosingApp();
			}
		};
		
		myToolbar.addCommandToSideMenu(sideMenuQuit);
		
		setLayout(new BorderLayout());
		this.setTitle("Asteroid Game");
		add(BorderLayout.NORTH, pv);
		
		//left Container with the BoxLayout positioned on the west 
  		Container leftContainer = new Container();
  		leftContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
  		
  		// Asteroid Stuff
  		addAsteroid.getAllStyles().setBgTransparency(255);  //255 for not Transparent
  		addAsteroid.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		addAsteroid.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		addAsteroid.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		add(BorderLayout.WEST,leftContainer);
  		leftContainer.add(addAsteroid);
  		AddAsteroidCommand myAddAsteroid = new AddAsteroidCommand(gw);
  		addAsteroid.setCommand(myAddAsteroid);
  		addKeyListener('a', myAddAsteroid);
		
  		// NPS Stuff
  		addNPS.getAllStyles().setBgTransparency(255);  //255 for not Transparent
  		addNPS.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		addNPS.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		addNPS.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(addNPS);
  		AddNPSCommand myAddNPS = new AddNPSCommand(gw);
  		addNPS.setCommand(myAddNPS);
  		addKeyListener('y', myAddNPS);
  		
  		// Space Station
  		addSS.getAllStyles().setBgTransparency(255);
  		addSS.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		addSS.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));
  		addSS.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(addSS);
  		AddSSCommand myAddSS = new AddSSCommand(gw);
  		addSS.setCommand(myAddSS);
  		addKeyListener('b', myAddSS);
  		
  		addPS.getAllStyles().setBgTransparency(255);
  		addPS.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		addPS.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));
  		addPS.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(addPS);
  		AddPSCommand myAddPS = new AddPSCommand(gw);
  		addPS.setCommand(myAddPS);
  		addKeyListener('s', myAddPS);
 
  		accelerate.getAllStyles().setBgTransparency(255);
  		accelerate.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		accelerate.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		accelerate.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(accelerate);
  		AccelerateCommand myAccelerate = new AccelerateCommand(gw);
  		accelerate.setCommand(myAccelerate);
  		addKeyListener('i', myAccelerate);	
  		addKeyListener(-91, myAccelerate);	//UP ARROW
  	
  		decelerate.getAllStyles().setBgTransparency(255);
  		decelerate.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		decelerate.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		decelerate.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(decelerate);
  		DecelerateCommand myDecelerate = new DecelerateCommand(gw);
  		decelerate.setCommand(myDecelerate);
  		addKeyListener('d', myDecelerate);	
  		addKeyListener(-92, myDecelerate);	//Down ARROW
  		
  		turnLeft.getAllStyles().setBgTransparency(255);
  		turnLeft.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		turnLeft.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		turnLeft.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(turnLeft);
  		TurnLeftCommand myTurnLeft = new TurnLeftCommand(gw);
  		turnLeft.setCommand(myTurnLeft);
  		addKeyListener('l', myTurnLeft);
  		addKeyListener(-93, myTurnLeft); //LEFT ARROW 
  		
  		turnRight.getAllStyles().setBgTransparency(255);
  		turnRight.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		turnRight.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		turnRight.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(turnRight);
  		TurnRightCommand myTurnRight = new TurnRightCommand(gw);
  		turnRight.setCommand(myTurnRight);
  		addKeyListener('r', myTurnRight);
  		addKeyListener(-94, myTurnRight); //Right ARROW 
  		
  		// KB DONT WORK
  		turnMSL.getAllStyles().setBgTransparency(255);
  		turnMSL.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		turnMSL.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		turnMSL.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(turnMSL);
  		TurnMissileLauncherLeftCommand myTurnMSL = new TurnMissileLauncherLeftCommand(gw);
  		turnMSL.setCommand(myTurnMSL);
  		addKeyListener(44, myTurnMSL);
  		
  		// KB DONT WORK
  		turnMSR.getAllStyles().setBgTransparency(255);
  		turnMSR.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		turnMSR.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		turnMSR.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(turnMSR);
  		TurnMissileLauncherRightCommand myTurnMSR = new TurnMissileLauncherRightCommand(gw);
  		turnMSR.setCommand(myTurnMSR);
  		addKeyListener(46, myTurnMSR);
  		
  		fireMissile.getAllStyles().setBgTransparency(255);
  		fireMissile.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		fireMissile.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		fireMissile.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(fireMissile);
  		FireMissileCommand myFireMissile = new FireMissileCommand(gw);
  		fireMissile.setCommand(myFireMissile);
  		addKeyListener('f', myFireMissile);
  		addKeyListener(-90, myFireMissile);	// spacebar
  		
  		LaunchMissile.getAllStyles().setBgTransparency(255);
  		LaunchMissile.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		LaunchMissile.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		LaunchMissile.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(LaunchMissile);
  		LaunchMissileCommand myLaunchMissile = new LaunchMissileCommand(gw);
  		LaunchMissile.setCommand(myLaunchMissile);
  		addKeyListener('L', myFireMissile);
  		
  		Jump.getAllStyles().setBgTransparency(255);
  		Jump.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		Jump.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		Jump.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(Jump);
  		JumpCommand myJump = new JumpCommand(gw);
  		Jump.setCommand(myJump);
  		addKeyListener('j', myJump);
  		
  		Reload.getAllStyles().setBgTransparency(255);
  		Reload.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		Reload.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		Reload.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(Reload);
  		ReloadCommand myReload = new ReloadCommand(gw);
  		Reload.setCommand(myReload);
  		addKeyListener('n', myReload);
  	
  		map.getAllStyles().setBgTransparency(255);
  		map.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		map.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		map.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(map);
  		MapCommand myMap = new MapCommand(gw);
  		map.setCommand(myMap);
  		addKeyListener('m', myMap);
  		
  		pause.getAllStyles().setBgTransparency(255);
  		pause.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		pause.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		pause.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(pause);
  		pause.setCommand(new PauseCommand(gw));
  		
  		refuel.getAllStyles().setBgTransparency(255);
  		refuel.getUnselectedStyle().setBgColor(ColorUtil.rgb(67, 97, 246));
  		refuel.getAllStyles().setFgColor(ColorUtil.rgb(255,255,255));  //flashes white on click
  		refuel.getAllStyles().setMargin(topGap, bottomGap, leftGap, rightGap);
  		leftContainer.add(refuel);
  		RefuelCommand myRefuel = new RefuelCommand(gw);
  		refuel.setCommand(myRefuel);
  		
		mv.getAllStyles().setBorder(Border.createLineBorder(8,ColorUtil.BLACK));
		add(BorderLayout.CENTER, mv);

		this.show();
	}

	@Override
	public void run() {
		if(gw.getPlay())
			gw.tick();	
	}
	public static Button pause() {return pause;}
	public static Button addAsteroid() {return addAsteroid;}
	public static Button addNPS() {return addNPS;}
	public static Button addSS() {return addSS;}
	public static Button addPS() {return addPS;}
	public static Button accelerate() {return accelerate;}
	public static Button decelerate() {return decelerate;}
	public static Button turnLeft() {return turnLeft;}
	public static Button turnRight() {return turnRight;}
	public static Button turnMSL() {return turnMSL;}
	public static Button turnMSR() {return turnMSR;}		
	public static Button fireMissile() {return fireMissile;}
	public static Button LaunchMissile() {return LaunchMissile;}
	public static Button Jump() {return Jump;}
	public static Button Reload() {return Reload;}
	public static Button map() {return map;}
	public static Button refuel() {return refuel;}
}
	