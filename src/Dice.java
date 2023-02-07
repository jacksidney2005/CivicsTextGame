public class Dice {
    int min = 1;
    int max = 6;
    int roll = (int) Math.floor(Math.random() * (max - min + 1) + min);
}
