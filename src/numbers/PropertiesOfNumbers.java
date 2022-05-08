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

    public static PropertiesOfNumbers exclusiveProperty(PropertiesOfNumbers prop) {
        PropertiesOfNumbers result = EVEN;
        switch (prop) {
            case BUZZ:
                result = BUZZ;
                break;
            case PALINDROMIC:
                result = PALINDROMIC;
                break;
            case GAPFUL:
                result = GAPFUL;
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
                break;
            case JUMPING:
                result = JUMPING;
        }
        return result;
    }
}
