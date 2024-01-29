package deskastre.vue;

import deskastre.Controleur;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

/**
 * Fenetre principale du jeu
 * @autor : Maximeuuu
 */
public class FenetreJeu extends JFrame implements KeyListener
{
	private Controleur ctrl;
	private PanelJeu panel;

	public FenetreJeu( Controleur ctrl )
	{
		/* Attribut */
		this.ctrl = ctrl;

		/* Proprietes */
		this.setIgnoreRepaint(true);
		this.setUndecorated(true);
		if( this.ctrl.transparenceFenetrePossible() )
		{
			this.setBackground( new Color(0,0,0,0) );
		}

		/* Position */
		this.setLocation(0,0);

		/* Dimensions */
		this.setResizable(false);
		this.setSize( this.ctrl.getDimensionEcranUtilisateur() );

		/* Composant */
		this.panel = new PanelJeu( this.ctrl );
		this.add( this.panel );

		/* Activation */
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	@Override
    public void keyTyped(KeyEvent e) {}
	@Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e)
	{
		boolean ctrl_C = (  e.getKeyCode() == KeyEvent.VK_C && (e.getModifiersEx() & InputEvent.CTRL_DOWN_MASK) != 0  );
		boolean echap = (  e.getKeyCode() == KeyEvent.VK_ESCAPE  );

		if( ctrl_C || echap )
		{
            System.exit(0);
        }
    }
}
