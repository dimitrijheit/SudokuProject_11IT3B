
public class Controller {
	private SudokuDocument doc;
	public Controller( SudokuDocument doc )
	{
		this.doc = doc;
	}
	void setValue( Position pos, int value ) throws Exception
	{
		SudokuAction a = new SetValueAction(pos, value);
		a.execute(doc);
	}
	void removeValue( Position pos) throws Exception
	{
		SudokuAction a = new SetValueAction(pos, -1 );
		a.execute(doc);
	}

	public void undoLastAction() {
		doc.undoLastAction();
	}

}
