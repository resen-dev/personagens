package org.personagens;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Atributos {
    protected int vida;
    protected int mana;
    protected int armadura;
    protected int dano;
}
