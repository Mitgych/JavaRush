
package hyperskill.numbers;

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
        PropertiesOfNumbers result = switch (prop) {
            case ODD -> EVEN;
            case EVEN -> ODD;
            case DUCK -> SPY;
            case SPY -> DUCK;
            case SUNNY -> SQUARE;
            case SQUARE -> SUNNY;
            case SAD -> HAPPY;
            case HAPPY -> SAD;
            default -> prop;
        };
        return result;
    }
}
