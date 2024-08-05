package backend.backend.domain.dto.commentDto;

import backend.backend.domain.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CommentResponseDto extends CommentRequestDto {
    private Long id;
    private String emogi;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String content;
    private String nickname;
    private Long parentId;
    private int depth;
    private List<CommentResponseDto> children= new ArrayList<>();

    // Entity -> DTO
    public CommentResponseDto(Comment comment, List<CommentResponseDto> commentResponseDtoList){
        this.id             = comment.getId();
        this.emogi     = comment.getMember().getEmoji();
        this.nickname       = comment.getNickname();
        this.content        = comment.getContent();
        this.depth          = comment.getDepth();
        this.createdAt      = comment.getCreatedAt();
        this.children       = commentResponseDtoList;
        this.updateAt       = comment.getUpdatedAt();
    }

    public CommentResponseDto(Comment comment, Long id){
        this.id             = comment.getId();
        this.emogi     = comment.getMember().getEmoji();
        this.nickname       = comment.getNickname();
        this.content        = comment.getContent();
        this.parentId       = id;
        this.depth          = comment.getDepth();
        this.createdAt      = comment.getCreatedAt();
        this.updateAt       = comment.getUpdatedAt();

    }

    public CommentResponseDto(Comment comment){
        this.id             = comment.getId();
        this.emogi    = comment.getMember().getEmoji();
        this.nickname       = comment.getNickname();
        this.content        = comment.getContent();
        this.depth          = comment.getDepth();
        this.createdAt      = comment.getCreatedAt();
        this.updateAt       = comment.getUpdatedAt();
    }

}