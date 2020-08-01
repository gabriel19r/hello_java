package arquivos_sequenciais;

import javax.swing.JOptionPane;
import java.io.*;

public class Arquivo_sequencial {
    static StringBuffer memoria = new StringBuffer();
    static String arq = Selecionando_Arquivo.caminho();

    public static void main(String[] args) {
        try {
            String linha="";
            String endereco="";
            String telefone="";
            String nome="";
            int inicio=-1;
            int primeiro;
            int ultimo;
            int fim;

            String arq = Selecionando_Arquivo.caminho();

            // - Ler arquivo
            BufferedReader arqentrada=new BufferedReader(new FileReader(arq));

            // - Abrir o arquivo para escrita
            /*
            BufferedWriter saida = new BufferedWriter(new FileWriter(arq, true));
             */

            nome = JOptionPane.showInputDialog("Digite o nome");
            nome = nome.toUpperCase();

            while((linha=arqentrada.readLine())!=null){
                memoria.append(linha+"\r\n");
            }

            inicio=memoria.indexOf(nome);

            if(inicio!=-1){
                ultimo=memoria.indexOf("\t",inicio);
                nome=ler(inicio,ultimo);
                primeiro=ultimo+1;
                ultimo=memoria.indexOf("\t",primeiro);
                endereco=ler(primeiro,ultimo);
                primeiro=ultimo+1;
                fim=memoria.indexOf("\n",primeiro);
                telefone=ler(primeiro,fim);

                Agenda agenda1=new Agenda(nome, endereco, telefone);

                JOptionPane.showMessageDialog(null,"Endereço: "+
                agenda1.getEndereco()+"\n"+"Telefone: "+
                        agenda1.getTelefone());

                endereco=JOptionPane.showInputDialog("Entre com o novo endereço");
                agenda1.setEndereco(endereco.toUpperCase());

                telefone=JOptionPane.showInputDialog("Entre com o novo telefone");
                agenda1.setTelefone(telefone);

                memoria.replace(inicio,fim+1,
                        agenda1.getNome()+"\t"+
                        agenda1.getEndereco()+"\t"+
                        agenda1.getTelefone()+"\r\n");
                gravar();
                JOptionPane.showMessageDialog(null,"Atualização realizada com sucesso");

            }else{
                JOptionPane.showMessageDialog(null,"Não cadastrado");
            }
            arqentrada.close();

            // - Para escrever o endereco
            /*
            String endereco = JOptionPane.showInputDialog("Digite o endereço");
            endereco = endereco.toUpperCase();
             */

            // - Para escrever o telefone
            /*
            String telefone = JOptionPane.showInputDialog("Digite o telefone");
            */

            // - Gravação do nome, endereço e telefone no arquivo
            /*
            Agenda agenda1 = new Agenda(nome, endereco, telefone);
            saida.write(agenda1.getNome() + "\t");
            saida.write(agenda1.getEndereco() + "\t");
            saida.write(agenda1.getTelefone() + "\r\n");

            saida.flush();
            saida.close();
            */

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de acesso ao arquivo");
        }
    }

    public static String ler(int primeiro, int ultimo){
        String dados="";
        dados=memoria.substring(primeiro,ultimo);
        return dados;
    }

    public static void gravar(){
        try{
            BufferedWriter arqsaida=new BufferedWriter(new FileWriter(arq));
            arqsaida.write(memoria.toString());
            arqsaida.flush();
            arqsaida.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro de gravação");
        }
    }
}
