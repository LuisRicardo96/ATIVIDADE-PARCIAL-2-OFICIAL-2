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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class TelaEmpresaListagem extends JFrame {

	private JPanel contentPane;
	private EmpresaRepositorio empresaRepo;
	private JTable tblAlunos;
	private JButton btnExcluir;
	private JButton btnTelaEdicao;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	
		
	public TelaEmpresaListagem(EmpresaRepositorio empresaRepo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuário\\Documents\\inicial.png"));
		setTitle("Cadastro de Aluno");

		this.empresaRepo = empresaRepo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 794, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
				
		JButton btnTelaCadastro = new JButton("Cadastrar Aluno");
		btnTelaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaEmpresaCadastro telaEmpresaCadastro = new TelaEmpresaCadastro(empresaRepo);
				telaEmpresaCadastro.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						
						listarAlunos();
					}
				});
				telaEmpresaCadastro.setVisible(true);
				
			}
			
		});
		btnTelaCadastro.setBounds(559, 11, 157, 44);
		contentPane.add(btnTelaCadastro);
		
		lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/add3.png"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(720, 11, 48, 44);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrAlunos = new JScrollPane();
		
		scrAlunos.setBounds(10, 11, 539, 382);
		contentPane.add(scrAlunos);
		
		tblAlunos = new JTable();
		
		tblAlunos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		tblAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cidade", "Bairro", "Endereco", "Profissao"
			}
		));
		scrAlunos.setViewportView(tblAlunos);
		
		btnExcluir = new JButton("Excluir Aluno");
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) tblAlunos.getModel().getValueAt(tblAlunos.getSelectedRow(), 0);
				int i = JOptionPane.showConfirmDialog(
				        null, 
				        "Deseja continuar?"
				        );
				if(i == JOptionPane.YES_OPTION) {
					empresaRepo.excluir(id);
					listarAlunos();
					JOptionPane.showMessageDialog(null, "Item selecionado foi Excluido!");
				}
				else if(i == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Item selecionado não foi Excluido!");
				}
				else if(i == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Operação Cancelada!");
				}
			}
		});
		btnExcluir.setBounds(559, 121, 157, 44);
		contentPane.add(btnExcluir);
		
		lblNewLabel_2 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/delete.png"));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.setBounds(720, 121, 48, 44);
		contentPane.add(lblNewLabel_2);
		

		btnTelaEdicao = new JButton("Editar Aluno");
		btnTelaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) tblAlunos.getModel().getValueAt(tblAlunos.getSelectedRow(), 0);
				TelaEmpresaEdicao telaEmpresaEdicao = new TelaEmpresaEdicao(empresaRepo, id);
				telaEmpresaEdicao.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						listarAlunos();
					}
				});
				telaEmpresaEdicao.setVisible(true);
			}
		});
		btnTelaEdicao.setBounds(559, 66, 157, 44);
		contentPane.add(btnTelaEdicao);
		
		
		
		lblNewLabel_1 = new JLabel("");
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/edit.png"));
		lblNewLabel_1.setIcon(img1);
		lblNewLabel_1.setBounds(720, 66, 48, 44);
		contentPane.add(lblNewLabel_1);
		
		
		
		this.listarAlunos();
	}
	
	public void listarAlunos() {
		ArrayList<Empresa> empresas = this.empresaRepo.listar();
		DefaultTableModel model = (DefaultTableModel) tblAlunos.getModel();
		model.setRowCount(0);
		for(Empresa empresa: empresas) {
			model.addRow(new Object[] {
				empresa.getId(),
				empresa.getNome(),
				empresa.getCidade(),
				empresa.getBairro(),
				empresa.getEndereco(),
				empresa.getProfissao()
			});
		}
	}
}
