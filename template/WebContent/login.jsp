<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>Login画面</title>

	<style type="text/css">
/*========================TAG LAYOUT=====================================*/
	body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
			}

		table{
			text-align:center;
			margin:0 auto;
			}
			/*===============ID LAYOUT===================*/
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
			}

		#header{
			width:100%;
			height:80px;
			background-color:black;
			}

		#main{
			width:100%;
			height:500px;
			text-align:center;
			}

		#footer{
			width:100%;
			height:80px;
			background-color:black;
			/*横並びにさせない*/
			clear:both;
		}
	</style>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
		<!-- p=段落、改行される -->
			<p>Login</p>
		</div>
		<div>
			<h3>商品を購入する際にはログインをお願いします</h3>
			<!-- フォームの宣言。action属性で定義されたアクションへとフォームの内容を送信する。 -->
			<s:form action="LoginAction">
			<!-- テキスト入力フィールドの宣言。 -->
				<s:textfield name="loginUserId"/>
			<!-- パスワード入力フィールドの宣言。 -->
				<s:password name="loginPassword"/>
			<!-- 送信ボタンの宣言。 -->
				<s:submit value="ログイン"/>
			</s:form>
			<br/>
			<div>
			<!-- span=改行されない -->
				<span>新規ユーザー登録は
				<!-- a href=リンクの挿入改行されない -->
					<a href='<s:url action="UserCreateAction"/>'>こちら</a>
					</span>
					</div>
				</div>
			</div>
			<div id="footer">
			</div>

</body>
</html>