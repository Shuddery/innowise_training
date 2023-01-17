package api.models.vk;

import java.util.List;
import lombok.Data;

@Data
public class CommentItemModel {
    private int id;
    private int from_id;
    private int date;
    private String text;
    private int can_edit;
    private int post_id;
    private int owner_id;
    private List<Object> parents_stack;
    private CommentLikesModel likes;
    private CommentThreadModel thread;
}
