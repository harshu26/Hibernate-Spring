package com.capg.dao;

import com.capg.entities.Employee;

public interface IEmployeeDao {
	Employee fetchById(int id);
}
