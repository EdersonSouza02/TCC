package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

import Controller.ProdutoController;
import VO.ProdutoVO;
import Validator.CadastroEntradaProdutroValidation;

import javax.swing.JScrollBar;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroProdutosView extends JFrame {

	private JPanel contentPane;

	static CadastroProdutosView frameProdutos = new CadastroProdutosView();
	public static JTextField txtCodigo;
	public static JTextField txtNome;
	private JTextField txtPesquisa;
	public static JComboBox comboBox;
	private static JTable table;
	private JTextField txtLote;
	public static JTextField txtCodProd;
	public static JTextField txtValor;
	public static JTextField txtQuantidade;
	public static JTextField txtPeso;
	private JTextField txtPesquisar;
	private JTable table_1;
	public static JDateChooser txtData;
	public static JLabel lblNomeProduto;
	public static JLabel lblCodigoProduto;
	public static JLabel lblTipo;
	public static JLabel lblCdigoDoProduto;
	public static JLabel lblDataDeValidade;
	public static JLabel lblValor;
	public static JLabel lblQuantidade;
	public static JLabel lblPeso;
	private JTextField textField;

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

					frameProdutos.setVisible(true);
					frameProdutos.setLocationRelativeTo(null);
					// frameProdutos.setExtendedState(MAXIMIZED_BOTH);

					pesquisarProdutoTodos();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroProdutosView() {
		setResizable(false);
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 953, 739);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBounds(0, 0, 272, 714);
		panel.setBackground(new Color(17, 144, 147));
		contentPane.add(panel);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 490, 0, 2);

		JButton button = new JButton("Cadastro de Clientes");
		button.setMnemonic(KeyEvent.VK_1);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBounds(0, 131, 270, 48);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroClienteView window = new CadastroClienteView();
				window.frmCadastroDeCliente.setVisible(true);
				window.frmCadastroDeCliente.setLocationRelativeTo(null);

				dispose();
			}
		});
		button.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-gest\u00E3o-de-cliente-25.png")));
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), null));
		button.setBackground(new Color(17, 144, 147));

		JButton button_1 = new JButton("Estoque");
		button_1.setMnemonic(KeyEvent.VK_5);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBounds(0, 371, 270, 48);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ViewEstoqueDesign estoque = new ViewEstoqueDesign();
				estoque.setVisible(true);
				estoque.setLocationRelativeTo(null);

				dispose();
			}
		});
		button_1.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-procurar-estoque-25.png")));
		button_1.setOpaque(true);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), null));
		button_1.setBackground(new Color(17, 144, 147));

		JButton button_2 = new JButton("Cadastro de Fornecedores");
		button_2.setMnemonic(KeyEvent.VK_2);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setBounds(0, 191, 270, 48);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroFornecedorView cadastroFornecedorView = new CadastroFornecedorView();
				cadastroFornecedorView.frame.setVisible(true);
				cadastroFornecedorView.frame.setLocationRelativeTo(null);

				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-caminh\u00E3o-25.png")));
		button_2.setOpaque(true);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), null));
		button_2.setBackground(new Color(17, 144, 147));

		JButton button_3 = new JButton("Cadastro de Produtos");
		button_3.setMnemonic(KeyEvent.VK_3);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setBounds(0, 251, 270, 48);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroProdutosView produto = new CadastroProdutosView();
				produto.setVisible(true);
				produto.setLocationRelativeTo(null);

				dispose();
			}
		});
		button_3.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-produto-25.png")));
		button_3.setOpaque(true);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), null));
		button_3.setBackground(new Color(17, 144, 147));

		JButton button_4 = new JButton("Vendas");
		button_4.setMnemonic(KeyEvent.VK_4);
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setBounds(0, 311, 270, 48);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VendasView vendas = new VendasView();
				vendas.setVisible(true);
				vendas.setLocationRelativeTo(null);

				dispose();
			}
		});
		button_4.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-performance-de-vendas-25.png")));
		button_4.setOpaque(true);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		button_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), null));
		button_4.setBackground(new Color(17, 144, 147));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 97, 0, 2);

		JLabel label = new JLabel("Varej\u00E3o Santos");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setBounds(10, 45, 199, 32);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ViewMenuDesign menu = new ViewMenuDesign();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
			}
		});
		label.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-p\u00E1gina-inicial-25.png")));
		label.setForeground(new Color(240, 248, 255));
		label.setFont(new Font("Segoe UI", Font.BOLD, 24));

		JLabel label_1 = new JLabel("Administrador");
		label_1.setBounds(24, 523, 79, 16);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 482, 276, 2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 89, 0, 2);
		panel.setLayout(null);

		JButton btnRelatorios = new JButton("Relatorios");
		btnRelatorios.setMnemonic(KeyEvent.VK_6);
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
				relatorios.setLocationRelativeTo(null);

				dispose();
			}
		});
		btnRelatorios.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-pdf-25.png")));
		btnRelatorios.setBounds(0, 431, 270, 48);
		btnRelatorios.setForeground(Color.WHITE);
		btnRelatorios.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), null));
		btnRelatorios.setBackground(new Color(17, 144, 147));
		panel.add(btnRelatorios);
		panel.add(separator);
		panel.add(button);
		panel.add(button_1);
		panel.add(button_2);
		panel.add(button_3);
		panel.add(button_4);
		panel.add(separator_1);
		panel.add(label);
		panel.add(separator_3);
		panel.add(label_1);
		panel.add(separator_2);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(10, 75, 208, 2);
		panel.add(separator_6);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { button, button_1, button_2, button_3,
				separator, button_4, separator_1, label, separator_3, label_1, separator_2 }));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(269, 0, 680, 849);
		contentPane.add(tabbedPane);
		
				JPanel panel_2 = new JPanel();
				tabbedPane.addTab("Cadastro de Entrada de Produtos", null, panel_2, null);
				panel_2.setLayout(null);
				
						JLabel lblNewLabel = new JLabel("CADASTRO DE ENTRADA DE PRODUTOS");
						lblNewLabel.setIcon(new ImageIcon(
								CadastroProdutosView.class.getResource("/imagens/icons8-caixa-registradora-filled-25.png")));
						lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setBounds(137, 6, 482, 30);
						panel_2.add(lblNewLabel);
						
								JSeparator separator_5 = new JSeparator();
								separator_5.setBounds(153, 30, 455, 2);
								panel_2.add(separator_5);
								
										JLabel lblLote = new JLabel("N\u00BA DO LOTE:");
										lblLote.setFont(new Font("Segoe UI", Font.BOLD, 12));
										lblLote.setBounds(39, 84, 87, 16);
										panel_2.add(lblLote);
										
												txtLote = new JTextField();
												txtLote.setEnabled(false);
												txtLote.setBounds(39, 112, 122, 28);
												panel_2.add(txtLote);
												txtLote.setColumns(10);
												
														lblCdigoDoProduto = new JLabel("C\u00D3DIGO DO PRODUTO:");
														lblCdigoDoProduto.setFont(new Font("Segoe UI", Font.BOLD, 12));
														lblCdigoDoProduto.setBounds(221, 84, 132, 16);
														panel_2.add(lblCdigoDoProduto);
														
																txtCodProd = new JTextField();
																txtCodProd.setLocation(221, 0);
																txtCodProd.setBounds(221, 112, 132, 28);
																panel_2.add(txtCodProd);
																txtCodProd.setColumns(10);
																
																		lblDataDeValidade = new JLabel("DATA DE VALIDADE:");
																		lblDataDeValidade.setFont(new Font("Segoe UI", Font.BOLD, 12));
																		lblDataDeValidade.setBounds(397, 84, 122, 16);
																		panel_2.add(lblDataDeValidade);
																		
																				txtData = new JDateChooser();
																				txtData.setBounds(397, 112, 122, 28);
																				panel_2.add(txtData);
																				
																						lblValor = new JLabel("VALOR:");
																						lblValor.setFont(new Font("Segoe UI", Font.BOLD, 12));
																						lblValor.setBounds(553, 84, 55, 16);
																						panel_2.add(lblValor);
																						
																								txtValor = new JTextField();
																								txtValor.setBounds(553, 112, 103, 28);
																								panel_2.add(txtValor);
																								txtValor.setColumns(10);
																								
																										lblQuantidade = new JLabel("QUANTIDADE:");
																										lblQuantidade.setFont(new Font("Segoe UI", Font.BOLD, 12));
																										lblQuantidade.setBounds(39, 190, 87, 16);
																										panel_2.add(lblQuantidade);
																										
																												lblPeso = new JLabel("PESO:");
																												lblPeso.setFont(new Font("Segoe UI", Font.BOLD, 12));
																												lblPeso.setBounds(221, 190, 55, 16);
																												panel_2.add(lblPeso);
																												
																														txtQuantidade = new JTextField();
																														txtQuantidade.setBounds(39, 224, 122, 28);
																														panel_2.add(txtQuantidade);
																														txtQuantidade.setColumns(10);
																														
																																txtPeso = new JTextField();
																																txtPeso.setBounds(221, 224, 122, 28);
																																panel_2.add(txtPeso);
																																txtPeso.setColumns(10);
																																
																																		JPanel panel_4 = new JPanel();
																																		panel_4.setLayout(null);
																																		panel_4.setBorder(new TitledBorder(null, "Produtos em Estoque", TitledBorder.LEFT, TitledBorder.TOP, null,
																																				new Color(0, 0, 0)));
																																		panel_4.setBounds(39, 296, 610, 272);
																																		panel_2.add(panel_4);
																																		
																																				JScrollPane scrollPane_1 = new JScrollPane();
																																				scrollPane_1.setBounds(17, 65, 576, 188);
																																				panel_4.add(scrollPane_1);
																																				
																																						table_1 = new JTable();
																																						table_1.setModel(new DefaultTableModel(new Object[][] {},
																																								new String[] { "Lote", "Cod.Produto", "Validade", "Valor", "Quantidade", "Peso" }));
																																						scrollPane_1.setViewportView(table_1);
																																						
																																								JButton button_12 = new JButton("Atualizar");
																																								button_12.addActionListener(new ActionListener() {
																																									public void actionPerformed(ActionEvent arg0) {

																																										try {
																																											listarLotes();
																																										} catch (Exception e) {
																																											// TODO Auto-generated catch block
																																											e.printStackTrace();
																																										}

																																									}
																																								});
																																								button_12.setIcon(
																																										new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-actualizar-25 (1).png")));
																																								button_12.setBounds(478, 25, 115, 28);
																																								panel_4.add(button_12);
																																								
																																										JButton button_13 = new JButton("Preencher campos");
																																										button_13.addActionListener(new ActionListener() {
																																											public void actionPerformed(ActionEvent e) {

																																												try {
																																													preencherCamposLote();
																																												} catch (Exception e1) {
																																													// TODO Auto-generated catch block
																																													e1.printStackTrace();
																																												}

																																											}
																																										});
																																										button_13.setIcon(
																																												new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-cor-de-preenchimento-25.png")));
																																										button_13.setBounds(291, 25, 175, 28);
																																										panel_4.add(button_13);
																																										
																																												txtPesquisar = new JTextField();
																																												txtPesquisar.addKeyListener(new KeyAdapter() {
																																													@Override
																																													public void keyReleased(KeyEvent arg0) {

																																														try {

																																															// Pattern patternString = Pattern.compile("[A-Z]");
																																															// Pattern patternNumeros = Pattern.compile("[0-9]");

																																															addDadosTableLote(pesquisaPorLote(Integer.parseInt(txtPesquisar.getText())));

																																														} catch (Exception e1) {

																																															e1.printStackTrace();
																																														}

																																													}
																																												});
																																												txtPesquisar.setColumns(10);
																																												txtPesquisar.setBounds(96, 25, 57, 28);
																																												panel_4.add(txtPesquisar);
																																												
																																														JButton button_14 = new JButton("");
																																														button_14.setIcon(
																																																new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-pesquisar-filled-25.png")));
																																														button_14.setBounds(181, 25, 47, 28);
																																														panel_4.add(button_14);
																																														
																																																JLabel label_4 = new JLabel("Pesquisar:");
																																																label_4.setBounds(17, 31, 78, 16);
																																																panel_4.add(label_4);
																																																
																																																		JButton button_15 = new JButton("Cadastrar");
																																																		button_15.addActionListener(new ActionListener() {
																																																			public void actionPerformed(ActionEvent arg0) {

																																																				try {
																																																					cadastraEntrada();
																																																					listarLotes();
																																																					limparLote();
																																																				} catch (Exception e) {
																																																					// TODO Auto-generated catch block
																																																					e.printStackTrace();
																																																				}
																																																			}

																																																		});
																																																		button_15.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-salvar-25 (2).png")));
																																																		button_15.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																																																		button_15.setBounds(46, 601, 117, 37);
																																																		panel_2.add(button_15);
																																																		
																																																				JButton button_16 = new JButton("Alterar");
																																																				button_16.addActionListener(new ActionListener() {
																																																					public void actionPerformed(ActionEvent arg0) {

																																																						try {
																																																							alterarLote();
																																																							listarLotes();
																																																							limparLote();
																																																						} catch (Exception e) {
																																																							// TODO Auto-generated catch block
																																																							e.printStackTrace();
																																																						}

																																																					}
																																																				});
																																																				button_16.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-alterar-25.png")));
																																																				button_16.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																																																				button_16.setBounds(242, 601, 106, 37);
																																																				panel_2.add(button_16);
																																																				
																																																						JButton button_17 = new JButton("Limpar");
																																																						button_17.addActionListener(new ActionListener() {
																																																							public void actionPerformed(ActionEvent e) {

																																																								limparLote();

																																																							}
																																																						});
																																																						button_17.setIcon(
																																																								new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-vassoura-filled-25.png")));
																																																						button_17.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																																																						button_17.setBounds(404, 601, 106, 37);
																																																						panel_2.add(button_17);
																																																						
																																																								JButton button_18 = new JButton("Excluir");
																																																								button_18.addActionListener(new ActionListener() {
																																																									public void actionPerformed(ActionEvent e) {

																																																										try {
																																																											excluirLote();
																																																											listarLotes();
																																																											limparLote();
																																																										} catch (Exception e1) {
																																																											// TODO Auto-generated catch block
																																																											e1.printStackTrace();
																																																										}
																																																									}

																																																								});
																																																								button_18.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-excluir-25.png")));
																																																								button_18.setFont(new Font("Segoe UI", Font.PLAIN, 12));
																																																								button_18.setBounds(556, 601, 100, 37);
																																																								panel_2.add(button_18);
																																																								
																																																								textField = new JTextField();
																																																								textField.setBounds(173, 134, 0, 0);
																																																								panel_2.add(textField);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cadastro de Produtos", null, panel_1, null);
		panel_1.setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(29, 117, 56, 26);
		txtCodigo.setColumns(10);
		panel_1.add(txtCodigo);

		lblCodigoProduto = new JLabel("C\u00D3DIGO:");
		lblCodigoProduto.setBounds(29, 92, 56, 14);
		lblCodigoProduto.setFont(new Font("Segoe UI", Font.BOLD, 12));
		panel_1.add(lblCodigoProduto);

		lblNomeProduto = new JLabel("NOME:");
		lblNomeProduto.setBounds(178, 92, 43, 14);
		lblNomeProduto.setFont(new Font("Segoe UI", Font.BOLD, 12));
		panel_1.add(lblNomeProduto);

		txtNome = new JTextField();
		txtNome.setLocation(178, 0);
		txtNome.setBounds(178, 117, 240, 26);
		txtNome.setColumns(10);
		panel_1.add(txtNome);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(30, 329, 610, 272);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "Produtos Cadastrados", TitledBorder.LEFT, TitledBorder.TOP, null,

				new Color(0, 0, 0)));
		panel_1.add(panel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 65, 576, 188);
		panel_3.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "Tipo" }));
		scrollPane.setViewportView(table);

		JButton button_5 = new JButton("Atualizar");
		button_5.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-actualizar-25 (1).png")));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					pesquisarProdutoTodos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_5.setBounds(478, 25, 115, 28);
		panel_3.add(button_5);

		JButton button_6 = new JButton("Preencher campos");
		button_6.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-cor-de-preenchimento-25.png")));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					preencherCampos();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_6.setBounds(301, 25, 165, 28);
		panel_3.add(button_6);

		txtPesquisa = new JTextField();
		txtPesquisa.setColumns(10);
		txtPesquisa.setBounds(96, 25, 57, 28);
		panel_3.add(txtPesquisa);

		JButton button_7 = new JButton("");
		button_7.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-pesquisar-filled-25.png")));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Pattern patternString = Pattern.compile("[A-Z]");
					Pattern patternNumeros = Pattern.compile("[0-9]");

					if (patternNumeros.matcher(txtPesquisa.getText()).find()) {

						addDadosTable(pesquisaPorCodigo(Integer.parseInt(txtPesquisa.getText())));

					} else if (patternString.matcher(txtPesquisa.getText()).find()) {

						pesquisarPorNome(txtPesquisa.getText());

					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		button_7.setBounds(181, 25, 47, 28);
		panel_3.add(button_7);

		JLabel label_8 = new JLabel("Pesquisar:");
		label_8.setBounds(17, 31, 78, 16);
		panel_3.add(label_8);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(214, 28, 314, 2);
		panel_1.add(separator_4);

		JButton button_8 = new JButton("Limpar");
		button_8.setBounds(388, 613, 106, 37);
		button_8.setIcon(
				new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-vassoura-filled-25.png")));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limpar();

			}
		});
		button_8.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_1.add(button_8);

		lblTipo = new JLabel("TIPO:");
		lblTipo.setBounds(485, 91, 55, 16);
		lblTipo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		panel_1.add(lblTipo);

		comboBox = new JComboBox();
		comboBox.setBounds(485, 117, 117, 26);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" ", "CONGELADO", "RESFRIADO", "TEMPERADO" }));
		panel_1.add(comboBox);

		JButton button_9 = new JButton("Excluir");
		button_9.setBounds(524, 613, 100, 37);
		button_9.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-excluir-25.png")));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					delete();
					pesquisarProdutoTodos();
					limpar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_9.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_1.add(button_9);

		JButton button_10 = new JButton("Alterar");
		button_10.setBounds(214, 613, 106, 37);
		button_10.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-alterar-25.png")));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					alteraProduto();
					pesquisarProdutoTodos();
					limpar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		button_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_1.add(button_10);

		JButton button_11 = new JButton("Cadastrar");
		button_11.setBounds(29, 613, 117, 37);
		button_11.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-salvar-25 (2).png")));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					cadastra();
					pesquisarProdutoTodos();
					limpar();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		button_11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_1.add(button_11);

		JLabel label_10 = new JLabel("CADASTRO DE PRODUTOS");
		label_10.setBounds(214, 6, 314, 26);
		label_10.setIcon(new ImageIcon(CadastroProdutosView.class.getResource("/imagens/icons8-caixa-25.png")));
		label_10.setFont(new Font("Segoe UI", Font.BOLD, 22));
		panel_1.add(label_10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { separator, button, button_1,
				button_2, button_3, button_4, separator_1, label, separator_3, label_1, separator_2, panel }));
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addDadosTable(ProdutoVO pVO) throws Exception {

		cleanTable(table);
		

		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

		String result = out.format(in.parse(pVO.getData().toString()));

		DefaultTableModel val = (DefaultTableModel) table.getModel();
		val.addRow(new String[] { Integer.toString(pVO.getCodigo()), pVO.getNome(), result,
				Double.toString(pVO.getValor()), Integer.toString(pVO.getQuan()), Double.toString(pVO.getPeso()),
				pVO.getTipo() });

	}

	private void cadastra() throws Exception {
		ProdutoVO produtoVO = new ProdutoVO();
		ProdutoController produtoController = new ProdutoController();

		String tipo = comboBox.getSelectedItem().toString();
		if (!txtCodigo.getText().trim().equals("")) {
			try {
				produtoVO.setCodigo(Integer.parseInt(txtCodigo.getText().trim()));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		produtoVO.setNome(txtNome.getText().trim());
		// produtoVO.setData(txtData.getDate());
		// produtoVO.setValor(Double.parseDouble(txtValor.getText().trim()));
		// produtoVO.setQuan(Integer.parseInt(txtQuantidade.getText().trim()));
		// produtoVO.setPeso(Double.parseDouble(txtPeso.getText().trim()));
		produtoVO.setTipo(tipo);

		produtoController.cadastroDeProduto(produtoVO);

		limpar();

	}

	private static void pesquisarProdutoTodos() throws Exception {
		ProdutoController controller = new ProdutoController();
		List<ProdutoVO> lista = new ArrayList<ProdutoVO>();

		lista = controller.pesquisarProdutoTodos();

		cleanTable(table);

		for (ProdutoVO produtoVO : lista) {

			DefaultTableModel dados = (DefaultTableModel) table.getModel();

			String txt = Integer.toString(produtoVO.getCodigo());

			// SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
			//
			// String result = out.format(in.parse(produtoVO.getData().toString()));
			//
			// String peso = Double.toString(produtoVO.getPeso());
			// String quantidade = Integer.toString(produtoVO.getQuan());
			// String valor = Double.toString(produtoVO.getValor());

			dados.addRow(new String[] { txt, produtoVO.getNome(), produtoVO.getTipo() });

		}

	}

	private static void cleanTable(JTable tabela) {

		DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();

		dtm.setNumRows(0);

	}

	private void delete() throws Exception {
		txtCodigo.enable(true);
		ProdutoVO produtoVO = new ProdutoVO();

		int txt = Integer.parseInt(txtCodigo.getText());
		produtoVO.setCodigo(txt);

		ProdutoController controller = new ProdutoController();
		JOptionPane.showMessageDialog(null, controller.excluir(produtoVO));

		limpar();

	}

	private void preencherCampos() throws Exception {

		int linhaSelecionada = table.getSelectedRow();

		String codigo = table.getValueAt(linhaSelecionada, 0).toString();

		ProdutoVO produtoVO = pesquisaPorCodigo(Integer.parseInt(codigo));

		txtCodigo.enable(false);
		txtCodigo.setText(Integer.toString(produtoVO.getCodigo()));
		txtNome.setText(produtoVO.getNome());
		// txtData.setDate(produtoVO.getData());
		// txtValor.setText(Double.toString(produtoVO.getValor()));
		// txtQuantidade.setText(Integer.toString(produtoVO.getQuan()));
		// txtPeso.setText(Double.toString(produtoVO.getPeso()));

	}

	private ProdutoVO pesquisaPorCodigo(int codigo) throws Exception {
		ProdutoController produtoController = new ProdutoController();

		return produtoController.pesquisarPorCodigo(codigo);
	}

	private void alteraProduto() throws Exception {
		txtCodigo.enable(true);
		ProdutoVO produtoVO = new ProdutoVO();
		String tipo = comboBox.getSelectedItem().toString();

		int txt = Integer.parseInt(txtCodigo.getText());
		produtoVO.setCodigo(txt);
		produtoVO.setNome(txtNome.getText().trim());
		// produtoVO.setData(txtData.getDate());
		// produtoVO.setValor(Double.parseDouble(txtValor.getText().trim()));
		// produtoVO.setQuan(Integer.parseInt(txtQuantidade.getText().trim()));
		// produtoVO.setPeso(Double.parseDouble(txtPeso.getText().trim()));
		produtoVO.setTipo(tipo);

		ProdutoController controller = new ProdutoController();
		controller.alteraProduto(produtoVO);

		limpar();

	}

	private void limpar() {
		txtCodigo.enable(true);
		txtCodigo.setText("");
		txtNome.setText("");
		// txtValor.setText("");
		// txtQuantidade.setText("");
		// txtPeso.setText("");

		txtCodigo.requestFocus();
		
		CadastroProdutosView.lblCdigoDoProduto.setForeground(Color.BLACK);
		CadastroProdutosView.lblCodigoProduto.setForeground(Color.BLACK);
		CadastroProdutosView.lblDataDeValidade.setForeground(Color.BLACK);
		CadastroProdutosView.lblNomeProduto.setForeground(Color.BLACK);
		CadastroProdutosView.lblPeso.setForeground(Color.BLACK);
		CadastroProdutosView.lblQuantidade.setForeground(Color.BLACK);
		CadastroProdutosView.lblTipo.setForeground(Color.BLACK);
		CadastroProdutosView.lblValor.setForeground(Color.BLACK);
		
	}

	private void pesquisarPorNome(String nome) throws Exception {
		cleanTable(table);

		ProdutoController controller = new ProdutoController();

		List<ProdutoVO> lista = controller.pesquisarPorNome(nome);

		for (ProdutoVO produtoVO : lista) {
			DefaultTableModel dados = (DefaultTableModel) table.getModel();

			String codigo = Integer.toString(produtoVO.getCodigo());
			SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");

			String data = out.format(in.parse(produtoVO.getData().toString()));
			String valor = Double.toString(produtoVO.getValor());
			String quantidade = Double.toString(produtoVO.getQuan());
			String peso = Double.toString(produtoVO.getPeso());

			dados.addRow(
					new String[] { codigo, produtoVO.getNome(), data, valor, quantidade, peso, produtoVO.getTipo() });

		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void cadastraEntrada() throws Exception {
		ProdutoVO produtoVO = new ProdutoVO();
		ProdutoController produtoController = new ProdutoController();

		String tipo = comboBox.getSelectedItem().toString();
		// produtoVO.setLote(Integer.parseInt(txtLote.getText()));
		if (!txtCodProd.getText().trim().equals("")) {
			try {
				produtoVO.setCodigo(Integer.parseInt(txtCodProd.getText().trim()));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Digite apenas n�meros", "C�digo Inv�lido",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if (txtData.getDate() != null) {
			try {
				produtoVO.setData(txtData.getDate());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Digite uma data v�lida", "Data Inv�lida",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (!txtValor.getText().trim().equals("")) {
			try {
				produtoVO.setValor(Double.parseDouble(txtValor.getText().trim()));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Digite apenas n�meros", "Pre�o Inv�lido",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if (!txtQuantidade.getText().trim().equals("")) {
			try {
				produtoVO.setQuan(Integer.parseInt(txtQuantidade.getText().trim()));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Digite apenas n�meros", "Quantidade Inv�lida",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if (!txtPeso.getText().trim().equals("")) {
			try {
				produtoVO.setPeso(Double.parseDouble(txtPeso.getText().trim()));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Digite apenas n�meros", "Peso Inv�lido",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		produtoController.cadastroDeEntrada(produtoVO);

		limpar();

	}

	private void listarLotes() throws Exception {

		ProdutoController controller = new ProdutoController();
		List<ProdutoVO> lista = new ArrayList<ProdutoVO>();

		lista = controller.listarLotes();

		cleanTable(table_1);

		for (ProdutoVO produtoVO : lista) {

			DefaultTableModel dados = (DefaultTableModel) table_1.getModel();

			String txt = Integer.toString(produtoVO.getCodigo());

			SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");

			String result = out.format(in.parse(produtoVO.getData().toString()));

			String peso = Double.toString(produtoVO.getPeso());
			String quantidade = Integer.toString(produtoVO.getQuan());
			String valor = Double.toString(produtoVO.getValor());
			String lote = Integer.toString(produtoVO.getLote());

			dados.addRow(new String[] { lote, txt, result, valor, quantidade, peso });

		}

	}

	private void preencherCamposLote() throws Exception {

		int linhaSelecionada = table_1.getSelectedRow();

		String codigo = table_1.getValueAt(linhaSelecionada, 0).toString();

		ProdutoVO produtoVO = pesquisaPorLote(Integer.parseInt(codigo));

		txtLote.enable(false);
		txtLote.setText(Integer.toString(produtoVO.getLote()));
		txtCodProd.setText(Integer.toString(produtoVO.getCodigo()));
		txtData.setDate(produtoVO.getData());
		txtValor.setText(Double.toString(produtoVO.getValor()));
		txtQuantidade.setText(Integer.toString(produtoVO.getQuan()));
		txtPeso.setText(Double.toString(produtoVO.getPeso()));

	}

	private ProdutoVO pesquisaPorLote(int codigo) throws Exception {
		ProdutoController produtoController = new ProdutoController();

		return produtoController.pesquisarPorLote(codigo);
	}

	private void addDadosTableLote(ProdutoVO pesquisaPorLote) throws Exception {
		cleanTable(table_1);

		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

		String result = out.format(in.parse(pesquisaPorLote.getData().toString()));

		DefaultTableModel val = (DefaultTableModel) table_1.getModel();
		val.addRow(new String[] { Integer.toString(pesquisaPorLote.getLote()),
				Integer.toString(pesquisaPorLote.getCodigo()), result, Double.toString(pesquisaPorLote.getValor()),
				Integer.toString(pesquisaPorLote.getQuan()), Double.toString(pesquisaPorLote.getPeso()) });

	}

	private void alterarLote() throws Exception {
		txtCodigo.enable(true);
		ProdutoVO produtoVO = new ProdutoVO();
		String tipo = comboBox.getSelectedItem().toString();

		int txt = Integer.parseInt(txtCodProd.getText());
		produtoVO.setCodigo(txt);
		produtoVO.setLote(Integer.parseInt(txtLote.getText()));
		produtoVO.setData(txtData.getDate());
		produtoVO.setValor(Double.parseDouble(txtValor.getText().trim()));
		produtoVO.setQuan(Integer.parseInt(txtQuantidade.getText().trim()));
		produtoVO.setPeso(Double.parseDouble(txtPeso.getText().trim()));

		ProdutoController controller = new ProdutoController();
		controller.alteraLote(produtoVO);

		limparLote();

	}

	private void limparLote() {
		txtCodigo.enable(false);
		txtLote.setText("");
		txtCodProd.setText("");
		txtData.setDate(null);
		txtValor.setText("");
		txtQuantidade.setText("");
		txtPeso.setText("");
		
		CadastroProdutosView.lblCdigoDoProduto.setForeground(Color.BLACK);
		CadastroProdutosView.lblCodigoProduto.setForeground(Color.BLACK);
		CadastroProdutosView.lblDataDeValidade.setForeground(Color.BLACK);
		CadastroProdutosView.lblNomeProduto.setForeground(Color.BLACK);
		CadastroProdutosView.lblPeso.setForeground(Color.BLACK);
		CadastroProdutosView.lblQuantidade.setForeground(Color.BLACK);
		CadastroProdutosView.lblTipo.setForeground(Color.BLACK);
		CadastroProdutosView.lblValor.setForeground(Color.BLACK);

	}

	private void excluirLote() throws Exception {
		txtCodigo.enable(true);
		ProdutoVO produtoVO = new ProdutoVO();

		int txt = Integer.parseInt(txtLote.getText());
		produtoVO.setCodigo(txt);

		ProdutoController controller = new ProdutoController();
		JOptionPane.showMessageDialog(null, controller.excluirLote(txt));

		limparLote();

	}
}
