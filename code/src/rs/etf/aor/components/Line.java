package rs.etf.aor.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Line {

    protected Component nextComp;
    protected int nextCompPort;
    protected int previousCompPort;
    protected int thikness;
    protected int value; //highZ = -1
    protected List<Point> points;
    protected List<Point> textPoints;

    public Line(Component nextComponent, int nextCompPort, int previousCompPort, int thik) {
        nextComp = nextComponent;
        this.nextCompPort = nextCompPort;
        this.previousCompPort = previousCompPort;
        thikness = thik;
        points = new LinkedList<Point>();
        textPoints = new LinkedList<Point>();
    }

    private String formatter(String hexString) {

        int desiredLength = 4;

        while (hexString.length() < desiredLength) {
            hexString = "0" + hexString;
        }

        return "0x" + hexString;

    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addTextPoint(Point point) {
        textPoints.add(point);
    }

    public void paint(Graphics g) {

        if (thikness == 1) {
            if (value == 1) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.blue);
            }
            if (value == -1) {
                g.setColor(new Color(128, 128, 0));
            }
        } else {
            if (value == -1) {
                g.setColor(new Color(128, 128, 0));
            } else {
                g.setColor(Color.lightGray);
            }
        }

        for (int i = 0; i < points.size() - 1; i++) {
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y);
            if (thikness > 1) {
                if (points.get(i).x == points.get(i + 1).x) {
                    g.drawLine(points.get(i).x + 1, points.get(i).y, points.get(i + 1).x + 1, points.get(i + 1).y);
                    g.drawLine(points.get(i).x - 1, points.get(i).y, points.get(i + 1).x - 1, points.get(i + 1).y);
                }
                if (points.get(i).y == points.get(i + 1).y) {
                    g.drawLine(points.get(i).x, points.get(i).y + 1, points.get(i + 1).x, points.get(i + 1).y + 1);
                    g.drawLine(points.get(i).x, points.get(i).y - 1, points.get(i + 1).x, points.get(i + 1).y - 1);
                }
            }
        }

        if (thikness > 1) {
            String stringValue;
            if (value != -1) {
                g.setColor(Color.lightGray);
                stringValue = formatter(Integer.toHexString(value));
            } else {
                g.setColor(new Color(128, 128, 0));
                stringValue = "highZ";
            }
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            for (int i = 0; i < textPoints.size(); i++) {
                g.drawString(stringValue, textPoints.get(i).x, textPoints.get(i).y);
            }
        }

    }

    private String getHexValue() {
        return "0x" + Integer.toHexString(value & 0x0000FFFF);
    }

    public void refreshValue(int newValue) {
        value = newValue;
        if (nextComp != null) {
            nextComp.refreshValue(value, nextCompPort);
        }
    }

    public int getNextCompPort() {
        return nextCompPort;
    }

    public void setNextCompPort(int nextCompPort) {
        this.nextCompPort = nextCompPort;
    }

    public int getPreviousCompPort() {
        return previousCompPort;
    }

    public void setPreviousCompPort(int previousCompPort) {
        this.previousCompPort = previousCompPort;
    }

    public Component getNextComp() {
        return nextComp;
    }

    public void setNextComp(Component nextComp) {
        this.nextComp = nextComp;
    }

    public int getThikness() {
        return thikness;
    }

    public void setThikness(int thikness) {
        this.thikness = thikness;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
