package br.com.exemplo.arquillian.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable {
 
      private static final long serialVersionUID = 1L;
 
      @Id
      @GeneratedValue
      @Column(name = "id")
      private int id;
      @Column(name = "name", length = 60)
      private String name;
      @Column(name = "age")
      private Integer age;
 
      public int getId() {
            return id;
      }
 
      public void setId(int id) {
            this.id = id;
      }
 
      public String getName() {
            return name;
      }
 
      public void setName(String name) {
            this.name = name;
      }
 
      public Integer getAge() {
            return age;
      }
 
      public void setAge(Integer age) {
            this.age = age;
      }
}
