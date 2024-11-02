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

    /*MONTH*/
    .container form .month {
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

    .container form .icon-month {
        color: darkblue;
        font-size: 20px;
        position: relative;
        left: 5px;
        bottom: 2px;
    }

    .container form .inp-month {
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
    /*END MONTH*/

    /*TIME*/
    .container form .time {
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

    .container form .icon-time {
        color: darkblue;
        font-size: 20px;
        position: relative;
        left: 5px;
        bottom: 2px;
    }

    .container form .inp-time {
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
    /*END TIME*/

    /*SALERY*/
    .container form .salery {
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

    .container form .icon-salery {
        color: darkblue;
        font-size: 20px;
        position: relative;
        left: 5px;
        bottom: 2px;
    }

    .container form .inp-salery {
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
    /*END SALERY*/

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
    <img src="/Image/Employee.jpg" alt="Description of image">

    <form action="">
        <div class="month">
            <span class="bi bi-calendar icon-month"></span>
        </div>
        <input type="month" name="name"  placeholder="  Enter Month" class="inp-month">

        <div class="time">
            <span class="bi bi-clock icon-time"></span>
        </div>
        <input type="time" name="position" placeholder="  Enter Total Hour" class="inp-time">

        <div class="salery">
            <span class="bi bi-cash-stack icon-salary"></span>
        </div>
        <input type="number" name="time" placeholder="  Enter Total Salary" class="inp-salery">


        <button type="button">Submit</button>
    </form>
</div>
<script src="/bootstrap-5.3.0-dist/js/bootstrap.bundle.js"></script>
</body>
<script src="assets/js/jquery-3.7.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
</html>
