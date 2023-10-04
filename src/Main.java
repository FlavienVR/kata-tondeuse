import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        List<Tondeuse> tondeuses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int maxX = 0;
            int maxY = 0;

            if ((line = br.readLine()) != null) {
                String[] gridSize = line.split(" ");
                maxX = Integer.parseInt(gridSize[0]);
                maxY = Integer.parseInt(gridSize[1]);
            }

            while ((line = br.readLine()) != null) {
                String[] initialPosition = line.split(" ");
                int initialX = Integer.parseInt(initialPosition[0]);
                int initialY = Integer.parseInt(initialPosition[1]);
                char initialOrientation = initialPosition[2].charAt(0);

                Tondeuse tondeuse = new Tondeuse(initialX, initialY, initialOrientation);

                if ((line = br.readLine()) != null) tondeuse.executeInstructions(line, maxX, maxY);

                tondeuses.add(tondeuse);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        for (Tondeuse tondeuse : tondeuses) {
            System.out.println(tondeuse.getPosition());
        }
    }
}