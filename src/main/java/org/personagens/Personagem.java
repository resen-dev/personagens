package org.personagens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.personagens.habilidades.Habilidades;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personagem extends Atributos implements Habilidades {

    private String nome;

    private List<HabilidadeBase> habilidades;

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
