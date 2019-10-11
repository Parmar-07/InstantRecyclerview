package instant.recyclerview.demo;

public class CustomModel {

    private String versionName;
    private String versionDesc;

    public CustomModel(String versionName, String versionDesc) {
        this.versionName = versionName;
        this.versionDesc = versionDesc;
    }

    public String getVersionName() {
        return versionName;
    }

    public String getVersionDesc() {
        return versionDesc;
    }
}
