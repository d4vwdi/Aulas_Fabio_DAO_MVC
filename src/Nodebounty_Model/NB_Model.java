/*CONCEITO:
 * Model é a classe responsável por recuperar,
 * armazenar, atualizar e processar dados que serão
 * exibidos pelo View. É o back-end da nossa
 * aplicação e normalmente ela instancia um POJO, 
 * Plain Old Java Object, a classe mais simples possível
 * composta por: 01. Campos privados, 02. Construtores, 
 * 03. Métodos Getters e Setters.
 * A classe Model também pode implementar algumas regras de
 * negócio, como por exemplo no caso da Nodebounty, verificar
 * se o cliente possui saldo de Cashback positivo antes de 
 * realizar a solicitação ou se a data de nascimento é maior
 * ou igual a dezoito anos, embora não seja específico do Model
 * realizar todas as validações. */

package Nodebounty_Model;

import java.sql.Date;
/* Aqui, o import precisa constar em "module-info.java"
 * para que não haja nenhum erro. Para isso adicionamos
 * "requires java.sql;" dentro do nosso módulo Nodebounty_DAO_MVC, 
 * Em Java, os módulos são uma forma de organizar e encapsular 
 * código em pacotes relacionados, permitindo um controle mais 
 * preciso sobre a visibilidade e o acesso de classes e recursos.
 * Em outras palavras, o código dentro do módulo Nodebounty_DAO_MVC
 * depende do código fornecido pelo módulo java.sql. Isso nos permite 
 * usar as classes e funcionalidades do módulo java.sql em nosso
 * próprio código. Esse é o conceito de Injeção de Dependência, deixamos
 * o módulo de alto nível (esta classe) independente do módulo de baixo 
 * nível (java.sql, que serve somente para conectar ao banco). Caso contrário
 * qualquer mudança no módulo de baixo nível afetaria o módulo de alto nível, 
 * mesmo que o de alto nível esteja correto. Acabamos de aplicar Inversão de
 * Dependência (DIP) e Injeção de Dependência (DI).  
 * */


public class NB_Model {
	//Criação dos atributos presentes na tabela `clientes` no banco de dados
	private int id;
	private String cpf;
	private String nome;
	private String email;
	private String endereco;
	private String cep;
	private String rg;
	private String datanascimento;
	private String senha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	//Geração de Getters e Setters
	
	
	
	
	
	
	
	
	
}
