


public class SetAction extends SudokuAction {
	private Position pos;
	private int value;
	public SetAction( Position pos, int value )
	{
		this.pos = pos;
		this.value = value;
	}
	@Override
	public void execute( SudokuDocument doc ) {
		doc.setValue( this.pos, this.value);
		super.execute( doc );
	}

	@Override
	public void unexecute( SudokuDocument doc ) {
		super.unexecute( doc );
	}

}
