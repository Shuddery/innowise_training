package api.models.vk;

import java.util.List;
import lombok.Data;

@Data
public class CommentResponseModel {
    private List<CommentItemModel> items;
    private boolean can_post;
    private boolean show_reply_button;
    private boolean groups_can_post;
}