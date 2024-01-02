package ef_ed_dorianhidalgo;


public class ListaGenericaDoblementeEnlazada {

    class Nodo {

        int info;
        Nodo ant, sig;
    }

    private Nodo raiz;

    public ListaGenericaDoblementeEnlazada() {
        raiz = null;
    }

    void insertar(int pos, int x) {
        if (pos <= cantidad() + 1) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            if (pos == 1) {
                nuevo.sig = raiz;
                if (raiz != null) {
                    raiz.ant = nuevo;
                }
                raiz = nuevo;
            } else if (pos == cantidad() + 1) {
                Nodo reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = null;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.ant = reco;
                nuevo.sig = siguiente;
                siguiente.ant = nuevo;
            }
        }
    }

    public int extraer(int pos) {
        if (pos <= cantidad()) {
            int informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
                if (raiz != null) {
                    raiz.ant = null;
                }
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente = prox.sig;
                if (siguiente != null) {
                    siguiente.ant = reco;
                }
                informacion = prox.info;
            }
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void borrar(int pos) {
        if (pos <= cantidad()) {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz != null) {
                    raiz.ant = null;
                }
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                prox = prox.sig;
                reco.sig = prox;
                if (prox != null) {
                    prox.ant = reco;
                }
            }
        }
    }

    public int cantidad() {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimir() {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print(reco.info + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

    public int GetPos(int x) {
        int pos = 0;
        Nodo reco = raiz;
        while (reco != null) {
            pos++;
            if (reco.info == x) {
                return pos;
            }
            reco = reco.sig;
        }
        return pos;
    }

    public int mayor() {
        if (!vacia()) {
            int may = raiz.info;
            Nodo reco = raiz.sig;
            while (reco != null) {
                if (reco.info > may) {
                    may = reco.info;
                }
                reco = reco.sig;
            }
            return may;
        } else {
            return -1;
        }
    }

    public int posMayor2() {
        if (!vacia()) {
            return GetPos(mayor());
        } else {
            return -1;
        }
    }

    public void intercambiar(int pos1, int pos2) {
        if (pos1 <= cantidad() && pos2 <= cantidad()) {
            Nodo reco1 = raiz;
            for (int f = 1; f < pos1; f++) {
                reco1 = reco1.sig;
            }
            Nodo reco2 = raiz;
            for (int f = 1; f < pos2; f++) {
                reco2 = reco2.sig;
            }
            int aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }

    public boolean ordenada() {
        if (cantidad() > 1) {
            Nodo reco1 = raiz;
            Nodo reco2 = raiz.sig;
            while (reco2 != null) {
                if (reco2.info < reco1.info) {
                    return false;
                }
                reco2 = reco2.sig;
                reco1 = reco1.sig;
            }
        }
        return true;
    }

    public void impresionReversa() {
        Nodo reco = raiz;
        for(int i =1; i<cantidad();i++){
            reco=reco.sig;
        }
        for(int i = cantidad();i>=1;i--){
            System.out.print(reco.info+"-");
            reco=reco.ant;
        }
        System.out.println();

    }

    public void imprimirReversoPosicion(int posi){
        Nodo reco = raiz;
        for(int i =1; i<posi;i++){
            reco=reco.sig;
        }
        for(int i = posi;i>=1;i--){
            System.out.print(reco.info+"-");
            reco=reco.ant;
        }
        System.out.println();
    }
    
    public void obtenerPosicion(int posi,char comando){
        Nodo reco= raiz;
        System.out.println("Posicion Original"+posi);
        if(comando=='A'){
            System.out.println("Posicion Anterior"+extraer(reco.info));
           // System.out.println("valor"+reco.ant.info);
        }
        if(comando=='P'){
            extraer(posi+1);
            System.out.println("Posicion Posterior"+extraer(posi+1));
        }
     
        
    }
    
    public int ObtenerPosicion(int Pos, String Comando){
        int retorno=-1;
        if(Pos <= cantidad()){
            Nodo reco = raiz;
            
            for(int f = 1; f <Pos; f++ ){
                reco = reco.sig;
            }
            if(Comando == "A"){
                if(reco.ant!=null){
                    return reco.ant.info;
                }
                else{
                    return -1;
                }
            }
         if (Comando == "P"){
             if(reco.sig!=null){
                 return reco.sig.info;
             }else{
                 return -1;
             }
         }   
        }
        return retorno;
    }
    
}
