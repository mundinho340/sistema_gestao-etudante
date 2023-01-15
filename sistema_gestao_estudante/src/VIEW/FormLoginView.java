package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class frmLoginBView {

	private JFrame frame;
	private JTextField txtNomeUsuario;
	private JTextField txtSenhaUsuario;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginBView window = new frmLoginBView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmLoginBView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 0);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Nome do usuario");
		label_1.setBounds(42, 23, 167, 14);
		frame.getContentPane().add(label_1);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(35, 48, 330, 20);
		frame.getContentPane().add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel label_2 = new JLabel("Senha de usuario");
		label_2.setBounds(42, 96, 271, 14);
		frame.getContentPane().add(label_2);
		
		txtSenhaUsuario = new JTextField();
		txtSenhaUsuario.setColumns(10);
		txtSenhaUsuario.setBounds(35, 145, 330, 20);
		frame.getContentPane().add(txtSenhaUsuario);
		
		JButton btnLogar = new JButton("Logar");
		buttonGroup.add(btnLogar);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogar.setBounds(35, 188, 89, 23);
		frame.getContentPane().add(btnLogar);
	}

}

