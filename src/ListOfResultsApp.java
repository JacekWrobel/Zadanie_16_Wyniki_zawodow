import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ListOfResultsApp {
    public static void main(String[] args) throws IOException {

        List<Player> list = listMaker();
        makeCsv(list);
    }


    public static List<Player> listMaker() {
        Scanner sc = new Scanner(System.in);
        List<Player> playerList = new ArrayList<>();

        boolean running = true;
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop)");
            String result = sc.nextLine();

            if (result.equals("stop")) running = false;
            else {
                String[] split = result.split(" ");
                Player player = new Player(split[0], split[1], Integer.valueOf(split[2]));
                playerList.add(player);
            }
        } while (running);
        return playerList;
    }

/*
        boolean running = true;
        while (running == true){
            System.out.println("Podaj wynik kolejnego gracza (lub stop)");
            String result = sc.nextLine();
            if (result.equals("stop")) running =false;
            String[] split = result.split(" ");
            Player player = new Player(split[0], split[1], Integer.valueOf(split[2]));
            playerList.add(player);
        }
        return playerList;
    }
*/
/*
        String result = "stop";
        do {
            System.out.println("Podaj wynik kolejnego gracza (lub stop)");
            result = sc.nextLine();

            if (result.equals("stop")) break;
            String[] split = result.split(" ");
            Player player = new Player(split[0], split[1], Integer.valueOf(split[2]));
            playerList.add(player);
        } while (result.equals("stop"));
        return playerList;
    }
*/

    public static void makeCsv(List<Player> playerList) throws IOException {
        Collections.sort(playerList);
        String fileName = "stats.csv";
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bfw = new BufferedWriter(fw);
        for (Player player : playerList) {
            bfw.write(player.toCsv());
        }
        bfw.close();
        System.out.println("Dane posortowano i zapisano do pliku stats.csv.\n");
    }
}
