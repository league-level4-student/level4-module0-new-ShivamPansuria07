package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {

    public static void main(String[] args) {

        DataType[] dataTypes;
        dataTypes = DataType.values();
        int x = JOptionPane.showOptionDialog(null, "Select the data type you want to learn about!",
                null,
                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, dataTypes, dataTypes[0]);
        switch (x) {

        case 0:
        	//byte
            JOptionPane.showMessageDialog(null, "The byte data type is a " + DataType.BYTE.getBits() + "-bit integer with a min of -128 and a max value of 127");
           
            break;
        case 1:
        	//short
        	JOptionPane.showMessageDialog(null, "The short data type is a " + DataType.SHORT.getBits() + "-bit integer with a min of -32,768  and a max value of 32,767");
            break;
        case 2:
        	//int
        	JOptionPane.showMessageDialog(null, "The int data type is a " + DataType.INT.getBits() + "-bit integer with a min of -2^31 and a max value of 2^31-1");
            break;
        case 3:
        	//long
        	JOptionPane.showMessageDialog(null, "The long data type is a " + DataType.LONG.getBits() + "-bit integer with a min of -2^63 and a max value of 2^63-1");
            break;
        case 4:
        	//float
        	JOptionPane.showMessageDialog(null, "The float data type is a " + DataType.FLOAT.getBits() + "-bit floating point with a range of values is almost infinite");
            break;
        case 5:
        	//double
        	JOptionPane.showMessageDialog(null, "The double data type is a " + DataType.DOUBLE.getBits() + "-bit integer with a 754 floating point. Its range of values is near infinite");
            break;
        case 6:
        	//boolean
        	JOptionPane.showMessageDialog(null, "The boolean data type is a " + DataType.BOOLEAN.getBits() + "-bit data type with two values, TRUE or FALSE");
            break;
        case 7:
        	//char
        	JOptionPane.showMessageDialog(null, "The char data type is a " + DataType.CHAR.getBits() + "-bit data type with a min of 0 and a max of 65,535");
            break;
        default:
            System.out.println("Please choose again!");
            break;

        }
    }
}
