
public abstract class SudokuAction implements SudokuActionInterface {

	@Override
	public void execute(SudokuDocument doc) {
		doc.appendAction( this );

	}

	@Override
	public void unexecute(SudokuDocument doc) {
		doc.removeAction( this );

	}

}
