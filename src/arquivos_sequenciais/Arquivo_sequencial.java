package arquivos_sequenciais;

import javax.swing.JOptionPane;
import java.io.*;

public class Arquivo_sequencial {
    static StringBuffer memoria; //do exemplo 2
    public static void main(String[] args)
    {
        // - Exemplo 1
        /*

        try {
            String arq = Selecionando_Arquivo.caminho();

            BufferedWriter saida = new BufferedWriter(new FileWriter(arq, true));

            String nome = JOptionPane.showInputDialog("Digite o nome");
            nome = nome.toUpperCase();

            String endereco = JOptionPane.showInputDialog("Digite o endereço");
            endereco = endereco.toUpperCase();

            String telefone = JOptionPane.showInputDialog("Digite o telefone");

            Agenda agenda1=new Agenda(nome,endereco,telefone);
            saida.write(agenda1.getNome()+"\t;");
            saida.write(agenda1.getEndereco()+"\t");
            saida.write(agenda1.getTelefone()+"\r\n");

            saida.flush();
            saida.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro de acesso ao arquivo");
        }

         */

        // - Exemplo 2
        /**/
        

    }
}
