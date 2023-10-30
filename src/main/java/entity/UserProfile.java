package entity;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({ "id", "mount", "name" })

public class UserProfile {

    @JsonProperty("id")
    private String id;
    @JsonProperty("mount")
    private String mount;
    @JsonProperty("name")
    private String name;

    public UserProfile(String id, String mount, String name) {

        this.id = id;
        this.mount = mount;
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
