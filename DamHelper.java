import java.awt.*;
import javax.swing.*;
import java.util.*;

public class DamHelper {
  Dama dam = new Dama();

  public int[][] generateStates () { // comentario git test
  int[][] states = new int[8][8];
  int pcount = 0;
  for (int i = 0; i < 8; i++){
    for (int j = 0; j < 8; j++){
      if ((i == 3) || (i == 4)) { // casas vazias
          states[i][j] = 0;
      }
      if (i < 3) {  // peças azuis
        if (i % 2 == 0) {
          if (j % 2 == 0) {
            pcount++;
            dam.pieces[pcount] = new Piece(1, j, i);
            states[i][j] = 1;
          }
          else {
            states[i][j] = 0;
          }
        }
          else {
            if (j % 2 == 0) {
              states[i][j] = 0;
            }
            else {
              pcount++;
              dam.pieces[pcount] = new Piece(1, j, i);
              states[i][j] = 1;
            }
          }
        }

      if (i > 4) { // peças vermelhas
        if (i % 2 == 0) {
          if (j % 2 == 0) {
            pcount++;
            dam.pieces[pcount] = new Piece(2, j, i);
            states[i][j] = 2;
          }
          else {
            states[i][j] = 0;
          }
        }
          else {
            if (j % 2 == 0) {
              states[i][j] = 0;
            }
            else {
              pcount++;
              dam.pieces[pcount] = new Piece(2, j, i);
              states[i][j] = 2;
            }
          }
        }

  //System.out.print(states[i][j]);
  //printf ("states[%d][%d] = %d      ", i, j, states[i][j]);

  }
  //System.out.print("\n");

  }

    return states;
  }

  public int[][] getBW () {
    int[][] bw = new int[8][8];
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
       if (i % 2 == 0) {
          if (j % 2 == 0) {
            bw[i][j] = 1;
          }
          else {
            bw[i][j] = 2;
          }
        }
        else {
          if (j % 2 == 0) {
            bw[i][j] = 2;
          }
          else {
            bw[i][j] = 1;
        }
    }
    System.out.print(bw[i][j]);
    //printf ("states[%d][%d] = %d      ", i, j, states[i][j]);
  }
  System.out.print("\n");

  }
  return bw;
  }

  public void move () {
    for (Piece piece : dam.pieces) {
      piece.pieceLine =+ 1;
    }
  }
}
