import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaDeVotacao extends JFrame{
    private JLabel textoTitulo;
    private JRadioButton botaoCandidato1, botaoCandidato2;
    private JButton botaoVotar;
    private ButtonGroup grupoCandidatos;
    private Container container;

    public SistemaDeVotacao(){
        setSize(500,500);
        setTitle("Sistema de Votação");
        setLocationRelativeTo(null);
        setLayout(null);

        textoTitulo = new JLabel("Urna Eletrônica");
        textoTitulo.setBounds(200,0,100,100);
        add(textoTitulo);

        botaoCandidato1 = new JRadioButton("Candidato 1");
        botaoCandidato1.setActionCommand("Candidato 1");
        botaoCandidato1.setBounds(100,100,100,200);
        add(botaoCandidato1);

        botaoCandidato2 = new JRadioButton("Candidato 2");
        botaoCandidato2.setActionCommand("Candidato 2");
        botaoCandidato2.setBounds(300,100,100,200);
        add(botaoCandidato2);

        grupoCandidatos = new ButtonGroup();
        grupoCandidatos.add(botaoCandidato1);
        grupoCandidatos.add(botaoCandidato2);
        botaoCandidato1.setSelected(true);

        botaoVotar = new JButton("Votar!");
        botaoVotar.setBounds(200,320,100,50);
        add(botaoVotar);
        botaoVotar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tratamentodoVoto();
            }
        });

        container = getContentPane();
        container.setLayout(null);
        container.add(botaoCandidato1);
        container.add(botaoCandidato2);
        container.add(botaoVotar);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void tratamentodoVoto(){
        String candidatoSelecionado = grupoCandidatos.getSelection().getActionCommand();
        JOptionPane.showMessageDialog(this,"Você votou no " + candidatoSelecionado);
    }


    public static void main(String[]args){
        SistemaDeVotacao sistemaDeVotacao = new SistemaDeVotacao();

    }
}
