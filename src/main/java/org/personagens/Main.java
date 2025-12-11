package org.personagens;

import java.sql.Time;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Personagem matheus = Personagem.builder()
                .nome("Matheus Unicornio")
                .vida(15)
                .mana(8)
                .armadura(12)
                .dano(4)
                .build();

        matheus.adicionarHabilidade(new HabilidadeBase("Q", 2, 1, 3));
        matheus.adicionarHabilidade(new HabilidadeBase("W", 9, 5, 8));
        matheus.adicionarHabilidade(new HabilidadeBase("E", 4, 7, 12));
        matheus.adicionarHabilidade(new HabilidadeBase("R", 6, 12, 30));

        System.out.println(matheus);

        Personagem renton = Personagem.builder()
                .nome("RENT0N")
                .vida(20)
                .mana(4)
                .armadura(2)
                .dano(10)
                .build();

        renton.adicionarHabilidade(new HabilidadeBase("Q", 1, 2, 5));
        renton.adicionarHabilidade(new HabilidadeBase("W", 1, 3, 4));
        renton.adicionarHabilidade(new HabilidadeBase("E", 2, 6, 10));
        renton.adicionarHabilidade(new HabilidadeBase("R", 4, 15, 25));

        System.out.println(renton);

        matheus.atacarComHabilidade(0, renton);

//        Thread.sleep(6000);

        matheus.atacarComHabilidade(0, renton);
        matheus.atacarComHabilidade(1, renton);
        renton.atacarComHabilidade(1, matheus);
        matheus.atacarComHabilidade(3, renton);

        System.out.println(matheus);
        System.out.println(renton);
    }
}
