package javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        if (gameObject==null || direction==null) return false;

        int xC = this.getX(); int yC = this.getY();

        if (direction.equals(Direction.UP))
            yC -= Model.FIELD_CELL_SIZE;
        if (direction.equals(Direction.DOWN))
            yC += Model.FIELD_CELL_SIZE;
        if (direction.equals(Direction.LEFT))
            xC -= Model.FIELD_CELL_SIZE;
        if (direction.equals(Direction.RIGHT))
            xC += Model.FIELD_CELL_SIZE;

        return xC == gameObject.getX() && yC == gameObject.getY();
    }
}
