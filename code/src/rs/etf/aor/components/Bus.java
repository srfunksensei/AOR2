/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dragan
 */
public class Bus extends Line {

    private Component currentComponent;

    private List<Component> components;
    private List<Integer> nextComponentPorts;


    @Override
    public int getPreviousCompPort() {
        return 0;
    }

    public Bus(int thik) {
        super (null, 0, 0, thik);
        value = -1;
        components = new LinkedList<Component>();
        nextComponentPorts = new LinkedList<Integer>();
        previousCompPort = 0;
    }

    private String formatter(String hexString) {

        int desiredLength = 4;

        while ( hexString.length() < desiredLength ) {
            hexString = "0" + hexString;
        }

        return "0x" + hexString;

    }

    public void clock() {
    }

    public void refreshValue(int newValue, Component currentComponent) {
        if (newValue != -1) {
            if (this.currentComponent != currentComponent || (currentComponent instanceof JunctionForBus) ||
                    (this.currentComponent == currentComponent && newValue != value)) {
                this.currentComponent = currentComponent;
                for (int i=0; i<components.size(); i++) {
                    components.get(i).refreshValue(newValue, nextComponentPorts.get(i));
                }
                value = newValue;
            }
        }
        else {
            if (currentComponent == this.currentComponent) {
                value = -1;
                this.currentComponent = null;
                for (int i=0; i<components.size(); i++) {
                    components.get(i).refreshValue(newValue, nextComponentPorts.get(i));
                }
            }
         }
    }

    public void addNextComponent (Component comp, int port) {
        components.add(comp);
        nextComponentPorts.add(port);
    }

    @Override
    public void paint(Graphics g) {
        String stringValue;
        if (value != -1) {
            g.setColor(Color.lightGray);
            stringValue = formatter(Integer.toHexString(value & 0xffff));
        }
        else {
            g.setColor(new Color(128, 128, 0));
            stringValue = "highZ";
        }
        for (int i=0; i<points.size() - 1; i+=2) {
            g.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
            if (points.get(i).x == points.get(i+1).x) {
                g.drawLine(points.get(i).x+1, points.get(i).y, points.get(i+1).x+1, points.get(i+1).y);
                g.drawLine(points.get(i).x-1, points.get(i).y, points.get(i+1).x-1, points.get(i+1).y);
            }
            if (points.get(i).y == points.get(i+1).y) {
                g.drawLine(points.get(i).x, points.get(i).y+1, points.get(i+1).x, points.get(i+1).y+1);
                g.drawLine(points.get(i).x, points.get(i).y-1, points.get(i+1).x, points.get(i+1).y-1);
            }
        }
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        for (int i=0; i<textPoints.size(); i++) {
            g.drawString(stringValue, textPoints.get(i).x, textPoints.get(i).y);
        }
    }

}
