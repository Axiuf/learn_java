package io.github.axiuf.excelData;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shan Cheng
 * @date 2021/3/5
 */

@Data
public class DemoData
{
    @ExcelProperty(value = "学生编号", index = 0)
    private int sno;

    @ExcelProperty(value = "学生姓名", index = 1)
    private String sname;
}
