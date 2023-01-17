package api.models.vk;

import lombok.Data;

@Data
public class CommentThreadModel {
    private int count;
    private boolean can_post;
    private boolean show_reply_button;
    private boolean groups_can_post;
}