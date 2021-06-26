package model;

public class usermodel {
    private String  iduser;
    private String  password;
    private byte[] image;
    private  String namefileimage;

    public String getNamefileimage() {
        return namefileimage;
    }

    public void setNamefileimage(String namefileimage) {
        this.namefileimage = namefileimage;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getIduser() {
        return iduser;
    }

    @Override
    public String toString() {
        return "user{" +
                "iduser='" + iduser + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
