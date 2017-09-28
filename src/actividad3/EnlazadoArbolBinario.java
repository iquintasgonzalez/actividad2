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
public class EnlazadoArbolBinario<E> implements ArbolBinario<E>{
    
    private NodoBinario <E> raiz;
    
    public EnlazadoArbolBinario() {
        raiz = null;
    }

    public EnlazadoArbolBinario(E elemRaiz, EnlazadoArbolBinario<E> hi,EnlazadoArbolBinario<E> hd ) {
        raiz= new NodoBinario<E>(elemRaiz,hi.raiz,hd.raiz);
        
               
    }
    
    public boolean esVacio(){
        if (raiz==null) {
            return true;
        }else
        
        return false;
    }
    
     public E raiz() throws ArbolVacioExcepcion{
         if (raiz==null) {
             throw new ArbolVacioExcepcion("hola");
         }
      return raiz.getElemento();
     }
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion{
        return raiz.getIzq();
    }

    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion{
        return 
    }

    public boolean esta(E elemento){
        if (raiz.getElemento().equals(elemento)) {
            return true;
        }else
        
        
        return this.hijoIzq().esta(elemento)||this.hijoDer().esta(elemento);
    }

    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion{
        if (esVacio()) {
            throw new ArbolVacioExcepcion("raiz :arbolvacio");
            
        }
        raiz.setElemento(elemRaiz);
    }

    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException{
        if (hi==null){
            throw new NullPointerException("Vacio");
        }else if (hi.esVacio()) {
            throw new ArbolVacioExcepcion("arbol vacio");
        
            
        }else
            
        raiz.setIzq( ((EnlazadoArbolBinario<E>) hi).raiz);  
    
    }

    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException{
        if (hd==null){
            throw new NullPointerException("Vacio");
        }else if (hd.esVacio()) {
            throw new ArbolVacioExcepcion("arbol vacio");
        
            
        }else
            
        raiz.setIzq( ((EnlazadoArbolBinario<E> )hd).raiz);  
    
    }

    public void suprimir(){
        raiz =null;
    }
}
