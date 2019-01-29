package com.internousdev.template.action2;
/*libに入っているstruts2-core-2.3.36.jarのActionSupportclassをインポート*/
import com.opensymphony.xwork2.ActionSupport;
/*HomeActionクラスが親クラスを継承*/
public class HomeAction extends ActionSupport{
/*executeメソッドがSUCCESSの場合struts.xmlに渡してSUCCESS画面を写す*/
	public String execute(){
		return SUCCESS;
	}

}
