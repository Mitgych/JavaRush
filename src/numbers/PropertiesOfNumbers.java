
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
    JUMPING;


    /**
     * Returns exclusive property for the passed parameter
     * If parameter haven't exclusive property - return itself
     */
    public static PropertiesOfNumbers exclusiveProperty(PropertiesOfNumbers prop) {
        PropertiesOfNumbers result = EVEN;
        switch (prop) {
            case JUMPING:
            case BUZZ:
            case PALINDROMIC:
            case GAPFUL:
                result = prop;
                break;
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
        }
        return result;
    }
}
