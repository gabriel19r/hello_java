package arquivos_sequenciais;

import javax.swing.JOptionPane;

public class Agenda {
    private String nome;
    private String endereco;
    private String telefone;

    public Agenda(String n, String e, String t)
    {
        this.nome = n;
        this.endereco = e;
        this.telefone = t;
    }

    public String getNome()
    {
        return nome;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setEndereco(String e) {
        this.endereco = e;
    }

    public void setTelefone(String t) {
        this.telefone = t;
    }
}
