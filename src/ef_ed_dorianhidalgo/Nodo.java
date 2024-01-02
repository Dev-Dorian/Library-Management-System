package ef_ed_dorianhidalgo;

public class Nodo {

    private int id;
    private Nodo hijoDerecho, hijoIzquierdo;

    public Nodo(int id) {
        this.id = id;
    }

    public Nodo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    @Override
    public String toString() {
        return "Nodo{" + "id=" + id;
    }

}
