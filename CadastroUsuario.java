import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nome = new JLabel("Nome:");
        JLabel email = new JLabel("Email:");
        JLabel idade = new JLabel("Idade:");

        JTextField campoNome = new JTextField(20);
        JTextField campoEmail = new JTextField(20);
        JTextField campoIdade = new JTextField(20);

        JButton Cadastrar = new JButton("Cadastrar");
        
        Cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, 
                    "Nome: " + campoNome.getText() + "\n" + "\n"
                  + "Email: " + campoEmail.getText() + "\n" + "\n"
                  + "Idade: " + campoIdade.getText());
            }
        });
        
        frame.add(nome);
        frame.add(campoNome);
        frame.add(email);
        frame.add(campoEmail);
        frame.add(idade);
        frame.add(campoIdade);
        frame.add(Cadastrar);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Centralizar

        
    }
}
