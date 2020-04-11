package encryptdecrypt.shift;

import encryptdecrypt.CryptAlgo;

public class BaseShift extends Shift implements CryptAlgo {

    public String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public BaseShift(int key) {
        super(key);
    }

    @Override
    public char encrypt(char data) {
        if (!Character.isAlphabetic(data)) {
            return data;
        }
        char resultChar = alphabet.charAt((alphabet.indexOf(Character.toLowerCase(data)) + key) % alphabet.length());
        return Character.isUpperCase(data) ? Character.toUpperCase(resultChar) : resultChar;
    }

    @Override
    public char decrypt(char data) {
        if (!Character.isAlphabetic(data)) {
            return data;
        }
        int a = (alphabet.indexOf(Character.toLowerCase(data)) - key) % alphabet.length();
        char resultChar = alphabet.charAt(a < 0 ? alphabet.length() - Math.abs(a) : a);
        return Character.isUpperCase(data) ? Character.toUpperCase(resultChar) : resultChar;
    }

}
