package de.itblogging.spring.beans;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Singleton {
  
  private Date date;

  public Singleton() {
    this.date = new Date();
  }

  public Date getDate() {
    return date;
  }
}
