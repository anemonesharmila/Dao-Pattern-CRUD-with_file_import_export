/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populationSurvery.entity;

/**
 *
 * @author sharmila
 */
public class Survey {
    private String area;
    private int areaId;
    private int totalChildren;
    private int totalMale;
    private int totalFemale;
    private int totalHouses;
    private int totalHouseHolds;

    public Survey() {
    }

    
    public Survey(String area, int areaId, int totalChildren, int totalMale, int totalFemale, int totalHouses, int totalHouseHolds) {
        this.area = area;
        this.areaId=areaId;
        this.totalChildren = totalChildren;
        this.totalMale = totalMale;
        this.totalFemale = totalFemale;
        this.totalHouses = totalHouses;
        this.totalHouseHolds = totalHouseHolds;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
    
    public int getTotalChildren() {
        return totalChildren;
    }

    public void setTotalChildren(int totalChildren) {
        this.totalChildren = totalChildren;
    }

    public int getTotalMale() {
        return totalMale;
    }

    public void setTotalMale(int totalMale) {
        this.totalMale = totalMale;
    }

    public int getTotalFemale() {
        return totalFemale;
    }

    public void setTotalFemale(int totalFemale) {
        this.totalFemale = totalFemale;
    }

    public int getTotalHouses() {
        return totalHouses;
    }

    public void setTotalHouses(int totalHouses) {
        this.totalHouses = totalHouses;
    }

    public int getTotalHouseHolds() {
        return totalHouseHolds;
    }

    public void setTotalHouseHolds(int totalHouseHolds) {
        this.totalHouseHolds = totalHouseHolds;
    }

    @Override
    public String toString() {
        return "Survey{" + "area=" + area + ", areaId=" + areaId + ", totalChildren=" + totalChildren + ", totalMale=" + totalMale + ", totalFemale=" + totalFemale + ", totalHouses=" + totalHouses + ", totalHouseHolds=" + totalHouseHolds + '}';
    }
    
    public String toCsv()
    {
        return   area + "," + areaId + "," + totalChildren + "," + totalMale + "," + totalFemale + "," + totalHouses + "," + totalHouseHolds +"\r\n";
    
    }
    
    
}
