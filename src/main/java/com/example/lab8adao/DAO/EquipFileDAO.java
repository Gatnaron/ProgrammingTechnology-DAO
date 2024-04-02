package com.example.lab8adao.DAO;

import com.example.lab8adao.infrastructure.IEquipDAO;
import com.example.lab8adao.model.Equip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EquipFileDAO implements IEquipDAO {
    private final String path = "src/main/resources/file.txt";

    @Override
    public void add(Equip equip) throws SQLException {

    }

    @Override
    public void update(Equip equip) throws SQLException {

    }

    @Override
    public Equip get(int id) throws SQLException {
        return null;
    }

    @Override
    public Collection<Equip> getAll() throws SQLException {
        File file = null;
        Scanner scanner = null;
        Collection<Equip> list = new ArrayList<>();

        try {
            file = new File(path);

            scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                var line = scanner.nextLine().split(" ");
                list.add(new Equip(Integer.parseInt(line[0]), line[1], line[2]));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
