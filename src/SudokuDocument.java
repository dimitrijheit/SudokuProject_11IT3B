
public class SudokuDocument {
	private SudokuData startData;
	private SudokuData currentData;

	public SudokuDocument( SudokuData startData )
	{
		this.startData = startData;
		this.currentData = this.startData;
	}
}
