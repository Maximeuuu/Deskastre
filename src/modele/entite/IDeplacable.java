package deskastre.modele.entite;

public interface IDeplacable
{
	public int getVelociteX();
	public int getVelociteY();
	public void arreter();

	public void deplacer( int x, int y );
}
