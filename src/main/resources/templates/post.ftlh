<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Post</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<header>
    <a href="/" class="logo">SimpleBlog</a>
    <nav><a href="/">Cancel</a></nav>
</header>

<h1>New Post</h1>
<form action="/posts" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <label>Title</label>
        <input type="text" name="title" required>
    </div>

    <div class="form-group">
        <label>Category</label>
        <select name="categoryIds" multiple style="height: 80px;">
            <#list allCategories as cat>
                <option value="${cat.id}">${cat.name}</option>
            </#list>
        </select>
    </div>

    <div class="form-group">
        <label>Content</label>
        <textarea name="content" rows="10" required></textarea>
    </div>

    <button type="submit">Publish</button>
</form>
</body>
</html>