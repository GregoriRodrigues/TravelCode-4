package modelos;

public class Contato {
    // atributos
    private int ID_Contato;
    private String Mensagem;
    private String Email;
    private String Nome;
    private String Telefone;
    private String Assunto;

    // construtor sem argumentos
    public Contato() {
        this.ID_Contato = 0;
        this.Mensagem = "";
        this.Email = "";
        this.Nome = "";
        this.Telefone = "";
        this.Assunto = "";
    }

    // construtor com argumentos
    public Contato(int ID_Contato, String Mensagem, String Email, String Nome, String Telefone, String Assunto) {
        this.ID_Contato = ID_Contato;
        this.Mensagem = Mensagem;
        this.Email = Email;
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Assunto = Assunto;
    }

    // getters e setters
    public int getID_Contato() {
        return ID_Contato;
    }

    public void setID_Contato(int ID_Contato) {
        this.ID_Contato = ID_Contato;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String Assunto) {
        this.Assunto = Assunto;
    }

    // toString
    @Override
    public String toString() {
        return "Contato [ID_Contato=" + ID_Contato + ", Mensagem=" + Mensagem + ", Email=" + Email + ", Nome=" + Nome + ", Telefone=" + Telefone + ", Assunto=" + Assunto + "]";
    }
}
