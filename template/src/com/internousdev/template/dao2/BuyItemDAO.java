package com.internousdev.template.dao2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.template.dto2.BuyItemDTO;
import com.internousdev.template.util2.DBConnector;

public class BuyItemDAO {

	public BuyItemDTO getBuyItemInfo(){

		//メソッドをインスタンス化する
		DBConnector dbConnector = new DBConnector();

		//Connectioを作りつなげる
		Connection connection = dbConnector.getConnection();

		//データを入れるためのBuyItemDTOを作り、使う
		BuyItemDTO buyItemDTO = new BuyItemDTO();

		String sql = "SELECT id,item_name,item_price FROM item_info_transaction";

		try{
		//上の？に何を入れるかのツール
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

		//executeQueryメソッドを実行する、実行したものの戻り値(ResultSet)
			ResultSet resultSet = preparedStatement.executeQuery();

		//next()で特定の要素に合致した場合のみ取得する
			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}

		//例外が発生した場合の処理
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTO;
	}

}
