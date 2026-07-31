package org.cortinovis.service.battle;

import org.cortinovis.domain.game.BattleResult;
import org.cortinovis.domain.player.Gesture;
import org.cortinovis.domain.player.Player;

public class BattleService {

  public BattleResult battle(Player player1, Player player2_) {
    Gesture player = player1.getGesture();
    Gesture player2 = player2_.getGesture();

    if(player.getWin().contains(player2.getType())) {
      return BattleResult.PLAYER1_WIN;
    }

    if(player.getLose().contains(player2.getType())) {
      return BattleResult.PLAYER2_WIN;
    }
    return BattleResult.DRAW;
  }
}