package com.usian.controller;

import com.usian.mapper.TbItemMapper;
import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemDesc;
import com.usian.pojo.TbItemParamItem;
import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("service/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("selectItemInfo")
    public TbItem selectItemInfo(Long itemId){
        return itemService.getById(itemId);
    }

    @RequestMapping("selectTbItemAllByPage")
    public PageResult selectTbItemAllByPage(Integer page, Integer rows){
        return itemService.selectTbItemAllByPage(page, rows);
    }

    @RequestMapping("insertTbItem")
    public Integer insertTbItem(@RequestBody TbItem tbItem, String desc, String itemParams){
        return itemService.insertTbItem(tbItem, desc, itemParams);
    }

    @RequestMapping("preUpdateItem")
    public Map<String, Object> preUpdateItem(Long itemId){
        return itemService.preUpdateItem(itemId);
    }

    @RequestMapping("selectItemDescByItemId")
    public TbItemDesc selectItemDescByItemId(@RequestParam Long itemId){
        return itemService.selectItemDescByItemId(itemId);
    }

    @RequestMapping("selectTbItemParamItemByItemId")
    public TbItemParamItem selectTbItemParamItemByItemId(@RequestParam Long itemId){
        return itemService.selectTbItemParamItemByItemId(itemId);
    }
}
