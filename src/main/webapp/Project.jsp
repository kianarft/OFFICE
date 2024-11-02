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

    .container form .icon-name {
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

    /*START DATE*/
    .container form .time-start {
        width: 40px;
        height: 30px;
        border: 2px solid darkblue;
        border-top-left-radius: 7px;
        border-bottom-left-radius: 7px;
        display: inline-block;
        margin-top: 30px;
        margin-left: 30px;
        padding: 5px;
    }

    .container form .icon-start-date {
        color: darkblue;
        font-size: 20px;
        position: relative;
        left: 5px;
        bottom: 2px;
    }

    .container form .inp-start-date {
        display: inline-block;
        width: 200px;
        height: 30px;
        position: relative;
        bottom: 4px;
        right:6px;
        border-top-right-radius: 7px;
        border-bottom-right-radius: 7px;
        border: 2px solid darkblue;
        font-size: 14px;
    }
    /*END DATE*/

    /*TIME*/
    .container form .time-end {
        width: 40px;
        height: 30px;
        border: 2px solid darkblue;
        border-top-left-radius: 7px;
        border-bottom-left-radius: 7px;
        display: inline-block;
        margin-top: 30px;
        margin-left: 30px;
        padding: 5px;
    }

    .container form .icon-date-end {
        color: darkblue;
        font-size: 20px;
        position: relative;
        left: 5px;
        bottom: 2px;
    }

    .container form .inp-date-end {
        display: inline-block;
        width: 200px;
        height: 30px;
        position: relative;
        bottom: 4px;
        right:6px;
        border-top-right-radius: 7px;
        border-bottom-right-radius: 7px;
        border: 2px solid darkblue;
        font-size: 14px;
    }
    /*END TIME*/

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
    <title>Employee</title>
    <link rel="stylesheet" href="/bootstrap-5.3.0-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min. js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<h1>Department</h1>
<div class="container">
    <img src="/Image/Project.jpg" alt="Description of image">

    <form action="">
        <div class="name">
            <span class="bi bi-person icon-name"></span>
        </div>
        <input type="text" name="name"  placeholder="  Enter Your Project Name" class="inp-name">

        <div class="time-start">
            <span class="bi bi-clock icon-start-date"></span>
        </div>
        <input type="date" name="time" placeholder="  Enter Your Start Date" class="inp-start-date">

        <div class="time-end">
            <span class="bi bi-clock icon-date-end"></span>
        </div>
        <input type="date" name="time" placeholder="  Enter Your End Date" class="inp-date-end">


        <button type="button">Submit</button>
    </form>
</div>
<script src="/bootstrap-5.3.0-dist/js/bootstrap.bundle.js"></script>
</body>
<script src="assets/js/jquery-3.7.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
</html>
