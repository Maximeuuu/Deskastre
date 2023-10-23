package deskastre.modele.entite;

public interface IDeplacable
{
	//public int getVelociteX();
	//public int getVelociteY();
	public void arreter();
	public void avancer();
	public void setVelocite( double vx, double vy );
	//public void accelerer();
	//public void decelerer();
	//public void deplacer( int x, int y );
}
