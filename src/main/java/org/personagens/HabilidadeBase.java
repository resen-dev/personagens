package org.personagens;

import lombok.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
public class HabilidadeBase {

    private String nome;
    private int dano;
    private int custo;
    private int coolDownTime;
    private boolean isInCoolDown;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public HabilidadeBase(String nome, int dano, int custo, int coolDownTime) {
        this.nome = nome;
        this.dano = dano;
        this.custo = custo;
        this.coolDownTime = coolDownTime;
        this.isInCoolDown = false;
    }

    public void executar(Personagem alvo) {

        iniciarCooldown();

        if(alvo.getArmadura() >= this.dano) {
            System.out.printf("%s defendeu habilidade %s.\n\n", alvo.getNome(), this.getNome());
            return;
        }

        alvo.receberDano(this.getDano(alvo));
    }

    private void iniciarCooldown() {

        this.isInCoolDown = true;
        System.out.printf("Habilidade %s entrou em cooldown (%ds). ", this.nome, this.coolDownTime);

        scheduler.schedule(() -> {
            this.isInCoolDown = false;
            System.out.printf("Habilidade %s saiu do cooldown.\n\n", this.nome);
        }, this.coolDownTime, TimeUnit.SECONDS);
    }


    private int getDano(Personagem alvo) {
        return this.dano -  alvo.getArmadura();
    }
}
