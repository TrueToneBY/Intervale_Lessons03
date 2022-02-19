package intervale.dz3.springbookdemo.openlibrary.repository.model.maper;

import intervale.dz3.springbookdemo.openlibrary.repository.model.Work;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkMapper implements RowMapper {
    @Override
    public Work mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Work(rs.getString("NAME"), rs.getInt("PAGES"),
                new String[] {rs.getString("AUTHOR")},  new String[] {rs.getString("ISBN")});
    }
}
