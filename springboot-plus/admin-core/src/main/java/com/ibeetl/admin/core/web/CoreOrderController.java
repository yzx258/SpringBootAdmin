package com.ibeetl.admin.core.web;


import java.util.List;


import com.ibeetl.admin.core.entity.CoreOrder;
import com.ibeetl.admin.core.service.CoreOrderService;
import com.ibeetl.admin.core.web.query.CoreOrderQuery;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.sql.core.engine.PageQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.ibeetl.admin.core.annotation.Function;

import com.ibeetl.admin.core.file.FileService;
import com.ibeetl.admin.core.util.*;


/**
 * CoreOrder 接口
 */
@Controller
public class CoreOrderController{

    private final Log log = LogFactory.getLog(this.getClass());
    private static final String MODEL = "/cms/coreOrder";


    @Autowired private CoreOrderService coreOrderService;
    
    @Autowired
    FileService fileService;
    /* 页面 */

    @GetMapping(MODEL + "/index.do")
    @Function("coreOrder.query")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/cms/coreOrder/index.html") ;
        view.addObject("search", CoreOrderQuery.class.getName());
        return view;
    }

    @GetMapping(MODEL + "/edit.do")
    @Function("coreOrder.edit")
    @ResponseBody
    public ModelAndView edit(Integer id) {
        ModelAndView view = new ModelAndView("/cms/coreOrder/edit.html");
        CoreOrder coreOrder = coreOrderService.queryById(id);
        view.addObject("coreOrder", coreOrder);
        return view;
    }

    @GetMapping(MODEL + "/add.do")
    @Function("coreOrder.add")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView("/cms/coreOrder/add.html");
        return view;
    }

    /* ajax json */

    @PostMapping(MODEL + "/list.json")
    @Function("coreOrder.query")
    @ResponseBody
    public JsonResult<PageQuery> list(CoreOrderQuery condtion)
    {
        PageQuery page = condtion.getPageQuery();
        coreOrderService.queryByCondition(page);
        return JsonResult.success(page);
    }

    @PostMapping(MODEL + "/add.json")
    @Function("coreOrder.add")
    @ResponseBody
    public JsonResult add(@Validated(ValidateConfig.ADD.class)CoreOrder coreOrder)
    {
        coreOrderService.save(coreOrder);
        return new JsonResult().success();
    }

    @PostMapping(MODEL + "/update.json")
    @Function("coreOrder.update")
    @ResponseBody
    public JsonResult<String> update(@Validated(ValidateConfig.UPDATE.class)  CoreOrder coreOrder) {
        boolean success = coreOrderService.update(coreOrder);
        if (success) {
            return new JsonResult().success();
        } else {
            return JsonResult.failMessage("保存失败");
        }
    }


   
    @GetMapping(MODEL + "/view.json")
    @Function("coreOrder.query")
    @ResponseBody
    public JsonResult<CoreOrder>queryInfo(Integer id) {
        CoreOrder coreOrder = coreOrderService.queryById( id);
        return  JsonResult.success(coreOrder);
    }

    @PostMapping(MODEL + "/delete.json")
    @Function("coreOrder.delete")
    @ResponseBody
    public JsonResult delete(String ids) {
        if (ids.endsWith(",")) {
            ids = StringUtils.substringBeforeLast(ids, ",");
        }
        List<Long> idList = ConvertUtil.str2longs(ids);
        coreOrderService.batchDelCoreOrder(idList);
        return new JsonResult().success();
    }
    

}
