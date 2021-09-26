package com.demo.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Asset;
import com.demo.dao.assetDao.AsssetDaoImpl;
import com.demo.exceptions.assetExceptions.AssetNotAddedException;
import com.demo.exceptions.assetExceptions.AssetNotFoundException;
import com.demo.service.assetService.AssetInterfaceImpl;



public class TestAssetDao {
	
	public static void main(String[] args)  {
		AssetDaoImpl dao=new AssetDaoImpl();
		AssetInterfaceImpl service=new AssetInterfaceImpl();
//		Asset a=new Asset("Hp","Laptop","Its an HP laptop",LocalDate.of(2021,9,21),true,14,25,10);
//		
//		
//		Asset a2=new Asset("Hp","Laptop","Its an HP laptop",LocalDate.of(2021,9,22),true,14,25,10);
//		
//		
//		Asset a3=new Asset("Dell","Laptop","Its an dell laptop",LocalDate.of(2021,9,21),true,14,25,10);
//		
//		Asset a4=new Asset("Lenevo","Laptop","Its an dell laptop",LocalDate.of(2021,9,22),true,14,25,10);
//		Asset a6=new Asset("Apple","Laptop","Its an apple laptop",LocalDate.of(2021,9,22),false,14,25,10);
//		
//
//		
//		
//		
//		Asset a5=new Asset("Core Java","Book","about java",LocalDate.of(2021,9,12),true,14,25,10);
		Asset a6=new Asset("Python","Book","about python",LocalDate.of(2021,9,12),true,14,25,10);
		//To add asset
		
			try {
//				dao.addAsset(a);
//				dao.addAsset(a2);
//				dao.addAsset(a3);
//				dao.addAsset(a4);
//				dao.addAsset(a5);
				service.addAsset(a6);
				
			} catch (AssetNotAddedException e) {
				System.out.println("Exception:  "+ e.getMessage());
			}
		 catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		System.out.println("\n\n");
		
		
//------------------------------------------------------------------------------------------------------------		
		
		
		//to get assets by given date
		
		//successfull retreival
		System.out.println("Assets by Date");
		List<Asset> adate=new ArrayList<>();
		try {
			adate = service.searchAssetByDate("2021-09-22");
		} catch (AssetNotFoundException e) {
			System.out.println("Exception:  "+ e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			for(Asset asset : adate)
			System.out.println(asset);
		System.out.println("\n\n");
		
		//Insuccessfull retreival ie if no asset was added on that date
				List<Asset> adates=new ArrayList<>();
				try {
					adates = service.searchAssetByDate("2020-09-22");
				} catch (AssetNotFoundException e) {
					System.out.println("Exception:  "+ e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					for(Asset asset : adates)
					System.out.println(asset);
				System.out.println("\n\n");
		
		
//------------------------------------------------------------------------------------------------------------			
		
		
		

		//to get assets by given name
				//successfull retreival
				System.out.println("Assets by Name");
				List<Asset> aname=new ArrayList<>();
				try {
					aname = service.searchAssetByName("Lenevo");
				} catch (AssetNotFoundException e) {
					System.out.println("Exception:  "+ e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(Asset asset : aname)
					System.out.println(asset);
				System.out.println("\n\n");
				
				//Insuccessfull retreival
				List<Asset> anames=new ArrayList<>();
				try {
					anames = service.searchAssetByName("Apple");
				} catch (AssetNotFoundException e) {
					System.out.println("Exception:  "+ e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(Asset asset : anames)
					System.out.println(asset);
				System.out.println("\n\n");
				
//-------------------------------------------------------------------------------------------------------------				
		
				//to get assets by given category
				//successfull retreival
				System.out.println("Assets by Category");
				List<Asset> acategory=new ArrayList<>();
				try {
					acategory = service.searchAssetByCategory("Laptop");
				} catch (AssetNotFoundException e) {
					System.out.println("Exception:  "+ e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(Asset asset : acategory)
					System.out.println(asset);
				
				//Insuccessfull retreival
				List<Asset> acategorys=new ArrayList<>();
				try {
					acategorys = service.searchAssetByCategory("Laptop");
				} catch (AssetNotFoundException e) {
					System.out.println("Exception:  "+ e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(Asset asset : acategorys)
					System.out.println(asset);
				
//--------------------------------------------------------------------------------------------------------------		
		
	}

}
