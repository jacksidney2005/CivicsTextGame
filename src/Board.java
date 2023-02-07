import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {
    final static int netZero = 100;

    private static class Destination {
        public int index;
        public String message;

        public Destination(int index, String message) {
            this.index = index;
            this.message = message;
        }
    }

    static Map < Integer, Destination > snake = new HashMap < Integer, Destination>() {{
        put(96, new Destination(42, "Catastrophic failure at a nuclear power plant, " +
                " widespread damage and contamination."));
        put(94, new Destination(71, "Increased seismic activity as a " +
                "result of geothermal energy production, leading to damage to infrastructure and communities."));
        put(75, new Destination(32, "Well collapses, causing toxic releases " +
                "and the release of greenhouse gases."));
        put(47, new Destination(16, "Public opposition to the construction of solar farms " +
                "due to concerns over aesthetics and land usage."));
        put(37, new Destination(3, "Decline of government funding for renewable energy projects " +
                "which causes a setback for development"));
        put(28, new Destination(10, ""));
    }};

    static Map < Integer, Destination > ladder = new HashMap < Integer, Destination >() {{
        put(4, new Destination(56, "Science teams found a way to double the life and " +
                "effectiveness of solar panels while also making them more cost effective."));
        put(12, new Destination(32, "Clean campaigns across the country have successfully " +
                "lobbied to increase government funding in the search for more renewables and building more wind farms."));
        put(14, new Destination(55, "Employee strikes at big oil companies result in more support " +
                "for the renewable energy industry furthering research and building progress of hydroelectricity."));
        put(22, new Destination(58, "After a government meeting, agreements have been made to fund new " +
                "geothermal energy plants and further the goal of net zero carbon emissions."));
        put(41, new Destination(79, "Small nonprofits have popped up around the country to bring small " +
                "solar farms to hundreds of low-income neighborhoods."));
        put(54, new Destination(88, "A huge step forward for new wind farms has been made, lengthening " +
                "the blades on the generators to be able to catch more wind and produce more power."));
    }};

    public boolean winCondition(int index) {
        return netZero == index;
    }

    public void StartGame() {
        int index = 0;
        Scanner in = new Scanner(System.in);
        String input;
        int diceValue = 0;

        do {
            System.out.println("Press r to roll Dice");
            input = in.next();
            Dice roll = new Dice();
            diceValue = roll.roll;

            index = calculateIndex(index, diceValue);
            System.out.println("You rolled a " + diceValue);
            System.out.println("Currently completed " + index + "%");
            if(winCondition(index)) {
                System.out.println("You Won!");
                return;
            }

        } while("r".equals(input));
    }

    public int calculateIndex(int index, int diceValue) {
        Destination destination = null;
        index += diceValue;

        if(index > netZero) {
            index = 100;
            return index;
        }

        if(null != snake.get(index)) {
            destination = snake.get(index);
            index = destination.index;
            System.out.println(destination.message);
        }

        if(null != ladder.get(index)) {
            destination = ladder.get(index);
            index = destination.index;
            System.out.println(destination.message);
        }

        return index;
    }
}