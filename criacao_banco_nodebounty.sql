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
  
  CREATE TABLE `DB_nodebounty`.`plano_03` (
  `a03_idplano` INT NOT NULL AUTO_INCREMENT,
  `a03_nomeplano` VARCHAR(255) NOT NULL,
  `a03_porcentagemcashbackplano` DECIMAL(5, 2) NOT NULL,
  `a03_parceriasplano` TEXT,
  PRIMARY KEY (`a03_idplano`)
);

CREATE TABLE `DB_nodebounty`.`cartao_04` (
  `a04_idcartao` INT NOT NULL AUTO_INCREMENT,
  `a04_titularcartao` VARCHAR(255) NOT NULL,
  `a04_validadecartao` DATE NOT NULL,
  `a04_numerocartao` VARCHAR(16) NOT NULL,
  `a04_cvccartao` INT NOT NULL,
  PRIMARY KEY (`a04_idcartao`)
);

ALTER TABLE `cartao_04`
ADD COLUMN `a03_idplano` INT,
ADD FOREIGN KEY (`a03_idplano`) REFERENCES `plano_03` (`a03_idplano`);


CREATE TABLE `DB_nodebounty`.`conta_corrente_02` (
  `a02_idcontacorrente` INT NOT NULL AUTO_INCREMENT,
  `a02_saldoconta` DECIMAL(10, 2) NOT NULL,
  `a02_statusconta` VARCHAR(255) NOT NULL,
  `a01_idcliente` INT,
  `a04_idcartao` INT,
  PRIMARY KEY (`a02_idcontacorrente`),
  FOREIGN KEY (`a01_idcliente`) REFERENCES `clientes_01` (`a01_id`),
  FOREIGN KEY (`a04_idcartao`) REFERENCES `cartao_04` (`a04_idcartao`)
);

ALTER TABLE `conta_corrente_02`
ADD COLUMN `a03_idplano` INT,
ADD FOREIGN KEY (`a03_idplano`) REFERENCES `plano_03` (`a03_idplano`);



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

/*Criando o Procedure para inserir dados na tabela conta corrente*/
USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_INSERIR_CONTA_CORRENTE_02`;
DELIMITER $$
CREATE PROCEDURE `PROC_INSERIR_CONTA_CORRENTE_02` (
    IN V_IDCONTACORRENTE INT,
    IN V_SALDOCONTA DECIMAL(10, 2),
    IN V_STATUSCONTA VARCHAR(255)
)
BEGIN
    INSERT INTO `conta_corrente_02` (a02_idcontacorrente, a02_saldoconta, a02_statusconta)
    VALUES (V_IDCONTACORRENTE, V_SALDOCONTA, V_STATUSCONTA);
END$$
DELIMITER ;

/*Criando o Procedure para atualizar dados na tabela conta corrente*/
USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_ATUALIZAR_CONTA_CORRENTE_02`;
DELIMITER $$
CREATE PROCEDURE `PROC_ATUALIZAR_CONTA_CORRENTE_02` (
    IN V_IDCONTACORRENTE INT,
    IN V_SALDOCONTA DECIMAL(10, 2),
    IN V_STATUSCONTA VARCHAR(255)
)
BEGIN
    UPDATE `conta_corrente_02`
    SET a02_saldoconta = V_SALDOCONTA,
        a02_statusconta = V_STATUSCONTA
    WHERE a02_idcontacorrente = V_IDCONTACORRENTE;
END$$
DELIMITER ;

/*Criando o Procedure para excluir dados na tabela conta corrente*/
USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_EXCLUIR_CONTA_CORRENTE_02`;
DELIMITER $$
CREATE PROCEDURE `PROC_EXCLUIR_CONTA_CORRENTE_02` (
    IN V_IDCONTACORRENTE INT
)
BEGIN
    DELETE FROM `conta_corrente_02`
    WHERE a02_idcontacorrente = V_IDCONTACORRENTE;
END$$
DELIMITER ;

/*Criando o Procedure para inserir dados na tabela plano*/

USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_INSERIR_PLANO_03`;
DELIMITER $$
CREATE PROCEDURE `PROC_INSERIR_PLANO_03` (
    IN V_IDPLANO INT,
    IN V_NOMEPLANO VARCHAR(255),
    IN V_PORCENTAGEMCASHBACK DECIMAL(5, 2),
    IN V_PARCERIASPLANO TEXT
)
BEGIN
    INSERT INTO `plano_03` (a03_idplano, a03_nomeplano, a03_porcentagemcashbackplano, a03_parceriasplano)
    VALUES (V_IDPLANO, V_NOMEPLANO, V_PORCENTAGEMCASHBACK, V_PARCERIASPLANO);
END$$
DELIMITER ;

