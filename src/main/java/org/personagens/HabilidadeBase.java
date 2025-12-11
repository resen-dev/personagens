package org.personagens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabilidadeBase {

    private String nome;
    private int dano;
    private int custo;
    private int cd;

    public void atacar(Personagem alvo) {

        int dano = this.getDano() - alvo.getArmadura();

        if(dano > 0) {

            alvo.setVida(alvo.getVida() - dano);

            System.out.format("Personagem: %s recebeu %s de dano e ficou com %s de vida.", alvo.getNome(), dano, alvo.getVida());
            return;
        }

        System.out.format("Personagem: %s defendeu", alvo.getNome());

    }
}
