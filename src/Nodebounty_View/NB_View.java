package Nodebounty_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Nodebounty_Controller.NB_Controller;

public class NB_View extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JLabel  jl_label0;
	JLabel  jl_label1;
	JLabel  jl_label2;
	JLabel  jl_label3;
	JLabel  jl_label4;
	JLabel  jl_label5;
	JLabel  jl_label6;
	JLabel  jl_label7;
	JTextField  jt_cpf;
	JTextField  jt_nome;
	JTextField  jt_email;
	JTextField  jt_endereco;
	JTextField  jt_cep;
	JTextField  jt_rg;
	JTextField  jt_datanascimento;
	JTextField  jt_senha;	
	JButton jb_inserir;
	
	NB_Controller Bounty_Controller = new NB_Controller();
	
	public NB_View() {
		setTitle("Exemplo MVC + DAO simplificado");
		setBounds(100,100,430,300);
		
		jl_label0 = new JLabel("CPF");
		jl_label0.setBounds(20,20,100,20);
		
		jt_cpf = new JTextField("");
		jt_cpf.setBounds(130,20,100,20);
		
		jl_label1 = new JLabel("Nome");
		jl_label1.setBounds(20,40,120,20);
		
		jt_nome = new JTextField("");
		jt_nome.setBounds(130,40,120,20);
		
		jl_label2 = new JLabel("Email");
		jl_label2.setBounds(20,60,140,20);
		
		jt_email = new JTextField("");
		jt_email.setBounds(130,60,140,20);
		
		jl_label3 = new JLabel("Endereco");
		jl_label3.setBounds(20,80,160,20);
		
		jt_endereco = new JTextField("");
		jt_endereco.setBounds(130,80,160,20);
		
		jl_label4 = new JLabel("CEP");
		jl_label4.setBounds(20,100,180,20);
		
		jt_cep = new JTextField("");
		jt_cep.setBounds(130,100,180,20);
		
		jl_label5 = new JLabel("RG");
		jl_label5.setBounds(20,120,200,20);
		
		jt_rg = new JTextField("");
		jt_rg.setBounds(130,120,200,20);
		
		jl_label6 = new JLabel("Data Nascimento");
		jl_label6.setBounds(20,140,220,20);
		
		jt_datanascimento = new JTextField("");
		jt_datanascimento.setBounds(130,140,220,20);
		
		jl_label7 = new JLabel("Senha");
		jl_label7.setBounds(20,160,240,20);
		
		jt_senha = new JTextField("");
		jt_senha.setBounds(130,160,240,20);
		
		
		jb_inserir = new JButton("Inserir");
		jb_inserir.setBounds(20,180,260,20);
		
		getContentPane().setLayout(null);
		getContentPane().add(jl_label0);
		getContentPane().add(jt_cpf);
		getContentPane().add(jl_label1);
		getContentPane().add(jt_nome);
		getContentPane().add(jl_label2);
		getContentPane().add(jt_email);
		getContentPane().add(jl_label3);
		getContentPane().add(jt_endereco);
		getContentPane().add(jl_label4);
		getContentPane().add(jt_cep);
		getContentPane().add(jl_label5);
		getContentPane().add(jt_rg);
		getContentPane().add(jl_label6);
		getContentPane().add(jt_datanascimento);
		getContentPane().add(jl_label7);
		getContentPane().add(jt_senha);
		getContentPane().add(jb_inserir);
		
		jb_inserir.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==jb_inserir) Bounty_Controller.INSERIR_CLIENTE(
				jt_cpf.getText(),
				jt_nome.getText(),
				jt_email.getText(),
				jt_endereco.getText(),
				jt_cep.getText(),
				jt_rg.getText(),
				jt_datanascimento.getText(),
				jt_senha.getText());
	}


	
	public static void main (String[] args) {
		NB_View obj_interface = new NB_View();
		obj_interface.setVisible(true);
		
	}
	 
		
	 
}
