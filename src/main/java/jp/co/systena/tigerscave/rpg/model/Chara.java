package jp.co.systena.tigerscave.rpg.model;

public class Chara {
  private String name;
  private String job;
  private int hp;

  public void setName(String name) {
    this.name = name;
  }
  public void setJob(String job) {
    this.job = job;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }

  public String getName() {
    return this.name;
  }
  public String getJob() {
    return this.job;
  }
  public int getHp() {
    return this.hp;
  }
}
