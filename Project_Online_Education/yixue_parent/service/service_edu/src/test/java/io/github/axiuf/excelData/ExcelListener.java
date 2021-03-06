package io.github.axiuf.excelData;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author Shan Cheng
 * @date 2021/3/5
 */
public class ExcelListener extends AnalysisEventListener<DemoData>
{
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext)
    {
        System.out.println("****" + demoData);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context)
    {
        System.out.println("表头" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext)
    {

    }
}
