package com.exe.app.paginacion;


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numElementosPorPagina;
    private int paginaActual;
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<>();

        this.numElementosPorPagina = 5;
        this.totalPaginas = page.getTotalPages();
        this.paginaActual = page.getNumber() + 1;

        int desde, hasta;
        if (totalPaginas <= numElementosPorPagina) {
            desde = 1;
            hasta = totalPaginas;
        } else {
            if (paginaActual <= numElementosPorPagina / 2) {
                desde = 1;
                hasta = numElementosPorPagina;
            } else if (paginaActual >= totalPaginas - numElementosPorPagina / 2) {
                desde = totalPaginas - numElementosPorPagina + 1;
                hasta = totalPaginas;
            } else {
                desde = paginaActual - numElementosPorPagina / 2;
                hasta = paginaActual + numElementosPorPagina / 2;
            }
        }

        for (int i = 0; i < (hasta - desde + 1); i++) {
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }
    }

    // Métodos de acceso para el estado de la paginación
    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean hasNext() {
        return page.hasNext();
    }

    public boolean hasPrevious() {
        return page.hasPrevious();
    }

    public String getUrl() {
        return this.url;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public int getPaginaActual() {
        return this.paginaActual;
    }

    public List<PageItem> getPaginas() {
        return this.paginas;
    }
}
