package dao.impl.extractUtil;

import model.Repair;
import model.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairExtract {
    public static Repair extractRepair(ResultSet rs) throws SQLException {
        Repair repair = new Repair();

        repair.setId(rs.getLong("id"));
        repair.setPayStatus(Status.valueOf(rs.getString("pay_status")));
        repair.setPrice(rs.getLong("price"));

        return repair;
    }
}
