package com.exe.app.paginacion;

public class PageItem {

    private int numero;
    private boolean actual;

    public PageItem(int numero, boolean actual){
        super();
        this.numero = numero;
        this.actual = actual;
    }


    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isActual() {
        return this.actual;
    }

    public boolean getActual() {
        return this.actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    
}
