package org.cortinovis.service.createPlayers;

import org.cortinovis.domain.player.Gesture;
import org.cortinovis.domain.player.Player;

import java.util.List;
import java.util.Random;

public class CreateBotPlayerService {

  private final Random random = new Random();
  private final CreateGesturesService createGesturesService = new CreateGesturesService();

  public Player createBotPlayer() {
    return new Player("Máquina");
  }

  public Gesture randomGesture() {
    List<Gesture> gestures = List.of(
            createGesturesService.Pedra(),
            createGesturesService.Papel(),
            createGesturesService.Tesoura()
    );

    return gestures.get(random.nextInt(gestures.size()));
  }
}