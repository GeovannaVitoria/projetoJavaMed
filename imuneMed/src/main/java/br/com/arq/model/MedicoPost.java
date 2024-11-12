package br.com.arq.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.arq.repository.ConexaoDB;

public class MedicoPost {
	public void cadastrarMedico(Medico medico) throws SQLException {
		String sql = "INSERT INTO medico (nome, senha, crm, hospital, email, especialidade) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConexaoDB.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, medico.getNome());
			statement.setString(2, medico.getSenha());
			statement.setString(3, medico.getCrm());
			statement.setString(4, medico.getHospital());
			statement.setString(5, medico.getEmail());
			statement.setString(6, medico.getEspecialidade());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Erro ao cadastrar médico", e);
		}
	}
}
