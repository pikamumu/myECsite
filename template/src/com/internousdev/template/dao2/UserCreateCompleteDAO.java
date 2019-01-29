package com.internousdev.template.dao2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.internousdev.template.util2.DBConnector;
import com.internousdev.template.util2.DateUtil;

public class UserCreateCompleteDAO {
	//インスタンス化
	private DateUtil dateUtil = new DateUtil();

	private String sql = "INSERT INTO login_user_transaction(login_id,login_pass,user_name,insert_date)VALUES(?,?,?,?)";
//throws SQLExceptionデータベースに関するラー情報を提供する
	public void createUser(String loginUserId,String loginUserPassword,String userName)throws SQLException{

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
		//dateUtilに日付(Dateメッソド)を取得する
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){


			e.printStackTrace();
		}finally{

		 //Connectionオブジェクトを閉じる
			connection.close();
		}


	}

}
