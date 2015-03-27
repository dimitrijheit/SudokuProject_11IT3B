
public class SudokuTest {

	public static void main(String[] args) {
		SudokuData startData = new SudokuData( 9 );
		startData.setValue( new Position( 5, 6),  8);
		SudokuDocument doc = new SudokuDocument(startData);
	}

}
