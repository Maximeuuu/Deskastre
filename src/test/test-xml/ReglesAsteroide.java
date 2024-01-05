import java.awt.Image;

/**
 * Propriétés des asteroides
 * @autor : Maximeuuu
 */
public class ReglesAsteroide extends AbstractRegles
{
	private double probaApparition;
	private int pvMin;//Integer ?
	private int pvMax;
	private double velociteXMin;
	private double velociteXMax;
	private double velociteYMin;
	private double velociteYMax;
	
	public ReglesAsteroide( String[] images, double pa, int pvMin, int pvMax, double vxMin, double vxMax, double vyMin, double vyMax )
	{
		super( images );
		this.probaApparition = pa;
		this.pvMin = pvMin;
		this.pvMax = pvMax;
		this.velociteXMin = vxMin;
		this.velociteXMax = vxMax;
		this.velociteYMin = vyMin;
		this.velociteYMax = vyMax;
	}
	
	public double getProbaApparition(){ return this.probaApparition; }
	
	public int getPv()
	{
		return pvMin + (int)(Math.random() * ((pvMax - pvMin) + 1));
	}
	
	public double getVelociteX()
	{
		return ReglesAsteroide.getVelocite( this.velociteXMin, this.velociteXMax );
	}
	
	public double getVelociteY()
	{
		return ReglesAsteroide.getVelocite( this.velociteYMin, this.velociteYMax );
	}
	
	private static final double getVelocite( double vMin, double vMax )
	{
		return vMin + Math.random() * ((vMax - vMin) + 1);
	}
	
	public String toString()
	{
		String s = super.toString()+"\n";
		
		s+="proba : "+this.probaApparition+"\n";
		s+="pvMin : "+this.pvMin+"\n";
		s+="pvMax : "+this.pvMax+"\n";
		s+="vXmin : "+this.velociteXMin+"\n";
		s+="VXmax : "+this.velociteXMax+"\n";
		s+="vYmin : "+this.velociteYMin+"\n";
		s+="vYmax : "+this.velociteYMax;
		
		return s;
	}
}

