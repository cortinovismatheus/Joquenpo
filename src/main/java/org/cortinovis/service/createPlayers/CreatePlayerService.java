package org.cortinovis.service.createPlayers;

import org.cortinovis.domain.player.Player;

import java.util.Scanner;

public class CreatePlayerService {

  private final Scanner scanner = new Scanner(System.in);

  public Player createPlayer(int playerNumber) {
    System.out.printf("Jogador %d, digite seu nome: ", playerNumber);
    String name = scanner.nextLine();

    return new Player(name);
  }
}