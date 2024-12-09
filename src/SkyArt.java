import javax.swing.*;
import java.awt.*;

public class SkyArt extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        GradientPaint skyGradient = new GradientPaint(
                0, 0, new Color(135, 206, 235),   // light sky blue at top
                0, height, new Color(176, 224, 230) // lighter toward bottom
        );
        g2d.setPaint(skyGradient);
        g2d.fillRect(0, 0, width, height);

        int sunDiameter = 100;
        int sunX = width - sunDiameter - 100;
        int sunY = 100;
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(sunX, sunY, sunDiameter, sunDiameter);

        g2d.setColor(new Color(255, 255, 255, 200));
        g2d.fillOval(100, 150, 100, 60);
        g2d.fillOval(150, 140, 120, 80);
        g2d.fillOval(210, 150, 100, 60);

        g2d.fillOval(300, 200, 80, 50);
        g2d.fillOval(340, 190, 100, 60);
        g2d.fillOval(390, 200, 80, 50);

        Polygon hills = new Polygon();
        hills.addPoint(0, height);
        hills.addPoint(width/3, height - 100);
        hills.addPoint(width/2, height - 50);
        hills.addPoint((2*width)/3, height - 120);
        hills.addPoint(width, height);
        g2d.setColor(new Color(34, 139, 34));
        g2d.fillPolygon(hills);


        int houseWidth = 100;
        int houseHeight = 80;
        int houseX = width/2 - houseWidth/2;
        int houseY = height - houseHeight - 50;
        g2d.setColor(new Color(139,69,19)); // Brown for house
        g2d.fillRect(houseX, houseY, houseWidth, houseHeight);

        Polygon roof = new Polygon();
        roof.addPoint(houseX - 10, houseY);
        roof.addPoint(houseX + houseWidth + 10, houseY);
        roof.addPoint(houseX + houseWidth/2, houseY - 40);
        g2d.setColor(new Color(139,0,0)); // Dark Red for roof
        g2d.fillPolygon(roof);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawArc(width/4, height/4, 40, 20, 0, 180);
        g2d.drawArc(width/4 + 30, height/4, 40, 20, 0, 180);

        g2d.drawArc(width/3, height/3, 40, 20, 0, 180);
        g2d.drawArc(width/3 + 30, height/3, 40, 20, 0, 180);

        g2d.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sky Scene");
            SkyArt canvas = new SkyArt();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // attempt fullscreen-like size
            frame.add(canvas);
            frame.setVisible(true);
        });
    }
}
