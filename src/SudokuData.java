import java.util.Arrays;

public class SudokuData {
	static private int blockSize = 3;
	static private int size = blockSize * blockSize;
	private int[][] data;

	public SudokuData() {
		this.data = new int[size][size];
		for (int[] row : this.data) {
			Arrays.fill(row, -1);
		}
	}

	public int[] getRow(int row) {
		return this.data[row];
	}

	public int[] getColumn(int col) {
		int[] out = new int[this.size];
		for (int i = 0; i < this.size; ++i) {
			out[i] = this.data[i][col];
		}
		return out;
	}

	public int[] getBlock( Position pos ) {
		int[] out = new int[size];
		for (int i = 0; i < this.blockSize; ++i) {
			for (int j = 0; j < this.blockSize; ++j) {
				out[i * blockSize + j] = this.data[i + pos.getRow() / 3 * 3][j + pos.getColumn() / 3 * 3];
			}
		}
		return out;
	}

	public int getValue(Position pos) {
		return this.data[pos.getRow()][pos.getColumn()];
	}

	public void setValue(Position pos, int value) {
		System.out.println("SudokuData set " + pos.toString() + " to " + value);
		this.data[pos.getRow()][pos.getColumn()] = value;
	}

	@Override
	public String toString() {
		String data = new String();
		for (int[] row : this.data) {
			data += Arrays.toString( row );
		}
		return "SudokuData [data=" + data + "]";
	}
	

}
