package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SecKillExecution;
import org.seckill.dto.SecKillResult;
import org.seckill.entity.SecKill;
import org.seckill.enums.SecKillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SecKillClosedException;
import org.seckill.exception.SecKillException;
import org.seckill.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Shan Cheng
 * @since 2021/4/18
 */

@Controller
@RequestMapping("/secKill") // url:/模块/资源/{id}/细分 例如：/seckill/list
public class SecKillController
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecKillService secKillService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model)
    {
        // 获取秒杀商品的列表页面
        List<SecKill> list = secKillService.getSecKillList();
        model.addAttribute("list", list);
        // list.jsp + model = ModelAndView
        return "list"; // WEB-INF/jsp/list.jsp 这里是由页面解析器做的字符串拼接
    }

    @RequestMapping(value = "/{secKillId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("secKillId") Long secKillId,  Model model)
    {
        if (secKillId == null) return "redirect:/seckill/list";
        SecKill secKill = secKillService.getById(secKillId);
        if (secKill == null) return "forward:/seckill/list";

        model.addAttribute("secKill", secKill);
        return "detail";
    }

    // ajax json
    @RequestMapping(value = "/{secKillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SecKillResult<Exposer> exposer(@PathVariable("secKillId") Long secKillId)
    {
        SecKillResult<Exposer> result;
        try
        {
            Exposer exposer = secKillService.exportSecKillUrl(secKillId);
            result = new SecKillResult<>(true, exposer);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            result = new SecKillResult<>(false, e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/{secKillId}/{md5}/execution", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SecKillResult<SecKillExecution> execute(@PathVariable("secKillId") Long secKillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "killPhone", required = false) Long phone)
    {
        if (phone == null) return new SecKillResult<>(false, "未注册");

        try
        {
            SecKillExecution execution = secKillService.executeSecKillProcedure(secKillId, phone, md5);
            return new SecKillResult<>(true, execution);
        }
        catch (RepeatKillException e)
        {
            SecKillExecution execution = new SecKillExecution(secKillId, SecKillStatEnum.REPEAT_KILL);
            return new SecKillResult<>(true, execution);
        }
        catch (SecKillClosedException e)
        {
            SecKillExecution execution = new SecKillExecution(secKillId, SecKillStatEnum.END);
            return new SecKillResult<>(true, execution);
        }
        catch (SecKillException e)
        {
            logger.error(e.getMessage(), e);
            SecKillExecution execution = new SecKillExecution(secKillId, SecKillStatEnum.INNER_ERROR);
            return new SecKillResult<>(true, execution);
        }
    }

    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SecKillResult<Long> time()
    {
        long time = new Date().getTime();
        return new SecKillResult<>(true, time);
    }
}