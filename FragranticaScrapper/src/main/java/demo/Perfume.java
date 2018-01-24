package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MJ00479956 on 6/2/2017.
 */
public class Perfume {
    private String brandName;

    private String perfumeName;

    private List<String> topNotes = new ArrayList<String>();

    private List<String> middleNotes = new ArrayList<String>();

    private List<String> baseNotes = new ArrayList<String>();

    private List<String> notes = new ArrayList<String>();

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPerfumeName() {
        return perfumeName;
    }

    public void setPerfumeName(String perfumeName) {
        this.perfumeName = perfumeName;
    }

    public List<String> getTopNotes() {
        return topNotes;
    }

    public void setTopNotes(List<String> topNotes) {
        this.topNotes = topNotes;
    }

    public List<String> getMiddleNotes() {
        return middleNotes;
    }

    public void setMiddleNotes(List<String> middleNotes) {
        this.middleNotes = middleNotes;
    }

    public List<String> getBaseNotes() {
        return baseNotes;
    }

    public void setBaseNotes(List<String> baseNotes) {
        this.baseNotes = baseNotes;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
