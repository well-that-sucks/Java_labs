package dao.impl;

import dao.RepairDao;
import dao.impl.extractUtil.OrderExtract;
import dao.impl.extractUtil.RepairExtract;
import model.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static utils.DBQueries.*;

public class RepairDaoImpl implements RepairDao {

    Connection connection;

    public RepairDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Optional<Repair> findById(long id) {
        Optional<Repair> optRepair = null;
        Repair repair;
        try (PreparedStatement ps1 = connection.prepareStatement(FIND_REPAIR_BY_ID);
             PreparedStatement ps2 = connection.prepareStatement(FIND_ORDER_BY_ID)) {
            ps1.setLong(1, id);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                repair = RepairExtract.extractRepair(rs1);

                ps2.setLong(1, rs1.getLong("order_id"));
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()) {
                    repair.setOrder(OrderExtract.extractOrder(rs2));
                }

                optRepair = Optional.ofNullable(repair);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return optRepair;
    }

    @Override
    public List<Repair> findAll() {
        List<Repair> repairs = new ArrayList<>();
        Repair currentRepair;
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_REPAIRS);
             PreparedStatement ps2 = connection.prepareStatement(FIND_ORDER_BY_ID)) {
            ResultSet rs1 = ps.executeQuery();
            while (rs1.next()) {
                currentRepair = RepairExtract.extractRepair(rs1);

                ps2.setLong(1, rs1.getLong("order_id"));
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()) {
                    currentRepair.setOrder(OrderExtract.extractOrder(rs2));
                }

                repairs.add(currentRepair);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return repairs;
    }

    @Override
    public Optional<Repair> findRepairByOrderId(long id) {
        Optional<Repair> optRepair = null;
        Repair repair;
        try (PreparedStatement ps1 = connection.prepareStatement(FIND_REPAIR_BY_ORDER_ID);
             PreparedStatement ps2 = connection.prepareStatement(FIND_ORDER_BY_ID)) {
            ps1.setLong(1, id);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                repair = RepairExtract.extractRepair(rs1);

                ps2.setLong(1, rs1.getLong("order_id"));
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()) {
                    repair.setOrder(OrderExtract.extractOrder(rs2));
                }

                optRepair = Optional.ofNullable(repair);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return optRepair;
    }

    @Override
    public void deleteById(long id) { }

    @Override
    public void deleteByOrderId(long id) { }
}
