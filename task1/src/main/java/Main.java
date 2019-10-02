import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> stringList = new ArrayList<String>();
        try {
            String fromFile = "C://Users//Konstantin//Desktop//Java задание//Java чрфрэшх//strings.txt";
            File file = new File(fromFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                System.out.println(line);
                stringList.add(line);
                line = bufferedReader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            String toFile = "C://Users//Konstantin//Desktop//Java задание//Java чрфрэшх//strings _reverse.txt";
            File file = new File(toFile);
            file.createNewFile();
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = stringList.size() - 1; i >= 0; i--) {
                bufferedWriter.write(stringList.get(i) + "\r\n");
                System.out.println(stringList.get(i));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }
}
