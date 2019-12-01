package jp.co.systena.tigerscave.rpg.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.rpg.model.CommandForm;
import jp.co.systena.tigerscave.rpg.model.Job;
import jp.co.systena.tigerscave.rpg.model.JobForm;
import jp.co.systena.tigerscave.rpg.model.Monk;
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

  @RequestMapping(value = "/command", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView command(ModelAndView mav, @Valid JobForm jobForm) {
    ArrayList<Job> character = new ArrayList<Job>();

    System.out.print(jobForm);
    List<Job> getForm = jobForm.getJob();
    for (int i = 0; i < getForm.size(); i++) {
      if(!getForm.get(i).getName().isEmpty()) {
        if(getForm.get(i).getJob().contentEquals("戦士")) {
          Warrier chara = new Warrier();
          chara.setJob(getForm.get(i).getJob());
          chara.setHp(100);
          chara.setName(getForm.get(i).getName());
          character.add(chara);
        }
        else if(getForm.get(i).getJob().contentEquals("魔法使い")) {
          Wizard chara = new Wizard();
          chara.setJob(getForm.get(i).getJob());
          chara.setHp(100);
          chara.setName(getForm.get(i).getName());
          character.add(chara);

        }
        else if(getForm.get(i).getJob().contentEquals("武闘家")) {
          Monk chara = new Monk();
          chara.setJob(getForm.get(i).getJob());
          chara.setHp(100);
          chara.setName(getForm.get(i).getName());
          character.add(chara);

        }
      }
      mav.addObject("character",character);
      session.setAttribute("character", character);
    }


    mav.setViewName("command");

    return mav;
  }


  @RequestMapping(value = "/battle", method = RequestMethod.POST) // URLとのマッピング
  public ModelAndView battle(ModelAndView mav, @Valid CommandForm commandForm) {
    List<Job> jobList = (List<Job>) session.getAttribute("character");
    List<String> commandList = commandForm.getCommandList();
    List<String> battleText = new ArrayList<String>();

    int enemyHp = 100;
    if(session.getAttribute("enemyhp") != null) {
      enemyHp = (int) session.getAttribute("enemyhp");
    }

    for (int i = 0; i < jobList.size(); i++) {
      if((commandForm.getCommand(i)).contentEquals("たたかう")) {
        battleText.add(jobList.get(i).attack(jobList.get(i).getName()));
        enemyHp = enemyHp - 10;
      }
      else if((commandForm.getCommand(i)).contentEquals("かいふく")) {
        battleText.add(jobList.get(i).heal(jobList.get(i).getName()));
      }
    }

    String enemyText = String.valueOf(enemyHp);

    session.setAttribute("enemyhp", enemyHp);
    mav.addObject("enemystat", enemyText);
    mav.addObject("battletext", battleText);
    mav.setViewName("battle");

    return mav;
  }

  @RequestMapping(value = "/command", method = RequestMethod.GET)
  public ModelAndView command(ModelAndView mav) {
    List<Job> character = (List<Job>) session.getAttribute("character");
    mav.addObject("character",character);
    mav.setViewName("command");

    return mav;
  }


}
