package org.cortinovis.service.createPlayers;

import org.cortinovis.domain.player.Gesture;
import org.cortinovis.domain.player.Types;

import java.util.List;

public class CreateGesturesService {

  public Gesture Pedra() {
    Gesture pedra = new Gesture(
            Types.PEDRA,
            List.of(Types.TESOURA),
            List.of(Types.PAPEL)
    );
    return pedra;
  }

  public Gesture Papel() {
    Gesture papel = new Gesture(
            Types.PAPEL,
            List.of(Types.PEDRA),
          List.of(Types.TESOURA)
    );
    return papel;
  }

  public Gesture Tesoura() {
    Gesture tesoura  = new Gesture(
            Types.TESOURA,
            List.of(Types.PAPEL),
            List.of(Types.PEDRA)
    );
    return tesoura;
  }
}
