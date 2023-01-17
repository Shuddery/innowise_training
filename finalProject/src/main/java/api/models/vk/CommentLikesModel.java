package api.models.vk;

import lombok.Data;

@Data
public class CommentLikesModel {
    private int can_like;
    private int count;
    private int user_likes;
    private int can_publish;
}