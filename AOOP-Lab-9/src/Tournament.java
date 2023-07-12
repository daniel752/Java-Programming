import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Random;

public class Tournament {
    final int NUMBER_OF_PLAYERS = 8;
    private String name, file_name;
    QueueAsList playersQueue;
    ObjectOutputStream playerOut;
    ObjectInputStream playerIn;
    Player[] players = new Player[NUMBER_OF_PLAYERS];

    public Tournament(String name, String file_name)
    {
        this.name = new String(name);
        this.file_name = new String(file_name);
        playersQueue = new QueueAsList();
        playerOut = null;
        playerIn = null;

        try
        {
            FileInputStream theFile = new FileInputStream(file_name);
            playerIn = new ObjectInputStream(theFile);

            System.out.println("Load from file");
            for (int i = 0; i < players.length; i++)
            {
                players[i] = (Player) playerIn.readObject();
                playersQueue.enqueue(players[i].getName());
            }
            playerIn.close();
        }
        catch (IOException e)
        {
            if (playerIn == null)
            {
                playersQueue.enqueue(new Player("Novak Djokovic", 10000));
                playersQueue.enqueue(new Player("Andy Murray", 9000));
                playersQueue.enqueue(new Player("Roger Federer", 8000));
                playersQueue.enqueue(new Player("Stanislas Wawrinka", 7000));
                playersQueue.enqueue(new Player("Rafael Nadal", 6000));
                playersQueue.enqueue(new Player("Kei Nishikori", 5000));
                playersQueue.enqueue(new Player("Tomas Berdych", 4000));
                playersQueue.enqueue(new Player("David Ferrer", 3000));
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private Player simulateGame(Player first, Player second) {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            first.updateGameWin();
            first.updateTotalScore();
            System.out.println(first.getName() + " wins");
            return first;
        } else {
            second.updateGameWin();
            second.updateTotalScore();
            System.out.println(second.getName() + " wins");
            return second;
        }
    }

    public void simulateTournament()
    {
        System.out.println("*******************************************************");
        System.out.println("Tennis tournament \"" + name + "\" is starting now");
        System.out.println("*******************************************************");
        while (playersQueue.size() > 1)
        {
            Player winner = simulateGame((Player) playersQueue.dequeue(), (Player) playersQueue.dequeue());
            playersQueue.enqueue(winner);
        }
        System.out.println(Arrays.toString(players));
    }

    public void printPlayers() {
        System.out.println("Players ranking:");
    }
}