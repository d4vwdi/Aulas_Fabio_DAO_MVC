package Nodebounty_Persistencia;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Nodebounty_DAO.Conexao_MySQL;
import Nodebounty_Model.NB_Model;

public class NB_Persistencia {
	CallableStatement oCall;
	Conexao_MySQL oConectar = new Conexao_MySQL();
	PreparedStatement oPrepared;
	ResultSet oResultSet;

	public void INSERIR_CLIENTE(NB_Model Bounty_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL INSERIR_CLIENTE(?, ?, ?, ?, ?, ?, ?, ?)");
				oCall.setString(1, Bounty_Model.getCpf());
				oCall.setString(2, Bounty_Model.getNome());
				oCall.setString(3, Bounty_Model.getEmail());
				oCall.setString(4, Bounty_Model.getEndereco());
				oCall.setString(5, Bounty_Model.getCep());
				oCall.setString(6, Bounty_Model.getRg());
				oCall.setString(7, Bounty_Model.getDatanascimento());
				oCall.setString(8, Bounty_Model.getSenha());

				oCall.execute();

			} catch (SQLException e) {e.printStackTrace();}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}