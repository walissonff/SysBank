/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wfsistemas.sysbank.apresentacao;

import br.com.wfsistemas.sysbank.apresentacao.ClassesUtil.Criptografia;
import br.com.wfsistemas.sysbank.apresentacao.ClassesUtil.CursorUtil;
import br.com.wfsistemas.sysbank.apresentacao.ClassesUtil.MensagemTela;
import br.com.wfsistemas.sysbank.entidade.Agencia;
import br.com.wfsistemas.sysbank.entidade.Cliente;
import br.com.wfsistemas.sysbank.entidade.Conta;
import br.com.wfsistemas.sysbank.entidade.ContaCorrente;
import br.com.wfsistemas.sysbank.entidade.ContaPoupanca;
import br.com.wfsistemas.sysbank.entidade.ContaSalario;
import br.com.wfsistemas.sysbank.entidade.Usuario;
import br.com.wfsistemas.sysbank.excecao.ArgumentInvalidExeception;
import br.com.wfsistemas.sysbank.excecao.CampoVazioException;
import br.com.wfsistemas.sysbank.excecao.SenhaInvalidaException;
import br.com.wfsistemas.sysbank.excecao.UsuarioLoginExistenteException;
import br.com.wfsistemas.sysbank.excecao.NumeroContaExistenteException;
import br.com.wfsistemas.sysbank.negocio.ClienteBO;
import br.com.wfsistemas.sysbank.negocio.ContaBO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author wff
 */
public class CadastroContaForm extends javax.swing.JFrame {
    Cliente cliente = null;
    Usuario usuario = null;
    Conta conta = null;
    ContaCorrente contaCorrente = null;
    ContaPoupanca contaPoupanca = null;
    ContaSalario contaSalario = null;
    String tipoDeConta = null;
    int numeroDaConta = 0;
    /**
     * Creates new form CadastrarContaForm
     */
    private CadastroContaForm() {
        initComponents();
        this.configurarComponestesTela();
        this.buscarCliente();
    }
    public CadastroContaForm(Usuario usuario)  {
        initComponents();
        this.usuario = usuario;
        this.configurarComponestesTela();
        this.buscarCliente();
        System.out.println(this.usuario.getCpf());
    }
    
    private void configurarComponestesTela() {
        pnlContaPoupanca.setVisible(false);
        pnlContaCorrente.setVisible(false);
        pnlContaSalario.setVisible(false); 
        lblClienteAtivo.setVisible(false);
    }
    public void buscarCliente() {
        try {
            ClienteBO clienteBO = new ClienteBO();
            this.cliente = clienteBO.buscarTodos().get(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possivel recuperar cliente", "Cliente", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparDadosContaTela() {
        txtCpf.setText("");
        lblNomeCliente.setText("");
        lblClienteAtivo.setText("");
        configurarComponestesTela();
        txtSenha.setText("");
        txtRepitaSenha.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadastroDeConta = new javax.swing.JPanel();
        pnlConsultaClienteCpf = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        btnConsultarCliente = new javax.swing.JButton();
        lblNomeCliente = new javax.swing.JLabel();
        lblClienteAtivo = new javax.swing.JLabel();
        cmbTipoConta = new javax.swing.JComboBox();
        lblTipoConta = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        pnlCadastoSenha = new javax.swing.JPanel();
        txtSenha = new javax.swing.JPasswordField();
        lblRepitaSenha = new javax.swing.JLabel();
        txtRepitaSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        lblObservacao = new javax.swing.JLabel();
        btnCadastrarConta = new javax.swing.JButton();
        pnlContaCorrente = new javax.swing.JPanel();
        lblLimite = new javax.swing.JLabel();
        lblTaxaServiços = new javax.swing.JLabel();
        txtLimite = new javax.swing.JTextField();
        txtTaxaServicos = new javax.swing.JTextField();
        pnlContaSalario = new javax.swing.JPanel();
        lblEmpresa = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        pnlContaPoupanca = new javax.swing.JPanel();
        lblTaxaJuros = new javax.swing.JLabel();
        txtTaxaJuros = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCadastroDeConta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Contas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        pnlConsultaClienteCpf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCpf.setText("CPF (*):");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnConsultarCliente.setText("Consultar");
        btnConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClienteActionPerformed(evt);
            }
        });

        lblNomeCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNomeCliente.setText("Nome: ");

        lblClienteAtivo.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblClienteAtivo.setForeground(new java.awt.Color(72, 131, 228));

