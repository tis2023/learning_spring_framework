package jp.co.sss.shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.repository.ItemRepository;

@Controller
public class ItemController {
    @Autowired
    ItemRepository repository;

    @RequestMapping("/items/findAll")
    public String showItemList(Model model){
        model.addAttribute("items", repository.findAll());
        return "items/item_list";
    }

    @RequestMapping("items/findAllByOrderByPriceDesc")
    public String showItemListByOrderByPriceDesc(Model model){
        model.addAttribute("items", repository. findAllByOrderByPriceDesc());
        return "items/item_list";
    }

    @RequestMapping("/items/getOne/{id}")
    public String showItem(@PathVariable int id, Model model){
        Item item =repository.getReferenceById(id);
        ItemBean itemBean = new ItemBean();
        BeanUtils.copyProperties(item, itemBean);
        model.addAttribute("item", itemBean);
        return "items/item";
    }

    @RequestMapping("/items/findByPrice/{price}")
    public String showItemListByPrice(@PathVariable Integer price, Model model){
        model.addAttribute("items", repository.findByPrice(price));
        return "items/item_list";
    }

    @RequestMapping("/items/findByNameAndPrice/{name}/{price}")
    public String showItemListByNameAndPrice(@PathVariable String name, @PathVariable Integer price, Model model){
        model.addAttribute("items", repository.findByNameAndPrice(name, price));
        return "items/item_list";
    }
}