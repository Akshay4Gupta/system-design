package designPatterns.singleton.chocolateFactory;

public class ChocolateFactory {
    private static volatile ChocolateFactory chocolateFactoryInstance;

    private ChocolateFactory () {

    }

    public static ChocolateFactory getInstance () {
        if (chocolateFactoryInstance == null) {
            synchronized (ChocolateFactory.class) {
                if (chocolateFactoryInstance ==  null)
                    chocolateFactoryInstance = new ChocolateFactory();
            }
        }
        return chocolateFactoryInstance;
    }
}
