import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {

        //Criando a janela principal
        JFrame frame = new JFrame("Cadastro de Usuário"); //Título da janela
        frame.setSize(500, 400); //Tamanho da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fechar ao clicar no X
        frame.setLayout(new FlowLayout()); //Indica que será utilizado o FlowLayout

        //Criando componentes
        //Nome e seu campo de entrada
        JLabel nome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(20);

        //Email e seu campo de entrada
        JLabel email = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);

        //Idade e seu campo de entrada
        JLabel idade = new JLabel("Idade:");
        JTextField campoIdade = new JTextField(20);

        //Seleção de sexo
        JLabel sexo = new JLabel("Sexo:");
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");
        ButtonGroup grupoSexo = new ButtonGroup(); //O ButtonGroup permite que apenas um botão seja selecionado(se não existisse, o usuário podia selecionar os dois)
        grupoSexo.add(masculino);
        grupoSexo.add(feminino);

        // Botão Cadastrar
        JButton Cadastrar = new JButton("Cadastrar");

        //Botão Limpar
        JButton Limpar = new JButton("Limpar");

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

        //Painel Sexo
        JPanel panelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSexo.add(sexo);
        panelSexo.add(masculino);
        panelSexo.add(feminino);

        //Painel Cadastrar (centralizado)
        JPanel panelCadastrar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCadastrar.add(Cadastrar);

        //Painel Limpar (centralizado)
        JPanel panelLimpar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelLimpar.add(Limpar);

        //Painel principal com FlowLayout (um abaixo do outro)
        JPanel Main = new JPanel();
        Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS)); //Foi necessário usar o BoxLayout
                                                               //para todos estarem empilhados :( 
                                                               //o FlowLayout é limitado
        Main.add(panelNome);
        Main.add(panelEmail);
        Main.add(panelIdade);
        Main.add(panelSexo);
        Main.add(panelCadastrar);
        Main.add(panelLimpar);

        //Botão de cadastrar
        Cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { //actionPerformed é quando alguém clica no botão
                String email = campoEmail.getText().trim(); //Pega o texto do campo de email e remove espaços desnecessários
                //Verificação se todos os campos estão preenchidos
                if (campoNome.getText().isEmpty() || campoEmail.getText().isEmpty() || campoIdade.getText().isEmpty() || (!masculino.isSelected() && !feminino.isSelected())) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
                } else if (email.contains("@") && email.contains(".")) {  //Verificação de email
                    JOptionPane.showMessageDialog(frame, 
                    "Usuário cadastrado:" + "\n" + "\n"
                  + "Nome: " + campoNome.getText() + "\n" + "\n"
                  + "Email: " + campoEmail.getText() + "\n" + "\n"
                  + "Idade: " + campoIdade.getText() + "\n" + "\n"
                  + "Sexo: " + (masculino.isSelected() ? "Masculino" : "Feminino"));
                } else {
                    JOptionPane.showMessageDialog(frame, "Email inválido, tente novamente!");
                }

            }
        });

        //Botão de limpar
        Limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoNome.setText("");
                campoEmail.setText("");
                campoIdade.setText(""); //Apaga tudo que foi digitado pelo usuário
                grupoSexo.clearSelection(); //Limpa a seleção de sexo
            }
        });

        frame.add(Main);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //Centralizar a janela
    }
}
