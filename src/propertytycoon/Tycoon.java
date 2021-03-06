/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertytycoon;

import java.util.*;


/**
 *
 * @author Group 22
 */
public class Tycoon 
{
    private int numberOfPlayers;
    private Board board;
    private ArrayList<Player> playersInGame;
    private ArrayList<Property> propertiesInGame;
    private ArrayList<Station> stationsInGame;
    private ArrayList<Utilities> utilitiesInGame;
    private int playerTakingTurn;
    private Card OKPL;
    
    //constructor
    public Tycoon(int players)
    {
                
        if (players > 6 || players < 2)
        {
            System.out.println("Please input in a valid amount of players (2-6).");
        }
        else
        {
            //initialise arraylists
            playersInGame = new ArrayList<Player>();  
            propertiesInGame = new ArrayList<Property>(); 
            stationsInGame = new ArrayList<Station>(); 
            utilitiesInGame = new ArrayList<Utilities>();            
            OKPL = new Card();
            //initialise board for referencing locations
            board = new Board();
            
            //initialise properties
            initialiseProperties();
            
            //no. of players in-game
            numberOfPlayers = players;
            
            //set first player
            int i = 0;
            Player player = new Player(i, i);
            player.setPlayersTurn(true);
            playerTakingTurn = 0;
            playersInGame.add(player);
            i++;
            
            //initialising and storing the other players, each has their own id and token
            for (int j = 1; j < numberOfPlayers; j++)
            {
                Player playa = new Player(j, j);
                playersInGame.add(playa);
            }
            
            //first player takes turn
            //GUI now references to playerTakeTurn()
            
            System.out.println(numberOfPlayers + " players in Property Tycoon!");
            System.out.println();
        }
    }
    
    /**
     * Returns the next player to take turn
     * @return playersInGame return next player
     */    
    public Player nextPlayer()
    {
        playerTakingTurn++;
        return playersInGame.get(playerTakingTurn);
    }
    
    /**
     * Global logic that takes turn for a player and prepares the next player
     * @param p player to take turn, should be nextPlayer()
     */    
    public void playerTakeTurn(Player p)
    {
            p.takeTurn(); // Rolls dice and advances (from player class)           
            p.setPlayersTurn(false);
            nextPlayer().setPlayersTurn(true);
    }

    /**
     * Retrieve the amount of players
     * @return numberOfPlayers return number of players
     */
    public int getNumberOfPlayers() 
    {
        return numberOfPlayers;
    }
    
    /**
     * Retrieve each player
     * @return playersInGame return all players
     */
    public ArrayList<Player> getPlayersInGame()
    {
        return playersInGame;
    }
    
    /**
     * Identify a player from their ID
     * @param i player's ID
     * @return playersInGame.get(i) return a player with an ID of i
     */
    public Player getPlayerInGameByID(int i)
    {
        return playersInGame.get(i);
    }

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) 
    //{
