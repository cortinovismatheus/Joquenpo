package org.cortinovis;

import org.cortinovis.domain.game.GameAction;
import org.cortinovis.domain.game.GameMode;
import org.cortinovis.domain.player.Player;
import org.cortinovis.service.battle.BattleService;
import org.cortinovis.service.createPlayers.CreateBotPlayerService;
import org.cortinovis.service.createPlayers.CreatePlayerService;
import org.cortinovis.service.selects.SelectGameAction;
import org.cortinovis.service.selects.SelectGameMode;
import org.cortinovis.service.selects.SelectGestureService;

public class Main {

  public static void main(String[] args) {

    CreateBotPlayerService createBotPlayerService = new CreateBotPlayerService();
    CreatePlayerService createPlayerService = new CreatePlayerService();
    SelectGestureService selectGestureService = new SelectGestureService();

    BattleService battleService = new BattleService();
    SelectGameMode selectGameMode = new SelectGameMode();
    SelectGameAction selectGameAction = new SelectGameAction();

    boolean playing = true;

    while (playing) {

      GameMode gameMode = selectGameMode.SelectGameMode();

      Player player1 = createPlayerService.createPlayer(1);
      Player player2;

      switch (gameMode) {
        case BOT:
          player2 = createBotPlayerService.createBotPlayerService();
          break;
        case LOCAL:
          player2 = createPlayerService.createPlayer(2);
          break;
        default:
          throw new IllegalStateException("Modo de jogo inválido.");
      }

      boolean changeMode = false;

      while (!changeMode && playing) {

        player1.setGesture(selectGestureService.selectGesture(player1.getName()));

        switch (gameMode) {
          case BOT:
            player2.setGesture(createBotPlayerService.randomGesture());
            break;
          case LOCAL:
            player2.setGesture(selectGestureService.selectGesture(player2.getName()));
            break;
        }

        battleService.battle(player1, player2);

        GameAction action = selectGameAction.selectGameAction();

        switch (action) {
          case PLAY_AGAIN:
            break;
          case CHANGE_GAME_MODE:
            changeMode = true;
            break;
          case EXIT:
            playing = false;
            break;
        }
      }
    }
    System.out.println("Obrigado por jogar!");
  }
}