/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author MB
 */
public class Add extends Combining{

    //2 inputs: first X, second Y
    //1 output
    public Add() {
        super(2, 1);
    }


    //supose it doesent have overflow
    @Override
    public void calculateState() {
        outValues[0] = (inValues[0] + inValues[1]) & 0x0000FFFF;
    }

}
