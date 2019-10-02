

public class Main {
    public static void main(String[] args) {
        ParseFile readFromFile = new ParseFile();
        WriteToFile writeToFile = new WriteToFile();
        String fromFile = "C://Users//Konstantin//Desktop//Java задание//Java чрфрэшх//servletsOld.txt";
        String toFile = "C://Users//Konstantin//Desktop//Java задание//Java чрфрэшх//servlets_output.txt";
        writeToFile.write(readFromFile.parse(fromFile), toFile);
    }
}
