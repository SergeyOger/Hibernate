package com.test;

import java.util.Date;

import com.hibernate.dao.TaskDao;
import com.hibernate.dateTime.Task;

public class TaskHandler {

	public static void main(String[] args) {

		Task task1 = new Task();
		task1.setStartDate(new Date());
		task1.setTaskTextString("Test tatsk");
		TaskDao.saveTask(task1);

		Task task = TaskDao.getTask(1);
		System.out.println(task.getTaskTextString());
		System.out.println(task.getStartDate());

	}

}
