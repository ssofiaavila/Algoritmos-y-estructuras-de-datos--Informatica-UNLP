package practica2.ejercicio4;

import tp02.ejercicio3.PilaGenerica;

public class Balanceo {
	private PilaGenerica<Character> pila;
	
	public Balanceo() {
		this.pila= new PilaGenerica<Character>();
	}
	    
    public boolean balanceado(String cadena) {
        boolean balanceado = true;
    	for (int i = 0;(i < cadena.length() && balanceado); i++) {
            switch (cadena.charAt(i)) {
                case '[':
                    pila.apilar(']');
                    break;
                case '(':
                    pila.apilar(')');
                    break;
                case '{':
                    pila.apilar('}');
                    break;
                case ']':
                	balanceado = this.verificar(']');
                    break;
                case ')':
                	balanceado = this.verificar(')');
                    break;
                case '}':
                	balanceado = this.verificar('}');
                    break;
            }
        }
        if(pila.esVacia()){
            return true;
        }
        return balanceado;
    }

    private boolean verificar(char c){  	
    	if(pila.esVacia() || (c != (Character) pila.desapilar().charValue())) 
        	return false;
        return true;
    }
    

}

