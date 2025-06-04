package utilities;

import io.cucumber.java.bs.A;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtils {

    static String dbUrl = "jdbc:mysql://stack-overflow.cfse9bqqndon.us-east-1.rds.amazonaws.com/CraterDBS";
    static String userName = "craterdbuser";
    static String password = "ptschool2023";


    /**
     * This method will create connection to the database
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(dbUrl, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will execute the query and return the data set
     * This method will return the data set as a list of lists meaning each row will be a list of strings
     * It will return all the data from the query
     * @param query the query to execute
     * @return List of List of Strings
     */
    public static List<List<String>> executeQuery(String query) {
        List<List<String>> data = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                //System.out.println(resultSet.getString("name"));
                List<String> row = new ArrayList<>();
                for (int i = 1; i < colCount; i++) {
                    //System.out.print(resultSet.getString(i) + " || ");
                    row.add(resultSet.getString(i));
                }
                //System.out.println();
                data.add(row);

            }
            System.out.println(data);

            //close all connections
            resultSet.close();
            statement.close();
            connection.close();
            return data;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * This method will execute the query and return the data set
     * This method will return a single record as a list of strings
     * If you have multiple columns in the query it will return the first row only
     * @param query the query to execute
     * @return List of Strings
     */
    public static List<String> selectRecord(String query){
        List<String> dataSet = new ArrayList<>();

        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();

            if(resultSet.next()){
                for (int i = 1; i < colCount; i++) {
                    dataSet.add(resultSet.getString(i));
                }
            }
            System.out.println(dataSet);
            //Close all connection
            resultSet.close();
            statement.close();
            connection.close();
            return  dataSet;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method will execute the query and return the data set
     * It will return a single record as a string , you will provide the column name and it will return the data for that column
     * @param query the query to execute
     * @param colName the column name to get the data from
     * @return
     */
    public static String selectRecord(String query, String colName){
        String dataSet = null;

        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int colCount = resultSetMetaData.getColumnCount();

            if(resultSet.next()){
                    dataSet = (resultSet.getString(colName));
            }
            System.out.println(dataSet);
            //Close all connection
            resultSet.close();
            statement.close();
            connection.close();
            return  dataSet;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }





}
