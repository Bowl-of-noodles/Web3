package rogachova.web3;


import rogachova.web3.model.AccessDataObj;
import rogachova.web3.model.AccessDataResult;
import rogachova.web3.model.PointResult;

import org.primefaces.event.SlideEndEvent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsManagerBean {
    private UIComponent errorWindow;

    private final ResultController pointResultController = new ResultController();
    private List<PointResult> pointResultList;
    private AccessDataObj<Long, PointResult> dbManager = new AccessDataResult();

    private String x;
    private String xFromCanvas;

    private String y;
    private String yFromCanvas;

    private String r;
    private String rFromCanvas;

    public PointsManagerBean() {
    }

    public void addResultFromCanvasToDB() {
        PointResult pointResult = pointResultController.createPointResult(xFromCanvas, yFromCanvas, rFromCanvas);
        dbManager.insert(pointResult);
        pointResultList.add(pointResult);
    }

    public void addResultToDB() {
        System.out.println("Прилетел запрос: x = " + x + ", y = " + y + ", r = " +r);
        PointResult pointResult = pointResultController.createPointResult(x, y, r);
        dbManager.insert(pointResult);
        pointResultList.add(pointResult);
    }

    public void clearTable() {
        dbManager.deleteAll();
        pointResultList = new ArrayList<>();
    }


    public AccessDataObj<Long, PointResult> getDbManager() {
        return dbManager;
    }

    public void setDbManager(AccessDataObj<Long, PointResult> dbManager) {
        this.dbManager = dbManager;
    }

    public List<PointResult> getPointResultList() {
        if (pointResultList == null) {
            pointResultList = dbManager.getAll();
        }
        return pointResultList;
    }

    public UIComponent getErrorWindow() {
        return errorWindow;
    }

    public void setErrorWindow(UIComponent errorWindow) {
        this.errorWindow = errorWindow;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getyFromCanvas() {
        return yFromCanvas;
    }

    public void setyFromCanvas(String yFromCanvas) {
        this.yFromCanvas = yFromCanvas;
    }

    public String getxFromCanvas() {
        return xFromCanvas;
    }

    public void setxFromCanvas(String xFromCanvas) {
        this.xFromCanvas = xFromCanvas;
    }

    public String getrFromCanvas() {
        return rFromCanvas;
    }

    public void setrFromCanvas(String rFromCanvas) {
        this.rFromCanvas = rFromCanvas;
    }

    public void onSlideEnd(SlideEndEvent event) {
        this.r = String.valueOf(event.getValue());
    }

    public void onSlideXEnd(SlideEndEvent event) {
        this.x = String.valueOf(event.getValue());
    }
}
