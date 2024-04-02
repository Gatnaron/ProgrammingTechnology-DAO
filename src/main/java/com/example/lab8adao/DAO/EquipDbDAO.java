package com.example.lab8adao.DAO;

import com.example.lab8adao.DataConnect;
import com.example.lab8adao.infrastructure.IEquipDAO;
import com.example.lab8adao.model.Equip;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EquipDbDAO implements IEquipDAO{
    @Override
    public void add(Equip equip) throws SQLException {
        var connection = DataConnect.createDataSource().getConnection();

        PreparedStatement state = connection.prepareStatement("insert into equipment (name, status) values (?,?)");
        state.setString(1, equip.name);
        state.setString(2, equip.status);

        state.executeUpdate();
    }

    @Override
    public void update(Equip equip) throws SQLException {
        var connection = DataConnect.createDataSource().getConnection();

        PreparedStatement state = connection.prepareStatement("update equipment set name = ?, status = ? where id = ?");
        state.setString(1,equip.name);
        state.setString(2,equip.status);
        state.setString(3, String.valueOf(equip.id));

        state.executeUpdate();
    }

    @Override
    public Equip get(int id) throws SQLException {
        var connection = DataConnect.createDataSource().getConnection();

        PreparedStatement state = connection.prepareStatement("select * from equipment where id = ?");
        state.setInt(1, id);
        var result = state.executeQuery();

        Equip equip = null;
        while (result.next()){
            equip = new Equip(result.getInt("id"), result.getString("name"), result.getString("status"));
        }
        return equip;
    }

    @Override
    public Collection<Equip> getAll() throws SQLException {
        var connection = DataConnect.createDataSource().getConnection();

        PreparedStatement state = connection.prepareStatement("select * from equipment");
        var result = state.executeQuery();

        Collection<Equip> list = new ArrayList<>();
        while (result.next()){
            list.add(new Equip(result.getInt("id"), result.getString("name"), result.getString("status")));
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException {
        var connection = DataConnect.createDataSource().getConnection();

        PreparedStatement state = connection.prepareStatement("delete from equipment where id = ?");
        state.setInt(1, id);

        state.executeUpdate();
    }

}
