package saverscoders.DAO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import saverscoders.resources.Database;

public class GenericDAOimpl extends Database implements GenericDAO {
    private final static String SQL_SELECT_ALL = "SELECT * FROM ?";

    @Override
    public <T> List<T> selectQuery(Class<T> type, String table) throws SQLException {
        //todo
        return null;
    }
}
