package deskastre.vue;

import deskastre.Controleur;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

/**
 * Fenetre principale du jeu
 * @autor : Maximeuuu
 */
public class FenetreJeu extends JFrame
{
	private PanelJeu panel;
	private int largeur;
	private int hauteur;
	private Controleur ctrl;

	public FenetreJeu( Controleur ctrl )
	{
		this.ctrl = ctrl;

		if( ConfigurationInterface.transparence() )
		{
			this.setUndecorated(true);
			this.setBackground( new Color(0,0,0,0) );
		}

		this.setLocation(0,0);

		/* Dimensions */
		this.setResizable(false);
		this.setSize( ConfigurationInterface.ecran() );

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
