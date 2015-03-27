


public class SetValueAction extends SudokuAction {
	private Position pos;
	private int value;
	private int prevValue;
	public SetValueAction( Position pos, int value )
	{
		this.pos = pos;
		this.value = value;
	}
	@Override
	public void execute( SudokuDocument doc ) throws Exception{
		int startValue = doc.startData.getValue(pos);
		if (startValue != -1) {
			throw new RuntimeException("Cannot override start data!");
		}
		this.prevValue = doc.currentData.getValue( this.pos );
		if ( value != -1 ) {
			doc.validateValueSet(pos, value);
			
		}
		doc.currentData.setValue( this.pos, this.value);
		super.execute( doc );
	}

	@Override
	public void unexecute( SudokuDocument doc ) {
		doc.currentData.setValue(pos, prevValue);
		super.unexecute( doc );
	}
	@Override
	public String toString() {
		return "SetValueAction [pos=" + pos + ", value=" + value
				+ ", prevValue=" + prevValue + ", toString()="
				+ super.toString() + "]";
	}

}
