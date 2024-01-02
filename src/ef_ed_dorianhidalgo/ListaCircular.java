package ef_ed_dorianhidalgo;


public class ListaCircular {

    class Nodo {

        int info;
        Nodo ant, sig;
    }

    private Nodo raiz;

    public ListaCircular() {
        raiz = null;
    }

    public void insertarPrimero(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
            raiz = nuevo;
        } else {
            Nodo ultimo = raiz.ant; //1
            nuevo.sig = raiz; //2
            nuevo.ant = ultimo; //3
            raiz.ant = nuevo; //4
            ultimo.sig = nuevo; //5
            raiz = nuevo;
        }
    }

    public void insertarUltimo(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        if (raiz == null) {
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
            raiz = nuevo;
        } else {
            Nodo ultimo = raiz.ant;
            nuevo.sig = raiz;
            nuevo.ant = ultimo;
            raiz.ant = nuevo;
            ultimo.sig = nuevo;
        }
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimir() {
        if (!vacia()) {
            Nodo reco = raiz;
            do {
                System.out.print(reco.info + "-");
                reco = reco.sig;
            } while (reco != raiz);
            System.out.println();
        }
    }

    public int cantidad() {
        int cant = 0;
        if (!vacia()) {
            Nodo reco = raiz;
            do {
                cant++;
                reco = reco.sig;
            } while (reco != raiz);
        }
        return cant;
    }

    public int extraer(int pos) {
        if (pos <= cantidad()) {
            int informacion;
            if (pos == 1) {
                if (cantidad() == 1) {
                    informacion = raiz.info;
                    raiz = null;
                } else {
                    Nodo ultimo = raiz.ant;
                    informacion = raiz.info;
                    raiz = raiz.sig;
                    ultimo.sig = raiz;
                    raiz.ant = ultimo;
                }
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 1; f++) {
                    reco = reco.sig;
                }
                informacion = reco.info;
                Nodo anterior = reco.ant;
                reco = reco.sig;
                anterior.sig = reco;
                reco.ant = anterior;
            }
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    public void borrar(int pos) {
        if (pos <= cantidad()) {
            if (pos == 1) {
                if (cantidad() == 1) {
                    raiz = null;
                } else {
                    Nodo ultimo = raiz.ant;
                    raiz = raiz.sig;
                    ultimo.sig = raiz;
                    raiz.ant = ultimo;
                }
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 1; f++) {
                    reco = reco.sig;
                }
                Nodo anterior = reco.ant;
                reco = reco.sig;
                anterior.sig = reco;
                reco.ant = anterior;
            }
        }
    }


    public int GetPos(int x) {
        int pos = 0;
        Nodo reco = raiz;
        do {
            pos++;
            if (reco.info == x) {
                return pos;
            }
            reco = reco.sig;
        } while (reco != raiz);

        return pos;
    }

    public boolean ordenada() {
        if (cantidad() > 1) {
            Nodo reco1 = raiz;
            Nodo reco2 = raiz.sig;
            do {
                if (reco2.info < reco1.info) {
                    return false;
                }
                reco2 = reco2.sig;
                reco1 = reco1.sig;
            } while (reco2 != raiz);

        }
        return true;
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

    public void ordenar() {
        if (cantidad() > 1) {
            while (!ordenada()) {
                Nodo reco1 = raiz;
                Nodo reco2 = raiz.sig;
                int pos1, pos2;
                do {
                    if (reco2.info < reco1.info) {
                        pos1 = GetPos(reco1.info);
                        pos2 = GetPos(reco2.info);
                        intercambiar(pos1, pos2);
                    }
                    reco2 = reco2.sig;
                    reco1 = reco1.sig;
                } while (reco2 != raiz);
            }
        }
    }

    public int mayor() {
        if (!vacia()) {
            int may = raiz.info;
            Nodo reco = raiz.sig;
            do {
                if (reco.info > may) {
                    may = reco.info;
                }
                reco = reco.sig;
            } while (reco != raiz);
            return may;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int posMayor() {
        if (!vacia()) {
            int may = raiz.info;
            int x = 2;
            int pos = x;
            Nodo reco = raiz.sig;
            do {
                if (reco.info > may) {
                    may = reco.info;
                    pos = x;
                }
                x++;
                reco = reco.sig;
            } while (reco != raiz);
            return pos;
        } else {
            return Integer.MAX_VALUE;
        }
    }


}
