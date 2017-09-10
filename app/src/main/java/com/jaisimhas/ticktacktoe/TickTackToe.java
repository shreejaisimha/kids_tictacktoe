package com.jaisimhas.ticktacktoe;

public class TickTackToe {
    public static final int SIDE =3; //final means its a constant, static means there is only variable irregardless of number of instances of this class.
    private int turn;
    private int [][] game;

    public TickTackToe()
    {  //constructor
        game = new int[SIDE][SIDE];
        resetGame();
    }

    public int play(int row, int col) {
        int currentTurn = turn;
        if (row >= 0 && col >= 0 && row < SIDE && col < SIDE && game[row][col] == 0) {
            game[row][col] = turn;

            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }
            return currentTurn;

        } else {
            return 0;
        }

    }

    public int whoactuallywon()
    {
        //check the rows to check if anyone won
        int rows = checktherows();
        if(rows>0)
        {
            return rows;
        }
        //check the columns to check if anyone won
        int columns = checkthecolumns();
        if(columns>0)
        {
            return columns;
        }

        //check the diagonals to check if anyone won
        int diagonals = checkthediagonals();
        if(diagonals > 0)
        {
            return diagonals;
        }
        return 0;
    }

    //function which will check the rows
    protected int checktherows()
    {
        for (int row = 0; row < SIDE; row++)
            if(game[row][0] !=0 && game[row][0] == game[row][1] && game[row][1] == game[row][2])
                return game[row][0]; //return positive value
        return 0;//else not match, return zero
    }

    //function which will check the rows
    protected int checkthecolumns()
    {
        for (int col = 0; col < SIDE; col++)
            if(game[0][col] !=0 && game[0][col] == game[1][col] && game[1][col] == game[2][col])
                return game[0][col];//return positive value
        return 0;//else not match, return zero
    }

    //function which will check the diagonals
    protected int checkthediagonals()
    {
        if(game[0][0] !=0 && game[0][0] == game[1][1] && game[1][1] == game[2][2])
            return game[0][0];
    }

    public boolean cannotPlay()
    {
        boolean result = true;
        for(int row =0; row < SIDE; row++)
            for(int col =0;col < SIDE; col++)
            {
                if(game[row][col]==0) //check if there is an empty entry
                    result = false;
            }
        return result;
    }

    public boolean isGameOver()
    {
        return (cannotPlay() || whoactuallywon() > 0);
    }

    public void resetGame()
    {
        for (int row =0;row < SIDE; row ++)
            for (int col =0;col < SIDE;col++)
            {
                game[row][col] = 0;
            }
        turn =1;
    }
}


