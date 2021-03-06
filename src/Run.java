import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import processing.core.PApplet;

public class Run{
	public static void main (String[] args){
		
		final Grid grid = new Grid();
		final KinectToMatrix km = new KinectToMatrix(grid);
		km.init();
		EventQueue.invokeLater(new Runnable() {
			@Override 
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}
				
				JFrame window = new ComboWindow(grid, km);
				window.setVisible(true);
				
			}
		});
		MusicPlayer musicPlayer = new MusicPlayer();
		musicPlayer.run(grid);
	}
	
}
