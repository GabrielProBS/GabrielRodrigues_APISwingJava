import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {
        //Criando a janela principal
        JFrame frame = new JFrame("Cadastro de Usuário"); //Título da janela
        frame.setSize(500, 400); //Tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar ao clicar no X
        frame.setLayout(new FlowLayout());

        //Criando componentes
        //Nome e seu campo
        JLabel nome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(20);

        //Email e seu campo
        JLabel email = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);

        //Idade e seu campo
        JLabel idade = new JLabel("Idade:");
        JTextField campoIdade = new JTextField(20);

        // Botão Cadastrar
        JButton Cadastrar = new JButton("Cadastrar");

        //Painéis para organizar os componentes
        //Painel Nome
        JPanel panelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNome.add(nome);
        panelNome.add(campoNome);

        //Painel Email
        JPanel panelEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEmail.add(email);
        panelEmail.add(campoEmail);

        //Painel Idade
        JPanel panelIdade = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIdade.add(idade);
        panelIdade.add(campoIdade);

        //Painel Cadastrar (centralizado)
        JPanel panelCadastrar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCadastrar.add(Cadastrar);

        //Painel principal com FlowLayout (um abaixo do outro)
        JPanel Main = new JPanel();
        Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS)); //Foi necessário usar o BoxLayout
                                                               //para todos estarem empilhados :( 
                                                               //o FlowLayout é limitado

        Main.add(panelNome);
        Main.add(panelEmail);
        Main.add(panelIdade);
        Main.add(panelCadastrar);

        // Ação do botão Cadastrar
        Cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //actionPerformed é quando alguém clica no botão
                if (campoNome.getText().isEmpty() || 
                    campoEmail.getText().isEmpty() || 
                    campoIdade.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                } else {
                    JOptionPane.showMessageDialog(frame, 
                    "Usuário cadastrado:" + "\n" + "\n"
                  + "Nome: " + campoNome.getText() + "\n" + "\n"
                  + "Email: " + campoEmail.getText() + "\n" + "\n"
                  + "Idade: " + campoIdade.getText());
                }
            }
        });
        
        frame.add(Main);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Centralizar

        
    }
}
