
package ef_ed_dorianhidalgo;

import java.util.Scanner;
public class Main {

 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cola cola = new Cola();
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();    
        Pila PilaNodos = new Pila();
        ListaCircular LC = new ListaCircular();
        ListaGenericaDoblementeEnlazada LD = new ListaGenericaDoblementeEnlazada();
        ArbolBinarioOrdenado AB = new ArbolBinarioOrdenado();
        ListaGenerica Lista = new ListaGenerica();


        for (int i = 0; i <= 9; i++) {
            System.out.print("Valor [" + i + "] = ");
            int numero = sc.nextInt();
            cola.insertar(numero);

        }

        System.out.println();

        int CantidadCola = cola.cantidad();

        for (int i = 1; i <= CantidadCola; i++) {
            pila1.insertar(cola.extraer());

        }

      pila1.imprimir();
        System.out.println();

        int pila = pila1.cantidad();
        for (int i = 1; i <= pila; i++) {
            LC.insertarPrimero(pila1.extraer());

        }
        System.out.println("Los elementos de la Lista Circular son: ");
        LC.imprimir();
        System.out.println();


        int listaC = LC.cantidad();

        for (int i = 1; i <= listaC; i++) {
            LD.insertar(1, LC.extraer(1));
        }
       System.out.println("Los elementos de la Lista doblemente enlazada son: ");
       LD.imprimir();
       System.out.println();
       
        
        
    int cantidapila= LD.cantidad();
    for(int i=1; i<=cantidapila ; i++){
       pila2.insertar(LD.extraer(1));
    }
    pila2.imprimir();


      int CantidadArbol=pila2.cantidad();
        for (int i = 0; i < CantidadArbol; i++) {
          AB.insertar(pila2.extraer());
       }
      
        System.out.println("La Impresion del Arbol en pre-orden es: ");
       AB.imprimirPre();
       System.out.println();
      int valormenor=AB.MenorValor();
      
      
      int cantidadNodos2 = pila2.cantidad();
        for (int i = 0; i < cantidadNodos2; i++) {
            AB.insertar(pila2.extraer());
        }
   
        System.out.println("Los nodos hoja son: ");
        AB.ImprimeNodosHoja();
        System.out.println("");

        System.out.println("El peso del arbol es: "+AB.Peso());

        int raizArbol= AB.devuelveRaiz();
        
        int cantidadGrafos= 0;
        
        if(raizArbol<valormenor){
            
            cantidadGrafos= valormenor;            
        }else{
           cantidadGrafos  =raizArbol;         
        }
         Grafo g = new Grafo(cantidadGrafos+1);
         g.insertarArista(raizArbol,valormenor, (raizArbol*10));
         g.mostrarGrafo();
        
        
        
    }
    
}
