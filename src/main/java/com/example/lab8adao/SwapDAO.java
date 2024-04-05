package com.example.lab8adao;

import com.example.lab8adao.DAO.EquipDbDAO;
import com.example.lab8adao.DAO.EquipFileDAO;
import com.example.lab8adao.infrastructure.IEquipDAO;

public class SwapDAO {
    public static final String DataBase = "db";
    public static final String File = "file";

    public static IEquipDAO createTaskDAO(String type){
        if (type.equalsIgnoreCase(DataBase)){
            return new EquipDbDAO();
        }
        else if (type.equalsIgnoreCase(File)){
            return new EquipFileDAO();
        }
        return null;
    }
}
