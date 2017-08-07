package com.showka.MyBatisDemo.u01.g001.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.showka.MyBatisDemo.kubun.KokyakuKubun;
import com.showka.MyBatisDemo.kubun.i.Kubun;
import com.showka.MyBatisDemo.u01.g001.search.U01G001Kokyaku;
import com.showka.MyBatisDemo.u01.g001.search.i.U01G001KokyakuSearchService;

@Controller
public class U00G001Controller {

	/**
	 * service
	 */
	@Autowired
	private U01G001KokyakuSearchService service;

	/**
	 * 検索
	 * 
	 * @param form
	 */
	@RequestMapping(value = "/u01g001/search", method = RequestMethod.GET)
	public String search(@ModelAttribute U01G001Form form, Model model, HttpSession session) {

		// 検索
		List<U01G001Kokyaku> result = service.searchForScreen(form.getKokyakuName(), form.getKokyakuName());

		// list
		ArrayList<HashMap<String, String>> kokyakuList = new ArrayList<>();
		for (U01G001Kokyaku k : result) {
			HashMap<String, String> m = new HashMap<String, String>();
			m.put("name", k.getName());
			KokyakuKubun kokyakuKubun = Kubun.get(KokyakuKubun.class, k.getKokyaku_kubun());
			m.put("kokyakuKubun", kokyakuKubun.getCodeWithName());
			m.put("bushoName", k.getShukanBusho().getName());
			kokyakuList.add(m);
		}
		model.addAttribute("kokyakuList", kokyakuList);

		// 画面
		// return "/u01/u01g001KokyakuList :: list";
		return "画面まだなし";
	}

}
