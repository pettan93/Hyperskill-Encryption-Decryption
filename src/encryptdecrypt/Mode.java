package encryptdecrypt;

public enum Mode {
    ENCRYPTION,
    DECRYPTION;

    public static Mode parse(String shortcut) {

        if ("dec".equals(shortcut.trim().toLowerCase())) {
            return Mode.DECRYPTION;
        }
        return Mode.ENCRYPTION;

    }
}
