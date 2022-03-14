package zhevakin.net.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OTSDao {


    @Autowired
    @Qualifier("OTSDataSource")
    private final DataSource dataSource;

    public OTSDao(@Qualifier("OTSDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> findItems(String orderId) throws SQLException {

        List<String> items = new ArrayList<>();
        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT TOP (1000) [Ordering].[dbo].[Reserves_ONES_NOVOSIBIRSK].[Id]\n" +
                        "      ,[GoodID]\n" +
                        "      ,[Qty]\n" +
                        "      ,[ReserveEventId]\n" +
                        "      ,[OrderID]\n" +
                        "      ,[Goods].nkCode\n" +
                        "      ,[Timestamp]\n" +
                        "  FROM [Ordering].[dbo].[Reserves_ONES_NOVOSIBIRSK]\n" +
                        "  LEFT OUTER JOIN [Ordering].[dbo].[Goods]\n" +
                        "    ON CAST(Goods.Barcode AS bigint) = GoodID\n" +
                        " WHERE OrderID = " + orderId);

        while (resultSet.next()) {
            String item = resultSet.getString("nkCode");
            items.add(item);
        }

        return items;
    }


}
