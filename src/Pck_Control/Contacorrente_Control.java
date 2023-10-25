package Pck_Control;

import Pck_Model.Contacorrente_Model;
import Pck_Persistencia.Contacorrente_Persistencia;

public class Contacorrente_Control {

    Contacorrente_Model Conta_Model = new Contacorrente_Model();
    Contacorrente_Persistencia Conta_Persistencia = new Contacorrente_Persistencia();

    public void PROC_INSERIR_CONTA_CORRENTE_02(int iIdConta, String sSaldoConta, String sStatusConta) {
        Conta_Model.setA02_idcontacorrente(iIdConta);
        Conta_Model.setA02_saldoconta(sSaldoConta);
        Conta_Model.setA02_statusconta(sStatusConta);

        Conta_Persistencia.PROC_INSERIR_CONTA_CORRENTE_02(Conta_Model);
    }

    public void PROC_ATUALIZAR_CONTA_CORRENTE_02(int iIdConta, String sSaldoConta, String sStatusConta) {
        Conta_Model.setA02_idcontacorrente(iIdConta);
        Conta_Model.setA02_saldoconta(sSaldoConta);
        Conta_Model.setA02_statusconta(sStatusConta);


        Conta_Persistencia.PROC_ATUALIZAR_CONTA_CORRENTE_02(Conta_Model);
    }

    public void PROC_EXCLUIR_CONTA_CORRENTE_02(int iIdConta) {
        Conta_Model.setA02_idcontacorrente(iIdConta);
        Conta_Persistencia.PROC_EXCLUIR_CONTA_CORRENTE_02(Conta_Model);
    }
}
