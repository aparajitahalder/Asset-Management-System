package dao;


import java.sql.SQLException;
import java.util.List;

import beans.Asset;

import Exceptions.AssetNotAddedException;
import Exceptions.AssetNotFoundException;

public interface AssetDaoIntf {
	
	public String addAsset(Asset a) throws SQLException, AssetNotAddedException;
	public List<Asset> displayAllAssets() throws AssetNotFoundException, SQLException;
	public List<Asset> getAssetByName(String name) throws AssetNotFoundException, SQLException;
	public List<Asset> getAssetByCategory(String categoryName) throws AssetNotFoundException, SQLException;
	public List<Asset> getAssetByDate(String date) throws AssetNotFoundException, SQLException;
	
		

}
