package Pck_Control;

import Pck_Model.Cartao_Model;
import Pck_Persistencia.Cartao_Persistencia;

public class Cartao_Control {

	Cartao_Model Cartao_Model = new Cartao_Model();
	Cartao_Persistencia Cartao_Persistencia = new Cartao_Persistencia();

	public void PROC_INSERIR_CARTAO_04(int iIdCartao, String sTitularCartao, String sValidadeCartao, String sNumeroCartao, int iCvcCartao, int iIdPlano) {

		Cartao_Model.setA04_idcartao(iIdCartao);
		Cartao_Model.setA04_titularcartao(sTitularCartao);
		Cartao_Model.setA04_validadecartao(sValidadeCartao);
		Cartao_Model.setA04_numerocartao(sNumeroCartao);
		Cartao_Model.setA04_cvccartao(iCvcCartao);
		Cartao_Model.setA03_idplano(iIdPlano);
		
		//Bounty_Persistencia.PROC_INSERIR_CLIENTE(Bounty_Model);
		Cartao_Persistencia.PROC_INSERIR_CARTAO_04(Cartao_Model);
	}

	public void PROC_ATUALIZAR_CARTAO_04(int iIdCartao, String sTitularCartao, String sValidadeCartao, String sNumeroCartao, int iCvcCartao, int iIdPlano) {
		
		Cartao_Model.setA04_idcartao(iIdCartao);
		Cartao_Model.setA04_titularcartao(sTitularCartao);
		Cartao_Model.setA04_validadecartao(sValidadeCartao);
		Cartao_Model.setA04_numerocartao(sNumeroCartao);
		Cartao_Model.setA04_cvccartao(iCvcCartao);
		Cartao_Model.setA03_idplano(iIdPlano);
		
		//Bounty_Persistencia.PROC_INSERIR_CLIENTE(Bounty_Model);
		Cartao_Persistencia.PROC_ATUALIZAR_CARTAO_04(Cartao_Model);
		
	}

	public void PROC_EXCLUIR_CARTAO_04(int iIdCartao) {
		
		Cartao_Model.setA04_idcartao(iIdCartao);
		
		Cartao_Persistencia.PROC_EXCLUIR_CARTAO_04(Cartao_Model);
		
	}

}
