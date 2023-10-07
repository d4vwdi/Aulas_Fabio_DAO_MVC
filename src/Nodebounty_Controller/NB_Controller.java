package Nodebounty_Controller;

import java.sql.Date;

import Nodebounty_Model.NB_Model;
import Nodebounty_Persistencia.NB_Persistencia;

/* CONCEITO: A classe Controller é responsável por gerenciar 
 * a lógica de controle ou de negócios de uma aplicação.
 * Ela atua como intermediário entre a camada de visualização 
 * (View) e a camada de modelo de dados (Model).
 * Sua principal característica é mapear as requisições feitas
 * pelo usuário através do browser (normalmente localhost:8080/algo),
 * através do path (/algo) o Controller retorna algum recurso, podendo
 * ser uma página HTML ou os dados do Model, através de métodos
 * chamados "Handler methods".
 *
 * 
 * */

public class NB_Controller {

	NB_Model Bounty_Model = new NB_Model();  
	NB_Persistencia Bounty_Persistencia = new NB_Persistencia();
	
	public void INSERIR_CLIENTE(String sCpf, String sNome, String sEmail, String sEndereco,
			String sCep, String sRg, String sData, String sSenha) {
		
		Bounty_Model.setCpf(sCpf);
		Bounty_Model.setNome(sNome);
		Bounty_Model.setEmail(sEmail);
		Bounty_Model.setEndereco(sEndereco);
		Bounty_Model.setCep(sCep);
		Bounty_Model.setRg(sRg);
		Bounty_Model.setDatanascimento(null);
		Bounty_Model.setSenha(sSenha);
		
		Bounty_Persistencia.INSERIR_CLIENTE(Bounty_Model);
	}
	
	public void ATUALIZAR_CLIENTE(String sNome,int iCodigo) {
	
	}
	
	public void EXCLUIR_CLIENTE(int iCodigo) {
		
	}


}
