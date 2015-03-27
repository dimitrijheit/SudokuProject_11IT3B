import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class SudokuDocument {
	private SudokuData startData;
	private SudokuData currentData;
	private ArrayList<SudokuActionInterface> performedActions;

	public SudokuDocument( SudokuData startData )
	{
		this.startData = startData;
		this.currentData = this.startData;
		this.performedActions = new ArrayList<SudokuActionInterface>();
	}
	public void setValue( Position pos, int value )
	{
		int current_val = currentData.getValue(pos);
		if ( current_val != -1 )
		{
			throw new RuntimeException( "Cannot set data twice" );
		}
		boolean check = this.validateValueSet(pos, value);
		if ( !check ) {
			System.out.println( "Cannot enter data, invalid " );
			System.out.println( "currentData: " + this.currentData );
		}
		currentData.setValue(pos, value);
	}
	public boolean validateValueSet( Position pos, int value )
	{
		// Check row for equal entries
		for (int entry : this.currentData.getRow(pos.getRow()) )
		{
			if( entry != -1 && entry == value )
			{

				System.out.println( "Value already in row" );
				return false;
			}
		}
		
		// Check col for equal entries
		for (int entry : this.currentData.getColumn(pos.getColumn()) )
		{
			if( entry != -1 && entry == value )
			{
				System.out.println( "Value already in column" );
				return false;
			}
		}
		
		// Check block for equal entries
		for (int entry : this.currentData.getBlock(pos) )
		{
			if( entry != -1 && entry == value )
			{
				System.out.println( "Value already in block" );
				return false;
			}
		}
		
		return true;
	}
	public void appendAction( SudokuActionInterface a )
	{
		this.performedActions.add( a );
	}
}
