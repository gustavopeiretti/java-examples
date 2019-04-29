package patterns.factory;

public class FactoryPatternExample {

    public static void main(String[] args) {

        FactoryPatternExample example = new FactoryPatternExample();
        example.printShape("CIRCLE");

    }


//    // Whithout factory
//    public void printShape(String shapeType) {
//
//        Shape shape;
//        switch (shapeType) {
//            case "CIRCLE":
//                shape = new Circle();
//                break;
//            case "RECTANGLE":
//                shape = new Rectangle();
//                break;
//            case "SQUARE":
//                shape = new Square();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + shapeType);
//        }
//        shape.draw();
//
//    }

    // Using Factory
    public void printShape(String shapeType) {

        Shape shape2 = ShapeFactory.getShape(shapeType);
        shape2.draw();

    }

}
