package com.tyss.crudproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class StudentDAO {

	public static Connection getConnection(){  
		Connection con=null;  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			String dburl="jdbc:mysql://localhost:3306/cg_db";
			con=DriverManager.getConnection(dburl, "root","root");  
		}catch(Exception e){System.out.println(e);}  
		return con;  
	}  	
	public static int save(Student e){  
		int status=0;  
		try{  
			Connection con=StudentDAO.getConnection();  
			PreparedStatement ps=con.prepareStatement(  
					"insert into assignment_db(name,password,email,country) values (?,?,?,?)");  
			ps.setString(1,e.getName());  
			ps.setString(2,e.getPassword());  
			ps.setString(3,e.getEmail());  
			ps.setString(4,e.getCountry());  
			status=ps.executeUpdate();  
			              
			            con.close();  
			        }catch(Exception ex){ex.printStackTrace();}  
			          
			        return status;  
			    }  
			    public static int update(Student e){  
			        int status=0;  
			        try{  
			            Connection con=StudentDAO.getConnection();  
			            PreparedStatement ps=con.prepareStatement(  
			                         "update into assignment_db set name=?,password=?,email=?,country=? where id=?");  
			            ps.setString(1,e.getName());  
			            ps.setString(2,e.getPassword());  
			            ps.setString(3,e.getEmail());  
			            ps.setString(4,e.getCountry());  
			            ps.setInt(5,e.getId());  
			status=ps.executeUpdate();  
			              
			            con.close();  
			        }catch(Exception ex){ex.printStackTrace();}  
			          
			        return status;  
			    }  
			    public static int delete(int id){  
			        int status=0;  
			        try{  
			            Connection con=StudentDAO.getConnection();  
			            PreparedStatement ps=con.prepareStatement("delete from into assignment_db where id=?");  
			            ps.setInt(1,id);  
			            status=ps.executeUpdate();  
			              
			            con.close(); 
			}catch(Exception e){e.printStackTrace();}  
			          
			        return status;  
			    }  
			    public static Student getEmployeeById(int id){  
			        Student e=new Student();  
			          
			        try{  
			            Connection con=StudentDAO.getConnection();  
			            PreparedStatement ps=con.prepareStatement("select * from into assignment_db where id=?");  
			            ps.setInt(1,id);  
			            ResultSet rs=ps.executeQuery();  
			            if(rs.next()){  
			                e.setId(rs.getInt(1));  
			                e.setName(rs.getString(2));  
			                e.setPassword(rs.getString(3));  
			                e.setEmail(rs.getString(4));  
			                e.setCountry(rs.getString(5));  
			            } 
			con.close();  
			        }catch(Exception ex){ex.printStackTrace();}  
			          
			        return e;  
			    }  
			    public static List<Student> getAllEmployees(){  
			        List<Student> list=new ArrayList<Student>();  
			        
			 try{  
				            Connection con=StudentDAO.getConnection();  
				            PreparedStatement ps=con.prepareStatement("select * from into assignment_db");  
				            ResultSet rs=ps.executeQuery();  
				            while(rs.next()){  
				            	Student s=new Student();
				                s.setId(rs.getInt(1));  
				                s.setName(rs.getString(2));  
				                s.setPassword(rs.getString(3));  
				                s.setEmail(rs.getString(4));  
				                s.setCountry(rs.getString(5));  
				                list.add(s);  
				            }  
				            con.close();  
				       }catch(Exception e){e.printStackTrace();}  
			           
				         return list;  
				     }  

		}
