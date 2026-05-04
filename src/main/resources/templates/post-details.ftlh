<!DOCTYPE html>
<html>
<head>
    <title>${post.title}</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<nav><a href="/">← Back to Home</a></nav>

<article>
    <h1>${post.title}</h1>
    <div class="post-meta">Written by ${post.author.username} on ${post.createdAt}</div>
    <div style="margin-top: 20px;">
        ${post.content}
    </div>
</article>

<hr>
<h3>Comments</h3>
<#list post.comments as comment>
    <div class="comment-box">
        <strong>${comment.author.username}</strong>: ${comment.content}
    </div>
<#else>
    <p>No comments.</p>
</#list>

<div style="margin-top: 30px;">
    <h4>Add a Comment</h4>
    <form action="/posts/${post.id}/comments" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <textarea name="content" rows="3" required></textarea>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>