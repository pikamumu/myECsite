package com.internousdev.template.util2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//MySQLデータベースに接続するためのドライバーのクラス名を指定する
	private static String driverName = "com.mysql.jdbc.Driver";
	//データベースをあらわすURLを設定している
	//"jdbc:mysql://localhost/" + databasename;
	private static String url = "jdbc:mysql://localhost/ecsitehi";

	//データベースの接続に用いるユーザ名をrootユーザとしている
	private static String user = "root";
	//データベースの接続に用いるユーザのパスワードを指定している
	private static String password = "mysql";

	//     ↓戻り値の型　　↓自分でこれから作るメソッドの名前
	public Connection getConnection() {
	//接続を表すConnectionオブジェクトを初期化
		Connection con =null;

		try{
			//JDBCドライバを読み込み
            //引数は、データベースにアクセスするためのJDBCドライバのクラス名である。
			//             ↓ドライバーのクラス    //この一文で使えるようになる
			Class.forName(driverName);

			//データベースへ接続
			//DriverManagerクラスのgetCo　　nnectionメソッドを使ってデータベースに接続する。
			con = (Connection)DriverManager.getConnection(url,user,password);
												//↑JAVAに組み込まれているメソッド

		//JDBCドライバが見つからないときの処理
		}catch(ClassNotFoundException e){
				e.printStackTrace();

		//接続やSQL処理の失敗時の処理
		}catch(SQLException e){
			e.printStackTrace();
		}
		//処理の結果を表す戻り値//MySQLに接続できたか情報を渡す（取得したコネクションをDAOに渡す）
		return con;
	}
}
