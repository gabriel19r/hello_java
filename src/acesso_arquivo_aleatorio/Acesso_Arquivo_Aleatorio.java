package acesso_arquivo_aleatorio;

import javax.swing.JOptionPane;
import java.io.*;

public class Acesso_Arquivo_Aleatorio {
    private static RandomAccessFile _arquivo;
    public static void main(String[]args){
        int codCliente;
        int alteraCodCliente;
        long aux;
        String codigo;
        String nome;
        String telefone;
        String email;
        String caminho;

        try{
            caminho=Selecionando_Arquivo.caminho();
            _arquivo=new RandomAccessFile(new File(caminho),"rw");

            codigo=JOptionPane.showInputDialog("Digite o código");
            codCliente=Integer.parseInt(codigo);
            aux=(codCliente-1)*100;

            if(aux<_arquivo.length()){
                _arquivo.seek(aux);
                if(codCliente==_arquivo.readInt()){
                    nome=ler(20);
                    telefone=ler(9);
                    email=ler(20);

                    Clientes cli=new Clientes(codCliente, nome, telefone,email);

                    JOptionPane.showMessageDialog(null,
                            "Nome: "+cli.getNome()+"\n"+
                                    "Telefone: "+ cli.getTelefone()+"\n"+
                                    "Email: "+ cli.getEmail());

                    nome=JOptionPane.showInputDialog("Digite o novo nome");
                    cli.setNome(nome.toUpperCase());

                    telefone=JOptionPane.showInputDialog("Digite o novo telefone");
                    cli.setTelefone(telefone.toUpperCase());

                    email=JOptionPane.showInputDialog("Digite o novo email");
                    cli.setEmail(email.toUpperCase());

                    _arquivo.seek(aux);

                    gravar(cli.getCodigo());
                    gravar(cli.getNome(),20);
                    gravar(cli.getTelefone(),8);
                    gravar(cli.getEmail(),20);

                    JOptionPane.showMessageDialog(null,"Registro cadastrado");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Registro não cadastrado");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Registro não cadastrado");
            }
            _arquivo.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro no arquivo");
        }
    }

    public static String ler(int quantidade){
        char letra;
        String texto="";
        try{
            for(int i=0;i<quantidade;i++){
                letra=_arquivo.readChar();
                if(letra!='\u0000'){
                    texto+=letra;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro na leitura");
        }
        finally {
            return texto;
        }
    }

    public static void gravar(String dado, int tamanho){
        try{
            StringBuffer sb=new StringBuffer(dado);
            sb.setLength(tamanho);
            _arquivo.writeChars(sb.toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro na gravação 1");
        }
    }

    public static void gravar(int codCliente){
        try{
            _arquivo.writeInt(codCliente);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro na gravação 2");
        }
    }
}
