

public class SudokuData {
	private int size = 9;
	private int[][] data;
	public SudokuData( int size )
	{
		this.size = size;
		data = new int[size][size];
	}
	public int getValue( Position pos )
	{
		return this.data[ pos.getRow() ][ pos.getColumn() ];
	}
	public void setValue( Position pos, int value )
	{
		System.out.println( "SudokuData set " + pos.toString() + " to " + value );
		this.data[ pos.getRow() ][ pos.getColumn() ] = value;
	}
	
}
