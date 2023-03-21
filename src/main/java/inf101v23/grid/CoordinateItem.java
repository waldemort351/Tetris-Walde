package inf101v23.grid;

import java.util.Objects;

public class CoordinateItem <E> {
    public final Coordinate coordinate;
    public final E item;

    public CoordinateItem(Coordinate coordinate, E item) {
        this.coordinate = coordinate;
        this.item = item;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateItem<?> that = (CoordinateItem<?>) o;
        return Objects.equals(coordinate, that.coordinate) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, item);
    }


    @Override
    public String toString() {
        return "{ coordinate='{ row='" + coordinate.row + "', col='" + coordinate.col + "' }', item='" + item.toString() + "' }";
    }


}
