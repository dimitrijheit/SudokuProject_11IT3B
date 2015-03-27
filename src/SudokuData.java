import java.util.Arrays;

public class SudokuData {
	static public final int blockSize = 3;
	static final public int size = blockSize * blockSize;
	private int[] data;

	public SudokuData() {
		this.data = new int[size * size];
		Arrays.fill(this.data, -1);
	}
	private SudokuData( int[] data )
	{
		this.data = data;
	}
	public SudokuData copy()
	{
		return new SudokuData( Arrays.copyOf( this.data, SudokuData.size * SudokuData.size ) );
	}

	public boolean isFinished() {
		for (int entry : this.data) {
			if (entry == -1) {
				return false;
			}
		}
		return true;
	}

	public int[] getRow(int row) {
		return Arrays.copyOfRange(this.data, row * size, (row + 1) * size);
	}

	public int[] getColumn(int col) {
		int[] out = new int[this.size];
		for (int i = 0; i < this.size; ++i) {
			out[i] = this.getValue(new Position(col, i));
		}
		return out;
	}

	public int[] getBlock(Position pos) {
		int[] out = new int[size];
		for (int i = 0; i < this.blockSize; ++i) {
			for (int j = 0; j < this.blockSize; ++j) {
				out[i * blockSize + j] = this.getValue(new Position(i
						+ pos.getRow() / 3 * 3, pos.getColumn() / 3 * 3));
			}
		}
		return out;
	}

	public int getValue(Position pos) {
		return this.data[pos.getRow() * size + pos.getColumn()];
	}

	public void setValue(Position pos, int value) {
		System.out.println("SudokuData set " + pos.toString() + " to " + value);
		this.data[pos.getRow() * size + pos.getColumn()] = value;
	}

	@Override
	public String toString() {
		String data = new String();
		data += Arrays.toString(this.data);
		return "SudokuData [data=" + data + "]";
	}

}
