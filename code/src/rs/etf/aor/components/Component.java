package rs.etf.aor.components;

public abstract class Component {
	
	protected int numIn, numOut;
	protected Line[] outLines;
	
	public Component(int numIn, int numOut) {
		super();
		this.numIn = numIn;
		this.numOut = numOut;
		outLines = new Line[numOut];
	}

	public int getNumIn() {
		return numIn;
	}

	public void setNumIn(int numIn) {
		this.numIn = numIn;
	}

	public int getNumOut() {
		return numOut;
	}

	public void setNumOut(int numOut) {
		this.numOut = numOut;
	}

        public void setLine (Line line, int index) {
            outLines[index] = line;
            line.setPreviousCompPort(index);
        }
	
	public abstract void refreshValue(int newValue, int port);
}
