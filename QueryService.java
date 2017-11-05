package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryService {
	
	private ArrayList<Model>models = new ArrayList<Model>();
	
	public ArrayList<Model> getModel(Connection connection){
		if(connection == null){
			return null;
		}else{
			try {
				PreparedStatement preparedStatment = connection.prepareStatement("Select * from DWH");
				ResultSet resultSet = preparedStatment.executeQuery();
				while(resultSet.next()){
					int id = resultSet.getInt(1);
					String task = resultSet.getString(2);
					String input = resultSet.getString(3);
					String output = resultSet.getString(4);
					Model model = new Model(id,task,input,output);
					models.add(model);
				}
				connection.close();
				return models;
			} catch (SQLException e) {
				System.out.println(e.toString());
				return null;
			}
		}
	}

}
