package encryptdecrypt;

import encryptdecrypt.shift.BaseShift;
import encryptdecrypt.shift.UnicodeShift;

import java.io.*;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        // Process input parameters
        CommandLineParser commandLineParser = new CommandLineParser(args);
        String modeParam = commandLineParser.parse("-mode");
        String keyParam = commandLineParser.parse("-key");
        String algParam = commandLineParser.parse("-alg");
        String pathInParam = commandLineParser.parse("-in");
        String pathOutParam = commandLineParser.parse("-out");

        // Initialize crypt algorithm
        CryptBox cryptBox = new CryptBox();
        cryptBox.setCryptMode(Mode.parse(modeParam));
        cryptBox.setCryptAlgo(algParam != null && algParam.equals("shift") ?
                new BaseShift(Integer.parseInt(keyParam)) :
                new UnicodeShift(Integer.parseInt(keyParam)));

        // Load input data
        String inputData = pathInParam != null ?
                getDataFromFile(pathInParam) :
                commandLineParser.parse("-data");

        // Encrypt / decrypt data
        String outputData = cryptBox.crypt(Objects.requireNonNull(inputData));

        // Output data
        if (pathOutParam != null) {
            writeResultToFile(pathOutParam, outputData);
        } else {
            System.out.println(outputData);
        }
    }

    private static String getDataFromFile(String path) throws IOException {
        String data;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            data = br.readLine();
        }
        return data;
    }

    private static void writeResultToFile(String path, String data) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(path))) {
            writer.println(data);
        }
    }
}

class CommandLineParser {

    private final String[] args;

    public CommandLineParser(String[] args) {
        this.args = args;
    }

    public String parse(String argName) {

        for (int i = 0; i < this.args.length; i++) {
            if (args[i].trim().toLowerCase().equals(argName)) {
                if (i + 1 <= args.length) {
                    return args[i + 1];
                }
                return null;
            }
        }
        return null;
    }
}


