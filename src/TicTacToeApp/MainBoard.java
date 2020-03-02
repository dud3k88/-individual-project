package TicTacToeApp;


class MainBoard {

    Tile [][] tiles = new Tile[3][3];

    MainBoard() {
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                Tile tile = new Tile(ShapeValue.EMPTY);
                tile.setTranslateX(i * 200);
                tile.setTranslateY(j * 200);
                tiles[i][j] = tile;
            }
        }
    }
}
