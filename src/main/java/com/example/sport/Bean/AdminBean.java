package com.example.sport.Bean;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

@TableName("admin")
public class AdminBean {

    @ApiModelProperty(value = "管理员ID", name = "id", example = "1", required = true)
    @TableId
    private int id;

    @ApiModelProperty(value = "用户名", name = "username", example = "admin", required = true)
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "姓名", name = "name", example = "张三")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "权限等级", name = "level", example = "1")
    @TableField("level")
    private int level;

    @ApiModelProperty(value = "学院ID", name = "collegeId", example = "1")
    @TableField("college_id")
    private int collegeId;

    @TableField("is_delete")
    private int isDelete;

    public AdminBean() {
    }

    public AdminBean(String username, String password, String name, int level, int collegeId) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.level = level;
        this.collegeId = collegeId;
    }

    public AdminBean(int id, String username, String password, String name, int level, int collegeId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.level = level;
        this.collegeId = collegeId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
}
