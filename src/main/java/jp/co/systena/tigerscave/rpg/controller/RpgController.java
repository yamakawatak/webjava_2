package jp.co.systena.tigerscave.rpg.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.rpg.model.Job;
import jp.co.systena.tigerscave.rpg.model.JobForm;
import jp.co.systena.tigerscave.rpg.model.Warrier;
import jp.co.systena.tigerscave.rpg.model.Wizard;


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

//    Chara create = (Chara) session.getAttribute("jobForm");//job,name
    //session.getAttribute("jobForm");
    String job =jobForm.getJob();
    if(jobForm.getJob().contentEquals("戦士")) {
      Warrier chara = new Warrier();
      chara.setJob(jobForm.getJob());
      chara.setHp(100);
      chara.setName(jobForm.getName());
      mav.addObject("chara",chara);
      session.setAttribute("character", chara);
    }
    else if(jobForm.getJob().contentEquals("魔法使い")) {
      Wizard chara = new Wizard();
      chara.setJob(jobForm.getJob());
      chara.setHp(100);
      chara.setName(jobForm.getName());
      mav.addObject("chara",chara);
      session.setAttribute("character", chara);
    }




    mav.setViewName("command");

    return mav;
  }

  @RequestMapping(value = "/command", method = RequestMethod.GET)
  public ModelAndView command(ModelAndView mav) {

    mav.setViewName("command");

    return mav;
  }

  @RequestMapping(value = "/battle", method = RequestMethod.GET)
  public ModelAndView battle(ModelAndView mav) {

    Job job = (Job)session.getAttribute("character");
//    String str = job.attack(job.getName());
    mav.addObject("battletext", job.attack(job.getName()));
    mav.setViewName("battle");

    return mav;
  }

}
