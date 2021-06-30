package dev.aquashdw.demo.springtutorial.board.dto;

import java.sql.Timestamp;

public class CommentDto {
    private int id;
    private String comment;
    private int userId;
    private int contentId;
    private Timestamp createDate;
    private Timestamp updateDate;

    public CommentDto() {
    }

    public CommentDto(int id, String comment, int userId, int contentId, Timestamp createDate, Timestamp updateDate) {
        this.id = id;
        this.comment = comment;
        this.userId = userId;
        this.contentId = contentId;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
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
        return "CommentDto{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                ", contentId=" + contentId +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
