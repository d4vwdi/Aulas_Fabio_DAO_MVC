package Pck_Control;

import Pck_Model.Plano_Model;
import Pck_Persistencia.Plano_Persistencia;

public class Plano_Control {

	Plano_Model Plano_Model = new Plano_Model();
	Plano_Persistencia Plano_Persistencia = new Plano_Persistencia();
	
	public void PROC_INSERIR_PLANO_03(int iIdPlano, String sNomePlano, String sPorcentagemCashbackPlano, String sParceriasPlano) {
		Plano_Model.setA03_idplano(iIdPlano);
		Plano_Model.setA03_nomeplano(sNomePlano);
		Plano_Model.setA03_parceriasplano(sParceriasPlano);
		Plano_Model.setA03_porcentagemcashbackplano(sPorcentagemCashbackPlano);
		
		Plano_Persistencia.PROC_INSERIR_PLANO_03(Plano_Model);
	}
	
	public void PROC_ATUALIZAR_PLANO_03(int iIdPlano, String sNomePlano, String sPorcentagemCashbackPlano, String sParceriasPlano) {
		Plano_Model.setA03_idplano(iIdPlano);
		Plano_Model.setA03_nomeplano(sNomePlano);
		Plano_Model.setA03_parceriasplano(sParceriasPlano);
		Plano_Model.setA03_porcentagemcashbackplano(sPorcentagemCashbackPlano);
		
		Plano_Persistencia.PROC_ATUALIZAR_PLANO_03(Plano_Model);
	}
	
	public void PROC_EXCLUIR_PLANO_03(int iIdPlano, String sNomePlano, String sPorcentagemCashbackPlano, String sParceriasPlano) {
		Plano_Model.setA03_idplano(iIdPlano);
		
		Plano_Persistencia.PROC_EXCLUIR_PLANO_03(Plano_Model);
	}
	
	
	
}
