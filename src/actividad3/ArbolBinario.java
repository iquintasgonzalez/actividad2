/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad3;

/**
 *
 * @author iqgonzalez17_ESEI
 */
public interface ArbolBinario<E> {

    public boolean esVacio();

    public E raiz() throws ArbolVacioExcepcion;

    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion;

    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion;

    public boolean esta(E elemento);

    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion;

    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException;

    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException;

    public void suprimir();

    //ejercicio 7
    public static <E> boolean mismaForma(ArbolBinario<E> a, ArbolBinario<E> b) {
        if (!a.esVacio() && !b.esVacio()) {
            return mismaForma(a.hijoIzq(), b.hijoIzq()) && mismaForma(a.hijoDer(), b.hijoDer());
        } else {
            return a.esVacio() && b.esVacio();
        }
    }

    //ejercicio 8
    
    public static <E extends Comparable<E>> boolean arbolSeleccion (ArbolBinario<E> arbol){
        
        ArbolBinario<E> menor=null;
            if (arbol.esVacio()) {
            return true;
        }
            if (arbol.hijoDer().esVacio() && arbol.hijoIzq().esVacio()) {
            return true;
        }else if (arbol.hijoDer().esVacio()) {
            menor=arbol.hijoIzq();
            return arbol.raiz().equals(menor.raiz())&& arbolSeleccion(menor);
        }else if (arbol.hijoDer().esVacio()) {
            menor=arbol.hijoIzq();
            return arbol.raiz().equals(menor.raiz())&& arbolSeleccion(menor);
        }else {
                if (arbol.hijoDer().raiz().compareTo(arbol.hijoIzq().raiz())<0) {
                    menor=arbol.hijoDer();
                }else
                    menor=arbol.hijoIzq();
        }
        
        return arbol.raiz().equals(menor.raiz()) && arbolSeleccion(arbol.hijoDer())&& arbolSeleccion(arbol.hijoIzq());
    }
    
    //ejercicio9
    public static <E> boolean esCamino(ArbolBinario<E> arbol, String camino) {
        if (camino.length() == 0) {
            return true;
        } else if (arbol.esVacio()) {
            return false;
        } else if (arbol.raiz().equals(camino.charAt(0))) {
            return esCamino(arbol.hijoIzq(), camino.substring(1)) || esCamino(arbol.hijoDer(), camino.substring(1));
        } else {
            return false;
        }

    }

    //ejercicio11
    public static <E> void visualizarPalabras(ArbolBinario<E> a) {
        String palabra = "";

        visualizarPalabras(a, palabra);
    }

    public static <E> void visualizarPalabras(ArbolBinario<E> a, String palabra) {
        if (!a.esVacio()) {
            if (a.hijoDer().esVacio() && a.hijoIzq().esVacio()) {
                System.out.println(palabra + a.raiz());
            } else {
                visualizarPalabras(a.hijoIzq(), palabra + a.raiz());
                visualizarPalabras(a.hijoDer(), palabra + a.raiz());

            }
        }
    }
    
    //ejercicio12 
    
    public static <E> E padre (ArbolBinario<E> a,E elemento){
        if (a.esVacio()) {
            return null;
            
        }
        else if (a.raiz().equals(elemento))return null;
        else if (a.hijoDer().raiz().equals(elemento)|| a.hijoIzq().raiz().equals(elemento))
                
        return a.raiz();
        
        else{
            E e= padre(a.hijoIzq(),elemento);
        }if (e==null) {
            return padre(a.hijoDer(), elemento);
            else return e;
        }
            
        
    }
    //ejercicio 13
    public static <E> boolean nivelK(ArbolBinario<E> a, E elem, int k) {
        if (a.esVacio()) {
            return false;
        }
        
        else if (k == 0) {
            if (a.raiz().equals(elem)) {
                return true;
            }else return nivelK(a.hijoIzq(), elem, k) || nivelK(a.hijoDer(), elem, k);
        
        }
        else if (k==0) {
            return false;
        }
        

        return false;
    }
}
