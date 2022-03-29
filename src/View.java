import java.awt.*;

import javax.swing.*;

public class View extends JPanel {

  public static void main(String args[]) {
    View v = new View(800, 800);
  }

  JFrame frame;
  double xScale = 2;
  double yScale = 2;
  int totalTrials = 50;

  public View(int width, int height) {
    setPreferredSize(new Dimension(width, height));
    frame = new JFrame("Mandelbrot");
    frame.add(this);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.pack();
    frame.setResizable(false);
    frame.setFocusable(true);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    setVisible(true);
    //setBackground(Color.BLACK);
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < getWidth(); i++) {
      for (int j = 0; j < getHeight(); j++) {
        paintSquare(g, i, j);
      }
    }
  }

  private void paintSquare(Graphics g, int x, int y) {
    double xCoord = (double) x / getWidth() * 2 * xScale - xScale;
    double yCoord = (double) y / getHeight() * 2 * yScale - yScale;
    ImaginaryNumber coord = new ImaginaryNumber(xCoord, yCoord);
    int numTrials = getNumTrials(coord);
    g.setColor(getColor(numTrials));
    g.fillRect(x, y, 1, 1);
  }

  private Color getColor(int num) {
    double percent = (double) num / totalTrials;
    return new Color((int) (255 * (1 - percent)), (int) (255 * (1 - percent)),
            (int) (255 * (1 - percent)));
  }

  private int getNumTrials(ImaginaryNumber num) {
    int trials = 0;
    ImaginaryNumber coord = new ImaginaryNumber(num.realPart, num.complexPart);
    while (num.norm() < 20 && trials < totalTrials) {
      trials++;
      num = num.square().add(coord);
    }
    return trials;
  }
}
