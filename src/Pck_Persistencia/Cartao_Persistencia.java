package Pck_Persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Pck_DAO.Conexao_MySQL;
import Pck_Model.Cartao_Model;

public class Cartao_Persistencia {
	CallableStatement oCall;
	Conexao_MySQL oConectar = new Conexao_MySQL();
	PreparedStatement oPrepared;
	ResultSet oResultSet;

	public void PROC_INSERIR_CARTAO_04(Cartao_Model Cartao_Model) {
		try {
			try {

				oCall = oConectar.getConexao().prepareCall("CALL PROC_INSERIR_CARTAO_04(?, ?, ?, ?, ?, ?, ?, ?)");
				oCall.setInt(1, Cartao_Model.getA04_idcartao());
				oCall.setString(2, Cartao_Model.getA04_titularcartao());
				oCall.setString(3, Cartao_Model.getA04_validadecartao());
				oCall.setString(4, Cartao_Model.getA04_numerocartao());
				oCall.setInt(5, Cartao_Model.getA04_cvccartao());
				oCall.setInt(6, Cartao_Model.getA03_idplano());

				oCall.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void PROC_ATUALIZAR_CARTAO_04(Cartao_Model Cartao_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_ATUALIZAR_CARTAO_04(?, ?, ?, ?, ?, ?, ?, ?)");
				oCall.setInt(1, Cartao_Model.getA04_idcartao());
				oCall.setString(2, Cartao_Model.getA04_titularcartao());
				oCall.setString(3, Cartao_Model.getA04_validadecartao());
				oCall.setString(4, Cartao_Model.getA04_numerocartao());
				oCall.setInt(5, Cartao_Model.getA04_cvccartao());
				oCall.setInt(6, Cartao_Model.getA03_idplano());

				oCall.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void PROC_EXCLUIR_CARTAO_04(Cartao_Model Cartao_Model) {
		try {
			try {
				oCall = oConectar.getConexao().prepareCall("CALL PROC_EXCLUIR_CARTAO_04(?)");
				oCall.setInt(1, Cartao_Model.getA04_idcartao());

				oCall.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
