package br.ufsc.dsoii.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufsc.dsoii.control.ClienteControl;
import br.ufsc.dsoii.model.Cliente;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	
	private ClienteControl clienteControl = new ClienteControl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(45, 67, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(45, 94, 70, 15);
		contentPane.add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(114, 65, 114, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(114, 94, 114, 19);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				c.setNome(txtNome.getText());
				c.setCpf(txtCpf.getText());
				clienteControl.getClienteDao().create(c);
				txtNome.setText("");
				txtCpf.setText("");
			}
		});
		btnCadastrar.setBounds(168, 190, 117, 25);
		contentPane.add(btnCadastrar);
	}
}
