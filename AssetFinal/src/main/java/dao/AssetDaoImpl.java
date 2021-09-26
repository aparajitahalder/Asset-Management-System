package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import beans.Asset;
import beans.User;
import dao.DBUtil;
import Exceptions.AssetNotAddedException;
import Exceptions.AssetNotFoundException;

/* 
 * when you call add method from service class convert the date into LocalDate n pass it in this format
 * LocalDate.of(YYYY/MM/DD)
 * i.e create Asset obj as
 * new Asset("Lenevo","Laptop","Its an dell laptop",LocalDate.of(2021,9,12),1,14,25,10);
 * */

public class AssetDaoImpl implements AssetDaoIntf {

	static Connection conn=null;
	static PreparedStatement pinsert;
	static PreparedStatement pselectCategory;
	static PreparedStatement pselectName;
	static PreparedStatement pselectAll;
	static PreparedStatement pselectDate;
	
	static {
		
		try {
			conn = DBUtil.getConnConnection();
			pinsert=conn.prepareStatement("Insert into Asset ( assetName,assetType,assetDescription,assetDateAdded,assetAvailability,assetLendingPeriod,"
					+ "assetLateReturnFee,assetBannedDays) values(?,?,?,?,?,?,?,?)");
			pselectAll=conn.prepareStatement("Select * from Asset");
			pselectName=conn.prepareStatement("Select * from Asset where assetName=?");
			pselectCategory=conn.prepareStatement("Select * from Asset where assetType=?");
			pselectDate=conn.prepareStatement("Select * from Asset where assetDateAdded=?");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	// for adding asset
	@Override
	public  String addAsset(Asset a) throws SQLException, AssetNotAddedException {

		//used LocalDate to create the date in asset class
		// for database java.sql.date is used
		Date date = Date.valueOf(a.getAssetDateAdded());
		String s=null;
           
			pinsert.setString(2, a.getAssetName());
			pinsert.setString(3, a.getAssetType());
			pinsert.setString(4, a.getAssetDescription());
			
			
			
			pinsert.setDate(5,date);
			pinsert.setBoolean(6, a.getAssetAvailable());
			pinsert.setInt(7, a.getAssetLendingPeriod());
			pinsert.setFloat(8, a.getAssetLateReturnFee());
			pinsert.setInt(9, a.getAssetBannedDays());

			int i = pinsert.executeUpdate();

			if (i > 0) {
				s="Insert Successfull";
				}
			else 
				throw new AssetNotAddedException("Asset not added ,TRY AGAIN!!!");

			return s;

	}

	// for displaying all the assets
	public List<Asset> displayAllAssets() throws AssetNotFoundException, SQLException {

		List<Asset> alist = new ArrayList<>();
		Asset a = null;

		
		ResultSet rs = null;

		
		
			rs = pselectAll.executeQuery();
			if (rs.next()) {
				LocalDate date=rs.getDate(5).toLocalDate();
				a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getBoolean(6),
						rs.getInt(7), rs.getInt(8), rs.getInt(9));
				alist.add(a);
				while (rs.next()) {
					a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getBoolean(6),
							rs.getInt(7), rs.getInt(8), rs.getInt(9));
					alist.add(a);

				}
			} else
				throw new AssetNotFoundException("There are no assets available");

	
		return alist;

	}

	// getting assets by name
	public List<Asset> getAssetByName(String name) throws AssetNotFoundException, SQLException {

		
		List<Asset> alist = new ArrayList<>();
		ResultSet rs = null;
		Asset a = null;
		
		pselectName.setString(1, name);
			rs = pselectName.executeQuery();
			if (rs.next()) {
				LocalDate date=rs.getDate(5).toLocalDate();
				a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getBoolean(6),
						rs.getInt(7), rs.getInt(8), rs.getInt(9));
				alist.add(a);
				while (rs.next()) {

					a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getBoolean(6),
							rs.getInt(7), rs.getInt(8), rs.getInt(9));
					alist.add(a);
				}
			} else
				throw new AssetNotFoundException("No Assets available ");


		return alist;

	}

	// getting assets by category
	public List<Asset> getAssetByCategory(String categoryName) throws AssetNotFoundException, SQLException {

		
		
		List<Asset> alist = new ArrayList<>();
		Asset a = null;
		ResultSet rs = null;
		
		pselectCategory.setString(1, categoryName);
			rs = pselectCategory.executeQuery();
			if (rs.next()) {
				LocalDate date=rs.getDate(5).toLocalDate();
				a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getBoolean(6),
						rs.getInt(7), rs.getInt(8), rs.getInt(9));
				alist.add(a);
				while (rs.next()) {

					a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getBoolean(6),
							rs.getInt(7), rs.getInt(8), rs.getInt(9));
					alist.add(a);
				}
			} else
				throw new AssetNotFoundException("No Asset found in this Category");

		

		return alist;

	}

//getting assets by date
	public List<Asset> getAssetByDate(String date) throws AssetNotFoundException, SQLException {

		
		List<Asset> alist = new ArrayList<>();
		Asset a = null;
		ResultSet rs = null;
	
		pselectDate.setString(1, date);
			rs = pselectDate.executeQuery();
			if (rs.next()) {
				LocalDate objdate=rs.getDate(5).toLocalDate();
				a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4), objdate, rs.getBoolean(6),
						rs.getInt(7), rs.getInt(8), rs.getInt(9));
				alist.add(a);
				while (rs.next()) {

					a = new Asset(rs.getString(2), rs.getString(3), rs.getString(4),objdate, rs.getBoolean(6),
							rs.getInt(7), rs.getInt(8), rs.getInt(9));
					alist.add(a);
				}
			} else
				throw new AssetNotFoundException("No assets were added on this date");

		

		return alist;

	}

	
	

}
