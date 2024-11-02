<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    * {
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
    }

    body {
        background-color: #747577;
    }

    h1 {
        margin: 80px auto;
        padding-top: 30px;
        font-size: 36px;
        width: 200px;
    }

    .container img {
        width: 300px;
        height: 300px;
        position: absolute;
        top: 203px;
        left: 530px;
        display: inline;
        box-shadow: -2px -2px 10px gray;
        box-shadow: 2px 2px 7px gray;
    }

    .container form {
        width: 300px;
        height: 300px;
        position: absolute;
        top: 203px;
        left: 830px;
        box-shadow: -2px -2px 10px gray;
        box-shadow: 2px 2px 7px gray;
        background-color: #c9c1c1;
    }

    /*NAME*/
    .container form .name {
        width: 40px;
        height: 30px;
        border: 2px solid darkblue;
        border-top-left-radius: 7px;
        border-bottom-left-radius: 7px;
        display: inline-block;
        margin-top: 50px;
        margin-left: 30px;
        padding: 5px;
    }

    .container form .icon-user {
        color: darkblue;
        font-size: 20px;
        position: relative;
        left: 5px;
        bottom: 2px;
    }

    .container form .inp-name {
        display: inline-block;
        width: 200px;
        height: 30px;
        position: relative;
        bottom: 3px;
        right:6px;
        border-top-right-radius: 7px;
        border-bottom-right-radius: 7px;
        border: 2px solid darkblue;
        font-size: 14px;
    }
    /*END NAME*/


    /*DESCRIPTION*/
    .container textarea {
        display: inline-block;
        width: 200px;
        height: 29px;
        position: relative;
        top: 14px;
        right:6px;
        border-top-right-radius: 7px;
        border-bottom-right-radius: 7px;
        border: 2px solid darkblue;
        font-size: 14px;
    }

    .container form .des {
        width: 40px;
        height: 30px;
        border: 2px solid darkblue;
        border-top-left-radius: 7px;
        border-bottom-left-radius: 7px;
        display: inline-block;
        margin-top: 20px;
        margin-left: 30px;
        position: relative;
        bottom: 0px;
    }

    .container form .icon-des {
        display: inline-block;
        position: relative;
        color: darkblue;
        top: 7px;
        left: 9px;
    }
    /*END DESCRIPTION*/

    .container button {
        border: 2px solid darkblue;
        color: darkblue;
        width: 80px;
        padding: 2px;
        border-radius: 10px;
        margin: 30px 100px;
    }
</style>
<head>
    <title>Role</title>
    <link rel="stylesheet" href="/bootstrap-5.3.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min. js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Department</h1>
<div class="container">
    <img src="/Image/department.png" alt="Description of image">

    <form action="">
        <div class="name">
            <span class="bi bi-person icon-user"></span>
        </div>
        <input type="text" name="name" placeholder="  Enter Your Name" class="inp-name">

        <div class="des">
            <span class="bi bi-chat-square icon-des"></span>
        </div>
        <textarea name="des" id="des" placeholder="  Description"></textarea>

        <button type="button">Submit</button>
    </form>
</div>
<script src="/bootstrap-5.3.0-dist/js/bootstrap.bundle.js"></script>
</body>
<script src="assets/js/jquery-3.7.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
</html>
