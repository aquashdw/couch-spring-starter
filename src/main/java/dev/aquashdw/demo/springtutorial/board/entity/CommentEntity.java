package dev.aquashdw.demo.springtutorial.board.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@DynamicUpdate
public class CommentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity writeUser;

    @OneToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private ArticleEntity article;

    private String comment;
}
