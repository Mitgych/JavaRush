
package numbers;

enum PropertiesOfNumbers {
    BUZZ,
    ODD,
    EVEN,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    SUNNY,
    SQUARE,
    JUMPING,
    SAD,
    HAPPY;


    /**
     * Returns exclusive property for the passed parameter
     * If parameter haven't exclusive property - return itself
     */
    public static PropertiesOfNumbers exclusionaryProperty(PropertiesOfNumbers prop) {
        PropertiesOfNumbers result = prop;
        switch (prop) {
            case ODD:
                result = EVEN;
                break;
            case EVEN:
                result = ODD;
                break;
            case DUCK:
                result = SPY;
                break;
            case SPY:
                result = DUCK;
                break;
            case SUNNY:
                result = SQUARE;
                break;
            case SQUARE:
                result = SUNNY;
                break;
            case SAD:
                result = HAPPY;
                break;
            case HAPPY:
                result = SAD;
        }
        return result;
    }
}
