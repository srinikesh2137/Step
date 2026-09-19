import java.util.*;

public class RockPaperScissors {
    static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String randomMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(moves.length)];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] table = new String[n][4];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String player = sc.nextLine().trim();
            String computer = randomMove(random);
            String result = playRound(player, computer);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            table[i][0] = String.valueOf(i + 1);
            table[i][1] = player;
            table[i][2] = computer;
            table[i][3] = result;
        }

        System.out.println("\nRound\tPlayer Move\tComputer Move\tResult");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1] + "\t\t" + row[2] + "\t\t" + row[3]);
        }

        double winPercentage = n == 0 ? 0.0 : (wins * 100.0) / n;
        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

        sc.close();
    }
}
