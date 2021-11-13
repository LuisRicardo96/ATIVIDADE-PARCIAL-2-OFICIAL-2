/*
	* < UNIME >
	* < B.S.I >
	* < PROGRAMAÇÃO ORIENTADA A OBJETOS 2 >
	* < PABLO ROXO >
	* < LUIS RICARDO SOUSA BORGES >
	*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class TelaEmpresaCadastro extends JFrame {

	private JPanel contentPane;
	private EmpresaRepositorio empresaRepo;
	private JTextField txtNome;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEndereco;
	private JTextField txtProfissao;

	public TelaEmpresaCadastro(EmpresaRepositorio empresaRepo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuário\\Documents\\cadastro.jpg"));
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.empresaRepo = empresaRepo;
		setBounds(200, 200, 320, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Informe os dados");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(33, 11, 214, 26);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 51, 39, 14);
		contentPane.add(lblNome);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 84, 62, 14);
		contentPane.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 115, 39, 14);
		contentPane.add(lblBairro);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(10, 148, 62, 14);
		contentPane.add(lblEndereco);

		JLabel lblProfissao = new JLabel("Profissao:");
		lblProfissao.setBounds(10, 181, 62, 14);
		contentPane.add(lblProfissao);
		
		txtNome = new JTextField();
		txtNome.setBounds(82, 48, 165, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(82, 81, 165, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(82, 112, 165, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(82, 145, 165, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtProfissao = new JTextField();
		txtProfissao.setBounds(82, 178, 165, 20);
		contentPane.add(txtProfissao);
		txtProfissao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(txtNome.getText().trim().equals("") || txtCidade.getText().trim().equals("") || txtBairro.getText().trim().equals("") || txtEndereco.getText().trim().equals("") || txtProfissao.getText().trim().equals("")){
					
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Alerta", JOptionPane.WARNING_MESSAGE);
					
				}else{
					Empresa empresa = new Empresa();
					empresa.setNome(txtNome.getText());
					empresa.setCidade(txtCidade.getText());
					empresa.setBairro(txtBairro.getText());
					empresa.setEndereco(txtEndereco.getText());
					empresa.setProfissao(txtProfissao.getText());
					empresaRepo.cadastrar(empresa);
					JOptionPane.showMessageDialog(btnCadastrar, "Aluno cadastrado com sucesso!");
					dispose();
				}
			}
		});
		btnCadastrar.setBounds(37, 232, 100, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCidade.setText("");
				txtBairro.setText("");
				txtEndereco.setText("");
				txtProfissao.setText("");
			}
		});
		btnLimpar.setBounds(147, 232, 100, 23);
		contentPane.add(btnLimpar);
	}
}
