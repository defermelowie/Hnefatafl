package hnefatafl;

public class startBoardLayout {

    private int blackStartLayout[][] = {
            {1,4} , {1,5} , {1,6} , {2,5} ,
            {4,1} , {5,1} , {6,1} , {5,2} ,
            {9,4} , {9,5} , {9,6} , {8,5} ,
            {4,9} , {5,9} , {6,9} , {5,8} ,
    };

    private int whiteStartLayout[][] = {
            {6,4} , {6,5} , {6,6} ,
            {5,4} , {5,6} ,
            {4,4} , {4,5} , {4,6} ,
            {5,5}
    };

    public int[][] getBlackStartLayout() {
        return blackStartLayout;
    }

    public int[][] getWhiteStartLayout() {
        return whiteStartLayout;
    }
}
