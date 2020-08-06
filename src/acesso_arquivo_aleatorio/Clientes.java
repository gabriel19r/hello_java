package acesso_arquivo_aleatorio;

public class Clientes {
    private int _codigo;
    private String _nome;
    private String _telefone;
    private String _email;

    public Clientes(int codigo, String nome, String telefone, String email){
        this._codigo=codigo;
        this._nome=nome;
        this._telefone=telefone;
        this._email=email;
    }

    public int getCodigo(){
        return _codigo;
    }

    public void setCodigo(int c){
        this._codigo=c;
    }

    public String getNome(){
        return _nome;
    }

    public void setNome(String n){
        this._nome=n;
    }

    public String getTelefone(){
        return _telefone;
    }

    public void setTelefone(String t){
        this._telefone=t;
    }

    public String getEmail(){
        return _email;
    }

    public void setEmail(String e){
        this._email=e;
    }
}
