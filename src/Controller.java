public class Controller {
	private SudokuDocument doc;

	public Controller(SudokuDocument doc) {
		this.doc = doc;
	}

	void setValue(Position pos, int value) throws Exception {
		SudokuAction a = new SetValueAction(pos, value);
		a.execute(doc);
	}

	void removeValue(Position pos) throws Exception {
		SudokuAction a = new SetValueAction(pos, -1);
		a.execute(doc);
	}

	public void undoLastAction() {
		if (doc.performedActions.isEmpty()) {
			return;
		}

		System.out.println("Undoing last Action");
		SudokuActionInterface a = doc.performedActions.get(doc.performedActions
				.size() - 1);
		a.unexecute(doc);
	}

}
