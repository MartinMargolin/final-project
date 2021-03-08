package models;

public class Piece
{
    int size;
    boolean isDead;
    int healthLeft;

    // placement stats
    int pieceSize;
    int rotationFromCenter;
    int x;
    int y;

    public Piece() // Default to size 2
    {
        this.size = 2;
    }

    public Piece(int size)
    {
        setSize(size);
        setHealth(size);
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }

    public void setHealth(int health)
    {
        this.healthLeft = health;
    }

    public int getHealth()
    {
        return this.healthLeft;
    }

    public void setLifeState(boolean state)
    {
        this.isDead = state;
    }

    public boolean getLifeState()
    {
        return this.isDead;
    }

    public void setStats(int pieceSize, int rotationFromCenter, int x, int y)
    {
        this.pieceSize = pieceSize;
        this.rotationFromCenter = rotationFromCenter;
        this.x = x;
        this.y = y;
    }

}
