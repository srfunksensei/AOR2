/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.etf.aor.asm;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Dragan
 */
public class Assembler {
    
    private static class Instruction {
        
        private String mnemonic;
        private List<String> operands;

        private byte[] decodedInstruction;
        
        private Instruction (String line) {
            
            line = line.trim();
            line = line.replaceAll("[\\s]+", " ");
            line = line.toUpperCase();

            operands = new LinkedList<String>();

            int position = line.indexOf(" ");

            //no-address instruction
            if (position == -1) {
                mnemonic = line;
                return;
            }

            mnemonic = line.substring(0, position);

            String[] operandsArray = line.substring(position + 1).split(",");

            for (int i=0; i<operandsArray.length; i++) {
                operandsArray[i] = operandsArray[i].trim();
                operandsArray[i] = operandsArray[i].replaceAll("[\\s]+", "");
                operands.add(operandsArray[i]);
            }
            
        }

        private byte[] decode () {

            decodeInstruction();
            decodeOperands();

            return decodedInstruction;
        }

        private void decodeOperands () {

            //instruction with one operand
            if ("ASR".equals(mnemonic) ||
                "PUSH".equals(mnemonic) ||
                "POP".equals(mnemonic) ||
                "INC".equals(mnemonic) ||
                "DEC".equals(mnemonic) ||
                "JMPIND".equals(mnemonic)) {

                String operand = operands.get(0);

                //immidiate
                if (operand.charAt(0) == '#') {
                    byte[] tempArray = new byte[4];
                    tempArray[0] = decodedInstruction[0];
                    tempArray[1] = decodedInstruction[1];
                    decodedInstruction = tempArray;
                    decodedInstruction[1] |= (byte) 0xC3;
                    int operandValue = Integer.parseInt(operands.get(0).substring(1));
                    decodedInstruction[2] = (byte) ( (operandValue & 0xFF00) >> 8);
                    decodedInstruction[3] = (byte) (operandValue & 0x00FF);
                    return;
                }

                //memory direct
                try {
                    Integer.parseInt (operand);

                    byte[] tempArray = new byte[4];
                    tempArray[0] = decodedInstruction[0];
                    tempArray[1] = decodedInstruction[1];
                    decodedInstruction = tempArray;
                    decodedInstruction[1] |= (byte) 0xC0;
                    int operandAddress = Integer.parseInt(operands.get(0));
                    decodedInstruction[2] = (byte) ( (operandAddress & 0xFF00) >> 8);
                    decodedInstruction[3] = (byte) (operandAddress & 0x00FF);

                    return;

                } catch (NumberFormatException e) {}

                //register indirect, register indirect + shift, memory indirect, relative
                if (operand.charAt(0) == '[') {

                    //memory indirect
                    try {
                        Integer.parseInt (operand.substring(1, operand.length() - 1));

                        byte[] tempArray = new byte[4];
                        tempArray[0] = decodedInstruction[0];
                        tempArray[1] = decodedInstruction[1];
                        decodedInstruction = tempArray;
                        decodedInstruction[1] |= (byte) 0xC1;
                        int operandAddress = Integer.parseInt(operands.get(0).substring(1, operand.length() - 1));
                        decodedInstruction[2] = (byte) ( (operandAddress & 0xFF00) >> 8);
                        decodedInstruction[3] = (byte) (operandAddress & 0x00FF);

                        return;

                    } catch (NumberFormatException e) {}

                    //relative
                    if ("PC".equals(operand.substring(1, 3))) {

                        byte[] tempArray = new byte[3];
                        tempArray[0] = decodedInstruction[0];
                        tempArray[1] = decodedInstruction[1];
                        decodedInstruction = tempArray;
                        decodedInstruction[1] |= (byte) 0xC2;
                        int operandAddress = Integer.parseInt(operands.get(0).substring(4, operand.length() - 1));
                        decodedInstruction[2] = (byte) (operandAddress & 0x0FF);

                        return;

                    }

                    //register indirect, register indiriect with shift
                    String[] parts = operand.split("\\+");
                    parts[0] = parts[0].substring(1);

                    //register indirect with shift
                    if (parts.length == 3) {
                        int shift = 0;
                        try {
                            shift = Integer.parseInt(parts[2].substring(0, parts[2].length()-1));
                        } catch (NumberFormatException e) {}

                        byte[] tempArray = new byte[3];
                        tempArray[0] = decodedInstruction[0];
                        tempArray[1] = decodedInstruction[1];
                        decodedInstruction = tempArray;
                        decodedInstruction[1] |= (byte) 0x80;

                        //BX + ...
                        if ("BX".equals(parts[0])) {
                            //BX + SI + shift
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x04;
                            }
                            //BX + DI + shift
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x05;
                            }
                        }

                        //BP + ...
                        else {
                            //BP + SI + shift
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x06;
                            }
                            //BP + DI + shift
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x07;
                            }
                        }

