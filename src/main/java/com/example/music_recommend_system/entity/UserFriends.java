package com.example.music_recommend_system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cyy
 * @since 2024-09-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserFriends implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("userID")
    private Integer userid;

    @TableField("friendID")
    private Integer friendid;


}
