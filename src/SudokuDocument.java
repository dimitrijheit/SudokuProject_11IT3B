import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class SudokuDocument {
	public SudokuData startData;
	public SudokuData currentData;
	public ArrayList<SudokuActionInterface> performedActions;

	public SudokuDocument(SudokuData startData) throws CloneNotSupportedException {
		this.startData = startData;
		this.currentData = this.startData.copy();
		this.performedActions = new ArrayList<SudokuActionInterface>();
	}

	public void validateValueSet(Position pos, int value) {
		// Check row for equal entries
		for (int entry : this.currentData.getRow(pos.getRow())) {
			if (entry != -1 && entry == value) {
				 throw new RuntimeException("Value already in row");
			}
		}

		// Check col for equal entries
		for (int entry : this.currentData.getColumn(pos.getColumn())) {
			if (entry != -1 && entry == value) {
				throw new RuntimeException("Value already in column");
			}
		}

		// Check block for equal entries
		for (int entry : this.currentData.getBlock(pos)) {
			if (entry != -1 && entry == value) {
				throw new RuntimeException("Value already in block");
			}
		}
	}
	public void save( String filename ) throws IOException
	{
		FileOutputStream fileOut = new FileOutputStream( filename);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject( this );
	}
	public void appendAction(SudokuActionInterface a) {
		this.performedActions.add(a);
	}

	public void removeAction(SudokuActionInterface a) {
		this.performedActions.remove(a);
	}

	@Override
	public String toString() {
		return "SudokuDocument [startData=" + startData + ", currentData="
				+ currentData + ", performedActions=" + performedActions
				+ ", toString()=" + super.toString() + "]";
	}
	
}
