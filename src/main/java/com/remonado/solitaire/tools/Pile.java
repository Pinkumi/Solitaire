package com.remonado.solitaire.tools;

import java.util.ArrayList;

public class Pile<T>{
    private T[] pile;
    private int top;
    public Pile(int capacidad){
        pile = (T[]) new Object[capacidad]; //Creamos el arreglo de objetos T
        top = -1;
    }
    public Pile(ArrayList<T> datos){
        pile = (T[]) new Object[datos.size()]; //Creamos el arreglo de objetos T
        top = -1;
        for(T t : datos){
            this.push(t);
        }


    }
    public Pile(){
        pile = (T[]) new Object[10];
        top = -1;
    }
    public void push(T dato){//Agrega un dato a la pila
        if (pila_llena()){
            System.out.println("Desbordamiento");
        }else{
            top++;
            pile[top]=dato;
        }
    }
    public T pop() { //toma un dato de la pila
        if (pila_vacia()) {
            System.out.println("Subdesbordamiento");
            return null;
        }
        T elemento = pile[top];
        top--;
        return elemento;
    }
    public T peak(){ //para verificar el valor del objeto superior
        if(pila_vacia())return null;
        return pile[top];
    }
    public boolean pila_vacia(){
        return top ==-1;
    }
    public boolean pila_llena(){
        return top == pile.length-1;
    }
    public T[] getCartas(){
        return pile;
    }
    @Override
    public String toString(){
        StringBuilder strb = new StringBuilder();
        strb.append("[ ");
        for(int i = 0; i< top +1; i++){
            strb.append(pile[i]);
            strb.append(" > ");
        }
        strb.append(" ]");
        return strb.toString();
    }
    public int getSize(){
        return top+1;
    }


}
