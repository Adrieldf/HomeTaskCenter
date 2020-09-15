package controller;

import java.sql.Connection;

import database.DBConnection;
import database.UserDB;
import model.User;

public class UserController {

	public void CreateOrUpdateUser(int id, String name, String password) {
		Connection conn = DBConnection.GetConnection();
		if(id != 0) {
			UserDB.UpdateUser(conn, id, name, password);
			
		}else {
			UserDB.InsertUser(conn, id, name, password);
		}
		DBConnection.CloseConnection();
	}
	
	public User GetUser(int id) {

		Connection conn = DBConnection.GetConnection();
		if(id == 0) {
			System.out.println("Código para pesquisa inválido");
			return null;
		}
		return UserDB.GetUser(conn, id);
	}
	
}
