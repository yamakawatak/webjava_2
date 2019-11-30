package jp.co.systena.tigerscave.rpg.model;

import java.util.ArrayList;
import java.util.List;

public class CommandForm {
  private String command;
  private List<String> commandList = new ArrayList<>();

  public String getCommand(int num) {
    return this.commandList.get(num);
  }
  public void setCommand(String command) {
    this.command = command;
  }
  public List<String> getCommandList() {
    return commandList;
  }
  public void setCommandList(String command) {
    this.commandList = commandList;
  }

}