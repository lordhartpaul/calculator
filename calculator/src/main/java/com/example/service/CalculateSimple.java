package com.example.service;

import com.example.model.OperationModel;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CalculateSimple {
	
	JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
  
	
	
    public int add(OperationModel model){
    	
    	String sql = "insert into calculator(a,b) values ("+model.getA()+","+model.getB()+")";
       	
	    template.update(sql);
	    
    	
        return model.getA() + model.getB();
    }

    public int subtract(OperationModel model){
        return model.getA() - model.getB();
    }

    public int multiply(OperationModel model){
        return model.getA() * model.getB();
    }

    public double divide(OperationModel model){
        if(model.getA() == 0) return 0;
        if(model.getB() == 0) return 0;
        return (double) model.getA() / model.getB();
    }

   public OperationModel clearSimple(OperationModel model){
        model.setA(0);
        model.setB(0);
        return model;
    }

}
