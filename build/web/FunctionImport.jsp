

<%@page import="java.util.Base64"%>
<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>File Upload</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .main{
                width: 300px;
                height: 200px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
                border: 2px solid;
            }
            form{
                width: 100%;
                position: relative;
                display: block;
                margin: 20px auto;
            }
            input{
                margin: 10px 0;
            }
            .ad{ 
                padding: 10px 10px;
            }
            

        </style>
    </head>

    <body>
        <h1 style="margin: 200px 0px; text-align: center;">Import Excel</h1>
        <div class="main">
            <form method="post" action="functionlist?action=import" enctype="multipart/form-data" >
                <input type="file" name="file"/>
                <input type="submit" value="Upload"/>
            </form>

        </div>
        <div class="ad">
            <a href="functionlist">
                <button class="btn btn-danger btn-rounded btn-fw  text-white mb-0 me-0" style = "height: 45px"type="button">
                    <i>
                        Back to Function List
                    </i>
                </button>
            </a>
        </div>
    </body>
</html>
