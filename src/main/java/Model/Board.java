package Model;

import java.util.ArrayList;
import java.util.List;

public class Board extends Thread {

    private int[][] size;
    private List<Ship> ships;
    private List<Player> players;

    public Board() {
        this.size = new int[10][10];
        this.ships = new ArrayList<Ship>();
        this.players = new ArrayList<Player>();
    }

    private int[] generateShipSize(){
        int sizes [] = {(int)(Math.random()*3+1), (int)(Math.random()*3+1)};
        if(sizes[0] != 1 && sizes[1] != 1){
            sizes[(int)Math.round(Math.random())] = 1;
        }
        return sizes;
    }

    private boolean verifyCoordShip(Ship shipVerify){
            if(shipVerify.getSizeX() > 1){
                for (int j = shipVerify.getCoordX(); j < shipVerify.getCoordX() + (shipVerify.getSizeX()-1); j++) {
                    for (int i = 0; i < ships.size(); i++) {
                        if (ships.get(i).getCoordX() == j && ships.get(i).getCcordY() == shipVerify.getCcordY()) {
                            return false;
                        }
                    }
                }
            }else if (shipVerify.getSizeY() > 1) {
                for (int j = shipVerify.getCcordY(); j < shipVerify.getCcordY() + (shipVerify.getSizeY()-1); j++) {
                    for (int i = 0; i < ships.size(); i++) {
                        if (ships.get(i).getCcordY() == j && ships.get(i).getCoordX() == shipVerify.getCoordX()){
                            return false;
                        }
                    }
                }
            }else{
                for (int i = 0; i < ships.size(); i++) {
                    if (ships.get(i).getCcordY() == shipVerify.getCcordY() && ships.get(i).getCoordX() == shipVerify.getCoordX()){
                        return false;
                    }
                }
            }
        return true;
    }

    private void generateShip(){
        for (int i = 0; i < 6; i++) {
            int[] sizeShip = generateShipSize();
            Ship ship = new Ship(sizeShip[0],sizeShip[1],(int)(Math.random()*8),(int)(Math.random()*8), true);
            while (!verifyCoordShip(ship)){
                ship = new Ship(sizeShip[0],sizeShip[1],(int)(Math.random()*8),(int)(Math.random()*8), true);
            }
            ships.add(ship);
        }
    }

    public List<Ship> getShips() {
        return ships;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.generateShip();
        System.out.println(board.getShips());
    }

    @Override
    public void run() {
        super.run();
    }
}
