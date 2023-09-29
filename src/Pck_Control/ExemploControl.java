package Pck_Control;

import Pck_Model.ExemploModel;

public class ExemploControl {
	ExemploModel oExemploModelo = new ExemploModel();
	
	public void inserirExemplo (String sNome) {
		oExemploModelo.setA01_nome(sNome);
	}
	
	public void atualizarExemplo(int iCodigo_01, String sNome) {
		oExemploModelo.setA01_codigo(iCodigo_01);
		oExemploModelo.setA01_nome(sNome);
	}

	public void removerExemplo(int iCodigo_01) {
		oExemploModelo.setA01_codigo(iCodigo_01);
	}
	
}
