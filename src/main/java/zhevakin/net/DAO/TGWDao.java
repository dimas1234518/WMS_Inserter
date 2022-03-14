package zhevakin.net.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import zhevakin.net.configure.TGWDriver;
import zhevakin.net.model.Telegram;

import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.sql.Connection.TRANSACTION_READ_COMMITTED;

@Repository
public class TGWDao {

 /*   public TGWDao(@Qualifier("TGWDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    @Qualifier("TGWDataSource")
    private final DataSource dataSource;
*/
    public int addTelegrams(List<Telegram> telegramList) throws SQLException {

        try {
            DataSource   dataSource = TGWDriver.TGWDataSource();
            Connection connection = dataSource.getConnection();
            connection.setTransactionIsolation(TRANSACTION_READ_COMMITTED);
    //        int id = findBigId(connection);
            connection.setAutoCommit(false);
            
            String SQL = "insert into [NSKLC_interface_Test].[dbo].[IFOUT_T]" +
                " ([IFOUTID], [IFSYSNAM], [IFOUTLFDNR], [IFOUTMLDNAM], [IFOUTFSRSTA], [TRXID], [IFOUTDATEN], [BUMID], [ALARMTXT], [DZINS])" +
                " values ((SELECT MAX ([IFOUTID])+1  FROM [NSKLC_interface_Test].[dbo].[IFOUT_T]), 'DEFAULT', 0, ?, 40, ?, ?, 0, null, getdate())";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            int rows = 0;
            for (Telegram telegram : telegramList) {
           //     preparedStatement.setString(1,String.valueOf(++id));
                preparedStatement.setString(1,telegram.getMsgNam());
                preparedStatement.setString(2,telegram.getTrxId());
                preparedStatement.setString(3,telegram.toString());
                rows += preparedStatement.executeUpdate();
            }

            connection.commit();
            connection.setAutoCommit(true);
            connection.close();
            return rows;

        } catch (IOException  e) {
            e.printStackTrace();
        }
        return 0;

    }

    private int findBigId(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT MAX ([IFOUTID]) FROM [NSKLC_interface_Test].[dbo].[IFOUT_T]");
        if (!resultSet.next()) return 0;
        return resultSet.getInt("");
    }

}
