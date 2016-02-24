package de.itblogging.spring.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Lazy
public class SingletonLazyInit {

  private Date date;

  public SingletonLazyInit() {
    this.date = new Date();
  }

  public Date getDate() {
    return date;
  }
}
