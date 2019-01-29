package com.internousdev.template.dao2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.template.dto2.LoginDTO;
import com.internousdev.template.util2.DBConnector;

public class LoginDAO {

//DTO型LoginDTOを使ってデータを格納する	メソッド　引数①			引数②
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

	//		型			変数		メソッドをインスタンス化する
		DBConnector dbConnector = new DBConnector();

		//Connectionを生成　
	//				変数　			//Connectionをつくってつなげるよ
		Connection connection = dbConnector.getConnection();
	//  	型		変数		データを入れるためLoginDTOを使うよ
		LoginDTO loginDTO = new LoginDTO();
		//															①				②
		String sql ="SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try{
			//PreparedStatement＝上の文の？に何を入れるかのツール//SQLの送信を行う
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

		//									①
			preparedStatement.setString(1, loginUserId);

		//									②
			preparedStatement.setString(2, loginPassword);

		// 	ResultSet=実行して得た値（戻り値）ResultSet＝DBから検索結果を受け取る		exectuteQuery()=sqlを実行
			ResultSet resultSet = preparedStatement.executeQuery();

			//結果表の取り出し対象レコードを一つ進める
			if(resultSet.next()){

			//取り出し対象のレコードの各列の値を取得する
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));


			//Resultsetの結果が正しく書かれていたら
				if(!(resultSet.getString("login_id").equals(null))){

			//LoginFlg(true)=ログイン状態で有ることを示す
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.getMessage();
		}

		//このクラスにいるloginDTO
		return loginDTO;
	}

}
