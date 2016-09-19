import java.awt.*;
import java.util.*;

// logical Layer classe das peças

public class Piece {
  boolean isAlive = false;
  int player;
  int pieceColumn;
  int pieceLine;

  public Piece (int play, int col, int line) {
    player = play;
    pieceColumn = col;
    pieceLine = line;
    System.out.println("new piece created on line: " + (this.pieceLine) + ", Column:" + (this.pieceColumn) + " for player: " + (this.player) + ".");
  }
  public Piece () {
  }
}
