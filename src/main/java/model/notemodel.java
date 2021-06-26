package model;

import java.sql.Timestamp;
import java.util.List;

public class notemodel {
    private int idnote;
    public String iduser;
    public String  content;
    private String notename;
    private Timestamp createdatetime;
    private String time;
    private Timestamp editdatetime;
    private String edittime;

    private int page=1;
    private int maxpageitem;
    private int totalpage =10;

    public Timestamp getEditdatetime() {
        return editdatetime;
    }

    public void setEditdatetime(Timestamp editdatetime) {
        this.editdatetime = editdatetime;
    }

    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime;
    }



    public List<notemodel> getListmodel() {
        return listmodel;
    }

    public void setListmodel(List<notemodel> listmodel) {
        this.listmodel = listmodel;
    }

    private int totalitem;

    private List<notemodel> listmodel;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxpageitem() {
        return maxpageitem;
    }

    public void setMaxpageitem(int maxpageitem) {
        this.maxpageitem = maxpageitem;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalitem() {
        return totalitem;
    }

    public void setTotalitem(int totalitem) {
        this.totalitem = totalitem;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getIdnote() {
        return idnote;
    }

    public void setIdnote(int idnote) {
        this.idnote = idnote;
    }

    @Override
    public String toString() {
        return "note{" +
                "idnote=" + idnote +
                ", iduser='" + iduser + '\'' +
                ", content='" + content + '\'' +
                ", notename='" + notename + '\'' +
                ", createdatetime=" + createdatetime +
                '}';
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }

    public Timestamp getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Timestamp createdatetime) {
        this.createdatetime = createdatetime;
    }
}
