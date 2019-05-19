package Model;

import Utils.DecimalClassifier;

public class ConfusionMatrix {

    private double v0;
    private double v1;
    private double v2;
    private double v3;
    private double v4;
    private double v5;
    private double v6;
    private double v7;
    private double v8;
    private double v9;
    private double f0;
    private double f1;
    private double f2;
    private double f3;
    private double f4;
    private double f5;
    private double f6;
    private double f7;
    private double f8;
    private double f9;

    public void classify(double[] expected, double[] real){
        int exp = DecimalClassifier.getDecimalValue(expected);
        int realDec = DecimalClassifier.getDecimalValue(real);

        switch (exp){
            case 0:
                if (realDec == 0)
                    v0++;
                else f0++;
                break;
            case 1:
                if (realDec == 1)
                    v1++;
                else f1++;
                break;
            case 2:
                if (realDec == 2)
                    v2++;
                else f2++;
                break;
            case 3:
                if (realDec == 3)
                    v3++;
                else f3++;
                break;
            case 4:
                if (realDec == 4)
                    v4++;
                else f4++;
                break;
            case 5:
                if (realDec == 5)
                    v5++;
                else f5++;
                break;
            case 6:
                if (realDec == 6)
                    v6++;
                else f6++;
                break;
            case 7:
                if (realDec == 7)
                    v7++;
                else f7++;
                break;
            case 8:
                if (realDec == 8)
                    v8++;
                else f8++;
                break;
            case 9:
                if (realDec == 9)
                    v9++;
                else f9++;
                break;
        }
    }

    public double accuracy(){
        return (v0 + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9) / (v0 + v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8 + v9 + f0 + f1 + f2 + f3 + f4 + f5 + f6 + f7 + f8 + f9);
    }

}
