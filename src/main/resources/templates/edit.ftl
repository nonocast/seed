<!doctype html>
<html lang="zh-cn">
<head>
    <title>edit</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="margin-top:30px;">
    <form class="form-horizontal" action="${uri}" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">Uri</label>
            <div class="col-sm-10">
                <p class="form-control-static">${uri}</p>
	            <input type="hidden" id="uri" value="${uri}">
            </div>
        </div>

	    <div class="form-group">
            <label class="col-sm-2 control-label">Content</label>
            <div class="col-sm-10">
                <textarea id="content" name="content" class="form-control" rows="20">${content!}</textarea>
            </div>
        </div>

	    <div class="form-group">
		    <label class="col-sm-2 control-label"></label>
		    <div class="col-sm-10">
                <button type="submit" class="btn btn-default">Save</button>
		    </div>
	    </div>
    </form>
</div>
</body>
</html>
