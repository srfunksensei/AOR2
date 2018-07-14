package rs.etf.aor.components;

public abstract class Combining extends Component {

    private int cnt;
    protected int[] inValues;
    protected int[] outValues;

    public Combining(int numIn, int numOut) {
        super(numIn, numOut);
        cnt = 0;
        inValues = new int[numIn];
        outValues = new int[numOut];
    }

    @Override
    public void refreshValue(int newValue, int port) {

        inValues[port] = newValue;
        cnt++;

        calculateState();
        refreshNextLines();
        cnt = 0;
    }

    public abstract void calculateState();

    public void refreshNextLines() {
        for (int i = 0; i < outLines.length; i++) {
            if (outLines[i] != null) {
                outLines[i].refreshValue(outValues[outLines[i].getPreviousCompPort()]);
            }
        }

    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
