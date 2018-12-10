package pramonow.com.android_howto.model;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("memberid")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("role")
    private int role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
