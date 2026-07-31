package org.cortinovis;

import org.cortinovis.domain.game.BattleResult;
import org.cortinovis.domain.game.GameMode;
import org.cortinovis.domain.player.Player;
import org.cortinovis.service.battle.BattleService;
import org.cortinovis.service.createPlayers.CreateBotPlayerService;
import org.cortinovis.service.createPlayers.CreatePlayerService;
import org.cortinovis.service.selects.SelectGameAction;
import org.cortinovis.service.selects.SelectGameMode;
import org.cortinovis.service.selects.SelectGestureService;

public class Main {
  private static final CreateBotPlayerService createBotPlayerService = new CreateBotPlayerService();
  private static final CreatePlayerService createPlayerService = new CreatePlayerService();
  private static final SelectGestureService selectGestureService = new SelectGestureService();
  private static final BattleService battleService = new BattleService();
  private static final SelectGameMode selectGameMode = new SelectGameMode();
  private static final SelectGameAction selectGameAction = new SelectGameAction();

  static void main(String[] args) {
    startGame();
  }

  public static void startGame(){
    boolean playing = true;

    while(playing){
      playing = playMode();
    }
    System.out.println("Obrigado por jogar!");
  }

  private static boolean playMode(){
    GameMode gameMode = selectGameMode.selectGameMode();

    Player player1 = createPlayerService.createPlayer(1);
    Player player2 = createPlayer(gameMode);

    boolean changeMode = false;

    while (!changeMode) {

      playRound(gameMode, player1, player2);

      switch (selectGameAction.selectGameAction()) {
        case PLAY_AGAIN -> {
        }
        case CHANGE_GAME_MODE -> changeMode = true;
        case EXIT -> {
          return false;
        }
      }
    }
    return true;
  }

  private static Player createPlayer(GameMode gameMode) {
    return switch (gameMode) {
      case BOT -> createBotPlayerService.createBotPlayer();
      case LOCAL -> createPlayerService.createPlayer(2);
    };
  }

  private static void playRound(GameMode gameMode, Player player1, Player player2) {

    BattleResult result;

    do {

      player1.setGesture(selectGestureService.selectGesture(player1.getName()));

      switch (gameMode) {
        case BOT -> player2.setGesture(createBotPlayerService.randomGesture());
        case LOCAL -> player2.setGesture(selectGestureService.selectGesture(player2.getName()));
      }

      result = battleService.battle(player1, player2);

      switch(result){
        case PLAYER1_WIN -> player1.addPoint();
        case PLAYER2_WIN -> player2.addPoint();
        case DRAW -> System.out.println("Empate! Joguem novamente.");
      }

    } while (result == BattleResult.DRAW);

    System.out.println(player1.getName() + " jogou " + player1.getGesture());
    System.out.println(player2.getName() + " jogou " + player2.getGesture());

    if (result == BattleResult.PLAYER1_WIN) {
      System.out.println(player1.getName() + " ganhou!");
    } else {
      System.out.println(player2.getName() + " ganhou!");
    }
    showScore(player1, player2);
  }

  private static void showScore(Player player1, Player player2) {
    System.out.println("\n===== PLACAR =====");
    System.out.println(player1.getName() + ": " + player1.getScore());
    System.out.println(player2.getName() + ": " + player2.getScore());
    System.out.println("==================\n");
  }
}