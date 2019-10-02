import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class ParseFile {
    private boolean servletFlag = false;
    private boolean servletMappingFlag = false;
    private StringBuilder findServletName = null;
    private List<ContainerForParsElements> listElements = new ArrayList<ContainerForParsElements>();

    public List<ContainerForParsElements> parse(String fileName){
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineString = bufferedReader.readLine();
            while (lineString != null){
                StringBuilder line = new StringBuilder(lineString);
                System.out.println(line.toString());
                if (line.toString().contains("<servlet>")) { servletFlag = true; }
                if (line.toString().contains("<servlet-mapping>")) { servletMappingFlag = true; }
                if (line.toString().contains("</servlet>")) { servletFlag = false; }
                if (line.toString().contains("</servlet-mapping>")) { servletMappingFlag = false; }

                if (servletFlag){
                    if (line.toString().contains("<servlet-name>")){
                        try {
                            removeTags(line);
                            findServletName = line;
                            listElements.add(new ContainerForParsElements(line.toString(), "", ""));
                        }catch (PatternSyntaxException e){
                            e.printStackTrace();
                        }
                    }
                    if (line.toString().contains("<servlet-class>")){
                        try {
                            removeTags(line);
                            addNewServletClassToList(listElements, findServletName.toString(), line.toString());
                        }catch (PatternSyntaxException e){
                            e.printStackTrace();
                        }
                    }
                }
                if (servletMappingFlag){
                    if (line.toString().contains("<servlet-name>")){
                        try {
                            removeTags(line);
                            findServletName = line;
                        }catch (PatternSyntaxException e){
                            e.printStackTrace();
                        }
                    }
                    if (line.toString().contains("<url-pattern>")){
                        try {
                            removeTags(line);
                            addNewURLPatternToList(listElements, findServletName.toString(), line.toString());
                        }catch (PatternSyntaxException e){
                            e.printStackTrace();
                        }
                    }
                }
                lineString = bufferedReader.readLine();
            }
            listElements.sort((o1, o2)->o1.getServletName().compareTo(o2.getServletName()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listElements;
    }

    private void addNewServletClassToList(List<ContainerForParsElements> list, String desiredServletName, String servletClass){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getServletName().equals(desiredServletName)){
                list.set(i, new ContainerForParsElements(desiredServletName, servletClass, list.get(i).getServletURL()));
                break;
            }
        }
    }

    private void addNewURLPatternToList(List<ContainerForParsElements> list, String desiredServletName, String urlPattern){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getServletName().equals(desiredServletName)){
                list.set(i, new ContainerForParsElements(desiredServletName, list.get(i).getServletClass(), urlPattern));
                break;
            }
        }
    }

    private void removeTags(StringBuilder line){
        int begin = line.indexOf(">");
        line.delete(0, begin + 1);
        int end = line.lastIndexOf("<");
        line.delete(end, line.capacity());
    }
}
