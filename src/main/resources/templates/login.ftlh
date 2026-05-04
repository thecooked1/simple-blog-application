<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div style="max-width: 300px; margin: 100px auto;">
    <h1 style="text-align: center;">Login</h1>
    <#if RequestParameters.error??><p style="color: red; font-size: 0.8rem;">Invalid username/password.</p></#if>

    <form action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group">
            <label>Username</label>
            <input type="text" name="username" required>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required>
        </div>
        <button type="submit" style="width: 100%;">Log In</button>
    </form>
    <p style="text-align: center; margin-top: 20px;">
        No account? <a href="/register" style="color: #000;">Register</a>
    </p>
</div>
</body>
</html>