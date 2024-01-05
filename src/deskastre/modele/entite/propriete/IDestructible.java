package deskastre.modele.entite.propriete;

/**
 * Objet pouvant se prendre des degats
 * @autor : Maximeuuu
 */
public interface IDestructible
{
	/*public boolean getPvMax();
	public boolean getPvActuel();

	public void setPvMax( int pv );
	public void setPvActuel( int pv );*/

	public boolean perdrePv();
	public boolean gagnerPv();

	public boolean estDetruit();

	public void detruire();
	public void reconstruire();
}
