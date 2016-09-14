package ledgerdb.server.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ledgerdb.server.config.DbConfig;

@Path(value = "/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private final DbConfig dbConfig;
    
    public AccountResource(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
    
    @GET
    public String getAccountTypes() throws SQLException, JsonProcessingException {
        
        try (Connection con = dbConfig.getConnection();
                Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("select * from account order by account_id");
            return JsonUtils.format(rs);
        }
    }
    
}
