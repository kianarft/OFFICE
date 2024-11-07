<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/bootstrap-5.3.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min. js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        /**{*/
        /*    margin: 0px;*/
        /*    padding: 0px;*/
        /*    box-sizing: border-box;*/
        /*}*/

        body {
            background-image: url(Image/Bg.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        }

        .login-form {
            width: 450px;
            height: 350px;
            background-color: white;
            margin: 150px auto;
            border-radius: 30px;
            filter: opacity(60%);
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.912) , -2px -2px 5px rgba(255, 255, 255, 0.507);
        }

        .div-icon {
            width: 130px;
            height: 130px;
            border-radius: 50%;
            background-color: rgb(12, 12, 83);
            position: absolute;
            top: 80px;
            left: 700px;
        }

        .div-icon .user-icon {
            color: white;
            font-size: 75px;
            position: relative;
            left: 25px;
            top: 30px;
        }

        .formform {
            width: 450px;
            height: 400px;
            background-color: rgba(255, 255, 255, 0);
            position: absolute;
            top: 150px;
            left: 543px;
            border-radius: 20px;
        }

        .formform .email {
            width: 45px;
            height: 40px;
            background-color: rgb(12, 12, 83);
            border-top-left-radius: 7px;
            border-bottom-left-radius: 7px;
            display: inline-block;
            margin-top: 120px;
            margin-left: 50px;
        }

        .formform .icon {
            color: white;
            font-size: 20px;
            position: relative;
            left: 13px;
            top: 12px;
        }

        .formform .inp-email,
        .formform .inp-pass {
            display: inline-block;
            width: 300px;
            height: 40px;
            position: relative;
            top: 8px;
            right: 4px;
            border-top-right-radius: 7px;
            border-bottom-right-radius: 7px;
            border: none;
            font-size: 14px;
        }

        .formform .pass {
            width: 45px;
            height: 40px;
            background-color: rgb(12, 12, 83);
            border-top-left-radius: 7px;
            border-bottom-left-radius: 7px;
            display: inline-block;
            margin-top: 30px;
            margin-left: 50px;
        }

        .formform #rembr {
            /* display: block; */
            margin: 50px;
        }

        .formform p {
            display: inline-block;
            position: relative;
            right: 50px;
            bottom: 2px;
            color: rgb(90, 88, 88);
            font-size: 15px;
        }

        .formform a {
            font-size: 14px;
            text-decoration: none;
            margin-left: 60px;
        }

        .sign-up {
            width: 330px;
            height: 40px;
            background-color: white;
            position: absolute;
            top: 500px;
            left: 593px;
            border-bottom-left-radius: 30px;
            border-bottom-right-radius: 30px;
            filter: opacity(60%);
            box-shadow: -1px -1px 5px rgba(255, 255, 255, 0.507);
        }

        .sign-up .sign-lnk {
            text-decoration: none;
            margin-left: 140px;
            cursor: pointer;
            color: rgb(81, 81, 207);
            font-size: 15px;
            font-weight: bold;
            position: relative;
            top: 5px;
        }
    </style>
</head>
<body>
<div class="login-form"></div>

<div class="div-icon">
    <span class="bi bi-person user-icon"></span>
</div>

<form action="" class="formform">
    <div class="email">
        <span class="bi bi-envelope icon"></span>
    </div>
    <input type="email" name="email" id="" placeholder="  Enter Your Email" class="inp-email">

    <div class="pass">
        <span class="bi bi-key icon"></span>
    </div>
    <input type="password" name="password" id="" placeholder="  Enter Your Password" class="inp-pass">

    <input type="checkbox" name="remember" id="rembr">
    <p>Remember me</p>

    <a href="">Forgot Password ?</a>
</form>

<div class="sign-up">
    <a href="./Sign-up.jsp" class="sign-lnk">Sign Up</a>
</div>
<script src="/bootstrap-5.3.0-dist/js/bootstrap.bundle.js"></script>
</body>
</html>
