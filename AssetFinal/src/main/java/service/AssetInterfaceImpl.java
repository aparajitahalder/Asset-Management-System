package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import beans.Asset;
import beans.User;

import dao.AssetDaoIntf;
import dao.AssetDaoImpl;
import Exceptions.AssetNotAddedException;
import Exceptions.AssetNotFoundException;

public class AssetInterfaceImpl implements AssetInterface {
	
	AssetDaoIntf dao;
	     public  AssetInterfaceImpl(){
	    	   dao=new AssetDaoImpl();
	       }

	@Override
	public String addAsset(Asset a) throws SQLException,AssetNotAddedException {
		String status=dao.addAsset(a);
		return status;
	}

	@Override
	public List<Asset> searchAssetByName(String name) throws AssetNotFoundException, SQLException {
		List<Asset> a=dao.getAssetByName(name);
		return a;
		
	}

	@Override
	public List<Asset> searchAssetByDate(String date) throws AssetNotFoundException, SQLException {
		List<Asset> a=dao.getAssetByDate(date);
		return a;
	}

	@Override
	public List<Asset> searchAssetByCategory(String category) throws AssetNotFoundException, SQLException {
		List<Asset> a=dao.getAssetByCategory(category);
		return a;
	}

	

	@Override
	public List<Asset> getAllAssets() throws AssetNotFoundException, SQLException {
		List<Asset> assets=dao.displayAllAssets();
		return assets;
	}
}