        cmbTipoConta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTipoConta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Corrente", "Poupança", "Salario" }));
        cmbTipoConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoContaActionPerformed(evt);
            }
        });

        lblTipoConta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTipoConta.setText("Tipo de Conta:");

        javax.swing.GroupLayout pnlConsultaClienteCpfLayout = new javax.swing.GroupLayout(pnlConsultaClienteCpf);
        pnlConsultaClienteCpf.setLayout(pnlConsultaClienteCpfLayout);
        pnlConsultaClienteCpfLayout.setHorizontalGroup(
            pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaClienteCpfLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConsultaClienteCpfLayout.createSequentialGroup()
                        .addComponent(lblTipoConta)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlConsultaClienteCpfLayout.createSequentialGroup()
                            .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblClienteAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlConsultaClienteCpfLayout.createSequentialGroup()
                            .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnConsultarCliente))))
                .addGap(29, 29, 29))
        );
        pnlConsultaClienteCpfLayout.setVerticalGroup(
            pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultaClienteCpfLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblClienteAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlConsultaClienteCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoConta)
                    .addComponent(cmbTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wfsistemas/sysbank/apresentacao/icones/cross79_1.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pnlCadastoSenha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senha do Cartao", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblRepitaSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRepitaSenha.setText("Repita a senha (*): ");

        lblSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSenha.setText("Senha (*):");

        lblObservacao.setText("(Somente numeros)");

        javax.swing.GroupLayout pnlCadastoSenhaLayout = new javax.swing.GroupLayout(pnlCadastoSenha);
        pnlCadastoSenha.setLayout(pnlCadastoSenhaLayout);
        pnlCadastoSenhaLayout.setHorizontalGroup(
            pnlCadastoSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastoSenhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastoSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRepitaSenha)
                    .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCadastoSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblObservacao)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(txtRepitaSenha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCadastoSenhaLayout.setVerticalGroup(
            pnlCadastoSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastoSenhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCadastoSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(lblObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCadastoSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRepitaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCadastoSenhaLayout.createSequentialGroup()
                        .addComponent(txtRepitaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))))
        );

        btnCadastrarConta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCadastrarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/wfsistemas/sysbank/apresentacao/icones/save (2)_1.png"))); // NOI18N
        btnCadastrarConta.setText("Cadastrar");
        btnCadastrarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarContaActionPerformed(evt);
            }
        });

        pnlContaCorrente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Conta Corrente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblLimite.setText("Limite");

        lblTaxaServiços.setText("Taxa de Serviços");

        javax.swing.GroupLayout pnlContaCorrenteLayout = new javax.swing.GroupLayout(pnlContaCorrente);
        pnlContaCorrente.setLayout(pnlContaCorrenteLayout);
        pnlContaCorrenteLayout.setHorizontalGroup(
            pnlContaCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContaCorrenteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblLimite)
                .addGap(45, 45, 45)
                .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTaxaServiços)
                .addGap(18, 18, 18)
                .addComponent(txtTaxaServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        pnlContaCorrenteLayout.setVerticalGroup(
            pnlContaCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContaCorrenteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlContaCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimite)
                    .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTaxaServiços)
                    .addComponent(txtTaxaServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContaSalario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Conta Salario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblEmpresa.setText("Nome da Empresa:");

        lblSalario.setText("Salario:");

        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.00"))));

        javax.swing.GroupLayout pnlContaSalarioLayout = new javax.swing.GroupLayout(pnlContaSalario);
        pnlContaSalario.setLayout(pnlContaSalarioLayout);
        pnlContaSalarioLayout.setHorizontalGroup(
            pnlContaSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContaSalarioLayout.createSequentialGroup()
                .addComponent(lblEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalario)
                .addGap(18, 18, 18)
                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        pnlContaSalarioLayout.setVerticalGroup(
            pnlContaSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContaSalarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContaSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalario)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpresa)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlContaPoupanca.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Conta Poupanca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblTaxaJuros.setText("Taxa de Juros (%):");

        javax.swing.GroupLayout pnlContaPoupancaLayout = new javax.swing.GroupLayout(pnlContaPoupanca);
        pnlContaPoupanca.setLayout(pnlContaPoupancaLayout);
        pnlContaPoupancaLayout.setHorizontalGroup(
            pnlContaPoupancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContaPoupancaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTaxaJuros)
                .addGap(18, 18, 18)
                .addComponent(txtTaxaJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContaPoupancaLayout.setVerticalGroup(
            pnlContaPoupancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContaPoupancaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlContaPoupancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTaxaJuros)
                    .addComponent(txtTaxaJuros))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout pnlCadastroDeContaLayout = new javax.swing.GroupLayout(pnlCadastroDeConta);
        pnlCadastroDeConta.setLayout(pnlCadastroDeContaLayout);
        pnlCadastroDeContaLayout.setHorizontalGroup(
            pnlCadastroDeContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroDeContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastroDeContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastroDeContaLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(271, 271, 271)
                        .addComponent(btnCadastrarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastroDeContaLayout.createSequentialGroup()
                        .addGroup(pnlCadastroDeContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlConsultaClienteCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCadastoSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlContaSalario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlContaPoupanca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlContaCorrente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlCadastroDeContaLayout.setVerticalGroup(
            pnlCadastroDeContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastroDeContaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConsultaClienteCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContaSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCadastoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlCadastroDeContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCadastroDeConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadastroDeConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        int resposta;
        String mensagem = "Deseja cancelar este cadastro ?";
        String titulo = "Cancelar cadastro";
        resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            this.atualizarDadosTelaCompleta();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    public void atualizarDadosTelaCompleta() {      
        this.configurarComponestesTela();
        cliente = null;
        this.buscarCliente();
        this.limparDadosContaTela();
    }
    
    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed
        // TODO add your handling code here:
        try {
            ClienteBO clienteBO = new ClienteBO();
            cliente = clienteBO.buscarByCpf(lerCpfCliente());
            this.setNomeClienteTela();
        } catch (CampoVazioException cve) {
            JOptionPane.showMessageDialog(this, cve.getMessage(), "Consultar Contas", JOptionPane.ERROR_MESSAGE);
        } catch (ArgumentInvalidExeception aie) {
            JOptionPane.showMessageDialog(this, aie.getMessage(), "Consultar Conta", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Não foi possivel consultar o contas \nTente novamente", "Cadastro contas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarClienteActionPerformed
    private String lerCpfCliente() {
        String cpf = txtCpf.getText().trim();

        String mensagem = "";

        if (cpf.length() < 11) {
            mensagem = "CPF inválido.";
        }

        if (!(mensagem == "" || mensagem == null)) {
            throw new CampoVazioException(mensagem);
        }

        return cpf;
    }
    
    private void setNomeClienteTela() {
        lblNomeCliente.setVisible(true);
        lblClienteAtivo.setText(cliente.getNome());
        lblClienteAtivo.setVisible(true);
    }
    private void btnCadastrarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarContaActionPerformed
        try {
            this.lerDados();
            ContaBO  contaBO = new ContaBO();                 
            if(conta instanceof ContaCorrente){
                contaBO.criarContaCorrente(contaCorrente);
            }
            if(conta instanceof ContaPoupanca){
                contaBO.criarContaPoupanca(contaPoupanca);
            }
            if(conta instanceof ContaSalario){
                contaBO.criarContaSalario(contaSalario);
            }
            exibirMensagemSucesso("Conta cadastrada com sucesso!", "Cadastro de Conta ");
        }catch (SQLException ex) {
            Logger.getLogger(CadastroContaForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        limparDadosContaTela();
    }//GEN-LAST:event_btnCadastrarContaActionPerformed
    
    public void lerDados() throws SQLException{
        String tipoConta = cmbTipoConta.getSelectedItem().toString();
        this.tipoDeConta = tipoConta;
        String strSenha = txtSenha.getText().trim();
        String strRepitaSenha = txtRepitaSenha.getText().trim();
        String strLimite = txtLimite.getText().trim();
        String strTaxaServicos = txtTaxaServicos.getText().trim();
        String nomeEmpresa = txtEmpresa.getText().trim();
        String strSalario = txtSalario.getText().trim(); 
        String strTaxaJuros = txtTaxaJuros.getText().trim();
        
        String mensagem = "";
                    
        if(strSenha.isEmpty()){
            mensagem = mensagem + "\nCampo SENHA é obrigatório.";
        }
        
        if(strRepitaSenha.isEmpty()){
            mensagem = mensagem + "\nCampo REPITA A SENHA é obrigatório.";
        }          
        String senha = null;
        if(mensagem == "" || mensagem == null){
            if(strSenha.equals(strRepitaSenha)){
                try {
                   senha = Criptografia.exemploMD5(strSenha);
                } catch (NoSuchAlgorithmException ex) {
                   Logger.getLogger(CadastroLoginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                   Logger.getLogger(CadastroLoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                mensagem = mensagem + "\n DIGITE AS SENHAS NOVAMENTE";
                throw new SenhaInvalidaException("As senhas são diferentes. \n Elas devem ser iguais");               
            }
        }
        if(mensagem == "" || mensagem == null){           
            if(tipoConta.equals("Corrente")){
                double taxaServicos = 0.0;
                double limite = 0.0;
                if(strLimite.isEmpty() || strTaxaServicos.isEmpty()){
                    mensagem = mensagem + "\nCampos limite e taxa de serviços é obrigatório.";
                }else{
                    try {
                        DecimalFormat formatador = new DecimalFormat("#,##0.00");
                        limite = formatador.parse(strLimite).doubleValue();
                        taxaServicos = formatador.parse(strTaxaServicos).doubleValue();
                    } catch (ParseException ex) {
                        mensagem = mensagem + "\nValor Unitário Invalido";
                    }
                }
                this.contaCorrente = new ContaCorrente(taxaServicos, limite, 
                this.cliente, tipoConta, senha);
            }else if(tipoConta.equals("Poupança")){
                double taxaJuros = 0.0;
                if(strTaxaJuros.isEmpty() && tipoConta.equals("Salario")){
                    mensagem = mensagem + "\nCampo Valor Renda é obrigatório.";
                }else{
                    try {
                        DecimalFormat formatador = new DecimalFormat("#,##0.00");
                        taxaJuros = formatador.parse(strTaxaJuros).doubleValue();
                    } catch (ParseException ex) {
                        mensagem = mensagem + "\nValor Unitário Invalido";
                    }
                }
                this.contaPoupanca = new ContaPoupanca(taxaJuros, this.cliente, tipoConta, senha);
            }else if(tipoConta.equals("Salario")){
                double salario = 0;
                if(strSalario.isEmpty()){
                    mensagem = mensagem + "\nCampo Valor Renda é obrigatório.";
                }else{
                    try {
                        DecimalFormat formatador = new DecimalFormat("#,##0.00");
                        salario = formatador.parse(strSalario).doubleValue();
                    } catch (ParseException ex) {
                        mensagem = mensagem + "\nValor Unitário Invalido";
                    }
                }
                this.contaSalario = new ContaSalario(nomeEmpresa, salario, this.cliente, tipoConta, senha);
            }else{
                mensagem = mensagem + "\nEscolha um tipo de conta";
            }
        }
    }
    private void cmbTipoContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoContaActionPerformed
        if(cmbTipoConta.getSelectedIndex() == 1){    
            pnlContaCorrente.setVisible(true);
            pnlContaPoupanca.setVisible(false);
            pnlContaSalario.setVisible(false);
        }else if(cmbTipoConta.getSelectedIndex() == 2){ 
            pnlContaCorrente.setVisible(false);
            pnlContaPoupanca.setVisible(true);
            pnlContaSalario.setVisible(false);
        }else if(cmbTipoConta.getSelectedIndex() == 3){       
            pnlContaCorrente.setVisible(false);
            pnlContaPoupanca.setVisible(false);
            pnlContaSalario.setVisible(true);
        }
    }//GEN-LAST:event_cmbTipoContaActionPerformed

    private void exibirMensagemErro(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(this ,mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }

    private void exibirMensagemSucesso(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(this, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    public void exibirMensagemInformacao(String mensagem, String titulo) {
        JOptionPane.showMessageDialog(this,  mensagem, titulo, JOptionPane.INFORMATION_MESSAGE); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroContaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroContaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroContaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroContaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new CadastroContaForm().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarConta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JComboBox cmbTipoConta;
    private javax.swing.JLabel lblClienteAtivo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblRepitaSenha;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTaxaJuros;
    private javax.swing.JLabel lblTaxaServiços;
    private javax.swing.JLabel lblTipoConta;
    private javax.swing.JPanel pnlCadastoSenha;
    private javax.swing.JPanel pnlCadastroDeConta;
    private javax.swing.JPanel pnlConsultaClienteCpf;
    private javax.swing.JPanel pnlContaCorrente;
    private javax.swing.JPanel pnlContaPoupanca;
    private javax.swing.JPanel pnlContaSalario;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JPasswordField txtRepitaSenha;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTaxaJuros;
    private javax.swing.JTextField txtTaxaServicos;
    // End of variables declaration//GEN-END:variables
}