package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BikeTire;

public class BikeTireDAOImpl implements BikeTireDAO  {
	DaoManager dao;
	Connection conn;
	public BikeTireDAOImpl() throws Exception {
		
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
	public List<BikeTire> findAll() {
		
		List<BikeTire> list = new ArrayList<>();
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

	private BikeTire processRow(ResultSet rs) {
			int id;
			BikeTire tire = null;
			try {
				id = rs.getInt(1);
				String vendor = rs.getString(2);
				String tireName = rs.getString(3);
				int size = rs.getInt(4);
				int cost = rs.getInt(5);
				tire = new beans.BikeTire(id,vendor,tireName,size,cost);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return tire;
//			System.out.println(String.format("ID: %1d, Name: %1s", rs.getInt(1), rs.getString(2)));
	}

	@Override
	public List<BikeTire> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BikeTire> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBikeTire(BikeTire tire) {
		
		
		try {

			PreparedStatement stmt = conn.prepareStatement("insert into tire "
					+ "(id, tire_vendor, tire_name, tire_manufacturer, country_of_origin, width_cm, cost, tire_weight)" 
					+ "values (NEXT VALUE FOR tireseq, ?, ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, tire.getMake());
			stmt.setString(2, tire.getModel());
			stmt.setString(3, tire.getManufacturer());
			stmt.setString(4, tire.getCountryOfOrigin());
			stmt.setInt(5, tire.getSize());
			stmt.setInt(6,tire.getPrice());
			stmt.setInt(7, tire.getWeight());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dao.cleanupConn(conn);
		return true;
	}

	@Override
	public boolean updateBikeTire(BikeTire bikeTire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBikeTire(BikeTire bikeTire) {
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
	
	public List<BikeTire> findByLike(String searchString) {
		List<BikeTire> list = new ArrayList<>();
		
		try {
			Connection conn = dao.getConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from tire where tire_name like '%" + searchString + "%'");  
            while (rs.next()) {
                list.add(processRow(rs));
            }
            dao.cleanup(conn, rs);
            
            return list;
           } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e); 
           }
		
		}

}
