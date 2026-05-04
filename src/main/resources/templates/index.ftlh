<!DOCTYPE html>
<html>
<head>
    <title>Simple Blog</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav>
    <a href="/">Home</a>
    <a href="/posts/new">New Post</a>
    <form action="/logout" method="post" style="display:inline;">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" style="padding:2px 5px; margin:0;">Logout</button>
    </form>
</nav>

<h1>Latest Posts</h1>

<#list posts as post>
    <div class="post-entry">
        <h2><a href="/posts/${post.id}">${post.title}</a></h2>
        <div class="post-meta">
            By ${post.author.username} | ${post.createdAt}
        </div>
        <p>${post.content?truncate(200, "...")}</p>
    </div>
<#else>
    <p>There are no posts yet.</p>
</#list>
</body>
</html>