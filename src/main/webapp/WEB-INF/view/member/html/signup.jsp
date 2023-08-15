<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>7DAYS Signup</title>
    <link rel="stylesheet" type="text/css" href="/WEB-INF/view/member/css/signup.css">
    <link rel="icon" href="http://localhost:8888/images/favicon.jpg">
</head>
<body>
<img src="/images/logo.jpg" alt="">
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="#">
            <h1>Information</h1>
            <input type="text" placeholder="Id"/>
            <input type="password" placeholder="Password"/>
            <input type="number" placeholder="Phone Number"/>
            <input type="text" placeholder="Address"/>
            <button>Sign up</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome!</h1>
                <p>7DAYS에서<br/><br/>공부를 시작해요!</p>
                <button class="ghost" id="signUp">Log in</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>