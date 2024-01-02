package ef_ed_dorianhidalgo;

public class ListaGenerica {

    class Nodo {

        int info;
        Nodo sig;
    }

    private Nodo raiz;

    public ListaGenerica() {
        raiz = null;
    }

    void insertar(int pos, int x) {
        if (pos <= cantidad() + 1) {
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            if (pos == 1) {
                nuevo.sig = raiz;
                raiz = nuevo;
            } else if (pos == cantidad() + 1) {
                Nodo reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = nuevo;
                nuevo.sig = null;
            } else {
                Nodo reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo siguiente = reco.sig;
                reco.sig = nuevo;
                nuevo.sig = siguiente;
            }
        }
    }

    public int extraer(int pos) {
        if (pos <= cantidad()) {
            int informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
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
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1; f <= pos - 2; f++) {
                    reco = reco.sig;
                }
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
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

    public void Reemplazar(int abuscar, int valor) {
        Nodo reco = raiz;
        while (reco != null) {
            if (reco.info == abuscar) {
                reco.info = valor;
            }
            reco = reco.sig;
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

    public void intercambiarValores(int valor1, int valor2) {
        int pos1 = GetPos(valor1);
        int pos2 = GetPos(valor2);
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

    public int GetPos(int valor) {
        int pos = 0;
        Nodo reco = raiz;
        while (reco != null) {
            pos++;
            if (reco.info == valor) {
                return pos;
            }
            reco = reco.sig;
        }
        return pos;
    }

    public boolean OrdenadaMenMay() {
        Nodo reco = raiz;
        Nodo reco2 = reco.sig;
        while (reco2 != null) {
            if (reco.info > reco2.info) {
                return false;
            }
            reco = reco.sig;
            reco2 = reco2.sig;
        }
        return true;
    }

    public int Mayor() {
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
            return 0;
        }
    }
    
    public int posMayor() {
        if (!vacia()) {
            int may = raiz.info;
            int pos = 1;
            Nodo reco = raiz.sig;
            while (reco != null) {
                if (reco.info > may) {
                    may = reco.info;
                    pos++;
                }
                reco = reco.sig;
            }
            return pos;
        } else {
            return 0;
        }
    }


}
