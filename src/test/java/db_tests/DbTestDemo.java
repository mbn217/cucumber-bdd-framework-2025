package db_tests;

import org.apache.xmlbeans.impl.xpath.XQuery;
import utilities.DbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTestDemo {
    static String query = "SELECT * FROM CraterDBS.items i order by i.id desc;";

    public static void main(String[] args) {
//        /**
//         * Step 1: We need to add the dependency into out pom.xml
//         */
//
//        String dbUrl = "jdbc:mysql://stack-overflow.cfse9bqqndon.us-east-1.rds.amazonaws.com/CraterDBS";
//        String userName = "craterdbuser";
//        String password = "ptschool2023";
//
//        //2. Create a connection
//
//        try {
//            /**
//             * A Connection object represents a connection with a database.
//             * A SQL statement is executed through the Connection object.
//             * The Connection object is used to create a Statement object.
//             */
//            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
//
//            //2. Create a Statement
//            Statement statement = connection.createStatement();
//
//            //3. Execute our query
//
//            ResultSet resultSet = statement.executeQuery(query);
//
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            int colCount =  resultSetMetaData.getColumnCount();
////            for (int i = 1; i <colCount ; i++){
////                System.out.println("Column name is " + resultSetMetaData.getColumnName(i));
////                System.out.println("Column Type is " + resultSetMetaData.getColumnType(i));
////                System.out.println("Column display size " + resultSetMetaData.getColumnDisplaySize(i));
////            }
//            List<List<String>> data  = new ArrayList<>();
//            while(resultSet.next()){
//                //System.out.println(resultSet.getString("name"));
//                List<String> row  = new ArrayList<>();
//                for (int i = 1 ; i <colCount ; i++){
//                    //System.out.print(resultSet.getString(i) + " || ");
//                    row.add(resultSet.getString(i));
//                }
//                //System.out.println();
//                data.add(row);
//
//            }
//            System.out.println(data);
//
//
//
//
//        //Close all connections
//            resultSet.close();
//            statement.close();
//            connection.close();
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


        //DbUtils.executeQuery(query);
        DbUtils.selectRecord(query);
        System.out.println("+++++++++++");
        DbUtils.selectRecord(query, "name");
    }
}
