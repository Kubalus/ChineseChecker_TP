package Client;

public interface AdjacencyStrategy {

    public abstract Field[] adjacentFields(Field field, Field[][] board);

}
