/*------------------//------------------01------------------//*/
CREATE DATABASE IF NOT EXISTS `nodebounty`;

USE `nodebounty`;


/*PARTE 01 - Criação do banco (ou schema) e da tabela clientes*/
/*Criação da tabela cliente*/
CREATE TABLE `nodebounty`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `endereco` VARCHAR(255) NULL,
  `cep` VARCHAR(255) NOT NULL,
  `rg` VARCHAR(255) NOT NULL,
  `datanascimento` VARCHAR(255),
  `senha` TEXT NOT NULL,
  PRIMARY KEY (`id`));

/*Inserindo valores para trabalharmos com depois, na hora da testagem*/
INSERT INTO `nodebounty`.`clientes` (cpf, nome, email, endereco, cep, rg, datanascimento, senha)
VALUES
    ('123.456.789-01', 'Seu Madruga', 'exemplo@email.com', 'Rua Exemplo 123', '12345-678', '12345678', '1990-01-01', 'senha123'),
    ('987.654.321-09', 'Dona Florinda', 'outro@email.com', 'Avenida Outra 456', '54321-876', '98765432', '1985-02-15', 'outrasenha456');

SELECT * FROM clientes;
/*------------------//------------------01------------------//*/

/*------------------//------------------02------------------//*/
/*PARTE 02 - Criação dos procedures (insert, delete & update)*/

/*Criando o Procedure para inserção de dados na tabela cliente*/

USE `nodebounty`;
DROP procedure IF EXISTS `INSERIR_CLIENTE`;
DELIMITER $$
USE `nodebounty`$$
CREATE DEFINER =`root`@`localhost` PROCEDURE `INSERIR_CLIENTE` (
IN V_CPF VARCHAR(255), 
IN V_NOME VARCHAR(255), 
IN V_EMAIL VARCHAR(255), 
IN V_ENDERECO VARCHAR(255), 
IN V_CEP VARCHAR(255), 
IN V_RG VARCHAR(255),
IN V_DATANASCIMENTO DATE,
IN V_SENHA TEXT)
BEGIN
    INSERT INTO `nodebounty`.`clientes` (CPF, NOME, EMAIL, ENDERECO, CEP, RG, DATANASCIMENTO, SENHA)
    VALUES (V_CPF, V_NOME, V_EMAIL, V_ENDERECO, V_CEP, V_RG, V_DATANASCIMENTO, V_SENHA);
END$$
DELIMITER ;

/*Criando o Procedure para exclusão de dados na tabela*/ 

USE `nodebounty`;
DROP procedure IF EXISTS `EXCLUIR_CLIENTE`;
DELIMITER $$
USE `nodebounty`$$
CREATE DEFINER =`root`@`localhost` PROCEDURE `EXCLUIR_CLIENTE` (
IN V_ID INT)
BEGIN
	DELETE FROM `clientes` WHERE id = V_ID;
END$$
DELIMITER ;

/*Criando o Procedure para atualizar dados de um cliente*/

USE `nodebounty`;
DROP procedure IF EXISTS `ATUALIZAR_CLIENTE`;
DELIMITER $$
USE `nodebounty`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ATUALIZAR_CLIENTE` (
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
    UPDATE `nodebounty`.`clientes`
    SET cpf = V_CPF,
	nome = V_NOME,
        email = V_EMAIL,
        endereco = V_ENDERECO,
        cep = V_CEP,
        rg = V_RG,
        datanascimento = V_DATANASCIMENTO,
        senha = V_SENHA
    WHERE id = V_ID;
END;$$
DELIMITER ;
/*------------------//------------------02------------------//*/

/*------------------//------------------03------------------//*/
/*PARTE 03 - Testado os nossos procedures*/
CALL INSERIR_CLIENTE('987.123.456-78', 'Seu Barriga', 'novo_cliente@email.com', 'Rua Nova 789', '98765-432', '98765431', '1988-09-10', 'senha123');
SELECT * FROM clientes;

CALL ATUALIZAR_CLIENTE(1, '517.625.589-52', 'Chaves', 'novo@email.com', 'Novo Endereco', '54321-987', '56856235', '2000-05-20', 'novaSenha');
SELECT * FROM clientes;

CALL EXCLUIR_CLIENTE(4);
SELECT * FROM clientes;
/*------------------//------------------03------------------//*/

/*Fim da configuração do banco no WorkBench. Partimos agora para o Eclipe.*/

drop database nodebounty;
