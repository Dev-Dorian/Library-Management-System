package ef_ed_dorianhidalgo;

public class Pila {

    class Nodo {        
        int info;
        Nodo sig;
    }

    private Nodo RAIZ;

    Pila() {
        RAIZ = null;
    }

    boolean vacia() {
        if (RAIZ == null) {
            return true;
        } else {
            return false;
        }
    }

    void insertar(int x) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;
        if (vacia()) {
            nuevo.sig = null;
            RAIZ = nuevo;
        } else {
            nuevo.sig = RAIZ;
            RAIZ = nuevo;
        }
    }

    int extraer() {
        if (!vacia()) {
            int informacion = RAIZ.info;
            RAIZ = RAIZ.sig;
            return informacion;
        } else {
                                                                                                                                                                                                  return Integer.MAX_VALUE;
        }
    }

    public void imprimir() {
        Nodo reco = RAIZ;
        System.out.println("Listado de todos los elementos de la pila.");
        while (reco != null) {
            System.out.print(reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

    public boolean ExisteElemento(int x) {
        Nodo reco = RAIZ;
        while (reco != null) {
            if (x == reco.info) {
                return true;
            }
            reco = reco.sig;
        }
        return false;
    }

    public void Remplazar(int abuscar,int remplazar){
         Nodo reco = RAIZ;
             while (reco != null) {
            if (abuscar == reco.info) {
             reco.info=remplazar;
            }
            reco = reco.sig;
        }
       }
    
    
    public int cantidad() {
        int cant = 0;
        Nodo reco = RAIZ;
        while (reco != null) {
            cant++;
            reco = reco.sig;
        }
        return cant;
    }
    public void inicializar(){
       
        Nodo reco = RAIZ;
        while (reco != null) {
            reco.info = 0;
            reco=reco.sig;
        }
       }

    public int retornar() {
        if (RAIZ != null) {
            int informacion = RAIZ.info;
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }



}
