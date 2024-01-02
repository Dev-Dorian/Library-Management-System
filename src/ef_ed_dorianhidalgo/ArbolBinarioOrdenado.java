package ef_ed_dorianhidalgo;



public class ArbolBinarioOrdenado {

    class Nodo {

        int info;
        Nodo izq, der;
    }

    Nodo raiz;

    public ArbolBinarioOrdenado() {
        raiz = null;
    }

    public void insertar(int info) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = info;
        nuevo.izq = null;
        nuevo.der = null;
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo anterior = null, reco;
            reco = raiz;
            while (reco != null) {
                anterior = reco;
                if (info < reco.info) {
                    reco = reco.izq;
                } else {
                    reco = reco.der;
                }
            }
            if (info < anterior.info) {
                anterior.izq = nuevo;
            } else {
                anterior.der = nuevo;
            }
        }
    }

    private void imprimirPre(Nodo reco) {
        if (reco != null) {
            System.out.print(reco.info + " ");
            imprimirPre(reco.izq);
            imprimirPre(reco.der);
        }
    }

    public void imprimirPre() {
        imprimirPre(raiz);
        System.out.println();
    }


    private void imprimirEntre(Nodo reco) {
        if (reco != null) {
            imprimirEntre(reco.izq);
            System.out.print(reco.info + " ");
            imprimirEntre(reco.der);
        }
    }


    public void imprimirEntre() {
        imprimirEntre(raiz);
        System.out.println();
    }

    private void imprimirPost(Nodo reco) {
        if (reco != null) {
            imprimirPost(reco.izq);
            imprimirPost(reco.der);
            System.out.print(reco.info + " ");
        }
    }

    public void imprimirPost() {
        imprimirPost(raiz);
        System.out.println();
    }

    int cant;

    private void cantidad(Nodo reco) {
        if (reco != null) {
            cant++;
            cantidad(reco.izq);
            cantidad(reco.der);
        }
    }

    public int cantidad() {
        cant = 0;
        cantidad(raiz);
        return cant;
    }
 
    
    public boolean existe(int info) {
        Nodo reco = raiz;
        while (reco != null) {
            if (info == reco.info) {
                return true;
            } else if (info > reco.info) {
                reco = reco.der;
            } else {
                reco = reco.izq;
            }
        }
        return false;
    }
    
    
    public int tipoNodo(int info){
        Nodo reco=raiz;
        while(reco!=null){
         if (info == reco.info) {
              if(reco.der==null && reco.izq==null){
                  return 2;
              }else{
                  return 1;
              }
            } 
         else if (info > reco.info) {
                reco = reco.der;
            } else {
                reco = reco.izq;                  
            }
        }
        return 0;
    }
    
    public int menorValor(int x) {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.izq != null) {
                reco = reco.izq;
            }
            return reco.info;
        }
        return -1;
       
    }
    
     public void MayorValor() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.der != null) {
                reco = reco.der;
            }
            System.out.println("El mayor valor del arbol es: "+reco.info);
        }

    }
     
     
     public int devuelveRaiz(){
         if(raiz!=null){
             return raiz.info;
         }
         return -1;
     }
      
   
    public int MenorValor() {
        if (raiz != null) {
            Nodo reco = raiz;
            while (reco.izq != null) {
                reco = reco.izq;
            }
            return reco.info;
        }
        return -1;
       
    }
    private void ImprimeNodosHoja(Nodo reco) {
        if (reco != null) {
            if (reco.izq == null && reco.der == null) {
                System.out.print(" - " + reco.info);
            }
            ImprimeNodosHoja(reco.izq);
            ImprimeNodosHoja(reco.der);
        }
    }

    public void ImprimeNodosHoja() {
        ImprimeNodosHoja(raiz);
    }
    private void Peso(Nodo reco) {
        if (reco != null) {
            cant++;
            Peso(reco.izq);
            Peso(reco.der);
        }
    }

    public int Peso() {
        Peso(raiz);
        return cant;
    }
    
    
}