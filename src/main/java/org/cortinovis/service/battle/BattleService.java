package org.cortinovis.service.battle;

import org.cortinovis.domain.player.Gesture;
import org.cortinovis.domain.player.Player;

public class BattleService {

  public void battle(Player player1, Player player2_) {
    Gesture player = player1.getGesture();
    Gesture player2 = player2_.getGesture();

    if(player.getWin().contains(player2.getType())) {
      System.out.println(player1.getName() + " ganhou!");
      return;
    }

    if(player.getLose().contains(player2.getType())) {
      System.out.println(player2_.getName() + " ganhou!");
      return;
    }

    System.out.println("Empate!");
  }
}