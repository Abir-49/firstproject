public class factory {
    public interface Product{
        void draw();
    }
    public class Circle implements Product{
        @Override
        public void draw() {
            System.out.println("Circle::draw()");
        }
    }
    public class Square implements Product{
        @Override
        public void draw() {
            System.out.println("Square::draw()");  
        }
    }
    public class Rectangle implements Product{
        @Override
        public void draw() {
            System.out.println("Rectangle::draw()");
        }
    }
    public class ShapeFactory{
        public Product getShape(String shapeType){
            if(shapeType == null){
                return null;
            }
            if(shapeType.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            } else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            }
            return null;
        }
    }
    public static void main(String[] args) {
        factory f = new factory();
        ShapeFactory shapeFactory = f.new ShapeFactory();
        Product shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Product shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Product shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();  
    }
}
