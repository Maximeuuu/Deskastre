package deskastre.vue;

import javax.swing.*;
import java.awt.Image;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class PanelImage extends JPanel implements MouseListener
{
	private Image image;

	public PanelImage( String nomImage )
	{
		this.image = getToolkit().getImage( nomImage );
		this.setBackground( new Color(0,0,0,0) );
		this.repaint();
		this.addMouseListener( this );
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage( this.image, 0, 0, ( (Component)(this.getParent()) ).getWidth(), ( (Component)(this.getParent()) ).getHeight(), this);
	}

	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("cliqué");
	}
}
