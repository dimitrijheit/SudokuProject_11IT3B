
public class SudokuTest {

	public static void main(String[] args) throws Exception{
		SudokuData startData = new SudokuData();
		startData.setValue( new Position( 8, 1),  4 );
		SudokuDocument doc = new SudokuDocument(startData);
		SudokuActionInterface a1 = new SetAction( new Position( 7, 6),  4 );
		SudokuActionInterface a2 = new SetAction( new Position( 5, 6),  7 );
		SudokuActionInterface a3 = new SetAction( new Position( 8, 8),  4 );
		a1.execute( doc );
		a2.execute( doc );
		a1.unexecute(doc);
		a3.execute( doc );
		doc.undoLastAction();
		
		doc.save( "foo.txt") ;
	}

}
