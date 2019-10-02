import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        String inputAddress = "";
        String inputFileName = "";
        String outputAddress = "";
        String outputFileName = "";
        List<DataModel> dataModelList = new ArrayList<>();
        WorkWithTable workWithTable = new WorkWithTable();
        try {
            fileInputStream = new FileInputStream("C://Users//Konstantin//Desktop//Java задание//Java чрфрэшх//connect.properties");
            properties.load(fileInputStream);

            System.out.println(properties.stringPropertyNames());

            inputAddress = properties.getProperty("INPUT.database.Access.path");
            inputFileName = properties.getProperty("INPUT.database.Access.table.name");
            outputFileName = properties.getProperty("OUTPUT.export.Excel.filename");
            outputAddress = properties.getProperty("OUTPUT.export.Excel.path") + "/";
            System.out.println(outputAddress);

        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            Driver driver = new net.ucanaccess.jdbc.UcanaccessDriver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:ucanaccess://" + inputAddress);
            Statement statement = connection.createStatement();
            String sql = "Select * from " + inputFileName;
            ResultSet resultSet = statement.executeQuery(sql);
            int columnIndexHiddenDelete = resultSet.findColumn("hiddenDelete");

            while (resultSet.next()){
                if (resultSet.getString(columnIndexHiddenDelete).equals("No")){
                    dataModelList.add(new DataModel(resultSet.getString(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
                }
            }

            workWithTable.writeToXLSX(dataModelList, outputAddress, outputFileName);

        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
