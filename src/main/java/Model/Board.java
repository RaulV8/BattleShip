package Model;

import java.util.ArrayList;
import java.util.List;

public class Board extends Thread {

    private int[][] size;
    private List<Ship> ships;
    private List<Player> players;

    public Board(int[][] size, List<Ship> ships, List<Player> players) {
        this.size = new int[10][10];
        this.ships = new ArrayList<Ship>();
        this.players = new ArrayList<Player>();
    }

    private void generateShipSize(int size){

    }

    @Override
    public void run() {
        super.run();
    }
}
