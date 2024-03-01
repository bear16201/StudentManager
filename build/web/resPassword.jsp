<%-- 
    Document   : resPassword
    Created on : Jun 1, 2022, 11:16:40 PM
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
    <%
        String messWatting = (String) request.getAttribute("messEmail");
//        String messWatting = "";
        int watting = 0;
        if (messWatting == "") {
            watting = 0;
        } else {
            watting = 1;
        }
    %>

    <body>
        <div class="main" style="height: 300px;">
            <p class="sign" align="center" >CHECK YOUR MAIL</p>
            <form class="form1" action="RessPass" method="post" style="padding: -1px; align-content: center" >
                <table>

                    <tr>
                        <td>
                            <input class="un " type="text" align="center" placeholder="Email"  name="email">
                        </td>
                    </tr>
                    <%if (watting == 1) {%>
                    <tr>
                        <td>
                            <div class="alert alert-dark d-flex align-items-center " role="alert" >
                                <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                                <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                                <div>
                                    <%=messWatting%>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <%}%>

                    <tr>
                        <td>
                            <button class="submit" align="center" type="submit" >Submit</button>
                        </td>
                    </tr>
                </table>

            </form>
        </div>
    </body>
</html>

