package org.example.objects;

public class TileMap {
    private Tile[][] tiles;

    public TileMap(int width, int height) {
        tiles = new Tile[width][height];
    }

    public void setTile(int x, int y, Tile tile) {
        tiles[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile generateTileMap{

    }

}
