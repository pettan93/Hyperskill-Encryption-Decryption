package encryptdecrypt.shift;

import encryptdecrypt.CryptAlgo;
import encryptdecrypt.Mode;

public class UnicodeShift extends Shift implements CryptAlgo {

    public UnicodeShift(int key) {
        super(key);
    }

    @Override
    public char encrypt(char data) {
        return getShifted(data, Mode.ENCRYPTION);
    }

    @Override
    public char decrypt(char data) {
        return getShifted(data, Mode.DECRYPTION);
    }

    private char getShifted(char character, Mode mode) {
        return (char) (((byte) character) + (mode == Mode.ENCRYPTION ? key : -key));
    }

}
