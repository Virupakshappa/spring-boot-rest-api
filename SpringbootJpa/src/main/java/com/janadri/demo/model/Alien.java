package com.janadri.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

@Id
private int aid;
private String aname;

public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
@Override
public String toString() {
	return "Alien [aname=" + aname + ", aid=" + aid + "]";
}

}
