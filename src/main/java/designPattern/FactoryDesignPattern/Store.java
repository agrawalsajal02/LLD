package designPattern.FactoryDesignPattern;

public class Store {
    public static void main(String[] args) {
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape shape=shapeFactory.getShape("CIRCLE");
        shape.draw();
    }
}
