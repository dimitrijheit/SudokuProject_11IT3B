
public class SudokuTest {

	public static void main(String[] args) throws Exception{
		SudokuData startData = new SudokuData();
		startData.setValue( new Position( 8, 1),  4 );
		SudokuDocument doc = new SudokuDocument(startData);
		Controller c = new Controller(doc);
		c.setValue( new Position( 7, 6),  4 );
		c.setValue( new Position( 5, 6),  7 );
		c.setValue( new Position( 8, 8),  4 );
		doc.undoLastAction();
		
		//doc.save( "foo.txt") ;
	}

}
