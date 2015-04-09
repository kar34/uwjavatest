package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired;
  private int count;
  
  public Person() {
    this("", 0, 0.0d);
    this.propertyChangeFired = false;
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    ssn = "";
  }

  public int getAge() {
    return age;
  }

  public void setAge(int a) {
    if (a < 0) 
      throw new IllegalArgumentException();
    else 
      age = a;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String n) {
    if (n == null)
      throw new IllegalArgumentException();
    else
      name = n;
  }  
  
  public double getSalary() {
    return salary;
  }

  public void setSalary(double s) {
    salary = s;
  }
  
  public String getSSN() {
    return ssn;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }

  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public int count() {
    return count;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public boolean equals(Object other) {
    if (other instanceof Person) {
      Person p = (Person)other;
      return this.name == p.name && this.age == p.age;
    } else 
      return false;
  }

  public int compareTo(Person other) {
    return (int) (other.salary - this.salary);
  }

  public static class AgeComparator implements Comparator<Person> {
    
    public int compare(Person pers1, Person pers2) {
      return pers1.getAge() - pers2.getAge();
    }

  }

  public static ArrayList<Person> getNewardFamily() {
    ArrayList<Person> family = new ArrayList<Person>();
    family.add(new Person("Ted", 41, 250000));
    family.add(new Person("Charlotte", 43, 150000));
    family.add(new Person("Michael", 22, 10000));
    family.add(new Person("Matthew", 15, 0));
    return family;
  }

  public String toString() {
    return "[Person name:" + this.name + " age:" + this.age + " salary:" + this.salary + "]";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
