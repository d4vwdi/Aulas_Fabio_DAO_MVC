package Nodebounty_Controller;

import Nodebounty_Model.NB_Model;

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
}
