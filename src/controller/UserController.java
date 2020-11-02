package controller;

import java.sql.Connection;

import database.DBConnection;
import database.PostgresqlUserDB;
import model.User;

public class UserController {

	public void CreateOrUpdateUser(int id, String name, String password, int idFamily) {
		Connection conn = DBConnection.GetConnection();
		PostgresqlUserDB userDB = new PostgresqlUserDB(conn);
		if (id != 0) {
			userDB.edit(new User(id, name, password, idFamily));

		} else {
			userDB.insert(new User(id, name, password, idFamily));
		}
		DBConnection.CloseConnection();
	}

	public User GetUser(int id, int idFamily) {

		Connection conn = DBConnection.GetConnection();
		PostgresqlUserDB userDB = new PostgresqlUserDB(conn);
		if (id == 0) {
			System.out.println("Código para pesquisa inválido");
			return null;
		}
		return userDB.getById(id, idFamily);
	}

}
