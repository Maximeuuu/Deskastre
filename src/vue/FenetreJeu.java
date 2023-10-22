package deskastre.vue;

import deskastre.Controleur;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class FenetreJeu extends JFrame
{
	private JPanel panel;
	private int largeur;
	private int hauteur;
	private Controleur ctrl;

	public FenetreJeu( Controleur ctrl )
	{
		this.ctrl = ctrl;
		
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if( gd.getDefaultConfiguration().isTranslucencyCapable() )
		{
			this.setUndecorated(true);
			this.setBackground( new Color(0,0,0,0) );
		}

		/* Dimensions */
		this.setResizable(false);
		this.setSize(1920, 1080);

		/*Composants*/
		this.panel = new PanelJeu( this.ctrl );
		this.add( this.panel );

		/* Activation */
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		/*this.getRootPane().putClientProperty("Window.alpha", 0.8f);
		this.getRootPane().setWindowDecorationStyle( JRootPane.NONE );*/ //a regarder

		//this.setOpacity​((float)(0.0));non
		//this.setGlassPane( this.panel ); non
	}
}
