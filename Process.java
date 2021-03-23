package com.company;

public class Process {
    private int index;
    private boolean zaglodzony = false;
    private int dlugosc;
    private int momentZgloszenia;
    private int pozostalyCzas;
    private int czasOczekiwania = 0;

    public Process(int index, int dlugosc, int momentzgloszenia) {
        this.index = index;
        this.dlugosc = dlugosc;
        this.momentZgloszenia = momentzgloszenia;
        this.pozostalyCzas = dlugosc;
    }

    @Override
    public String toString() {
        return "Process{" +
                "index=" + index +
                ", zaglodzony=" + zaglodzony +
                ", dlugosc=" + dlugosc +
                ", momentZgloszenia=" + momentZgloszenia +
                ", pozostalyCzas=" + pozostalyCzas +
                ", czasOczekiwania=" + czasOczekiwania +
                '}';
    }

    public boolean isDone() {
        return pozostalyCzas <= 0;
    }

    public void run(int time) {
        pozostalyCzas-=time;
    }
    public void wait(int time) {
        czasOczekiwania+=time;
    }

    //deprecated???
    public void finish(int finishTime) {
        czasOczekiwania = finishTime - momentZgloszenia - dlugosc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isZaglodzony() {
        return zaglodzony;
    }

    public void setZaglodzony(boolean zaglodzony) {
        this.zaglodzony = zaglodzony;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getMomentZgloszenia() {
        return momentZgloszenia;
    }

    public void setMomentZgloszenia(int momentZgloszenia) {
        this.momentZgloszenia = momentZgloszenia;
    }

    public int getPozostalyCzas() {
        return pozostalyCzas;
    }

    public void setPozostalyCzas(int pozostalyCzas) {
        this.pozostalyCzas = pozostalyCzas;
    }

    public int getCzasOczekiwania() {
        return czasOczekiwania;
    }

    public void setCzasOczekiwania(int czasOczekiwania) {
        this.czasOczekiwania = czasOczekiwania;
    }
}
