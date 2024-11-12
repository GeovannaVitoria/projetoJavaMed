package br.com.arq.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.arq.repository.ConexaoDB;

public class PacientePost {
	public void cadastrarPaciente(Paciente paciente) throws SQLException {
		String sql = "INSERT INTO paciente (cpf, nome, data_nasc, nome_doenca, sexo, desc_doenca) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConexaoDB.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, paciente.getCpf());
			statement.setString(2, paciente.getNome());

			statement.setDate(3, Date.valueOf(paciente.getData_nasc()));

			statement.setString(4, paciente.getNome_doenca());
			statement.setString(5, paciente.getSexo());
			statement.setString(6, paciente.getDesc_doenca());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Erro ao cadastrar paciente", e);
		}
	}
}
