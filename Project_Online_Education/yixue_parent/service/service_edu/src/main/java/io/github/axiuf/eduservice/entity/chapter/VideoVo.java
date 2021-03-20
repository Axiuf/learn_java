package io.github.axiuf.eduservice.entity.chapter;

import lombok.Data;

/**
 * @author Shan Cheng
 * @since 2021/3/8
 */

@Data
public class VideoVo
{
    private String id;

    private String title;

    private String videoSourceId;

    private Integer isFree;
}
