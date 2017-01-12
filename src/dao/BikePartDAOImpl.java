package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BikePart;

public class BikePartDAOImpl implements BikePartDAO  {
	DaoManager dao;
	Connection conn;
	public BikePartDAOImpl() throws Exception {
		
		super();
		dao = new DaoManager();
		try {
			conn = dao.getConnection();
			System.out.println("Created conn");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<BikePart> findAll() {
		List<BikePart> list = new ArrayList<>();
        try { 
             Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery("select * from tire"); 
            while (rs.next()) {
                list.add(processRow(rs));
            }
            dao.cleanup(conn, rs);
            
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e); 
        }
	}

	private BikePart processRow(ResultSet rs) {
			int id;
			BikePart part = null;
			try {
				id = rs.getInt(1);
				String vendor = rs.getString(2);
				String tireName = rs.getString(3);
				int size = rs.getInt(4);
				int cost = rs.getInt(5);
				part = new beans.BikePart(id,vendor,tireName,size,cost);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return part;
//			System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
	}

	@Override
	public List<BikePart> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BikePart> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBikePart(BikePart part) {
		
		
		try {

			PreparedStatement stmt = conn.prepareStatement("insert into tire "
					+ "(id, tire_vendor, tire_name, tire_manufacturer, country_of_origin, width_cm, cost, tire_weight)" 
					+ "values (NEXT VALUE FOR tireseq, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, part.getMake());
			stmt.setString(2, part.getModel());
			stmt.setString(3, part.getManufacturer());
			stmt.setString(4, part.getCountryOfOrigin());
			stmt.setInt(5, part.getSize());
			stmt.setInt(6,part.getPrice());
			stmt.setInt(7, part.getWeight());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.cleanupConn(conn);
		return true;
	}

	@Override
	public boolean updateBikePart(BikePart bikePart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBikePart(BikePart bikePart) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean deleteByID(int id){
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from tire where id = ?");
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		//dao.cleanupConn(conn);
		return true;
	}
	
	public List<BikePart> findByLike(String searchString) {
		List<BikePart> list = new ArrayList<>();
		
		try {
			Connection conn = dao.getConnection();
            Statement s = conn.createStatement();
            String query = "select * from tire where tire_name like '%" + searchString + "%'";
            System.out.println(query);
            System.out.println("=================================================");
            
            ResultSet rs = s.executeQuery(query);
            
            while (rs.next()) {
                list.add(processRow(rs));
            }
            dao.cleanup(conn, rs);
            
            return list;
           } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e); 
           }
		
		}


	public BikePart findByID(String partId) {
		BikePart part = null;
		int id = Integer.parseInt(partId);
		try { 
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from tire where id= " + id); 
           if (rs.next()){
        	   part = processRow(rs);
           }
           dao.cleanup(conn, rs);
           
           return part;
       } catch (SQLException e) {
           throw new RuntimeException(e.getMessage(), e); 
       }
	}

}
