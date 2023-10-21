/*------------------//------------------01------------------//*/
CREATE DATABASE IF NOT EXISTS `DB_nodebounty`;

USE `DB_nodebounty`;


/*PARTE 01 - Criação do banco (ou schema) e da tabela clientes*/
/*Criação da tabela cliente*/
CREATE TABLE `DB_nodebounty`.`clientes_01` (
  `a01_id` INT NOT NULL AUTO_INCREMENT,
  `a01_cpf` VARCHAR(255) NOT NULL,
  `a01_nome` VARCHAR(255) NOT NULL,
  `a01_email` VARCHAR(255) NOT NULL,
  `a01_endereco` VARCHAR(255) NULL,
  `a01_cep` VARCHAR(255) NOT NULL,
  `a01_rg` VARCHAR(255) NOT NULL,
  `a01_datanascimento` VARCHAR(255),
  `a01_senha` TEXT NOT NULL,
  PRIMARY KEY (`a01_id`));

/*Inserindo valores para trabalharmos com depois, na hora da testagem*/
INSERT INTO `DB_nodebounty`.`clientes_01` (a01_cpf, a01_nome, a01_email, a01_endereco, a01_cep, a01_rg, a01_datanascimento, a01_senha)
VALUES
    ('123.456.789-01', 'Seu Madruga', 'exemplo@email.com', 'Rua Exemplo 123', '12345-678', '12345678', '1990-01-01', 'senha123'),
    ('987.654.321-09', 'Dona Florinda', 'outro@email.com', 'Avenida Outra 456', '54321-876', '98765432', '1985-02-15', 'outrasenha456');

SELECT * FROM clientes_01;
/*------------------//------------------01------------------//*/

/*------------------//------------------02------------------//*/
/*PARTE 02 - Criação dos procedures (insert, delete & update)*/

/*Criando o Procedure para inserção de dados na tabela cliente*/

USE `DB_nodebounty`;
DROP procedure IF EXISTS `PROC_INSERIR_CLIENTE`;
DELIMITER $$
USE `DB_nodebounty`$$
CREATE DEFINER =`root`@`localhost` PROCEDURE `PROC_INSERIR_CLIENTE` (
IN V_CPF VARCHAR(255), 
IN V_NOME VARCHAR(255), 
IN V_EMAIL VARCHAR(255), 
IN V_ENDERECO VARCHAR(255), 
IN V_CEP VARCHAR(255), 
IN V_RG VARCHAR(255),
IN V_DATANASCIMENTO DATE,
IN V_SENHA TEXT)
BEGIN
    INSERT INTO `DB_nodebounty`.`clientes_01` (a01_CPF, a01_NOME, a01_EMAIL, a01_ENDERECO, a01_CEP, a01_RG, a01_DATANASCIMENTO, a01_SENHA)
    VALUES (V_CPF, V_NOME, V_EMAIL, V_ENDERECO, V_CEP, V_RG, V_DATANASCIMENTO, V_SENHA);
END$$
DELIMITER ;

/*Criando o Procedure para exclusão de dados na tabela*/ 

USE `DB_nodebounty`;
DROP procedure IF EXISTS `PROC_EXCLUIR_CLIENTE`;
DELIMITER $$
USE `DB_nodebounty`$$
CREATE DEFINER =`root`@`localhost` PROCEDURE `PROC_EXCLUIR_CLIENTE` (
IN V_ID INT)
BEGIN
	DELETE FROM `clientes_01` WHERE a01_id = V_ID;
END$$
DELIMITER ;

/*Criando o Procedure para atualizar dados de um cliente*/

USE `DB_nodebounty`;
DROP procedure IF EXISTS `PROC_ATUALIZAR_CLIENTE`;
DELIMITER $$
USE `DB_nodebounty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `PROC_ATUALIZAR_CLIENTE` (
    IN V_ID INT,
    IN V_CPF VARCHAR(255), 
    IN V_NOME VARCHAR(255), 
    IN V_EMAIL VARCHAR(255), 
    IN V_ENDERECO VARCHAR(255), 
    IN V_CEP VARCHAR(255), 
    IN V_RG VARCHAR(255),
    IN V_DATANASCIMENTO DATE,
    IN V_SENHA TEXT
)
BEGIN
    UPDATE `DB_nodebounty`.`clientes_01`
    SET a01_cpf = V_CPF,
		a01_nome = V_NOME,
        a01_email = V_EMAIL,
        a01_endereco = V_ENDERECO,
        a01_cep = V_CEP,
        a01_rg = V_RG,
        a01_datanascimento = V_DATANASCIMENTO,
        a01_senha = V_SENHA
    WHERE a01_id = V_ID;
END;$$
DELIMITER ;
/*------------------//------------------02------------------//*/

/*------------------//------------------03------------------//*/
/*PARTE 03 - Testado os nossos procedures*/
CALL PROC_INSERIR_CLIENTE('987.123.456-78', 'Seu Barriga', 'novo_cliente@email.com', 'Rua Nova 789', '98765-432', '98765431', '1988-09-10', 'senha123');
SELECT * FROM clientes_01;

CALL PROC_ATUALIZAR_CLIENTE(1, '517.625.589-52', 'Chaves', 'novo@email.com', 'Novo Endereco', '54321-987', '56856235', '2000-05-20', 'novaSenha');
SELECT * FROM clientes_01;

CALL PROC_EXCLUIR_CLIENTE(1);
SELECT * FROM clientes_01;
/*------------------//------------------03------------------//*/

-- Criação de uma VIEW chamada clientes_view
CREATE VIEW clientes_view AS
SELECT
    a01_id AS ID,
    a01_cpf AS CPF,
    a01_nome AS Nome,
    a01_email AS Email,
	a01_endereco AS Emdereco,
	a01_cep AS Cep,
	a01_rg AS RG,
	a01_datanascimento AS Data_Nascimento,
	a01_senha AS Senha
FROM
    DB_nodebounty.clientes_01;   


SELECT * FROM clientes_view;



/*Fim da configuração do banco no WorkBench. Partimos agora para o Eclipe.*/
