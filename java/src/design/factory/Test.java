package design.factory;
public class Test {
    public static void main(String[] args){
        Circle shape = ShapeFactory.getShape(Circle.class);
        shape.draw();
    }
}
