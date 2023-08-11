package design.factory;
public class ShapeFactory {
    public static <T> T getShape(Class<T> clazz) {
        T shape = null;
        try {
            shape = (T) clazz.newInstance();
        } catch (Exception e) {
           // ignore
        }
        return shape;
    }
}
