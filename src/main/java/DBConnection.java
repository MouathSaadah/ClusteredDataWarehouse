
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class DBConnection {

    private static final Logger logger = Logger.getLogger("DBConnection");
    private DataSource ds;

    public DBConnection() {
        try {
            this.ds = getDataSource();
        }
        catch (SQLException e){
            logger.severe("Error, Failed to get Data Source Connection");
            logger.severe(e.getMessage());
            logger.severe(e.toString());
        }
    }

    private  DataSource getDataSource() throws SQLException {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("111");
        logger.info("Driver loaded");
        return ds;
    }

    public  void addDeal(Deal deal) throws SQLException {
             if(deal == null)
               throw new IllegalArgumentException("new deal object is empty !!");
        try (Connection conn = ds.getConnection()) {
            String sql = "INSERT INTO deal VALUES(NEXTVAL('deal_id_sq'),?,?,?,?)";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, deal.getFromCurrency().getAlpha3());
            pStmt.setString(2, deal.getToCurrency().getAlpha3());
            pStmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pStmt.setInt(4, deal.getAmount());
            pStmt.executeUpdate();
            System.out.println("Added new Deal to DB Complete");

        }
    }
}