                        decodedInstruction[2] = (byte) (shift & 0x0FF);

                        return;

                    }

                    //register indirect, register indirect with shift
                    if (parts.length == 2) {

                        //register indirect with shift
                        try {

                            int shift = 0;
                            try{
                                shift = Integer.parseInt(parts[1].substring(0, parts[1].length()-1));
                            } catch (NumberFormatException e) {}

                            byte[] tempArray = new byte[3];
                            tempArray[0] = decodedInstruction[0];
                            tempArray[1] = decodedInstruction[1];
                            decodedInstruction = tempArray;
                            decodedInstruction[1] |= (byte) 0x80;

                            //BX + shift
                            if ("BX".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x00;
                            }

                            //BP + shift
                            if ("BP".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x01;
                            }

                            //SI + shift
                            if ("SI".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x02;
                            }

                            //DI + shift
                            if ("DI".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x03;
                            }

                            decodedInstruction[2] = (byte) (shift & 0x0FF);

                            return;

                        } catch (NumberFormatException e) {}

                        //register indirect
                        decodedInstruction[1] |= (byte) 0x40;

                        //BX + ...
                        if ("BX".equals(parts[0])) {
                            //BX + SI
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x04;
                            }
                            //BX + DI
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x05;
                            }
                        }

                        //BP + ...
                        else {
                            //BP + SI
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x06;
                            }
                            //BP + DI
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x07;
                            }
                        }

                        return;

                    }

                    decodedInstruction[1] |= (byte) 0x40;

                    //BX
                    if ("BX".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x00;
                    }

                    //BP
                    if ("BP".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x01;
                    }

                    //SI
                    if ("SI".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x02;
                    }

                    //DI
                    if ("DI".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x03;
                    }

                }

                //direct register
                decodedInstruction[1] |= (byte) 0x00;

                //AX
                if ("AX".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x00;
                }

                //BX
                if ("BX".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x01;
                }

                //CX
                if ("CX".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x02;
                }

                //DX
                if ("DX".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x03;
                }

                //SP
                if ("SP".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x04;
                }

                //BP
                if ("BP".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x05;
                }

                //SI
                if ("SI".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x06;
                }

                //DI
                if ("DI".equals(operand)) {
                    decodedInstruction[1] |= (byte) 0x07;
                }

                return;

            }

            //instruction with two operand
            if ("MOVS".equals(mnemonic) ||
                "MOVD".equals(mnemonic) ||
                "ADD".equals(mnemonic) ||
                "AND".equals(mnemonic)) {

                //first operand is AX
                if ("AX".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x00;
                }

                //first operand is BX
                if ("BX".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x08;
                }

                //first operand is CX
                if ("CX".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x10;
                }

                //first operand is DX
                if ("DX".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x18;
                }

                //first operand is SP
                if ("SP".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x20;
                }

                //first operand is BP
                if ("BP".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x28;
                }

                //first operand is SI
                if ("SI".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x30;
                }

                //first operand is DI
                if ("DI".equals(operands.get(0))) {
                    decodedInstruction[1] |= 0x38;
                }

                //decode second operand

                String drugiOperand = operands.get(1);

                //immidiate
                if (drugiOperand.charAt(0) == '#') {
                    byte[] tempArray = new byte[4];
                    tempArray[0] = decodedInstruction[0];
                    tempArray[1] = decodedInstruction[1];
                    decodedInstruction = tempArray;
                    decodedInstruction[1] |= (byte) 0xC3;
                    int operandValue = Integer.parseInt(operands.get(1).substring(1));
                    decodedInstruction[2] = (byte) ( (operandValue & 0xFF00) >> 8);
                    decodedInstruction[3] = (byte) (operandValue & 0x00FF);
                    return;
                }

                //memory direct
                try {
                    Integer.parseInt (drugiOperand);

                    byte[] tempArray = new byte[4];
                    tempArray[0] = decodedInstruction[0];
                    tempArray[1] = decodedInstruction[1];
                    decodedInstruction = tempArray;
                    decodedInstruction[1] |= (byte) 0xC0;
                    int operandAddress = Integer.parseInt(operands.get(1));
                    decodedInstruction[2] = (byte) ( (operandAddress & 0xFF00) >> 8);
                    decodedInstruction[3] = (byte) (operandAddress & 0x00FF);

                    return;

                } catch (NumberFormatException e) {}

                //register indirect, register indirect + shift, memory indirect, relative
                if (drugiOperand.charAt(0) == '[') {

                    //memory indirect
                    try {
                        Integer.parseInt (drugiOperand.substring(1, drugiOperand.length() - 1));

                        byte[] tempArray = new byte[4];
                        tempArray[0] = decodedInstruction[0];
                        tempArray[1] = decodedInstruction[1];
                        decodedInstruction = tempArray;
                        decodedInstruction[1] |= (byte) 0xC1;
                        int operandAddress = Integer.parseInt(operands.get(1).substring(1, drugiOperand.length() - 1));
                        decodedInstruction[2] = (byte) ( (operandAddress & 0xFF00) >> 8);
                        decodedInstruction[3] = (byte) (operandAddress & 0x00FF);

                        return;

                    } catch (NumberFormatException e) {}

                    //relative
                    if ("PC".equals(drugiOperand.substring(1, 3))) {

                        byte[] tempArray = new byte[3];
                        tempArray[0] = decodedInstruction[0];
                        tempArray[1] = decodedInstruction[1];
                        decodedInstruction = tempArray;
                        decodedInstruction[1] |= (byte) 0xC2;
                        int operandAddress = Integer.parseInt(operands.get(1).substring(4, drugiOperand.length() - 1));
                        decodedInstruction[2] = (byte) (operandAddress & 0x0FF);

                        return;

                    }

                    //register indirect, register indiriect with shift
                    String[] parts = drugiOperand.split("\\+");
                    parts[0] = parts[0].substring(1);

                    //register indirect with shift
                    if (parts.length == 3) {
                        int shift = 0;
                        try {
                            shift = Integer.parseInt(parts[2]);
                        } catch (NumberFormatException e) {}

                        byte[] tempArray = new byte[3];
                        tempArray[0] = decodedInstruction[0];
                        tempArray[1] = decodedInstruction[1];
                        decodedInstruction = tempArray;
                        decodedInstruction[1] |= (byte) 0x80;

                        //BX + ...
                        if ("BX".equals(parts[0])) {
                            //BX + SI + shift
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x04;
                            }
                            //BX + DI + shift
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x05;
                            }
                        }

                        //BP + ...
                        else {
                            //BP + SI + shift
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x06;
                            }
                            //BP + DI + shift
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x07;
                            }
                        }

                        decodedInstruction[2] = (byte) (shift & 0x0FF);

                        return;

                    }

                    //register indirect, register indirect with shift
                    if (parts.length == 2) {

                        //register indirect with shift
                        try {

                            int shift = 0;
                            try{
                                shift = Integer.parseInt(parts[1].substring(0, parts[1].length()-1));
                            } catch (NumberFormatException e) {}

                            byte[] tempArray = new byte[3];
                            tempArray[0] = decodedInstruction[0];
                            tempArray[1] = decodedInstruction[1];
                            decodedInstruction = tempArray;
                            decodedInstruction[1] |= (byte) 0x80;

                            //BX + shift
                            if ("BX".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x00;
                            }

                            //BP + shift
                            if ("BP".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x01;
                            }

                            //SI + shift
                            if ("SI".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x02;
                            }

                            //DI + shift
                            if ("DI".equals(parts[0])) {
                                decodedInstruction[1] |= (byte) 0x03;
                            }

                            decodedInstruction[2] = (byte) (shift & 0xFF);

                            return;

                        } catch (NumberFormatException e) {}

                        //register indirect
                        decodedInstruction[1] |= (byte) 0x40;

                        //BX + ...
                        if ("BX".equals(parts[0])) {
                            //BX + SI
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x04;
                            }
                            //BX + DI
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x05;
                            }
                        }

                        //BP + ...
                        else {
                            //BP + SI
                            if ("SI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x06;
                            }
                            //BP + DI
                            if ("DI".equals(parts[1])) {
                                decodedInstruction[1] |= (byte) 0x07;
                            }
                        }

                        return;

                    }

                    decodedInstruction[1] |= (byte) 0x40;

                    //BX
                    if ("BX".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x00;
                    }

                    //BP
                    if ("BP".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x01;
                    }

                    //SI
                    if ("SI".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x02;
                    }

                    //DI
                    if ("DI".equals(parts[0])) {
                        decodedInstruction[1] |= (byte) 0x03;
                    }

                    return;

                }

                //direct register
                decodedInstruction[1] |= (byte) 0x00;

                //AX
                if ("AX".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x00;
                }

                //BX
                if ("BX".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x01;
                }

                //CX
                if ("CX".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x02;
                }

                //DX
                if ("DX".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x03;
                }

                //SP
                if ("SP".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x04;
                }

                //BP
                if ("BP".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x05;
                }

                //SI
                if ("SI".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x06;
                }

                //DI
                if ("DI".equals(drugiOperand)) {
                    decodedInstruction[1] |= (byte) 0x07;
                }

            }

        }

        private void decodeInstruction () {

            if ("RTS".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = 0x01;
                return;
            }

            if ("RTI".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = 0x02;
                return;
            }

            if ("INTE".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = 0x04;
                return;
            }

            if ("INTD".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = 0x08;
                return;
            }

            if ("TRPE".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = 0x10;
                return;
            }

            if ("TRPD".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = 0x20;
                return;
            }

            if ("JMP".equals(mnemonic)) {
                decodedInstruction = new byte[3];
                decodedInstruction[0] = 0x40;
                int address = Integer.parseInt(operands.get(0));
                decodedInstruction[1] = (byte) ( (address & 0xFF00) >> 8);
                decodedInstruction[2] = (byte) (address & 0x00FF);
                return;
            }

            if ("JSR".equals(mnemonic)) {
                decodedInstruction = new byte[3];
                decodedInstruction[0] = 0x5F;
                int address = Integer.parseInt(operands.get(0));
                decodedInstruction[1] = (byte) ( (address & 0xFF00) >> 8);
                decodedInstruction[2] = (byte) (address & 0x00FF);
                return;
            }

            if ("BNZ".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = 0x60;
                int relativeAddress = Integer.parseInt(operands.get(0));
                decodedInstruction[1] = (byte) (relativeAddress & 0x00FF);
                return;
            }

            if ("INT".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = 0x7F;
                int interruptEntry = Integer.parseInt(operands.get(0));
                decodedInstruction[1] = (byte) (interruptEntry & 0x00FF);
                return;
            }

            if ("ASR".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0x80;
                decodedInstruction[1] = (byte) 0x00;
                return;
            }

            if ("PUSH".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0xFF;
                decodedInstruction[1] = (byte) 0x00;
                return;
            }

            if ("POP".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0xFF;
                decodedInstruction[1] = (byte) 0x08;
                return;
            }

            if ("INC".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0xFF;
                decodedInstruction[1] = (byte) 0x10;
                return;
            }

            if ("DEC".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0xFF;
                decodedInstruction[1] = (byte) 0x18;
                return;
            }

            if ("JMPIND".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0xFF;
                decodedInstruction[1] = (byte) 0x20;
                return;
            }

            if ("MOVS".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0x81;
                decodedInstruction[1] = (byte) 0x00;
                return;
            }

            if ("MOVD".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0x82;
                decodedInstruction[1] = (byte) 0x00;
                return;
            }

            if ("ADD".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0x84;
                decodedInstruction[1] = (byte) 0x00;
                return;
            }

            if ("AND".equals(mnemonic)) {
                decodedInstruction = new byte[2];
                decodedInstruction[0] = (byte) 0x88;
                decodedInstruction[1] = (byte) 0x00;
                return;
            }

            if ("HALT".equals(mnemonic)) {
                decodedInstruction = new byte[1];
                decodedInstruction[0] = (byte) 0x00;
            }

        }
        
    }

    public static byte[] assemble (String inputFile) throws FileNotFoundException {
        byte[] memory = new byte[1024];

        List<Instruction> instructions = new LinkedList<Instruction>();

        FileInputStream fstream = new FileInputStream(inputFile);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        try {
            while ((strLine = br.readLine()) != null) {
                if (strLine.length() != 0) {
                    Instruction instruction = new Instruction(strLine);
                    instructions.add(instruction);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i=0, position = 0; i<instructions.size(); i++) {
            byte[] temp = instructions.get(i).decode();
            for (int j=0; j<temp.length; j++) {
                memory[position++] = temp[j];
            }
            memory[position] = 0x00;
        }

        return memory;
    }

    public static byte[] assemble (File inputFile) {
        byte[] memory = new byte[1024];

        List<Instruction> instructions = new LinkedList<Instruction>();

        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(inputFile);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;

        try {
            while ((strLine = br.readLine()) != null) {
                if (strLine.length() != 0) {
                    Instruction instruction = new Instruction(strLine);
                    instructions.add(instruction);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i=0, position = 0; i<instructions.size(); i++) {
            byte[] temp = instructions.get(i).decode();
            if (temp != null) {
                for (int j=0; j<temp.length; j++) {
                    memory[position++] = (byte)(temp[j] & 0xFF);
                }
            }
        }

        return memory;
    }

    public static void main (String[] args) {
        try {
            byte[] array = assemble("ulaz.asm");
            for (int i=0; i<array.length; i++) {
                System.out.println(Integer.toHexString(array[i] & 0xFF));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
