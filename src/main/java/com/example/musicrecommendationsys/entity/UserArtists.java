package com.example.musicrecommendationsys.entity;

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
 * @since 2024-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserArtists implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("userID")
    private Integer userid;

    @TableField("artistID")
    private Integer artistid;

    private Integer weight;


}
