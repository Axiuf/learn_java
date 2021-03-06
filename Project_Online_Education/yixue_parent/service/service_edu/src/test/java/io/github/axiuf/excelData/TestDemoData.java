package io.github.axiuf.excelData;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/3/5
 */
public class TestDemoData
{
    public static void main(String[] args)
    {
        String fileName = "C:\\Users\\axiuf\\Desktop\\write.xlsx";

        // EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());


        EasyExcel.read(fileName, DemoData.class, new ExcelListener()).sheet().doRead();
    }

    private static List<DemoData> getData()
    {
        List<DemoData> list = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            DemoData demoData = new DemoData();
            demoData.setSno(i);
            demoData.setSname("name" + i);
            list.add(demoData);
        }

        return list;
    }


}
