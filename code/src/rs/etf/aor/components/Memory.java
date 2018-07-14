/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.components;

/**
 *
 * @author pm070001
 */
public class Memory extends Sequential{

    private byte[] mem, startMem;
    private int clockNum;
    private int currClockNum;
    private int holdTime;
    private boolean  active;
    
    // first is address
    // secund is data
    // third is rdbus
    // forth is wrbus

    public Memory(int clockNum, byte[] mem) {
        super(4, 1, 0);
        this.mem = mem;
        this.startMem = mem.clone();
        this.clockNum = clockNum;
        currClockNum = clockNum;
        outValues[0] = -1;
        inValues[2] = -1;
        inValues[3] = -1;
        inValues[1] = -1;
        active = false;
    }
    

    @Override
    protected void calculateState() {

        if (inValues[2] == 0){
            // read
            active = true;
            outValues[0] = mem[inValues[0]] & 0x00FF;
            
        }else if (inValues[3] == 0){
            // write
            mem[inValues[0]] = (byte)(inValues[1] & 0xFF);
            outValues[0] = -1;
        }
        
    }

    @Override
    public void clock() {

        if (active){
            currClockNum--;

            if (currClockNum <= 0)
            {
                 for (int i=0; i<outLines.length; i++) {
                    if (outLines[i] != null) {
                        ((Bus)outLines[i]).refreshValue(outValues[outLines[i].getPreviousCompPort()] & 0xFF, this);
                    }
                }

                currClockNum = 5;
                holdTime = 3;
                
            }

            holdTime--;
            if (holdTime == 0)
            {
                ((Bus)outLines[0]).refreshValue(-1, this);
                active = false;
                currClockNum = clockNum;
            }

        }
    }

}
