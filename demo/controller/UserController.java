package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Buken;
import com.example.demo.obj.BukenDto;
import com.example.demo.obj.UserDto;
import com.example.demo.service.BukenService;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private UserService userService;

	/**
	 * ユーザー情報一覧画面を表示
	 * 
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */

	@GetMapping(value = "/user/list")
	public ModelAndView displayList(Model model) {
		List<UserDto> userlist = userService.searchAll();
		System.out.println("User情報取得しました。" + userlist);
		model.addAttribute("userlist", userlist);

		ModelAndView maView = new ModelAndView("/user/list");
		return maView;
	}

	// 物件一覧
	@Autowired
	private BukenService bukenService;

	@GetMapping(value = "/user/Buken")
	public ModelAndView displayListBuken(Model model) {
		List<BukenDto> bukenList = bukenService.searchAll();
		System.out.println("物件情報取得しました。" + bukenList);
		model.addAttribute("bukenList", bukenList);

		ModelAndView modelAndView = new ModelAndView("/user/Buken");
		return modelAndView;
	}

	/**
	 * ユーザー新規登録画面を表示
	 * 
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		return "user/add";
	}

	/**
	 * ユーザー情報詳細画面を表示
	 * 
	 * @param id    表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		return "user/view";
	}

	// 物件新規画面
	@GetMapping(value = "/user/BukenAdd")
	public String displayBukenAdd(Model model) {
		return "/user/BukenAdd";
	}

//物件新規
	@PostMapping("/user/BukenAdd")
	public String addBuken(@ModelAttribute BukenDto bukenDto) {
	    Buken buken = new Buken();
	    //buken.setPropertyId(bukenDto.getPropertyId());
	    buken.setPropertyName(bukenDto.getPropertyName());
	    buken.setAddress(bukenDto.getAddress());
	    buken.setPropertyType(bukenDto.getPropertyType());
	    buken.setPropertyArea(bukenDto.getPropertyArea());
	    buken.setPrice(bukenDto.getPrice());
	    buken.setSyozokuCompanyId(bukenDto.getSyozokuCompanyId());
	    buken.setStatus(bukenDto.getStatus());

	    bukenService.saveBuken(buken);

	    return "redirect:/user/Buken";
	}
	
	//検索
	@GetMapping("/user/Buken/{searchId}")
	public String searchBukenById(@PathVariable("searchId") Long propertyId, Model model) {
	    List<BukenDto> bukenList = bukenService.searchById(propertyId);
	    model.addAttribute("bukenList", bukenList);
	    System.out.println("bbbbbbbbbbbbbbbbbbbbbbbb");
	    return "user/Buken"; // 返回包含搜索结果的模板
	}
	
	
	@GetMapping("/AA")
    public String displayBukenAdd() {
        return "user/Buken";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("uid") String uid, Model model) {
        model.addAttribute("uidValue", uid);
        return "user/Buken";
    }
	
    //删除
    @PostMapping("/user/Buken/delete/{id}")
    public String deleteBuken(@PathVariable("id") Long propertyId) {
        //bukenService.deleteBukenById(propertyId);
    	bukenService.deleteBuken(propertyId);
        return "redirect:/user/Buken"; // 删除后重定向到物件列表页面
    }
    
 // 编辑物件页面
    @GetMapping("/user/BukenEdit/{propertyId}")
    public String displayBukenEdit(@PathVariable Long propertyId, Model model) {
        BukenDto bukenDto = bukenService.getBukenById(propertyId);
        model.addAttribute("bukenDto", bukenDto);
        return "user/BukenEdit";
    }


    // 更新物件操作
    @PostMapping("/user/BukenUpdate")
    public String updateBuken(@ModelAttribute("bukenDto") BukenDto bukenDto) {
        bukenService.updateBuken(bukenDto);
        return "redirect:/user/BukenList"; // 根据需要进行重定向，此处示例重定向到物件列表页面
    }

}