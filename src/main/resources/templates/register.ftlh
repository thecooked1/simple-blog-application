<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div style="max-width: 300px; margin: 80px auto;">
    <h1 style="text-align: center;">Register</h1>

    <form action="/register" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-group">
            <label>Username</label>
            <input type="text" name="userName" value="${(user.userName)!''}" required>
            <@spring.bind "user.userName" />
            <#list spring.status.errorMessages as error><small style="color:red">${error}</small></#list>
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" value="${(user.email)!''}" required>
            <@spring.bind "user.email" />
            <#list spring.status.errorMessages as error><small style="color:red">${error}</small></#list>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" required>
            <@spring.bind "user.password" />
            <#list spring.status.errorMessages as error><small style="color:red">${error}</small></#list>
        </div>

        <button type="submit" style="width: 100%;">Create Account</button>
    </form>
    <p style="text-align: center; margin-top: 20px;">
        Already registered? <a href="/login" style="color: #000;">Login</a>
    </p>
</div>
</body>
</html>