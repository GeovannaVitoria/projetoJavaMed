package br.com.arq.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

	public static Connection getConnection() throws SQLException {
		try {
			String url = "jdbc:mysql://localhost:3306/hospital";
			String user = "root";
			String password = "senha";

			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new SQLException("Erro ao conectar com o banco de dados", e);
		}
	}
}
