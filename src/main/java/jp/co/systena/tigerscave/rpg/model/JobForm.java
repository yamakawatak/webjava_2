package jp.co.systena.tigerscave.rpg.model;

import java.util.ArrayList;
import java.util.List;

public class JobForm {
//  private String name;
//  private String job;
  private List<Job> job = new ArrayList<>();

  public List<Job> getJob() {
    return job;
  }

  public void setJob(List<Job> job) {
    this.job = job;
  }

  public int size() {
    return job.size();
  }

//  public String getName() {
//    return this.name;
//  }
//  public void setName(String name) {
//    this.name = name;
//  }
//  public String getJob() {
//    return this.job;
//  }
//  public void setJob(String job) {
//    this.job = job;
//  }
}
