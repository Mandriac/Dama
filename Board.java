import java.awt.*;
import javax.swing.*;
import java.util.*;
// Presentation Layer tabuleiro. recebe um array com os estados de cada ponto do grid
public class Board {

  static DamHelper help = new DamHelper();
  static int[][] bw = new int[8][8];
  static int[][] states = new int[8][8];

  static JFrame frame;
  static DrawPanel drawPanel;
  public static void main(String[] args) {

  Board board = new Board();

    board.vai();
  }

  public void vai() {
    bw = help.getBW();
    states = help.generateStates();
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    drawPanel = new DrawPanel();
    //while (Dam.isOn == true);
    //drawPanel.repaint();
    frame.getContentPane().add(drawPanel);
    frame.setSize(400,420);
    frame.setVisible(true);
    while (help.dam.isOn == true) {

      try {
        drawPanel.repaint();
				Thread.sleep(42);
			} catch(Exception ex) {}
    }
  }

class DrawPanel extends JPanel {
  public void paintComponent(Graphics g)  {
    int line = 0;
    int column = 0;
    for(int[] bwi : bw) {
      for (int bwj : bwi) {
        if (bwj == 1) {
          g.setColor(Color.black);
        }
        if (bwj == 2) {
          g.setColor(Color.white);
        }
        g.fillRect(400 * column / 8, 400 * line / 8, 50, 50);
        line++;
        if (line == 8) {
          line = 0;
        }

      }
      column++;
      }
      int lines = 0;
      int columns = 0;

      for (Piece piece : help.dam.pieces) {

      for(int[] statesi : states) {
        for (int statesj : statesi) {
            if (piece.pieceLine == lines && piece.pieceColumn == columns) {
              if (piece.player == 1) {g.setColor(Color.red);}
              if (piece.player == 2) {g.setColor(Color.blue);}
              g.fillOval((400/8 * lines) + 3, (400/8 * columns) + 3, 42, 42);
            }
            lines++;
            if (lines == 8) {
            lines = 0;
            }
          }
          columns++;
        }
      }
    }
  }
}
