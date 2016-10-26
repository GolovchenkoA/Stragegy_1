package ua.golovchenko.artem.strategy.model;

import java.io.Serializable;

/**
 * Created by art on 14.10.2016.
 */
public class User implements Serializable {

    private Long id;
    private String name;
    private String login;
    private String password;
    private Long CastleId;


    public User(){};

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCastleId() {
        return CastleId;
    }

    public void setCastleId(Long castleId) {
        CastleId = castleId;
    }

    @Override
    public String toString() {
        String user_settings = "ID: " + getId() + "; Login: " + getLogin() + "; Name: " + getName();


        return user_settings;
    }
}
