/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary;

/**
 *
 * @author tigerye
 */
public class Binary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IEEE754 a = new IEEE754("11000011100011001010101000111101");
        System.out.println(a.getDecimalValue());
        IEEE754 b = new IEEE754(0.0097f);
        System.out.println(b.getIEEE754Value());
        IEEE754 c = new IEEE754(173.7f);
        System.out.println(c.getIEEE754Value());
        IEEE754 d = new IEEE754("01000100010110101111111000110110");
        System.out.println(d.getDecimalValue());
    }

}
