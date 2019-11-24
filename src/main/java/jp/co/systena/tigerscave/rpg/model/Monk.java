package jp.co.systena.tigerscave.rpg.model;

public class Monk extends Job {
  @Override
  public String attack(String name) {
    return name + "は拳で攻撃した";
  }


}
