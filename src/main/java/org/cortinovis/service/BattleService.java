package org.cortinovis.service;

import org.cortinovis.domain.Gesture;
import org.cortinovis.domain.Hand;

public class BattleService {

  public void battle(Hand hand1, Hand hand2) {
    Gesture player = hand1.getGesture();
    Gesture player2 = hand2.getGesture();

    if(player.getWin().contains(player2.getType())) {
      System.out.println("Player1 Win");
      return;
    }

    if(player.getLose().contains(player2.getType())) {
      System.out.println("Player2 Win");
      return;
    }

    System.out.println("Draw");
  }
}