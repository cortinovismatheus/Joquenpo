package org.cortinovis.domain.player;

import java.util.List;

public class Gesture {
  Types type;
  List<Types> Win;
  List<Types> Lose;

  public Gesture(Types type, List<Types> Win, List<Types> Lose) {
    this.type = type;
    this.Win = Win;
    this.Lose = Lose;
  }

  public Types getType() {
    return type;
  }

  public List<Types> getWin() {
    return Win;
  }

  public List<Types> getLose() {
    return Lose;
  }

  @Override
  public String toString() {
    return switch (type) {
      case PEDRA -> "Pedra";
      case PAPEL -> "Papel";
      case TESOURA -> "Tesoura";
    };
  }
}
