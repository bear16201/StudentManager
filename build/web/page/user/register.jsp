<%-- 
    Document   : signUp
    Created on : Mar 8, 2022, 1:57:46 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!--<link href="../../css/styleLogin.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Sign in</title>
        <style>

            .main {
                background-color: #FFFFFF;
                width: 400px;
                height: 400px;
                margin: 7em auto;
                border-radius: 1.5em;
                box-shadow: 0px 11px 35px 2px rgba(0, 0, 0, 0.14);
            }

            .sign {
                padding-top: 40px;
                color: rgb(74, 82, 87);
                font-family: 'Ubuntu', sans-serif;
                font-weight: bold;
                font-size: 23px;
            }

            .un {
                width: 76%;
                color: rgb(38, 50, 56);
                font-weight: 700;
                font-size: 14px;
                letter-spacing: 1px;
                background: rgba(136, 126, 126, 0.04);
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                outline: none;
                box-sizing: border-box;
                border: 2px solid rgba(0, 0, 0, 0.02);
                margin-bottom: 50px;
                margin-left: 46px;
                text-align: center;
                margin-bottom: 27px;
                font-family: 'Ubuntu', sans-serif;
            }

            form.form1 {
                padding-top: -1px;
            }

            .pass {
                width: 76%;
                color: rgb(38, 50, 56);
                font-weight: 700;
                font-size: 14px;
                letter-spacing: 1px;
                background: rgba(136, 126, 126, 0.04);
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                outline: none;
                box-sizing: border-box;
                border: 2px solid rgba(0, 0, 0, 0.02);
                margin-bottom: 50px;
                margin-left: 46px;
                text-align: center;
                margin-bottom: 27px;
                font-family: 'Ubuntu', sans-serif;
            }


            .un:focus, .pass:focus {
                border: 2px solid rgba(0, 0, 0, 0.18) !important;
            }

            .submit {
                cursor: pointer;
                border-radius: 5em;
                color: rgb(255, 255, 255);
                background: linear-gradient(to right, #27a7b0, #E040FB);
                border: 0;
                padding-left: 40px;
                padding-right: 40px;
                padding-bottom: 10px;
                padding-top: 10px;
                font-family: 'Ubuntu', sans-serif;
                margin-left: 35%;
                font-size: 13px;
                box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
            }

            .forgot {
                text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
                color: #e7bebe;
                padding-top: 15px;
            }

            a {
                text-shadow: 0px 0px 3px rgba(117, 117, 117, 0.12);
                color: #2c0515;
                text-decoration: none
            }

            @media (max-width: 600px) {
                .main {
                    border-radius: 0px;
                }
            }


            body {
                background-image: url('images/BGRound.jpg');
            }
            .main .gender{
                padding-left: 100px;
                padding-bottom: 30px;
            }
            .un{
                width: 100%;
            }
            .pass{
                width: 100%;
            }
            .submit{
                width: 60%;
            }

        </style>
    </head>

    <body>
        <div class="main" style="height: 600px;">
            <p class="sign" align="center" >Register</p>
            <form class="form1" action="SignUp" method="post" style="padding: -1px; align-content: center" >
                <table>
                    <tr>
                        <td>
                            <input class="un " type="text"  placeholder="FullName"  name="fullname">
                        </td>
                    </tr>
                    <tr>

                        <td class="gender"> 
                            <a style="padding-right: 20px">
                                Gender:           
                            </a>
                            <input type="radio" name="gender" value="1" checked="checked"/>
                            <a style="padding-right: 20px">
                                Male
                            </a>
                            <input type="radio" name="gender" value="0"  />Female
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="un " type="number" align="center" placeholder="Number of phone"  name="mobile">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="un " type="text" align="center" placeholder="Email"  name="email">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="pass" type="password" align="center" placeholder="Password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="submit" align="center" type="submit" >Register</button>
                        </td>
                    </tr>
                </table>

            </form>
        </div>
    </body>
</html>