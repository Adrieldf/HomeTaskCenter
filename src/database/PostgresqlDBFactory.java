package database;

import java.sql.DriverManager;
import java.sql.SQLException;

import dao.CategoryDAO;
import dao.DAOFactory;
import dao.FamilyDAO;
import dao.ProductDAO;
import dao.UserDAO;

public class PostgresqlDBFactory extends DAOFactory{
	
	public static DAOFactory getInstancia() {

	        if (instance == null) {
	        	instance = new PostgresqlDBFactory();
	        }

	        return instance;
	    }

	    private PostgresqlDBFactory() {
	        this.openConnection();
	    }
	    
	    private void openConnection(){
	        String driver = "org.postgresql.Driver";
	        String url = "jdbc:postgresql://motty.db.elephantsql.com:5432/bfrqpuzi";
	        String user = "bfrqpuzi";
	        String pwd = "Fm4za9rfWeSZgcRituCazF2eg8vCyJ1C";

	        try {

	            Class.forName(driver);
	            conn = DriverManager.getConnection(url, user, pwd);

	            //insertProduct(conn, 100, "produto100", "descricao produto100");
	            //updateProduct(conn, 100, "produtonovo", "produto massa");
	            //getProducts(conn);
	        } catch (ClassNotFoundException cnfe) {
	            System.out.println("Não foi possível encontrar o driver JDBC");
	        } catch (SQLException se) {
	            System.out.println("Não foi possível conectar ao Banco de Dados");
	        }
	    }  
	    
	@Override
	public void closeConnection() {
		 try {
	            if (this.conn != null) {
	                this.conn.close();
	            }
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		return new PostgresqlCategoryDB(conn);
	}

	@Override
	public FamilyDAO getFamilyDAO() {
		return new PostgresqlFamilyDB(conn);
	}

	@Override
	public ProductDAO getProductDAO() {
		return new PostgresqlProductDB(conn);
	}

	@Override
	public UserDAO getUserDAO() {
		return new PostgresqlUserDB(conn);
	}

}
