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
		this.setIgnoreRepaint( true );

		if( this.ctrl.fenetreEstTransparente() )
		{
			this.setUndecorated(true);
			this.setBackground( new Color(0,0,0,0) );
		}

		this.setLocation(0,0);

		/* Dimensions */
		this.setResizable(false);
		this.setSize( this.ctrl.getDimensionEcran() );

		/*Composants*/
		this.panel = new PanelJeu( this.ctrl );
		this.add( this.panel );

		/* Activation */
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}

	//TODO
	/*
		* Detection F11 -> fullScreen
		* CTRL+C -> exit(0)
	*/
}
