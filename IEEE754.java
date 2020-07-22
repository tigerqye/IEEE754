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
public class IEEE754 {

    private float number;
    private String bits = "";
    private int s;
    private float e;
    private float m;

    public IEEE754(String bits) {
        this.bits = bits;
    }

    public IEEE754(float number) {
        this.number = number;
    }

    public double getDecimalValue() {
        s = Character.getNumericValue(bits.charAt(0));
        for (int i = 0; i < 8; i++) {
            e += Character.getNumericValue(bits.charAt(1 + i)) * Math.pow(2, 7 - i);
        }
        for (int i = 0; i < 23; i++) {
            m += Character.getNumericValue(bits.charAt(9 + i)) * Math.pow(2, 22 - i);
        }
        this.number = (float) (Math.pow(-1, s) * (1 + m / Math.pow(2, 23)) * Math.pow(2, e - 127));
        return number;
    }

    public String getIEEE754Value() {
        int e10 = 127;
        int zero = 0;
        if (number >= 0) {
            this.bits += "0";
        } else {
            this.bits += "1";
            number = number * -1;
        }
        while (number >= 2 && (e10 - 127) < 8) {
            number = number / 2;
            e10 += 1;
        }
        while (number < 1 && (127 - e10) < 8) {
            number = number * 2;
            e10 -= 1;
        }
        while (e10 > 0) {
            this.bits = this.bits.charAt(0) + Integer.toString(e10 % 2) + this.bits.substring(1);
            e10 = e10 / 2;
            zero += 1;
        }
        for (int i = 0; i < 8 - zero; i++) {
            this.bits = this.bits.charAt(0) + "0" + this.bits.substring(1);
        }
        number -= 1;
        for (int i = 0; i < 23; i++) {
            number = number * 2;
            if (number >= 1) {
                this.bits += "1";
                number -= 1;
            } else {
                this.bits += "0";
            }
        }
        return bits;
    }
}
