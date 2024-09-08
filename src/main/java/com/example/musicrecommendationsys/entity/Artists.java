package com.example.musicrecommendationsys.entity;

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
public class Artists implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String url;


}
