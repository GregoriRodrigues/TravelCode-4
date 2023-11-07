package modelos;

public class RecebeContato {
    private int ID_RecebeContato;
    private Contato ID_Contato;
    private Destino ID_Destino;

    public RecebeContato() {
    }

    public RecebeContato(Contato ID_Contato, Destino ID_Destino) {
        this.ID_Contato = ID_Contato;
        this.ID_Destino = ID_Destino;
    }

    public int getID_RecebeContato() {
        return ID_RecebeContato;
    }

    public void setID_RecebeContato(int ID_RecebeContato) {
        this.ID_RecebeContato = ID_RecebeContato;
    }

    public Contato getID_Contato() {
        return ID_Contato;
    }

    public void setID_Contato(Contato ID_Contato) {
        this.ID_Contato = ID_Contato;
    }

    public Destino getID_Destino() {
        return ID_Destino;
    }

    public void setID_Destino(Destino ID_Destino) {
        this.ID_Destino = ID_Destino;
    }

    @Override
    public String toString() {
        return "RecebeContato [ID_RecebeContato=" + ID_RecebeContato + ", ID_Contato=" + ID_Contato + ", ID_Destino=" + ID_Destino + "]";
    }
}
