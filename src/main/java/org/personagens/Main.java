package org.personagens;


public class Main {
    public static void main(String[] args) {

        Personagem matheus = new Personagem();

        matheus.setNome("Matheus Unicornio");

        matheus.setVida(15);
        matheus.setMana(8);
        matheus.setArmadura(12);
        matheus.setDano(4);

        System.out.println(matheus);

        Personagem renton = new Personagem();

        renton.setNome("RENT0N");

        renton.setVida(20);
        renton.setMana(4);
        renton.setArmadura(2);
        renton.setDano(10);

        System.out.println(renton);

        matheus.atacar(renton);
    }
}