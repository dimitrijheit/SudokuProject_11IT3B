import java.util.ArrayList;

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
		currentData.setValue(pos, value);
	}
	public void appendAction( SudokuActionInterface a )
	{
		this.performedActions.add( a );
	}
}
