package inf101v23.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Note: Some methods are reused from the assignment "lab5".

public class Grid<E> implements IGrid<E> {

    protected int rows;
    protected int cols;
    protected List<List<E>> cells;

    public Grid(int row, int col, E defaultValue) {
        if(row <= 0 || col <= 0) {
            throw new IllegalArgumentException();
        }

        rows = row;
        cols = col;
        this.cells = new ArrayList<>(rows);
        for(int i = 0; i < rows; i++) {
            List<E> rowList = new ArrayList<>(cols);
            for (int j = 0; j < cols; j++) {
                rowList.add(defaultValue);
            }
            cells.add(rowList);
        }
    }

    public Grid(int row, int col) {
        this(row, col, null);
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public void set(Coordinate coordinate, E value) {
        checkCoordinate(coordinate);

        cells.get(coordinate.row).set(coordinate.col, value);
    }

    @Override
    public E get(Coordinate coordinate) {
        checkCoordinate(coordinate);

        return cells.get(coordinate.row).get(coordinate.col);
    }

    /**
     * Checks whether coordinate is within bounds of the grid
     * @param coordinate the coordinate to check
     */
    private void checkCoordinate(Coordinate coordinate) {
        if(!coordinateIsOnGrid(coordinate)) {
            throw new IndexOutOfBoundsException("Both row and column indices must be within bounds");
        }
    }

    /**
     * This method computes which index in the list belongs to a given Coordinate
     */
    // private int coordinateToIndex(Coordinate coordinate) {
    //     return coordinate.row + coordinate.col * rows;
    // }

    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        if(coordinate.row < 0 || coordinate.row >= rows) {
            return false;
        }
        return coordinate.col >= 0 && coordinate.col < cols;
    }

    @Override
    public Iterator<CoordinateItem<E>> iterator() {
        List<CoordinateItem<E>> coordinateItems = new ArrayList<>();

        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                CoordinateItem<E> coordinateItem = new CoordinateItem<>(coordinate, get(coordinate));
                coordinateItems.add(coordinateItem);
            }
        }
        return coordinateItems.iterator();
    }
}











