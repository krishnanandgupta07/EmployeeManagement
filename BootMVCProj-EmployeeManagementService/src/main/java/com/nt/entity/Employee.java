package com.nt.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="emp")
public class Employee {

	@Id
	@SequenceGenerator(name="egen1",sequenceName="empno_seq1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "egen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;
	private String csvStatus="disabled";
}
