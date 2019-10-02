import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {

    public void write(List<ContainerForParsElements> listElements, String writeToFile){
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(writeToFile);
            file.createNewFile();
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (ContainerForParsElements element : listElements){
                bufferedWriter.write(element.getServletName() + "-" + element.getServletClass() + "-" + element.getServletURL() + "\r\n");
                System.out.println(element.getServletName() + "-" + element.getServletClass() + "-" + element.getServletURL());
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
