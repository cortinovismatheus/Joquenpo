package org.cortinovis.service.selects;

import org.cortinovis.domain.game.GameAction;

import java.util.Scanner;

public class SelectGameAction {
  private final Scanner scanner = new Scanner(System.in);

  public GameAction selectGameAction() {

    while (true) {
      System.out.println("Você deseja jogar de novo?");
      System.out.println("1 - Sim");
      System.out.println("2 - Mudar modo de jogo");
      System.out.println("3 - Não");
      System.out.println("Opção: ");
      int option =  scanner.nextInt();
      switch (option) {
        case 1:
          return GameAction.PLAY_AGAIN;
        case 2:
          return GameAction.CHANGE_GAME_MODE;
        case 3:
          return GameAction.EXIT;
        default:
          System.out.println("Opção inválida!\n");
      }
    }
  }
}