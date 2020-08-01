package arquivos_aleatorios;

import javax.swing.JOptionPane;
import java.io.*;

public class Arquivo_Aleatorio {

    private static RandomAccessFile _arquivo;

    public static void main(String[] args) {

        try {
            int codigo;
            String nome;
            String telefone;
            String email;
            String caminho;
            long aux;

            caminho = Selecionando_Arquivo.caminho();
            _arquivo = new RandomAccessFile(new File(caminho), "rw");
            aux = _arquivo.length();
            _arquivo.seek(aux);

            codigo = (int) ((aux / 100) + 1);
            gravar(codigo);

            nome = JOptionPane.showInputDialog("Digite o nome");
            gravar(nome.toUpperCase(), 20);

            telefone = JOptionPane.showInputDialog("Digite o telefone");
            gravar(telefone.toUpperCase(), 9);

            email = JOptionPane.showInputDialog("Digite o email");
            gravar(email.toUpperCase(), 20);

            _arquivo.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no arquivo");
        }
    }

    public static void gravar(String dado, int tamanho)throw IOException {
        StringBuffer buffer = new StringBuffer(dado);
        buffer.setLength(tamanho);
        _arquivo.writeChars(buffer.toString());
    }

    public static void gravar(int codigo)throw IOException {
        _arquivo.writeInt(codigo);
    }
}



