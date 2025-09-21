public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        System.out.println("instance created"); // Private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        System.out.println(obj1.hashCode()); // Should print true, indicating both references point to the same instance
    System.out.println(obj2.hashCode());
    }
}