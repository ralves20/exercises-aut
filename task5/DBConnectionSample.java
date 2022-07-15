import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnectionSample {

    public static void main(String[] args) throws SQLException {


        final String connectionString = "jdbc:<YOUR-CONNECTION-STRING>";
        final String userName = "DBUSER";
        final String passOfUser = "dbP@ss1234";

        Connection conn = null;

        // Object of Statement. Used to create the statement to execute a query
        Statement stmt = null;

        //ResultSet - 'Maintains a point to the current row in the result set'
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        conn = DriverManager.getConnection(connectionString, userName, passOfUser);
        stmt = conn.createStatement();

        String query = "SELECT * FROM DATABASE.table a" +
                "WHERE a.COLUMN like '%NAME%'"
        resultSet = stmt.executeQuery() query;

        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                String columnValue = resultSet.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue + ", ");
            }
            System.out.println("");
        }

        //Close connection
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}