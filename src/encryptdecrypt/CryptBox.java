package encryptdecrypt;

public class CryptBox {

    private Mode cryptMode;

    private CryptAlgo cryptAlgo;

    public CryptBox() {
    }

    public String crypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (byte b : input.getBytes()) {
            char character = (char) b;
            sb.append(
                    cryptMode == Mode.ENCRYPTION ?
                            cryptAlgo.encrypt(character) :
                            cryptAlgo.decrypt(character)
            );
        }
        return sb.toString();
    }

    public void setCryptMode(Mode cryptMode) {
        this.cryptMode = cryptMode;
    }

    public void setCryptAlgo(CryptAlgo cryptAlgo) {
        this.cryptAlgo = cryptAlgo;
    }
}
