<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			// json的定义
			var jsonObject={
				"key1":1,
				"key2":[1,"aa",{"key2_1":2}],
				"key3":{"key3_1":"kee" }
			};
			// json的访问
			alert(jsonObject.key2[2].key2_1);
			// json对象转字符串
			var jsonStr=JSON.stringify(jsonObject);
			alert(jsonStr);
			// json字符串转json对象
			var jsonObject2=JSON.parse(jsonStr);
		</script>
	</head>
	<body>
		
	</body>
</html>