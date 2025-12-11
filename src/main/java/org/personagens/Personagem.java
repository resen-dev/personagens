package org.personagens;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
public class Personagem extends Atributos{

    private String nome;

    private List<HabilidadeBase> habilidades;

    public void atacarComHabilidade(int habilidadeIndex, Personagem alvo) {

        HabilidadeBase habilidade = habilidades.get(habilidadeIndex);

        if(habilidade.isInCoolDown()){
            System.out.format("habilidade %s está em tempo de recarga.\n\n", habilidade.getNome());
            return;
        }

        if(habilidade.getCusto() > this.getMana()) {
            System.out.format("%s não possuí mana para utilizar habilidade %s.\n\n", this.getNome(), habilidade.getNome());
            return;
        }

        this.setMana(this.getMana() - habilidade.getCusto());

        System.out.format("%s gastou %s de mana e ficou com %s. ", this.getNome(), habilidade.getCusto(), this.getMana());

        habilidade.executar(alvo);
    }

    public void adicionarHabilidade(HabilidadeBase habilidade) {

        if(this.habilidades == null) { this.habilidades = new ArrayList<>(); }

        this.habilidades.add(habilidade);
    }

    void receberDano(int dano) {
        if(dano >= this.getVida()) {
            this.eliminar();
        }else{
            this.vida = vida - dano;
            System.out.format("%s recebeu %s de dano e ficou com %s de vida. \n\n", this.getNome(), dano, this.getVida());
        }
    }

    private void eliminar() {
        this.vida = 0;
        System.out.format("%s recebeu %s de dano e foi eliminado. \n\n", this.getNome(), dano);
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                vida: %s
                Mana: %s
                Dano: %s
                Armadura: %s
                """.formatted(getNome(), getVida(), getMana(), getDano(), getArmadura());
    }
}
