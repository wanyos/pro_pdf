
package com.wanyos.modelo;

import java.time.LocalTime;

/**
 *
 * @author wanyos
 */
public class Turno {
      
    private int turno, minutos;
    private LocalTime init, fin, total_turno;
    private String cc, lugar_init, lugar_fin;
    
    
    public Turno(int turno, String cc, LocalTime init, String lugar_init, LocalTime fin, String lugar_fin, LocalTime total_turno, int  minutos){
        this.turno = turno;
        this.cc = cc;
        this.init = init;
        this.lugar_init = lugar_init;
        this.fin = fin;
        this.lugar_fin = lugar_fin;
        this.total_turno = total_turno;
        this.minutos = minutos;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public LocalTime getInit() {
        return init;
    }

    public void setInit(LocalTime init) {
        this.init = init;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public LocalTime getTotal_turno() {
        return total_turno;
    }

    public void setTotal_turno(LocalTime total_turno) {
        this.total_turno = total_turno;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getLugar_init() {
        return lugar_init;
    }

    public void setLugar_init(String lugar_init) {
        this.lugar_init = lugar_init;
    }

    public String getLugar_fin() {
        return lugar_fin;
    }

    public void setLugar_fin(String lugar_fin) {
        this.lugar_fin = lugar_fin;
    }
    
    
    
}
