package SoftServe.Practice2;

public abstract class Shape {

    private ShapeType shapeType;

    public Shape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public abstract void drawShape();
}
