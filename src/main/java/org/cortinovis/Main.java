package org.cortinovis;

import org.cortinovis.domain.Hand;
import org.cortinovis.service.BattleService;
import org.cortinovis.service.CreateGesturesServices;

public class Main {

  public static void main(String[] args) {
    CreateGesturesServices createGesturesServices = new CreateGesturesServices();
    BattleService battleService = new BattleService();

    Hand player1 = new Hand(createGesturesServices.Papel());
    Hand player2 = new Hand(createGesturesServices.Pedra());

    battleService.battle(player1, player2);
  }
}
