package com.clases;

public class Pronostico {
    private Partido partido;
    private Equipo equipo1;
    private ResultadoEnum resultado;
    private Equipo equipo2;

    // Metodos Triviales Getters and Setters
    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    // Puntos

    public int calcularPuntos(int equipo1, int equipo2) {
        int puntos = 0;
        if (equipo1 == equipo2) {
            if (this.resultado == ResultadoEnum.EMPATE)
                puntos = 1;
        } else if (equipo1 > equipo2) {
            if (this.resultado == ResultadoEnum.GANADOR_EQUIPO1)
                puntos = 1;
        } else if (equipo1 < equipo2)
            if (this.resultado == ResultadoEnum.GANADOR_EQUIPO2)
                puntos = 1;
        return puntos;
    }

    public String pronostico() {
        String pronosticoString = "Undefined";
        if (this.resultado == ResultadoEnum.GANADOR_EQUIPO1)
            pronosticoString = "Gana " + this.getEquipo1().getNombre();
        else if (resultado == ResultadoEnum.EMPATE)
            pronosticoString = "Empate";
        else if (this.resultado == ResultadoEnum.GANADOR_EQUIPO2)
            pronosticoString = "Gana " + this.getEquipo2().getNombre();
        return pronosticoString;
    }
}
