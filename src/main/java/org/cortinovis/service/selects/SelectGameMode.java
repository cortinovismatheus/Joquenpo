package org.cortinovis.service.selects;

import org.cortinovis.domain.game.GameMode;

import java.util.Scanner;

public class SelectGameMode {
  private final Scanner scanner = new Scanner(System.in);

  public GameMode selectGameMode() {

      while (true) {
        System.out.println("Select a game mode:");
        System.out.println("1 - Contra a máquina");
        System.out.println("2 - Multiplayer local");
        System.out.println("Opção: ");
        int option =  scanner.nextInt();
        switch (option) {
          case 1:
            return GameMode.BOT;
          case 2:
            return GameMode.LOCAL;
          default:
            System.out.println("Opção inválida!\n");
        }
      }
  }
}
