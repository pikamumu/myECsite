package com.internousdev.template.action2;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.template.dao2.BuyItemDAO;
import com.internousdev.template.dao2.LoginDAO;
import com.internousdev.template.dto2.BuyItemDTO;
import com.internousdev.template.dto2.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
												//①
public class LoginAction extends ActionSupport implements SessionAware{


	private String loginUserId;
	private String loginPassword;
	private String result;
	//②
	private Map<String,Object> session;


	//executeメソッドを定義する
	public String execute(){

	//インスタンス化
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = new LoginDTO();
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		//もとはERROR処理
		result = ERROR;
		//DBの情報を取得したloginDAOからIDとPASSを受け取る
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		//Map型にして要素を追加 //key(名前)loginUser value(内容)lognDTO カンマ区切り
		session.put("loginUser", loginDTO);


		//条件に合えばSUCCESS
		//入力したユーザーがログイン状態ならば（Flgはどこから？→LoginDAOクラスにあるインスタンスloginDTO）
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

		//session.put()で要素を追加する
		//①はお客様側から、②③④はDBのテーブル情報から
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());


		}
		//execute()の戻り値→struts.xmlへ
		return result;
	}

	//お客様の入力情報を保持する
	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	//↑だけだと次の画面に受け継がれないのでsessionにして続けられるようにする
	//③

	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}

//sessionを使う条件
	//①SessionAwareを実装する
	//②Map型を定義する
	//③sessionのgetter,setterを書く
