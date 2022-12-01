<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css" /> -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title></title>
</head>
<body>
<h1>迷路脱出ゲーム</h1>
<p>ルール説明</p>
<ul>
	<li>1.迷路の大きさを選びます。数値入力も可能です（※5以上の奇数で入力してください）</li>
	<li>2.矢印ボタンをクリックし、迷路を進んでいきます。</li>
	<li>3.ゴールにたどり着いたらクリアです。ハイスコアを目指してみましょう。</li>
</ul>
<form action="/Maze/IndexServlet" method="post">
	<label for="small"><input id="small" type="radio" name="size" value="1"/>ちいさめ</label>
	<label for="medium"><input id="medium" type="radio" name="size" value="2"/>ふつう</label>
	<label for="large"><input id="large" type="radio" name="size" value="3"/>おおきめ</label>
	<p>サイズを細かく決める</p>
	タテ：<input type="number" name="height" />ヨコ：<input type="number" name="width" />
	<input type="submit" value="このサイズにする！"/>
	<p>${error}</p>
</form>
</body>
</html>