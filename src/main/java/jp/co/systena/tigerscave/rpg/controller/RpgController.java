package jp.co.systena.tigerscave.rpg.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.rpg.model.JobForm;
import jp.co.systena.tigerscave.springtest.application.model.Cart;


@Controller
public class RpgController {
  @Autowired
  HttpSession session;
  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public ModelAndView create(ModelAndView mav) {

    mav.setViewName("createCharacter");

    return mav;
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView selectJob(ModelAndView mav, @Valid JobForm jobForm) {

    Character character = (Character) session.getAttribute("jobForm");
    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cartList", cart);
    }
    cart.addOrder(listForm.getId(), listForm.getNum());

    mav.setViewName("CartView");

    return mav;
  }



}
