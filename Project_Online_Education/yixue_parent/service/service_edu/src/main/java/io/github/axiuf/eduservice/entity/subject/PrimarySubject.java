package io.github.axiuf.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/3/6
 */

@Data
public class PrimarySubject
{
    private String id;

    private String title;

    private List<SecondarySubject> children = new ArrayList<>();
}
