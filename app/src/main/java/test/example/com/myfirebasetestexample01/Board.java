package test.example.com.myfirebasetestexample01;

import java.util.Map;

public class Board {
    private String comment;
    private String id;
    private Map<String,String> time;

    public Board() {
    }

    public Board(String comment, String id, Map<String, String> time) {
        this.comment = comment;
        this.id = id;
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getTime() {
        return time;
    }

    public void setTime(Map<String, String> time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Board{" +
                "comment='" + comment + '\'' +
                ", id='" + id + '\'' +
                ", time=" + time +
                '}';
    }
}
