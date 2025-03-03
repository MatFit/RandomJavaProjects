import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JPanel {

    // Game constants
    private static final int GRID_SIZE = 20;
    private static final int CELL_SIZE = 20;
    private static final int DELAY = 100;

    // Game variables
    private int[] x = new int[GRID_SIZE * GRID_SIZE];
    private int[] y = new int[GRID_SIZE * GRID_SIZE];
    private int snakeLength = 1;
    private int foodX, foodY;
    private char direction = 'R';
    private boolean gameOver = false;

    // Timer for game loop
    private Timer timer;

    public SnakeGame() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE));
        setFocusable(true);
        requestFocus();

        // Initialize snake and food
        x[0] = GRID_SIZE / 2;
        y[0] = GRID_SIZE / 2;
        newFood();

        // Add key listener for direction changes
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP && direction != 'D') {
                    direction = 'U';
                } else if (keyCode == KeyEvent.VK_DOWN && direction != 'U') {
                    direction = 'D';
                } else if (keyCode == KeyEvent.VK_LEFT && direction != 'R') {
                    direction = 'L';
                } else if (keyCode == KeyEvent.VK_RIGHT && direction != 'L') {
                    direction = 'R';
                }
            }
        });

        // Start game loop
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        timer.start();
    }

    // Update game state
    private void updateGame() {
        if (gameOver) {
            return;
        }

        // Move snake
        for (int i = snakeLength - 1; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (direction == 'U') {
            y[0]--;
        } else if (direction == 'D') {
            y[0]++;
        } else if (direction == 'L') {
            x[0]--;
        } else if (direction == 'R') {
            x[0]++;
        }

        // Check for collision with wall or self
        if (x[0] < 0 || x[0] >= GRID_SIZE || y[0] < 0 || y[0] >= GRID_SIZE) {
            gameOver = true;
        }
        for (int i = 1; i < snakeLength; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver = true;
            }
        }

        // Check for food collision
        if (x[0] == foodX && y[0] == foodY) {
            snakeLength++;
            newFood();
        }
    }

    // Generate new food location
    private void newFood() {
        Random random = new Random();
        foodX = random.nextInt(GRID_SIZE);
        foodY = random.nextInt(GRID_SIZE);
    }

    // Draw game
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over!", GRID_SIZE * CELL_SIZE / 2 - 50, GRID_SIZE * CELL_SIZE / 2);
        } else {
            // Draw snake
            g.setColor(Color.GREEN);
            for (int i = 0; i < snakeLength; i++) {
                g.fillRect(x[i] * CELL_SIZE, y[i] * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }

            // Draw food
            g.setColor(Color.RED);
            g.fillRect(foodX * CELL_SIZE, foodY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnakeGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}