//        //for now, here I just have the test for the rolling mechanism
//        Player player = new Player(0, 0);
//        for (int i = 0; i <= 99; i++)
//        {
//            player.setPlayersTurn(true);
//            player.takeTurn();
//        }
    //}

    /**
     * Initialises the properties for the game, creating objects for each property
     */     
    public void initialiseProperties()
    {
        Property crapperStreet = new Property("Crapper Street", 60, "Brown", true, 2, 10, 30, 90, 160, 250, 30);
        Property gangstersParadise = new Property("Gangster's Paradise", 60, "Brown", true, 4, 20, 60, 180, 320, 450, 30);
        Property weepingAngel = new Property("Weeping Angel", 100, "Blue", true, 6, 30, 90, 270, 400, 550, 50);
        Property pottsAvenue = new Property("Potts Avenue", 100, "Blue", true, 6, 30, 90, 270, 400, 550, 50);
        Property nardoleDrive = new Property("Nardole Drive", 120, "Blue", true, 8, 40, 100, 300, 450, 600, 60);
        Property skywalkerDrive = new Property("Skywalker Drive", 140, "Purple", true, 10, 50, 150, 450, 625, 750, 70);
        Property wookieHole = new Property("Wookie Hole", 140, "Purple", true, 10, 50, 150, 450, 625, 750, 70);
        Property reyLane = new Property("Rey Lane", 160, "Purple", true, 12, 60, 180, 500, 700, 900, 80);
        Property cooperDrive = new Property("Cooper Drive", 180, "Orange", true, 14, 70, 200, 550, 750, 950, 90);
        Property wolowitzStreet = new Property("Wolowitz Street", 180, "Orange", true, 14, 70, 200, 550, 750, 950, 90);
        Property pennyLane = new Property("Penny Lane", 200, "Orange", true, 16, 80, 220, 600, 800, 1000, 100);
        Property yueFeiSquare = new Property("Yue Fei Square", 220, "Red", true, 18, 90, 250, 700, 875, 1050, 110);
        Property mulanRouge = new Property("Mulan Rouge", 220, "Red", true, 18, 90, 250, 700, 875, 1050, 110);
        Property hanXinGardens = new Property("Han Xin Gardens", 240, "red", true, 20, 100, 300, 750, 925, 1100, 120);
        Property kirkClose = new Property("Kirk Close", 260, "Yellow", true, 22, 110, 330, 800, 975, 1150, 130);
        Property picardAvenue = new Property("Picard Avenue", 260, "Yellow", true, 22, 110, 330, 800, 975, 1150, 130);
        Property crusherCreek = new Property("Crusher Creek", 280, "Yellow", true, 22, 120, 360, 850, 1025, 1200, 140);
        Property siratMews = new Property("Sirat Mews", 300, "Green", true, 26, 130, 390, 900, 1100, 1275, 150);
        Property ghengisCrescent = new Property("Ghengis Crescent", 300, "Green", true, 26, 130, 390, 900, 1100, 1275, 150);
        Property ibisClose = new Property("Ibis Close", 320, "Green", true, 28, 150, 450, 1000, 1200, 1400, 160);
        Property hawkingWay = new Property("Hawking Way", 350, "Deep Blue", true, 35, 175, 500, 1100, 1300, 1500, 175);
        Property turingHeights = new Property("Turing Heights", 400, "Deep Blue", true, 50, 200, 600, 1400, 1700, 2000, 200);
        
        propertiesInGame.add(crapperStreet);
        propertiesInGame.add(gangstersParadise);
        propertiesInGame.add(weepingAngel);
        propertiesInGame.add(pottsAvenue);
        propertiesInGame.add(nardoleDrive);
        propertiesInGame.add(skywalkerDrive);
        propertiesInGame.add(wookieHole);
        propertiesInGame.add(reyLane);
        propertiesInGame.add(cooperDrive);
        propertiesInGame.add(wolowitzStreet);
        propertiesInGame.add(pennyLane);
        propertiesInGame.add(yueFeiSquare);
        propertiesInGame.add(mulanRouge);
        propertiesInGame.add(hanXinGardens);
        propertiesInGame.add(kirkClose);
        propertiesInGame.add(picardAvenue);
        propertiesInGame.add(crusherCreek);
        propertiesInGame.add(siratMews);
        propertiesInGame.add(ghengisCrescent);
        propertiesInGame.add(ibisClose);
        propertiesInGame.add(hawkingWay);
        propertiesInGame.add(turingHeights);
        
        
        Station brighton = new Station("Brighton Station", true);
        Station hove = new Station("Hove Station", true);
        Station falmer = new Station("Falmer Station", true);
        Station lewes = new Station("Lewes Station", true);
        
        stationsInGame.add(brighton);
        stationsInGame.add(hove);
        stationsInGame.add(falmer);
        stationsInGame.add(lewes);
        
        
        Utilities tesla = new Utilities("Tesla Power Co", true);
        Utilities edison = new Utilities("Edison Water", true);
        
        utilitiesInGame.add(tesla);
        utilitiesInGame.add(edison);   
    }

    /**
     * Retrieve a list of all properties
     * @return propertiesInGame return all properties
     */
    public ArrayList<Property> getPropertiesInGame() 
    {
        return propertiesInGame;
    }
    
    /**
     * Retrieve a particular property
     * @param i ID of a particular property
     * @return propertiesInGame.get(i) return a property with an ID of i
     */
    public Property getPropertyInGame(int i)
    {
        return propertiesInGame.get(i);
    }

    /**
     * Retrieve all stations
     * @return stationsInGame return all stations
     */
    public ArrayList<Station> getStationsInGame() 
    {
        return stationsInGame;
    }

    /**
     * Retrieve all utilities
     * @return utilitiesInGame return all utilities
     */
    public ArrayList<Utilities> getUtilitiesInGame() 
    {
        return utilitiesInGame;
    }

    /**
     * Retrieve Opportunity Knocks and Pot Luck cards
     * @return OKPL return all drawable cards
     */
    public Card getOKPL()
    {
        return OKPL;
    }
}
