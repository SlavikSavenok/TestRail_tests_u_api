package models;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Project {
    private Integer id;
    private String name;
    private  String announcement;
    @SerializedName("show_announcement")
    private Boolean showAnnouncement;
}
