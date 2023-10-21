package Pck_Control;

import Pck_Model.Nodebounty_Model;
import Pck_Persistencia.Nodebounty_Persistencia;

public class Nodebounty_Control {
	
	
	Nodebounty_Model Bounty_Model = new Nodebounty_Model();  
	Nodebounty_Persistencia Bounty_Persistencia = new Nodebounty_Persistencia();

	
	public void PROC_INSERIR_CLIENTE(String sCpf, String sNome, String sEmail, String sEndereco,
			String sCep, String sRg, String sData, String sSenha) {
		
		Bounty_Model.setA01_cpf(sCpf);
		Bounty_Model.setA01_nome(sNome);
		Bounty_Model.setA01_email(sEmail);
		Bounty_Model.setA01_endereco(sEndereco);
		Bounty_Model.setA01_cep(sCep);
		Bounty_Model.setA01_rg(sRg);
		Bounty_Model.setA01_datanascimento(null);
		Bounty_Model.setA01_senha(sSenha);
		
		Bounty_Persistencia.PROC_INSERIR_CLIENTE(Bounty_Model);
	}
	
	public void PROC_ATUALIZAR_CLIENTE(String sNome, int sId, String sCpf, String sEmail, String sEndereco,
			String sCep, String sRg, String sData, String sSenha) {
			
		Bounty_Model.setA01_id(sId);
		Bounty_Model.setA01_cpf(sCpf);
		Bounty_Model.setA01_nome(sNome);
		Bounty_Model.setA01_email(sEmail);
		Bounty_Model.setA01_endereco(sEndereco);
		Bounty_Model.setA01_cep(sCep);
		Bounty_Model.setA01_rg(sRg);
		Bounty_Model.setA01_datanascimento(null);
		Bounty_Model.setA01_senha(sSenha);
		
		Bounty_Persistencia.PROC_ATUALIZAR_CLIENTE(Bounty_Model);
	
	}
	
	public void PROC_EXCLUIR_CLIENTE(int sId) {
	    Bounty_Model.setA01_id(sId);
	    System.out.println("ID to delete: " + sId); // Add this line for debugging
	    Bounty_Persistencia.PROC_EXCLUIR_CLIENTE(Bounty_Model);
	}

}