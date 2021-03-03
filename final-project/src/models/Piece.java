package models;

public class Piece
{
    int size;

    public void Piece() // Default to size 2
    {
        this.size = 2;
    }

    public void Piece(int size)
    {
        setSize(size);
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }
}
