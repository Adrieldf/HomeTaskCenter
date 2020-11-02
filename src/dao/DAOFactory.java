package dao;

import java.sql.Connection;


public abstract class DAOFactory {

    protected static DAOFactory instance;

    public static DAOFactory getInstance() {
        return null;
    }
    
    protected Connection conn;
    public abstract void closeConnection();
    
    public abstract CategoryDAO getCategoryDAO();

    public abstract FamilyDAO getFamilyDAO();
    
    public abstract ProductDAO getProductDAO();
    
    public abstract UserDAO getUserDAO();
  
}

