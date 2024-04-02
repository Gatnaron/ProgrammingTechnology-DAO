package com.example.lab8adao.infrastructure;

import com.example.lab8adao.model.Equip;

import java.sql.SQLException;
import java.util.Collection;

public interface IEquipDAO {
    public void add(Equip equip) throws SQLException;
    public void update(Equip equip) throws SQLException;
    public Equip get(int id) throws SQLException;
    public Collection<Equip> getAll() throws SQLException;
    public void delete(int id) throws SQLException;
}
