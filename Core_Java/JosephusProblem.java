import java.util.*;
public class JosephusProblem {
    public static int findSurvivor(int n, int k) {

        List<Integer> players = new ArrayList<>();

        // Add players 1 to n
        for (int i = 1; i <= n; i++) {
            players.add(i);
        }

        int index = 0;

        while (players.size() > 1) {

            index = (index + k - 1) % players.size();
            players.remove(index);
        }

        return players.get(0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        System.out.print("Enter gap (k): ");
        int k = sc.nextInt();

        int survivor = findSurvivor(n, k);

        System.out.println("Last remaining player: " + survivor);
    }
}
