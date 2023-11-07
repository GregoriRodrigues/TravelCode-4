package modelos;

public class Promocao {
    private int ID_Promocao;
    private String Detalhes_Promocao;
    private String Data_Inicio;
    private String Data_Fim;

    public Promocao() {
    }

    public Promocao(int ID_Promocao, String Detalhes_Promocao, String Data_Inicio, String Data_Fim) {
        this.ID_Promocao = ID_Promocao;
        this.Detalhes_Promocao = Detalhes_Promocao;
        this.Data_Inicio = Data_Inicio;
        this.Data_Fim = Data_Fim;
    }

    public int getID_Promocao() {
        return ID_Promocao;
    }

    public void setID_Promocao(int ID_Promocao) {
        this.ID_Promocao = ID_Promocao;
    }

    public String getDetalhes_Promocao() {
        return Detalhes_Promocao;
    }

    public void setDetalhes_Promocao(String Detalhes_Promocao) {
        this.Detalhes_Promocao = Detalhes_Promocao;
    }

    public String getData_Inicio() {
        return Data_Inicio;
    }

    public void setData_Inicio(String Data_Inicio) {
        this.Data_Inicio = Data_Inicio;
    }

    public String getData_Fim() {
        return Data_Fim;
    }

    public void setData_Fim(String Data_Fim) {
        this.Data_Fim = Data_Fim;
    }

    @Override
    public String toString() {
        return "ID_Promocao: " + ID_Promocao + ", Detalhes_Promocao: " + Detalhes_Promocao +
                ", Data_Inicio: " + Data_Inicio + ", Data_Fim: " + Data_Fim;
    }
}
