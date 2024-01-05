import java.util.*;
import java.awt.Point;

public class TestObjets
{
	public TestObjets()
	{
		List<Object> ensObjet = new ArrayList<Object>();

		ensObjet.add( new MonPoint(1,1, 'a') );
		ensObjet.add( new MonPoint(2,1, 'b') );
		ensObjet.add( new MonPoint(3,1, 'c') );
		ensObjet.add( new MonPoint(4,1, 'a') );
		ensObjet.add( new MonPoint(1,1, 'b') );

		for( Object o : ensObjet )
		{
			System.out.println( o );
		}
		System.out.println("\n\n");

		ensObjet.remove( 4 );

		for( Object o : ensObjet )
		{
			System.out.println( o );
		}
	}

	public static void main( String[] args )
	{
		new TestObjets();
	}

	public class MonPoint extends Point
	{
		private char id;

		public MonPoint( int x, int y, char id )
		{
			super(x,y);
			this.id = id;
		}
	}
}
