 
package com.emergentes.gestion;



public class Lista {
    private int id;
    private String nombre;
    private Double p1;
    private Double p2;
    private Double ef;

    public Lista() {
        this.id = 0;
        this.nombre = "";
        this.p1 = 0.0;
        this.p2 = 0.0;
        this.ef = 0.0;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public Double getP2() {
        return p2;
    }

    public void setP2(Double p2) {
        this.p2 = p2;
    }

    public Double getEf() {
        return ef;
    }

    public void setEf(Double ef) {
        this.ef = ef;
    }
    
    }
