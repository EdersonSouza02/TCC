package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Controller.LoginController;
import VO.LoginVO;
import ViewFuncionarios.ViewMenuDesignFuncionario;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewLoginDesign extends JFrame {
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	static ViewLoginDesign frameLogin = new ViewLoginDesign();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameLogin.setVisible(true);
					frameLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewLoginDesign() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(54, 33, 817, 564);
		JPanel contentPane = new JPanel();
		contentPane.setSize(new Dimension(788, 554));
		contentPane.setName("Login");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(340, 0, 471, 535);
		panel.setBackground(new Color(17, 144, 147));
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Varej\u00E3o Santos");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(156, 299, 165, 27);
		panel.add(lblNewLabel_2);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUsuario.setBounds(45, 125, 44, 16);

		txtLogin = new JTextField();
		txtLogin.setBounds(45, 152, 240, 27);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSenha.setBounds(45, 205, 36, 14);

		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					try {

						if (logar().equals("Administrador")) {

							ViewMenuDesign menu = new ViewMenuDesign();
							menu.setVisible(true);
							menu.setLocationRelativeTo(null);

							dispose();

						} else if (logar().equals("Funcionario")) {
							ViewMenuDesignFuncionario menu2 = new ViewMenuDesignFuncionario();
							menu2.setVisible(true);
							menu2.setLocationRelativeTo(null);
							dispose();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		});
		txtSenha.setBounds(45, 231, 240, 28);
		contentPane.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {

		});
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setBounds(45, 292, 240, 32);
		btnEntrar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(17, 144, 147), new Color(17, 144, 147),
				new Color(17, 144, 147), new Color(17, 144, 147)));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(17, 144, 147));
		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {

					if (logar().equals("Administrador")) {

						ViewMenuDesign menu = new ViewMenuDesign();
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);

						dispose();

					} else if (logar().equals("Funcionario")) {
						ViewMenuDesignFuncionario menu = new ViewMenuDesignFuncionario();
						menu.setVisible(true);
						menu.setLocationRelativeTo(null);
						dispose();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(17, 152, 28, 27);
		lblNewLabel.setIcon(
				new ImageIcon(ViewLoginDesign.class.getResource("/imagens/icons8-administrador-masculino.png")));

		JLabel label = new JLabel("");
		label.setBounds(17, 230, 28, 27);
		label.setIcon(new ImageIcon(ViewLoginDesign.class.getResource("/imagens/icons8-senha.png")));

		JLabel lblEsqueceuASenha = new JLabel("Esqueceu a senha?");
		lblEsqueceuASenha.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				ViewEsquecerSenha name = new ViewEsquecerSenha();
				name.setVisible(true);
				name.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblEsqueceuASenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEsqueceuASenha.setBounds(17, 345, 98, 16);
		lblEsqueceuASenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.setLayout(null);
		contentPane.add(lblUsuario);
		contentPane.add(lblNewLabel);
		contentPane.add(txtLogin);
		contentPane.add(lblSenha);
		contentPane.add(label);
		contentPane.add(btnEntrar);
		contentPane.add(lblEsqueceuASenha);
		contentPane.add(panel);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ViewLoginDesign.class.getResource("/imagens/logoOficial.png")));
		label_1.setBounds(156, 149, 145, 138);
		panel.add(label_1);

		JLabel lblNewLabel_1 = new JLabel("Cadastrar Usu\u00E1rio");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				CadastroUsuarioView cadastroUsuarioView = new CadastroUsuarioView();
				cadastroUsuarioView.setVisible(true);
				cadastroUsuarioView.setLocationRelativeTo(null);
				dispose();

			}
		});
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(192, 345, 98, 16);
		contentPane.add(lblNewLabel_1);

	}

	private String logar() throws Exception {
		LoginVO loginVO = new LoginVO();

		loginVO.setLogin(txtLogin.getText());
		loginVO.setSenha(txtSenha.getText());

		LoginController controller = new LoginController();
		return controller.logar(loginVO);

	}
}
