package arquivos_sequenciais;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.File;

public class Selecionando_Arquivo {
    public static String caminho()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int res = fileChooser.showOpenDialog(null);

        if (res == fileChooser.CANCEL_OPTION) {
            return null;
        }

        File arq = fileChooser.getSelectedFile();

        if (arq == null || arq.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de arquivo inválido");
        } else {
            return arq.getPath();
        }

        return null;

    }
}
