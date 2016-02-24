package de.itblogging.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope(scopeName = "prototype")
public class Prototype {

  private Date date;

  public Prototype() {
    this.date = new Date();
  }

  public Date getDate() {
    return date;
  }
}
