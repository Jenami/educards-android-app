package educards.educards_model;

public class PlayerApi {

    private String name;
    private Integer age;
    private String image;
    private String password;

    public PlayerApi(){}

    public PlayerApi(String name, Integer age, String image, String password) {
        this.name = name;
        this.age = age;
        this.image = image;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
