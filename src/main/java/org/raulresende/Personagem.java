package org.raulresende;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.raulresende.habilidades.Habilidades;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personagem extends Atributos implements Habilidades {

    private String nome;

    private HabilidadeBase habilidadeQ;
    private HabilidadeBase habilidadeW;
    private HabilidadeBase habilidadeE;
    private HabilidadeBase habilidadeR;

    public void atacar(Personagem alvo) {

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
