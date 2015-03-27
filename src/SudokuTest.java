
public class SudokuTest {

	public static void main(String[] args) {
		SudokuData startData = new SudokuData( 9 );
		SudokuDocument doc = new SudokuDocument(startData);
		SudokuActionInterface a1 = new SetAction( new Position( 7, 8),  4 );
		SudokuActionInterface a2 = new SetAction( new Position( 1, 3),  7 );
		SudokuActionInterface a3 = new SetAction( new Position( 7, 8),  4 );
		a1.execute( doc );
		a2.execute( doc );
		a3.execute( doc );
	}

}
