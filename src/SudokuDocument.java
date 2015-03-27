import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class SudokuDocument {
	private SudokuData startData;
	private SudokuData currentData;
	private ArrayList<SudokuActionInterface> performedActions;

	public SudokuDocument(SudokuData startData) throws CloneNotSupportedException {
		this.startData = startData;
		this.currentData = this.startData.copy();
		this.performedActions = new ArrayList<SudokuActionInterface>();
	}

	public void clearValue(Position pos) {
		int startValue = this.startData.getValue(pos);
		if (startValue != -1) {
			throw new RuntimeException("Cannot undo start data: " + pos + " " + startValue);
		}
		currentData.setValue(pos, -1);
	}

	public boolean setValue(Position pos, int value) {
		int current_val = currentData.getValue(pos);
		if (current_val != -1) {
			throw new RuntimeException("Cannot set data twice");
		}
		boolean check = this.validateValueSet(pos, value);
		if (!check) {
			System.out.println("Entered incorrect data ");
			System.out.println("currentData: " + this.currentData);
			return false;
		}
		this.currentData.setValue(pos, value);
		if (currentData.isFinished()) {
			System.out.println("Sudoku finished");
		}
		return true;
	}

	public boolean validateValueSet(Position pos, int value) {
		// Check row for equal entries
		for (int entry : this.currentData.getRow(pos.getRow())) {
			if (entry != -1 && entry == value) {
				System.out.println("Value already in row");
				return false;
			}
		}

		// Check col for equal entries
		for (int entry : this.currentData.getColumn(pos.getColumn())) {
			if (entry != -1 && entry == value) {
				System.out.println("Value already in column");
				return false;
			}
		}

		// Check block for equal entries
		for (int entry : this.currentData.getBlock(pos)) {
			if (entry != -1 && entry == value) {
				System.out.println("Value already in block");
				return false;
			}
		}

		return true;
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

	public void undoLastAction() {
		if (this.performedActions.isEmpty()) {
			return;
		}

		System.out.println("Undoing last Action");
		SudokuActionInterface a = this.performedActions
				.get(this.performedActions.size() - 1);
		a.unexecute(this);

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
