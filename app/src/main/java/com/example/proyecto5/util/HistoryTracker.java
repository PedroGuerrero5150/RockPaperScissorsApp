package com.example.proyecto5.util;

import java.util.*;


public class HistoryTracker {
    private List<String> historyList;

    //cosas singletone
    private HistoryTracker() { historyList = new ArrayList<String>();}   //constructor
    private static HistoryTracker ourInstance = new HistoryTracker();   //instancia
    public static HistoryTracker getInstance() {
        return ourInstance;
    } //getInstancia

    //metodo borrar historico
    public void clear() { historyList.clear();}

    //getters, setters
    public void setHistoryList(String playerChoice, String computerPlay, String result) {

        if(result.equals("win"))
            result = "Ganador: Jugador";
        else if (result.equals("lose"))
            result = "Ganador: Computador";
        else
            result = "Empate";

        historyList.add("Eleccion jugador: " + playerChoice + "\n" +"Jugada computador: " + computerPlay
                        +"\n" + result + "\n");
    }
    public List<String> getMethodList() {
        return historyList;
    }

}
