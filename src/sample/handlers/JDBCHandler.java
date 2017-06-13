package sample.handlers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Gabo on 08/06/2017.
 * Se arma la conexión del driver JDBC y los métodos para ejecutar comandos QUERY
 */
public class JDBCHandler {

    private final String URLLocal = "jdbc:mysql://localhost:3306/";
    private Connection connection;
    private Statement statement;
    private String dbms;
    private String serverName;
    private String portNumber;

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public JDBCHandler(boolean localhost, String dbms, String serverName, String portNumber, String user, String password) {
        try {
            //Se hace la conexión
            this.dbms = dbms;
            this.serverName = serverName;
            this.portNumber = portNumber;
            String url = "jdbc:" + this.dbms + "://" + this.serverName + ":" + this.portNumber + "/";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JDBCHandler(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, ArrayList<String>> retrieveQuery(String query) throws SQLException {
        statement = connection.createStatement();
        ResultSet myRes = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = myRes.getMetaData();
        HashMap<String, ArrayList<String>> results = new HashMap<>();
        ArrayList<String> labels = getColumnLabels(resultSetMetaData);
        int i = 0;
        while (true) {
            ArrayList resultColumn = new ArrayList();
            while (myRes.next()) {
                resultColumn.add(myRes.getString(labels.get(i)).toString());
            }
            if (i == labels.size() - 1) {
                results.put(labels.get(i).toString(), resultColumn);
                myRes.beforeFirst();
                break;
            } else {
                results.put(labels.get(i).toString(), resultColumn);
                myRes.beforeFirst();
                i++;
            }
        }
        return results;
    }

    private ArrayList<String> getColumnLabels(ResultSetMetaData metaData) throws SQLException {
        ArrayList<String> labels = new ArrayList<>();
        int cols = metaData.getColumnCount();
        for (int i = 1; i <= cols; i++) {
            labels.add(metaData.getColumnName(i));
        }
        return labels;
    }

    public String executeQuery(String query) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(query);
        return "Complete!";
    }


}
