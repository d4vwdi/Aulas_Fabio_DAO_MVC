package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pck_DAO.Conexao_MySQL;
import Pck_Model.Nodebounty_Model;

public class Nodebounty_Persistencia {
	CallableStatement oCall;
	Conexao_MySQL oConectar = new Conexao_MySQL();
	PreparedStatement oPrepared;
	ResultSet oResultSet;

	public void PROC_INSERIR_CLIENTE(Nodebounty_Model Bounty_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_INSERIR_CLIENTE(?, ?, ?, ?, ?, ?, ?, ?)");
				oCall.setString(1, Bounty_Model.getA01_cpf());
				oCall.setString(2, Bounty_Model.getA01_nome());
				oCall.setString(3, Bounty_Model.getA01_email());
				oCall.setString(4, Bounty_Model.getA01_endereco());
				oCall.setString(5, Bounty_Model.getA01_cep());
				oCall.setString(6, Bounty_Model.getA01_rg());
				oCall.setString(7, Bounty_Model.getA01_datanascimento());
				oCall.setString(8, Bounty_Model.getA01_senha());

				oCall.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void PROC_ATUALIZAR_CLIENTE(Nodebounty_Model Bounty_Model) {
	    try {
	        oCall = oConectar.getConexao().prepareCall("CALL PROC_ATUALIZAR_CLIENTE(?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        oCall.setInt(1, Bounty_Model.getA01_id()); // Start indexing from 1
	        oCall.setString(2, Bounty_Model.getA01_cpf());
	        oCall.setString(3, Bounty_Model.getA01_nome());
	        oCall.setString(4, Bounty_Model.getA01_email());
	        oCall.setString(5, Bounty_Model.getA01_endereco());
	        oCall.setString(6, Bounty_Model.getA01_cep());
	        oCall.setString(7, Bounty_Model.getA01_rg());
	        oCall.setString(8, Bounty_Model.getA01_datanascimento());
	        oCall.setString(9, Bounty_Model.getA01_senha());

	        oCall.execute();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
		public void PROC_EXCLUIR_CLIENTE(Nodebounty_Model Bounty_Model) {
		    try {
		        oCall = oConectar.getConexao().prepareCall("CALL PROC_EXCLUIR_CLIENTE(?)");
		        oCall.setInt(1, Bounty_Model.getA01_id());
		        oCall.execute();
		        System.out.println("Deletion successful."); // Add this line for debugging
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}



	

}