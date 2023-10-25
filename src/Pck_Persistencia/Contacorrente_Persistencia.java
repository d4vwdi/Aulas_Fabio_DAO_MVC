package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pck_DAO.Conexao_MySQL;
import Pck_Model.Contacorrente_Model;

public class Contacorrente_Persistencia {
	CallableStatement oCall;
	Conexao_MySQL oConectar = new Conexao_MySQL();
	PreparedStatement oPrepared;
	ResultSet oResultSet;

	public void PROC_INSERIR_CONTA_CORRENTE_02(Contacorrente_Model Conta_Model) {
		
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_INSERIR_CONTA_CORRENTE_02(?, ?, ?)");
				oCall.setInt(1, Conta_Model.getA02_idcontacorrente());
				oCall.setString(2, Conta_Model.getA02_saldoconta());
				oCall.setString(3, Conta_Model.getA02_statusconta());
				
				oCall.execute()
;			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	};
	
	public void PROC_ATUALIZAR_CONTA_CORRENTE_02(Contacorrente_Model Conta_Model) {
		
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_INSERIR_CONTA_CORRENTE_02(?, ?, ?)");
				oCall.setInt(1, Conta_Model.getA02_idcontacorrente());
				oCall.setString(2, Conta_Model.getA02_saldoconta());
				oCall.setString(3, Conta_Model.getA02_statusconta());
				
				oCall.execute()
;			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	};
	
	public void PROC_EXCLUIR_CONTA_CORRENTE_02(Contacorrente_Model Conta_Model) {
		
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_INSERIR_CONTA_CORRENTE_02(?)");
				oCall.setInt(1, Conta_Model.getA02_idcontacorrente());

				
				oCall.execute()
;			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	};
	


}
