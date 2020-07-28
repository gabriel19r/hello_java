package arquivos_sequenciais;

import javax.swing.JOptionPane;
import java.io.*;

public class Arquivo_sequencial {
    static StringBuffer memoria; //do exemplo 2 e 3
    static String arq=Selecionando_Arquivo.caminho(); //do exemplo 3
    public static void main(String[] args) {
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
        /*

        try{
            String arq=Selecionando_Arquivo.caminho();
            BufferedReader arqEntrada=new BufferedReader(new FileReader(arq));

            String nome=JOptionPane.showInputDialog("Digite o nome");
            nome=nome.toUpperCase();

            String linha;
            String endereco="";
            String telefone="";

            while((linha=arqEntrada.readLine()) != null){
                memoria.append(linha+"\r\n");
            }

            int inicio=-1;
            inicio=memoria.indexOf(nome);

            if(inicio!=-1){
                int ultimo=memoria.indexOf("\t",inicio);
                nome=ler(inicio,ultimo);

                int primeiro=ultimo+1;
                ultimo=memoria.indexOf("\t",primeiro);

                endereco=ler(primeiro,ultimo);
                primeiro=ultimo+1;

                int fim=memoria.indexOf("\n",primeiro);
                telefone=ler(primeiro,fim);

                Agenda agenda1=new Agenda(nome,endereco,telefone);

                JOptionPane.showMessageDialog(null,"Endereço: "+agenda1.getEndereco()+"\n"+"Telefone: "+agenda1.getTelefone());
            }else{
                JOptionPane.showMessageDialog(null,"Não cadastrado");
            }
            arqEntrada.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro de leitura");
        }
    }

    public static String ler(int p, int u){
        String dados="";

        dados=memoria.substring(p,u);

        return dados;
    }

    //*/

        // - Exemplo 3

        try{
        BufferedReader arqEntrada=new BufferedReader(new FileReader(arq));

        String nome=JOptionPane.showInputDialog("Digite o nome");
        nome=nome.toUpperCase();

        String linha="";
        String endereco="";
        String telefone="";

        while((linha=arqEntrada.readLine())!=null){
            memoria.append(linha+"\r\n");
        }

        int inicio=-1;
        inicio=memoria.indexOf(nome);

        if(inicio!=-1){
            int ultimo=memoria.indexOf("\t",inicio);
            nome=ler(inicio,ultimo);

            int primeiro=ultimo+1;
            ultimo=memoria.indexOf("\t",primeiro);

            endereco=ler(primeiro,ultimo);

            primeiro=ultimo+1;

            int fim=memoria.indexOf("\n",primeiro);
            telefone=ler(primeiro,fim);

            Agenda agenda1=new Agenda(nome,endereco,telefone);

            JOptionPane.showMessageDialog(null,agenda1.getEndereco()+"\n"+agenda1.getTelefone());

            endereco=JOptionPane.showInputDialog("Entre com o novo endereço");
            endereco=endereco.toUpperCase();
            agenda1.setEndereco(endereco);

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
        arqEntrada.close();

    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Erro de leitura");
    }
}

public static String ler(int p,int u){
    String dados="";
    dados=memoria.substring(p,u);
    return dados;
}

public static void gravar(){
    try{
        BufferedWriter saida=new BufferedWriter(new FileWriter(arq));

        saida.write(memoria.toString());

        saida.flush();
        saida.close();
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Erro de gravação");
        }
    }
}