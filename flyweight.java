public class flyweight {
    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        private String color;
        private int x;
        private int y;
        private int radius;

        public Circle(String color) {
            this.color = color;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Drawing Circle [Color: " + color + ", X: " + x + ", Y: " + y + ", Radius: " + radius + "]");
        }
    }

    static class ShapeFactory {
        private static final java.util.Map<String, Shape> circleMap = new java.util.HashMap<>();

        public static Shape getCircle(String color) {
            Circle circle = (Circle) circleMap.get(color);

            if (circle == null) {
                circle = new Circle(color);
                circleMap.put(color, circle);
                System.out.println("Creating a new circle of color: " + color);
            }
            return circle;
        }
    }

    public static void main(String[] args) {
        Shape redCircle1 = ShapeFactory.getCircle("Red");
        redCircle1.setX(10);
        redCircle1.setY(20);
        redCircle1.setRadius(15);
        redCircle1.draw();

        Shape redCircle2 = ShapeFactory.getCircle("Red");
        redCircle2.setX(30);
        redCircle2.setY(40);
        redCircle2.setRadius(25);
        redCircle2.draw();

        Shape blueCircle = ShapeFactory.getCircle("Blue");
        blueCircle.setX(50);
        blueCircle.setY(60);
        blueCircle.setRadius(35);
        blueCircle.draw();
    }
}
