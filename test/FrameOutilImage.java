import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class FrameOutilImage extends JFrame
{
	private JPanel panel;
	private int largeur;
	private int hauteur;

	public FrameOutilImage()
	{
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
		this.panel = new PanelOutilImage();
		this.add( this.panel );

		/* Activation */
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		/*this.getRootPane().putClientProperty("Window.alpha", 0.8f);
		this.getRootPane().setWindowDecorationStyle( JRootPane.NONE );*/ //a regarder
		
		//this.setOpacity​((float)(0.0));non
		//this.setGlassPane( this.panel ); non
	}
	
	public static void main( String[] args )
	{
		new FrameOutilImage();
	}
}
