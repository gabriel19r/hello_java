package acesso_arquivo_aleatorio;

import javax.swing.JOptionPane;
import java.io.*;

public class Acesso_Arquivo_Aleatorio {
    private static RandomAccessFile _arquivo;
    public static void main(String[]args){
        try{
            int codCliente;
            long aux;
            String codigo;
            String caminho;

            caminho=Selecionando_Arquivo.caminho();
            _arquivo=new RandomAccessFile(new File(caminho),"rw");

            codigo=JOptionPane.showInputDialog("Digite o código");
            codCliente=Integer.parseInt(codigo);
            aux=(codCliente-1)*100;

            if(aux<_arquivo.length()){
                _arquivo.seek(aux);
                if(codCliente==_arquivo.readInt()){
                    JOptionPane.showMessageDialog(null,"Registro cadastrado");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Registro não cadastrado");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Registro cadastrado");
            }
            _arquivo.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro no arquivo");
        }
    }
}
