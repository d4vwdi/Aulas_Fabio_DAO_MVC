package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pck_DAO.Conexao_MySQL;
import Pck_Model.Plano_Model;

public class Plano_Persistencia {
	CallableStatement oCall;
	Conexao_MySQL oConectar = new Conexao_MySQL();
	PreparedStatement oPrepared;
	ResultSet oResultSet;
	
	public void PROC_INSERIR_PLANO_03(Plano_Model Plano_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_INSERIR_PLANO_03(?, ?, ?, ?)");
				oCall.setInt(1, Plano_Model.getA03_idplano());
				oCall.setString(2, Plano_Model.getA03_nomeplano());
				oCall.setString(3, Plano_Model.getA03_porcentagemcashbackplano());
				oCall.setString(4, Plano_Model.getA03_parceriasplano());


				oCall.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void PROC_ATUALIZAR_PLANO_03(Plano_Model Plano_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_ATUALIZAR_PLANO_03(?, ?, ?, ?)");
				oCall.setInt(1, Plano_Model.getA03_idplano());
				oCall.setString(2, Plano_Model.getA03_nomeplano());
				oCall.setString(3, Plano_Model.getA03_porcentagemcashbackplano());
				oCall.setString(4, Plano_Model.getA03_parceriasplano());


				oCall.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void PROC_EXCLUIR_PLANO_03(Plano_Model Plano_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_EXCLUIR_PLANO_03(?)");
				oCall.setInt(1, Plano_Model.getA03_idplano());
				
				oCall.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
