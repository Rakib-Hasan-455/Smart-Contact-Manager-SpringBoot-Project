package com.example.smartcontactmanagerproject.entity;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;
    private  String nickname;
    private String work;
    private String email;
    private String phone;
    private String image;
    @Column(length = 999)
    private String description;

    @ManyToOne
    private User user;
    public Contact(int cid, String name, String nickname, String work, String email, String phone, String image, String description) {
        this.cid = cid;
        this.name = name;
        this.nickname = nickname;
        this.work = work;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.description = description;
    }

    public Contact() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", work='" + work + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
