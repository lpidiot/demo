package com.idiot.music.entity;
/**
 * @auther idiot
 * @date 2019/9/15 - 14:22
 **/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idiot.music.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:TbUser
 * @Description:用户表-账户公用信息
 * @Version:1.0
 **/
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class SysUser extends BaseEntity {
    private String username;
    private String password;
    private String name;

    @JsonIgnore
    private List<SysRole> roles = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }


}
