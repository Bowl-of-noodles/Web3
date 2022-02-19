package rogachova.web3;

import rogachova.web3.model.PointResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ResultController {

    public PointResult createPointResult(String x, String y, String r) {
        double xValue = Double.parseDouble(x);
        double yValue = Double.parseDouble(y);
        double rValue = Double.parseDouble(r);
        boolean valid = validate(xValue, yValue, rValue);
        boolean hit = valid && checkHit(xValue, yValue, rValue);
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return new PointResult(xValue, yValue, rValue, time, valid, hit);
    }

    private boolean validate(double x, double y, double r) {
        return validateX(x) && validateY(y) && validateR(r);
    }

    private boolean validateX(double x) {
        return x >= -5 && x <= 5;
    }

    private boolean validateY(double y) {
        return y >= -5 && y <= 3;
    }

    private boolean validateR(double r) {
        return r >= 2 && r <= 5;
    }

    private boolean checkHit(double xValue, double yValue, double rValue) {
        return checkTriangle(xValue, yValue, rValue) || checkRectangle(xValue, yValue, rValue) || checkCircle(xValue, yValue, rValue);
    }

    private boolean checkTriangle(double xValue, double yValue, double rValue) {
        return xValue <= 0 && yValue >= 0 && (-xValue) + yValue <= rValue/2;
    }

    private boolean checkCircle(double xValue, double yValue, double rValue) {
        return xValue >= 0 && yValue >= 0 && (xValue*xValue + yValue*yValue <= rValue*rValue/4);
    }

    private boolean checkRectangle(double xValue, double yValue, double rValue) {
        return (xValue <= 0 && yValue <= 0 && xValue >= -rValue && yValue >= -rValue/2);
    }
}
