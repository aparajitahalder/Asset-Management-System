package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import beans.Asset;
import beans.User;
import Exceptions.AssetNotFoundException;
import Exceptions.AssetNotAddedException;
import Exceptions.AssetNotFoundException;
import Exceptions.AssetNotAddedException;
public interface AssetInterface {
	
	// method that will enable admin to add asset
	public String addAsset(Asset a) throws SQLException,AssetNotAddedException;
	
	// method that will search an IT asset by name
	public List<Asset> searchAssetByName(String name) throws AssetNotFoundException, SQLException;
	
	// method that will search an IT asset by date
	public List<Asset> searchAssetByDate(String date) throws AssetNotFoundException, SQLException;
	
	// method that will search an It asset by category
	public List<Asset> searchAssetByCategory(String category) throws AssetNotFoundException, SQLException;
	// method to getAllAssets 
	public List<Asset> getAllAssets() throws AssetNotFoundException, SQLException;
	
	
}
