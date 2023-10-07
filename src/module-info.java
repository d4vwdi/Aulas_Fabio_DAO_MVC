/**
 * 
 */
/**
 * 
 */
module Nodebounty_DAO_MVC {
/* Aplicamos os princípios DIP (Depency 
 * Inversion Principle) e DI (Dependency Injection)
 * abaixo, essencialmente separando o módulo de baixo 
 * nível dos módulos de alto nível que serão instanciados
 * nos outros pacotes MVC.
 */
	requires java.sql;
	requires java.desktop;
}