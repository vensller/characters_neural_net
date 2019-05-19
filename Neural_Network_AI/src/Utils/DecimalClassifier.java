package Utils;

public class DecimalClassifier {

    public static int getDecimalValue(double[] value){
        if (Math.round(value[0]) == 1)
            return 0;
        else if (Math.round(value[1]) == 1)
            return 1;
        else if (Math.round(value[2]) == 1)
            return 2;
        else if (Math.round(value[3]) == 1)
            return 3;
        else if (Math.round(value[4]) == 1)
            return 4;
        else if (Math.round(value[5]) == 1)
            return 5;
        else if (Math.round(value[6]) == 1)
            return 6;
        else if (Math.round(value[7]) == 1)
            return 7;
        else if (Math.round(value[8]) == 1)
            return 8;
        else if (Math.round(value[9]) == 1)
            return 9;

        return -1;
    }
}