/*Criando o Procedure para atualizar dados na tabela plano*/

USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_ATUALIZAR_PLANO_03`;
DELIMITER $$
CREATE PROCEDURE `PROC_ATUALIZAR_PLANO_03` (
    IN V_IDPLANO INT,
    IN V_NOMEPLANO VARCHAR(255),
    IN V_PORCENTAGEMCASHBACK DECIMAL(5, 2),
    IN V_PARCERIASPLANO TEXT
)
BEGIN
    UPDATE `plano_03`
    SET a03_nomeplano = V_NOMEPLANO,
        a03_porcentagemcashbackplano = V_PORCENTAGEMCASHBACK,
        a03_parceriasplano = V_PARCERIASPLANO
    WHERE a03_idplano = V_IDPLANO;
END$$
DELIMITER ;

/*Criando o Procedure para excluir dados na tabela plano*/

USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_EXCLUIR_PLANO_03`;
DELIMITER $$
CREATE PROCEDURE `PROC_EXCLUIR_PLANO_03` (
    IN V_IDPLANO INT
)
BEGIN
    DELETE FROM `plano_03`
    WHERE a03_idplano = V_IDPLANO;
END$$
DELIMITER ;

/*Criando o Procedure para inserir dados na tabela cartao*/
USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_INSERIR_CARTAO_04`;
DELIMITER $$
CREATE PROCEDURE `PROC_INSERIR_CARTAO_04` (
    IN V_IDCARTAO INT,
    IN V_TITULARCARTAO VARCHAR(255),
    IN V_VALIDADECARTAO DATE,
    IN V_NUMEROCARTAO VARCHAR(16),
    IN V_CVCCARTAO INT
)
BEGIN
    INSERT INTO `cartao_04` (a04_idcartao, a04_titularcartao, a04_validadecartao, a04_numerocartao, a04_cvccartao)
    VALUES (V_IDCARTAO, V_TITULARCARTAO, V_VALIDADECARTAO, V_NUMEROCARTAO, V_CVCCARTAO);
END$$
DELIMITER ;

/*Criando o Procedure para atualizar dados na tabela cartao*/

USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_ATUALIZAR_CARTAO_04`;
DELIMITER $$
CREATE PROCEDURE `PROC_ATUALIZAR_CARTAO_04` (
    IN V_IDCARTAO INT,
    IN V_TITULARCARTAO VARCHAR(255),
    IN V_VALIDADECARTAO DATE,
    IN V_NUMEROCARTAO VARCHAR(16),
    IN V_CVCCARTAO INT
)
BEGIN
    UPDATE `cartao_04`
    SET a04_titularcartao = V_TITULARCARTAO,
        a04_validadecartao = V_VALIDADECARTAO,
        a04_numerocartao = V_NUMEROCARTAO,
        a04_cvccartao = V_CVCCARTAO
    WHERE a04_idcartao = V_IDCARTAO;
END$$
DELIMITER ;

/*Criando o Procedure para excluir dados na tabela cartao*/

USE `DB_nodebounty`;
DROP PROCEDURE IF EXISTS `PROC_EXCLUIR_CARTAO_04`;
DELIMITER $$
CREATE PROCEDURE `PROC_EXCLUIR_CARTAO_04` (
    IN V_IDCARTAO INT
)
BEGIN
    DELETE FROM `cartao_04`
    WHERE a04_idcartao = V_IDCARTAO;
END$$
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

CALL PROC_INSERIR_CONTA_CORRENTE_02(1, 5000.00, 'Ativo');
SELECT * FROM conta_corrente_02;

CALL PROC_ATUALIZAR_CONTA_CORRENTE_02(1, 7500.00, 'Ativo');
SELECT * FROM conta_corrente_02;

CALL PROC_EXCLUIR_CONTA_CORRENTE_02(1);
SELECT * FROM conta_corrente_02;

CALL PROC_INSERIR_PLANO_03(1, 'Beauty', 10.5, 'MAC, MakeB, Vult');
SELECT * FROM plano_03;

CALL PROC_ATUALIZAR_PLANO_03(1, 'Health', 15.0, 'Updated Parcerias');
SELECT * FROM plano_03;

CALL PROC_EXCLUIR_PLANO_03(1); 
SELECT * FROM plano_03;

CALL PROC_INSERIR_CARTAO_04(1, 'John Doe', '2024-12-31', '1234567890123456', 123);
SELECT * FROM cartao_04;

CALL PROC_ATUALIZAR_CARTAO_04(1, 'Updated Name', '2025-12-31', '9876543210987654', 456);
SELECT * FROM cartao_04;

CALL PROC_EXCLUIR_CARTAO_04(1);
SELECT * FROM cartao_04;

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