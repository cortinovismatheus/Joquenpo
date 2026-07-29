package org.cortinovis.service.selects;

import org.cortinovis.domain.player.Gesture;
import org.cortinovis.service.createPlayers.CreateGesturesService;

import java.util.Scanner;

public class SelectGestureService {

  private final Scanner scanner = new Scanner(System.in);
  private final CreateGesturesService createGesturesService = new CreateGesturesService();

  public Gesture selectGesture(String playerName) {

    while (true) {
      System.out.println("\n" + playerName + ", escolha um gesto:");
      System.out.println("1 - Pedra");
      System.out.println("2 - Papel");
      System.out.println("3 - Tesoura");
      System.out.print("Opção: ");

      if (!scanner.hasNextInt()) {
        System.out.println("Digite apenas números.");
        scanner.next();
        continue;
      }

      int option = scanner.nextInt();

      switch (option) {
        case 1:
          return createGesturesService.Pedra();
        case 2:
          return createGesturesService.Papel();
        case 3:
          return createGesturesService.Tesoura();
        default:
          System.out.println("Opção inválida!");
      }
    }
  }
}