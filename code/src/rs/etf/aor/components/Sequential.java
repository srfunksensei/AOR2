package rs.etf.aor.components;

public abstract class Sequential extends Component {

    protected int state;
    protected int[] inValues, outValues;

    //sequental component always has one output port
    public Sequential(int numIn, int state) {
        this(numIn, 1, state);
        inValues = new int[numIn];
        outValues = new int[1];

        for (int i = 0; i < numIn; i++) {
            inValues[i] = 0;
        }

        outValues[0] = state;

    }

    //if you need single bit value than sequental component has more than one output port
    public Sequential(int numIn, int numOut, int state) {
        super(numIn, numOut);
        this.state = state;
        inValues = new int[numIn];
        outValues = new int[numOut];

        for (int i = 0; i < numIn; i++) {
            inValues[i] = 0;
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        outValues[0] = state;
    }

    public void refreshSequential() {
        calculateState();
    }

    @Override
    public void refreshValue(int newValue, int port) {
        inValues[port] = newValue;

    }

    protected abstract void calculateState();

    public void clock() {
        for (int i = 0; i < outLines.length; i++) {
            if (outLines[i] != null) {
                outLines[i].refreshValue(outValues[i]);
            }
        }
    }
}
