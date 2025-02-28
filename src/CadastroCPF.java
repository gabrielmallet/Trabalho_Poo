import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;

public class CadastroCPF extends JFrame{
    private JLabel nomeUsuario,cpfUsuario,cursoNome,dadosCadastrados;
    private JButton botaoInserir,botaoCancelar;
    private JTextField nomeUsuarioCaixaTexto;
    private JFormattedTextField cpfCaixaTexto;
    private JComboBox cursoOpcoes;
    private JFrame janelaDados;
    private MaskFormatter cpfMascara;

    public CadastroCPF(){
        setSize(350,400);
        setTitle("Cadastro do CPF");
        setLocationRelativeTo(null);

        nomeUsuario = new JLabel("Nome:");
        nomeUsuario.setBounds(5,5,50,50);
        add(nomeUsuario);
        setLayout(null);
        nomeUsuarioCaixaTexto = new JTextField();
        nomeUsuarioCaixaTexto.setBounds(50,5,250,50);
        add(nomeUsuarioCaixaTexto);

        cpfUsuario = new JLabel("CPF:");
        cpfUsuario.setBounds(5,65,50,50);
        add(cpfUsuario);
        try{
            cpfMascara = new MaskFormatter("###.###.###-##");
            cpfMascara.setPlaceholderCharacter('_');
            cpfCaixaTexto = new JFormattedTextField(cpfMascara);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cpfCaixaTexto.setBounds(50,70,250,50);
        add(cpfCaixaTexto);

        cursoNome = new JLabel("Curso:");
        cursoNome.setBounds(5,140,50,50);
        add(cursoNome);
        cursoOpcoes = new JComboBox<>();
        cursoOpcoes.setBounds(50,140,150,50);
        cursoOpcoes.addItem("Nenhum");
        cursoOpcoes.addItem("Engenharia");
        cursoOpcoes.addItem("Veterinaria");
        cursoOpcoes.addItem("Advocacia");
        add(cursoOpcoes);

        botaoInserir = new JButton("Inserir!");
        botaoInserir.setBounds(50,300,100,50);
        add(botaoInserir);
        botaoInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaResultados();
            }
        });

        botaoCancelar = new JButton("Cancelar!");
        botaoCancelar.setBounds(155,300,100,50);
        add(botaoCancelar);
        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpandoOpcoes();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void janelaResultados(){
        String nomeCadastrado = nomeUsuarioCaixaTexto.getText();
        String cpfCadastrado = cpfCaixaTexto.getText();
        String cursoCadastrado = cursoOpcoes.getSelectedItem().toString();

        if (cpfCadastrado.equals("___.___.___-__")){
            JOptionPane.showMessageDialog(this,"A caixa CPF não pode ser deixada vazia!");
        }else{
            janelaDados = new JFrame();
            janelaDados.setTitle("Dados Cadastrados");
            janelaDados.setSize(300,200);
            janelaDados.setLocationRelativeTo(null);

            dadosCadastrados = new JLabel("<html>Nome: " + nomeCadastrado +
                    "<br>CPF: " + cpfCadastrado +
                    "<br>Curso: " + cursoCadastrado + "<html>");

            janelaDados.add(dadosCadastrados);
            janelaDados.setVisible(true);
            janelaDados.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    public void limpandoOpcoes(){
        nomeUsuarioCaixaTexto.setText("");
        cpfCaixaTexto.setText("");
        cursoOpcoes.setSelectedItem("Nenhum");
    }

    public static void main(String[]args){
        CadastroCPF cadastro = new CadastroCPF();
    }
}