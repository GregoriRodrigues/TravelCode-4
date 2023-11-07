package modelos;

public class Destino {
    private int ID_Destino;
    private String Nome_Destino;
    private String Descricao;
    private int ID_Promocao;

    public Destino() {
    }

    public Destino(int ID_Destino, String Nome_Destino, String Descricao, int ID_Promocao) {
        this.ID_Destino = ID_Destino;
        this.Nome_Destino = Nome_Destino;
        this.Descricao = Descricao;
        this.ID_Promocao = ID_Promocao;
    }

    public int getID_Destino() {
        return ID_Destino;
    }

    public void setID_Destino(int ID_Destino) {
        this.ID_Destino = ID_Destino;
    }

    public String getNome_Destino() {
        return Nome_Destino;
    }

    public void setNome_Destino(String Nome_Destino) {
        this.Nome_Destino = Nome_Destino;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getID_Promocao() {
        return ID_Promocao;
    }

    public void setID_Promocao(int ID_Promocao) {
        this.ID_Promocao = ID_Promocao;
    }

    @Override
    public String toString() {
        return "Destino [ID_Destino=" + ID_Destino + ", Nome_Destino=" + Nome_Destino + ", Descricao=" + Descricao
                + ", ID_Promocao=" + ID_Promocao + "]";
    }
}
