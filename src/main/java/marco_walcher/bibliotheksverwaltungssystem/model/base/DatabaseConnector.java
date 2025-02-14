package marco_walcher.bibliotheksverwaltungssystem.model.base;

import java.sql.*;

public class DatabaseConnector {

    //region <Properties>
    private static DatabaseConnector instance;

    private final String url = "jdbc:mysql://localhost:3306/Library";
    private String dbUser = null;
    private String dbPassword = null;

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    //endregion

    //region <Constructor>
    private DatabaseConnector() {
        setDbLoginfromEnv();
    }
    //enregion

    //region <Getter/Setter>
    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    private void setDbLoginfromEnv() {
        this.dbUser = System.getenv("DB_USER");
        this.dbPassword = System.getenv("DB_PASSWORD");

        if (this.dbUser == null | this.dbPassword == null) {
            throw new Error("Umgebungsvariablen für Datenbank-Connection fehlen.");
        }
    }

    public ResultSet getDbData(String query) {
        DatabaseConnector.instance.openDbConnection();
        ResultSet dbData = DatabaseConnector.instance.executeQuery(query);
        DatabaseConnector.instance.closeDbConnection();
        return dbData;
    }
    //enregion

    //region <Methods>
    private void openDbConnection() {
        try {
            this.conn = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeDbConnection() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
            if (this.stmt != null) {
                this.stmt.close();
            }
            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet executeQuery(String query) {
        try {
            this.stmt = this.conn.createStatement();
        } catch (SQLException ex) {
            throw new Error("Es konnte kein Statement erstellt werden. " + ex);
        }
        try {
            this.rs = this.stmt.executeQuery(query);
        } catch (SQLException ex) {
            throw new Error("Die query konnte nicht executed werden. " + ex);
        }
        return this.rs;
    }
    //enregion
}
