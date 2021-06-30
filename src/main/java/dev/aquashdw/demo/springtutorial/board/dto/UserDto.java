package dev.aquashdw.demo.springtutorial.board.dto;

import java.sql.Timestamp;

public class UserDto {
    private int id;
    private String userId;
    private String userKey;
    private Timestamp createDate;
    private Timestamp updateDate;

    public UserDto() {
    }

    public UserDto(int id, String userId, String userKey, Timestamp createDate, Timestamp updateDate) {
        this.id = id;
        this.userId = userId;
        this.userKey = userKey;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userKey='" + userKey + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
