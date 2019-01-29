package com.internousdev.template.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.internousdev.template.dto2.MyPageDTO;
import com.internousdev.template.util2.DBConnector;

public class MyPageDAO {

	public MyPageDTO getMyPageUserInfo(String item_transaction_id,String user_master_id)throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		MyPageDTO myPageDTO = new MyPageDTO();
		//ubit=user_buy_item_transactionの略
		String sql = "SELECT iit.item_name, ubit.total_price, ubit.total_count, ubit.pay FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.item_transaction_id = ? AND ubit.user_master_id = ? ORDER BY ubit.insert_date DESC";

	try{
		//SQLに送信する
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, item_transaction_id);
		preparedStatement.setString(2,user_master_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		//結果表の取り出し対象レコードを一つ進める
		if(resultSet.next()){
			myPageDTO.setItemName(resultSet.getString("item_name"));
			myPageDTO.setTotalPrice(resultSet.getString("total_price"));
			myPageDTO.setTotalCount(resultSet.getString("total_count"));
			myPageDTO.setPayment(resultSet.getString("pay"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	return myPageDTO;
	}


	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
//dbのテーブルから情報を削除する
		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";
		PreparedStatement preparedStatement;
		int result =0;
		try{

			//SQLに送信する
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);
//executeUpdate()で情報を更新する
			result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;
	}

}
