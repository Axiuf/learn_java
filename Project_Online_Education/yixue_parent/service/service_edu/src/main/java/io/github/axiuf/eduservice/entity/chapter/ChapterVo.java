package io.github.axiuf.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/8
 */
@Data
public class ChapterVo
{
    private String id;

    private String title;


    private List<VideoVo> children = new ArrayList<>();
}